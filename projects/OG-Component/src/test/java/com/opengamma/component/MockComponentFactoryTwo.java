/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

/**
 * Mock factory.
 */
@BeanDefinition
public class MockComponentFactoryTwo implements Bean, ComponentFactory {

  @PropertyDefinition(validate = "notNull")
  private MockComponent delta;
  @PropertyDefinition
  private MockComponent epsilon;
  @PropertyDefinition
  private ComponentInfo info;
  @PropertyDefinition
  private final List<String> list = new ArrayList<>();

  //-------------------------------------------------------------------------
  @Override
  public void init(ComponentRepository repo, LinkedHashMap<String, String> configuration) throws Exception {
    ComponentInfo info = new ComponentInfo(List.class, "two");
    repo.registerComponent(info, getList());
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code MockComponentFactoryTwo}.
   * @return the meta-bean, not null
   */
  public static MockComponentFactoryTwo.Meta meta() {
    return MockComponentFactoryTwo.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(MockComponentFactoryTwo.Meta.INSTANCE);
  }

  @Override
  public MockComponentFactoryTwo.Meta metaBean() {
    return MockComponentFactoryTwo.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the delta.
   * @return the value of the property, not null
   */
  public MockComponent getDelta() {
    return delta;
  }

  /**
   * Sets the delta.
   * @param delta  the new value of the property, not null
   */
  public void setDelta(MockComponent delta) {
    JodaBeanUtils.notNull(delta, "delta");
    this.delta = delta;
  }

  /**
   * Gets the the {@code delta} property.
   * @return the property, not null
   */
  public final Property<MockComponent> delta() {
    return metaBean().delta().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the epsilon.
   * @return the value of the property
   */
  public MockComponent getEpsilon() {
    return epsilon;
  }

  /**
   * Sets the epsilon.
   * @param epsilon  the new value of the property
   */
  public void setEpsilon(MockComponent epsilon) {
    this.epsilon = epsilon;
  }

  /**
   * Gets the the {@code epsilon} property.
   * @return the property, not null
   */
  public final Property<MockComponent> epsilon() {
    return metaBean().epsilon().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the info.
   * @return the value of the property
   */
  public ComponentInfo getInfo() {
    return info;
  }

  /**
   * Sets the info.
   * @param info  the new value of the property
   */
  public void setInfo(ComponentInfo info) {
    this.info = info;
  }

  /**
   * Gets the the {@code info} property.
   * @return the property, not null
   */
  public final Property<ComponentInfo> info() {
    return metaBean().info().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the list.
   * @return the value of the property, not null
   */
  public List<String> getList() {
    return list;
  }

  /**
   * Sets the list.
   * @param list  the new value of the property, not null
   */
  public void setList(List<String> list) {
    JodaBeanUtils.notNull(list, "list");
    this.list.clear();
    this.list.addAll(list);
  }

  /**
   * Gets the the {@code list} property.
   * @return the property, not null
   */
  public final Property<List<String>> list() {
    return metaBean().list().createProperty(this);
  }

  //-----------------------------------------------------------------------
  @Override
  public MockComponentFactoryTwo clone() {
    return JodaBeanUtils.cloneAlways(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      MockComponentFactoryTwo other = (MockComponentFactoryTwo) obj;
      return JodaBeanUtils.equal(getDelta(), other.getDelta()) &&
          JodaBeanUtils.equal(getEpsilon(), other.getEpsilon()) &&
          JodaBeanUtils.equal(getInfo(), other.getInfo()) &&
          JodaBeanUtils.equal(getList(), other.getList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(getDelta());
    hash = hash * 31 + JodaBeanUtils.hashCode(getEpsilon());
    hash = hash * 31 + JodaBeanUtils.hashCode(getInfo());
    hash = hash * 31 + JodaBeanUtils.hashCode(getList());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(160);
    buf.append("MockComponentFactoryTwo{");
    int len = buf.length();
    toString(buf);
    if (buf.length() > len) {
      buf.setLength(buf.length() - 2);
    }
    buf.append('}');
    return buf.toString();
  }

  protected void toString(StringBuilder buf) {
    buf.append("delta").append('=').append(JodaBeanUtils.toString(getDelta())).append(',').append(' ');
    buf.append("epsilon").append('=').append(JodaBeanUtils.toString(getEpsilon())).append(',').append(' ');
    buf.append("info").append('=').append(JodaBeanUtils.toString(getInfo())).append(',').append(' ');
    buf.append("list").append('=').append(JodaBeanUtils.toString(getList())).append(',').append(' ');
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code MockComponentFactoryTwo}.
   */
  public static class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code delta} property.
     */
    private final MetaProperty<MockComponent> _delta = DirectMetaProperty.ofReadWrite(
        this, "delta", MockComponentFactoryTwo.class, MockComponent.class);
    /**
     * The meta-property for the {@code epsilon} property.
     */
    private final MetaProperty<MockComponent> _epsilon = DirectMetaProperty.ofReadWrite(
        this, "epsilon", MockComponentFactoryTwo.class, MockComponent.class);
    /**
     * The meta-property for the {@code info} property.
     */
    private final MetaProperty<ComponentInfo> _info = DirectMetaProperty.ofReadWrite(
        this, "info", MockComponentFactoryTwo.class, ComponentInfo.class);
    /**
     * The meta-property for the {@code list} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<List<String>> _list = DirectMetaProperty.ofReadWrite(
        this, "list", MockComponentFactoryTwo.class, (Class) List.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "delta",
        "epsilon",
        "info",
        "list");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 95468472:  // delta
          return _delta;
        case -1535503510:  // epsilon
          return _epsilon;
        case 3237038:  // info
          return _info;
        case 3322014:  // list
          return _list;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends MockComponentFactoryTwo> builder() {
      return new DirectBeanBuilder<MockComponentFactoryTwo>(new MockComponentFactoryTwo());
    }

    @Override
    public Class<? extends MockComponentFactoryTwo> beanType() {
      return MockComponentFactoryTwo.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code delta} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<MockComponent> delta() {
      return _delta;
    }

    /**
     * The meta-property for the {@code epsilon} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<MockComponent> epsilon() {
      return _epsilon;
    }

    /**
     * The meta-property for the {@code info} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<ComponentInfo> info() {
      return _info;
    }

    /**
     * The meta-property for the {@code list} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<List<String>> list() {
      return _list;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 95468472:  // delta
          return ((MockComponentFactoryTwo) bean).getDelta();
        case -1535503510:  // epsilon
          return ((MockComponentFactoryTwo) bean).getEpsilon();
        case 3237038:  // info
          return ((MockComponentFactoryTwo) bean).getInfo();
        case 3322014:  // list
          return ((MockComponentFactoryTwo) bean).getList();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 95468472:  // delta
          ((MockComponentFactoryTwo) bean).setDelta((MockComponent) newValue);
          return;
        case -1535503510:  // epsilon
          ((MockComponentFactoryTwo) bean).setEpsilon((MockComponent) newValue);
          return;
        case 3237038:  // info
          ((MockComponentFactoryTwo) bean).setInfo((ComponentInfo) newValue);
          return;
        case 3322014:  // list
          ((MockComponentFactoryTwo) bean).setList((List<String>) newValue);
          return;
      }
      super.propertySet(bean, propertyName, newValue, quiet);
    }

    @Override
    protected void validate(Bean bean) {
      JodaBeanUtils.notNull(((MockComponentFactoryTwo) bean).delta, "delta");
      JodaBeanUtils.notNull(((MockComponentFactoryTwo) bean).list, "list");
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}