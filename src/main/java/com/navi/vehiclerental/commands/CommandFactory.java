package com.navi.vehiclerental.commands;

import com.navi.vehiclerental.commands.impl.AddBranchCommand;
import com.navi.vehiclerental.commands.impl.AddVehicleCommand;
import com.navi.vehiclerental.commands.impl.BookCommand;
import com.navi.vehiclerental.commands.impl.DisplayVehicleCommand;
import com.navi.vehiclerental.models.Slot;
import com.navi.vehiclerental.services.BookingService;
import com.navi.vehiclerental.services.OnboardService;

/**
 * Command Factory
 */
public class CommandFactory {

  private final OnboardService onboardService;
  private final BookingService bookingService;

  public CommandFactory(OnboardService onboardService,
      BookingService bookingService) {
    this.onboardService = onboardService;
    this.bookingService = bookingService;
  }

  public Command getAddBranchCommand(String[] arguments) {
    return new AddBranchCommand(onboardService, arguments[1], arguments[2].split(","));
  }

  public Command getAddVehicleCommand(String[] arguments) {
    return new AddVehicleCommand(onboardService, arguments[1], arguments[2], arguments[3],
        Integer.parseInt(arguments[4]));
  }

  public Command getBookCommand(String[] arguments) {
    return new BookCommand(bookingService, arguments[1], arguments[2],
        new Slot(Integer.parseInt(arguments[3]), Integer.parseInt(arguments[4])));
  }

  public Command getDisplayVehiclesCommand(String[] arguments) {
    return new DisplayVehicleCommand(onboardService, arguments[1],
        new Slot(Integer.parseInt(arguments[2]), Integer.parseInt(arguments[3])));
  }
}
