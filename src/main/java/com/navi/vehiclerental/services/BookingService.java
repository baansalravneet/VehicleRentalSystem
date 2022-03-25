package com.navi.vehiclerental.services;

import com.navi.vehiclerental.booking.BookingStrategy;
import com.navi.vehiclerental.models.Branch;
import com.navi.vehiclerental.models.Slot;
import com.navi.vehiclerental.models.Vehicle;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingService {

  private BookingStrategy bookingStrategy;
  private final OnboardService onboardService;

  public BookingService(BookingStrategy bookingStrategy,
      OnboardService onboardService) {
    this.bookingStrategy = bookingStrategy;
    this.onboardService = onboardService;
  }

  public int book(String branchId, String vehicleType, Slot slot) {
    Branch branch = onboardService.getBranch(branchId);
    if (branch != null) {
      List<Vehicle> availableVehicles = branch.availableVehicles(slot).stream()
          .filter(v -> v.getVehicleType().equals(vehicleType))
          .collect(Collectors.toList());
      Optional<Vehicle> pickedVehicle = bookingStrategy.getVehicle(availableVehicles);
      if (pickedVehicle.isPresent()) {
        pickedVehicle.get().addBookedSlot(slot);
        return pickedVehicle.get().getPrice()*(slot.getTime());
      }
    }
    return -1;
  }

  public void setBookingStrategy(BookingStrategy bookingStrategy) {
    this.bookingStrategy = bookingStrategy;
  }
}
