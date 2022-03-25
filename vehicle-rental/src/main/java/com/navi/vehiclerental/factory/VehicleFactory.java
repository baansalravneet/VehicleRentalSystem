package com.navi.vehiclerental.factory;

import com.navi.vehiclerental.models.Vehicle;

/**
 * Handles creating Vehicle objects
 */
public class VehicleFactory {

  public Vehicle createVehicle(String branchId, String vehicleId, String vehicleType, int price) {
    return new Vehicle(vehicleId, vehicleType, branchId, price);
  }
}
