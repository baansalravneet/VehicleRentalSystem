package com.navi.vehiclerental.store;

import com.navi.vehiclerental.models.Branch;
import com.navi.vehiclerental.models.Vehicle;
import java.util.HashMap;
import java.util.Map;

/**
 * A Proxy class for external database.
 * Only handling reads and writes.
 */
public class DataStoreProxy {

  private final Map<String, Branch> branchMap;
  // Assuming vehicle id being unique across branches
  private final Map<String, Vehicle> vehicleMap;

  public DataStoreProxy() {
    this.branchMap = new HashMap<>();
    this.vehicleMap = new HashMap<>();
  }

  public Branch getBranch(String branchId) {
    return this.branchMap.get(branchId);
  }

  public Vehicle getVehicle(String vehicleId) {
    return this.vehicleMap.get(vehicleId);
  }

  public void addBranch(Branch branch) {
    this.branchMap.put(branch.getBranchId(), branch);
  }

  public void addVehicle(Vehicle vehicle) {
    this.vehicleMap.put(vehicle.getVehicleId(), vehicle);
  }
}
