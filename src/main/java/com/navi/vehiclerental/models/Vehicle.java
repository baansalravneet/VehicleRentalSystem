package com.navi.vehiclerental.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Vehicle class
 */
public class Vehicle {

  private final String vehicleId;
  private final String vehicleType;
  private final double price;
  private final List<Slot> bookedSlots;

  public Vehicle(String vehicleId, String vehicleType, double price) {
    this.vehicleId = vehicleId;
    this.vehicleType = vehicleType;
    this.price = price;
    this.bookedSlots = new ArrayList<>();
  }

  public String getVehicleId() {
    return vehicleId;
  }

  public double getPrice() {
    return price;
  }

  public boolean isAvailable(Slot slot) {
    for (Slot s : bookedSlots) {
      if (s.isClashing(slot)) {
        return false;
      }
    }
    return true;
  }

  public String getVehicleType() {
    return vehicleType;
  }

  public void addBookedSlot(Slot slot) {
    bookedSlots.add(slot);
  }
}
