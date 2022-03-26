package com.navi.vehiclerental;

import com.navi.vehiclerental.pricing.PricingStrategy;
import com.navi.vehiclerental.pricing.impl.SimplePricingStrategy;
import com.navi.vehiclerental.pricing.impl.SurgePricingStrategy;
import org.junit.jupiter.api.Test;

public class PricingStrategyTest extends BaseTest {

  @Test
  public void testSimpleStrategy() {
    PricingStrategy ps = new SimplePricingStrategy();
    assert(ps.getPrice(vehicle, slot) == 100);
  }

  @Test
  public void testSurgeStrategy() {
    PricingStrategy ps = new SurgePricingStrategy(new SimplePricingStrategy());
    assert(ps.getPrice(vehicle, slot) == 110);
  }

}