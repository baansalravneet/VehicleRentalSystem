package com.navi.vehiclerental.factory;

import com.navi.vehiclerental.models.Vehicle;

/**
 * Creates Vehicle objects
 */
public class VehicleFactory {

  public Vehicle createVehicle(String vehicleId, String vehicleType, int price) {
    return new Vehicle(vehicleId, vehicleType, price);
  }
}
