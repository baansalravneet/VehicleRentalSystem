package com.navi.vehiclerental.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Vehicle class
 */
public class Vehicle {

  private final String vehicleId;
  private final String vehicleType;
  private final String branchId;
  private final int price;
  private List<Slot> bookedSlots;

  public Vehicle(String vehicleId, String vehicleType, String branchId, int price) {
    this.vehicleId = vehicleId;
    this.vehicleType = vehicleType;
    this.branchId = branchId;
    this.price = price;
    this.bookedSlots = new ArrayList<>();
  }

  public String getVehicleId() {
    return vehicleId;
  }

  public int getPrice() {
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
