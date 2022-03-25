package com.navi.vehiclerental.services;

import com.navi.vehiclerental.factory.BranchFactory;
import com.navi.vehiclerental.factory.VehicleFactory;
import com.navi.vehiclerental.models.Branch;
import com.navi.vehiclerental.models.Vehicle;
import com.navi.vehiclerental.store.DataStoreProxy;

/**
 * Handles logic for on-boarding a Branch and a Vehicle
 */
public class OnboardService {

  private final DataStoreProxy dataStoreProxy;
  private final BranchFactory branchFactory;
  private final VehicleFactory vehicleFactory;

  public OnboardService(DataStoreProxy dataStoreProxy, BranchFactory branchFactory,
      VehicleFactory vehicleFactory) {
    this.dataStoreProxy = dataStoreProxy;
    this.branchFactory = branchFactory;
    this.vehicleFactory = vehicleFactory;
  }

  public boolean addBranch(String branchId, String... vehicleTypes) {
    if (this.dataStoreProxy.getBranch(branchId) != null) {
      return false;
    }
    this.dataStoreProxy.addBranch(this.branchFactory.createBranch(branchId, vehicleTypes));
    return true;
  }

  public boolean addVehicle(String branchId, String vehicleId, String vehicleType, int price) {
    if (this.dataStoreProxy.getVehicle(vehicleId) != null
        || this.dataStoreProxy.getBranch(branchId) == null
        || !this.dataStoreProxy.getBranch(branchId).containsVehicleType(vehicleType)) {
      return false;
    }
    Vehicle vehicle = this.vehicleFactory.createVehicle(branchId, vehicleId, vehicleType, price);
    this.dataStoreProxy.addVehicle(vehicle);
    this.dataStoreProxy.getBranch(branchId).addVehicle(vehicle);
    return true;
  }

  public Branch getBranch(String branchId) {
    return this.dataStoreProxy.getBranch(branchId);
  }
}
