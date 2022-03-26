package com.navi.vehiclerental.pricing.impl;

import com.navi.vehiclerental.models.Slot;
import com.navi.vehiclerental.models.Vehicle;
import com.navi.vehiclerental.pricing.PricingStrategy;

/**
 * Decorator for surge pricing
 */
public class SurgePricingStrategy implements PricingStrategy {

  private final PricingStrategy baseStrategy;

  public SurgePricingStrategy(PricingStrategy baseStrategy) {
    this.baseStrategy = baseStrategy;
  }

  @Override
  public double getPrice(Vehicle vehicle, Slot slot) {
    double price = 1.1 * baseStrategy.getPrice(vehicle, slot);
    return Math.floor(price * 100) / 100;
  }
}
