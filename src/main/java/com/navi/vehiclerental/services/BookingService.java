package com.navi.vehiclerental.services;

import com.navi.vehiclerental.booking.BookingStrategy;
import com.navi.vehiclerental.booking.impl.LowestPriceBookingStrategy;
import com.navi.vehiclerental.models.Branch;
import com.navi.vehiclerental.models.Slot;
import com.navi.vehiclerental.models.Vehicle;
import com.navi.vehiclerental.pricing.PricingStrategy;
import com.navi.vehiclerental.pricing.impl.SimplePricingStrategy;
import com.navi.vehiclerental.pricing.impl.SurgePricingStrategy;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Booking Service
 * Based on the set booking strategy and pricing strategy, vehicles are booked.
 */
public class BookingService {

  private BookingStrategy bookingStrategy = new LowestPriceBookingStrategy();
  private PricingStrategy pricingStrategy = new SimplePricingStrategy();
  private final OnboardService onboardService;

  public BookingService(OnboardService onboardService) {
    this.onboardService = onboardService;
  }

  public double book(String branchId, String vehicleType, Slot slot) {
    Branch branch = onboardService.getBranch(branchId);
    if (branch != null) {
      List<Vehicle> availableVehicles = branch.availableVehicles(slot).stream()
          .filter(v -> v.getVehicleType().equals(vehicleType))
          .collect(Collectors.toList());
      Optional<Vehicle> pickedVehicle = bookingStrategy.getVehicle(availableVehicles);
      if (pickedVehicle.isPresent()) {
        pickedVehicle.get().addBookedSlot(slot);
        PricingStrategy ps = pricingStrategy;
        if (isSurge(branch, slot)) {
          ps = new SurgePricingStrategy(pricingStrategy);
        }
        return ps.getPrice(pickedVehicle.get(), slot);
      }
    }
    return -1;
  }

  public void setBookingStrategy(BookingStrategy bookingStrategy) {
    this.bookingStrategy = bookingStrategy;
  }

  public void setPricingStrategy(PricingStrategy pricingStrategy) {
    this.pricingStrategy = pricingStrategy;
  }

  private boolean isSurge(Branch branch, Slot slot) {
    return (double)branch.availableVehicles(slot).size() / branch.totalVehicles() <= 0.2;
  }
}
