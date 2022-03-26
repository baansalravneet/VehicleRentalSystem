package com.navi.vehiclerental.booking.impl;

import com.navi.vehiclerental.booking.BookingStrategy;
import com.navi.vehiclerental.models.Vehicle;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Default lowest price booking strategy
 */
public class LowestPriceBookingStrategy implements BookingStrategy {

  @Override
  public Optional<Vehicle> getVehicle(List<Vehicle> availableVehicles) {
    return availableVehicles.stream().min(Comparator.comparing(Vehicle::getPrice));
  }
}
