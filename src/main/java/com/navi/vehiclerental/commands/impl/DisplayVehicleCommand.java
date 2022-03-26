package com.navi.vehiclerental.commands.impl;

import com.navi.vehiclerental.commands.Command;
import com.navi.vehiclerental.models.Slot;
import com.navi.vehiclerental.models.Vehicle;
import com.navi.vehiclerental.services.OnboardService;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Display vehicle command
 */
public class DisplayVehicleCommand implements Command {

  private final OnboardService onboardService;
  private final String branchId;
  private final Slot slot;

  public DisplayVehicleCommand(OnboardService onboardService,
      String branchId, Slot slot) {
    this.onboardService = onboardService;
    this.branchId = branchId;
    this.slot = slot;
  }

  @Override
  public void execute() {
    List<String> availableVehicles = onboardService.getBranch(branchId).availableVehicles(slot)
        .stream().sorted(Comparator.comparing(Vehicle::getPrice)).map(Vehicle::getVehicleId)
        .collect(Collectors.toList());
    System.out.println(String.join(",", availableVehicles));
  }
}
