package com.navi.vehiclerental.booking;

import com.navi.vehiclerental.models.Vehicle;
import java.util.List;
import java.util.Optional;

/**
 * Get the best Vehicle according to the strategy
 */
public interface BookingStrategy {
  Optional<Vehicle> getVehicle(List<Vehicle> availableVehicles);
}
