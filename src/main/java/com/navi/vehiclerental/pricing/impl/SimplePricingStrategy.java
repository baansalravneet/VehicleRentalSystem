package com.navi.vehiclerental.pricing.impl;

import com.navi.vehiclerental.models.Slot;
import com.navi.vehiclerental.models.Vehicle;
import com.navi.vehiclerental.pricing.PricingStrategy;

/**
 * Simple pricing strategy
 */
public class SimplePricingStrategy implements PricingStrategy {

  @Override
  public double getPrice(Vehicle vehicle, Slot slot) {
    double price = vehicle.getPrice() * slot.getTime();
    return Math.floor(price * 100) / 100;
  }
}
