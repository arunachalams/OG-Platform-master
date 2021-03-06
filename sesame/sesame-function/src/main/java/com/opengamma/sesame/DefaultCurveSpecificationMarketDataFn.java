/**
 * Copyright (C) 2013 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.sesame;

import java.util.HashMap;
import java.util.Map;

import com.opengamma.financial.analytics.curve.CurveSpecification;
import com.opengamma.financial.analytics.ircurve.strips.CurveNodeWithIdentifier;
import com.opengamma.financial.analytics.ircurve.strips.PointsCurveNodeWithIdentifier;
import com.opengamma.id.ExternalIdBundle;
import com.opengamma.sesame.marketdata.MarketDataFn;
import com.opengamma.util.ArgumentChecker;
import com.opengamma.util.result.Result;

/**
 * Function implementation that provides market data for a curve specification.
 */
public class DefaultCurveSpecificationMarketDataFn implements CurveSpecificationMarketDataFn {

  /** For looking up the underlying market data. */
  private final MarketDataFn _marketDataFn;

  public DefaultCurveSpecificationMarketDataFn(MarketDataFn marketDataFn) {
    _marketDataFn = ArgumentChecker.notNull(marketDataFn, "marketDataFn");
  }

  @Override
  public Result<Map<ExternalIdBundle, Double>> requestData(Environment env, CurveSpecification curveSpecification) {
    Map<ExternalIdBundle, Double> curveData = new HashMap<>();

    // Interim result object used to build up the complete set of
    // failures rather than exiting early
    Result<Boolean> result = Result.success(true);

    for (CurveNodeWithIdentifier node : curveSpecification.getNodes()) {

      Result<Double> fwdItem = _marketDataFn.getCurveNodeValue(env, node);

      if (node instanceof PointsCurveNodeWithIdentifier) {

        // For these curves there are 2 tickers and we need access to both of them
        PointsCurveNodeWithIdentifier pointsNode = (PointsCurveNodeWithIdentifier) node;
        Result<Double> spotItem = _marketDataFn.getCurveNodeUnderlyingValue(env, pointsNode);

        if (Result.allSuccessful(fwdItem, spotItem)) {
          curveData.put(node.getIdentifier().toBundle(), fwdItem.getValue());
          curveData.put(pointsNode.getUnderlyingIdentifier().toBundle(), spotItem.getValue());
        } else {
          result = Result.failure(result, fwdItem, spotItem);
        }
      } else {

        if (fwdItem.isSuccess()) {
          curveData.put(node.getIdentifier().toBundle(), fwdItem.getValue());
        } else {
          result = Result.failure(result, fwdItem);
        }
      }
    }

    if (result.isSuccess()) {
      return Result.success(curveData);
    } else {
      return Result.failure(result);
    }
  }
}
