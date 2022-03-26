package com.navi.vehiclerental;

import com.navi.vehiclerental.booking.BookingStrategy;
import com.navi.vehiclerental.booking.impl.LowestPriceBookingStrategy;
import com.navi.vehiclerental.models.Vehicle;
import java.util.Optional;
import org.junit.jupiter.api.Test;

public class BookingStrategyTest extends BaseTest {

  @Test
  public void testLowestPriceStrategy() {
    BookingStrategy bs = new LowestPriceBookingStrategy();
    Optional<Vehicle> vehicle = bs.getVehicle(vehicles);
    assert (vehicle.isPresent());
    assert (vehicle.get().getVehicleId().equals("V3"));
  }
}
