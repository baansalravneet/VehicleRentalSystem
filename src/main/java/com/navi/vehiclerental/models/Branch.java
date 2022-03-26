package com.navi.vehiclerental.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Branch class
 */
public class Branch {

  private final String branchId;
  private final Set<String> vehicleTypes;
  private final List<Vehicle> vehicles;

  public Branch(String branchId, Set<String> vehicleTypes) {
    this.branchId = branchId;
    this.vehicleTypes = vehicleTypes;
    this.vehicles = new ArrayList<>();
  }

  public String getBranchId() {
    return branchId;
  }

  public boolean containsVehicleType(String vehicleType) {
    return this.vehicleTypes.contains(vehicleType);
  }

  public List<Vehicle> availableVehicles(Slot slot) {
    return this.vehicles.stream().filter(vehicle -> vehicle.isAvailable(slot))
        .collect(Collectors.toList());
  }

  public void addVehicle(Vehicle vehicle) {
    this.vehicles.add(vehicle);
  }

  public int totalVehicles() {
    return this.vehicles.size();
  }
}
