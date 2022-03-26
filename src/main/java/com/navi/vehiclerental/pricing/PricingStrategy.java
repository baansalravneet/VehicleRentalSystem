package com.navi.vehiclerental.pricing;

import com.navi.vehiclerental.models.Slot;
import com.navi.vehiclerental.models.Vehicle;

/**
 * Interface to define multiple pricing strategies.
 */
public interface PricingStrategy {
  double getPrice(Vehicle vehicle, Slot slot);
}
