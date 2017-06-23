/**
 * Copyright (C) 2012 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.financial.analytics.volatility.cube;

import java.io.Serializable;

import com.opengamma.id.ExternalId;

/**
 * Class that gets an {@link ExternalId} for an (x, y, z) point on a volatility cube.
 * There are no restrictions on how these ids are produced; they could be autogenerated,
 * or pulled out of a map, for example.
 *
 * @param <X> The type of the x-axis values
 * @param <Y> The type of the y-axis values
 * @param <Z> The type of the z-axis values
 */
public interface CubeInstrumentProvider<X, Y, Z> extends Serializable {

  /**
   * Gets the external
   * @param xAxis The x axis value
   * @param yAxis The y axis value
   * @param zaxis The z axis value
   * @return The external id of (x, y, z) point
   */
  ExternalId getInstrument(X xAxis, Y yAxis, Z zaxis);

  /**
   * Gets the data field name.
   * @return The data field name
   */
  String getDataFieldName();

}