package com.navi.vehiclerental;

import com.navi.vehiclerental.models.Slot;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class BookingServiceTest extends BaseTest {

  @Test
  @Order(value = 1)
  public void testBooking() {
    double price = bookingService.book("B1", "CAR", new Slot(5,6));
    assert(price == 10);
  }

  @Test
  @Order(value = 2)
  public void testSurgeBooking() {
    bookingService.book("B1", "CAR", new Slot(1,3));
    bookingService.book("B1", "CAR", new Slot(1,3));
    bookingService.book("B1", "CAR", new Slot(1,3));
    double price = bookingService.book("B1", "CAR", new Slot(1,3));
    assert(price == 22);
  }
}
