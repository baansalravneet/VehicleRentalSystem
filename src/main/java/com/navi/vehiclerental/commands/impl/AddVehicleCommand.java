package com.navi.vehiclerental.commands.impl;

import com.navi.vehiclerental.commands.Command;
import com.navi.vehiclerental.services.OnboardService;

/**
 * Add vehicle command
 */
public class AddVehicleCommand implements Command {

  private final OnboardService onboardService;
  private final String branchId;
  private final String vehicleType;
  private final String vehicleId;
  private final int price;

  public AddVehicleCommand(OnboardService onboardService, String branchId, String vehicleType,
      String vehicleId, int price) {
    this.onboardService = onboardService;
    this.branchId = branchId;
    this.vehicleType = vehicleType;
    this.vehicleId = vehicleId;
    this.price = price;
  }

  @Override
  public void execute() {
    if (onboardService.addVehicle(this.branchId, this.vehicleId, this.vehicleType, this.price)) {
      System.out.println("TRUE");
    } else {
      System.out.println("FALSE");
    }
  }
}
