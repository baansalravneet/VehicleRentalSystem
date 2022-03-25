package com.navi.vehiclerental.commands.impl;

import com.navi.vehiclerental.commands.Command;
import com.navi.vehiclerental.models.Slot;
import com.navi.vehiclerental.services.BookingService;

public class BookCommand implements Command {

  private final BookingService bookingService;
  private final String branchId;
  private final String vehicleType;
  private final Slot slot;

  public BookCommand(BookingService bookingService, String branchId, String vehicleType,
      Slot slot) {
    this.bookingService = bookingService;
    this.branchId = branchId;
    this.vehicleType = vehicleType;
    this.slot = slot;
  }

  @Override
  public void execute() {
    System.out.println(bookingService.book(branchId, vehicleType, slot));
  }
}
