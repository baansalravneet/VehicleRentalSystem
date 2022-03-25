package com.navi.vehiclerental.services;

public class ServiceWrapper {

  private final BookingService bookingService;
  private final OnboardService onboardService;

  public ServiceWrapper(BookingService bookingService,
      OnboardService onboardService) {
    this.bookingService = bookingService;
    this.onboardService = onboardService;
  }


  public BookingService getBookingService() {
    return bookingService;
  }

  public OnboardService getOnboardService() {
    return onboardService;
  }
}
