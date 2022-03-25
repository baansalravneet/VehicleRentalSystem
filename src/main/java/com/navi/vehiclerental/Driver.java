package com.navi.vehiclerental;

import com.navi.vehiclerental.booking.BookingStrategy;
import com.navi.vehiclerental.booking.impl.LowestPriceBookingStrategy;
import com.navi.vehiclerental.commands.Command;
import com.navi.vehiclerental.commands.CommandFactory;
import com.navi.vehiclerental.factory.BranchFactory;
import com.navi.vehiclerental.factory.VehicleFactory;
import com.navi.vehiclerental.inputparser.InputParser;
import com.navi.vehiclerental.services.BookingService;
import com.navi.vehiclerental.services.OnboardService;
import com.navi.vehiclerental.services.ServiceWrapper;
import com.navi.vehiclerental.store.DataStoreProxy;
import java.util.Scanner;

/**
 * Main class to receive inputs and print outputs
 */
public class Driver {

  private ServiceWrapper serviceWrapper;
  private InputParser inputParser;

  public static void main(String[] args) {
    Driver driver = new Driver();
    driver.initialize();

    driver.run();
  }

  public void initialize() {
    BookingStrategy bookingStrategy = new LowestPriceBookingStrategy();

    DataStoreProxy dataStoreProxy = new DataStoreProxy();
    BranchFactory branchFactory = new BranchFactory();
    VehicleFactory vehicleFactory = new VehicleFactory();

    OnboardService onboardService = new OnboardService(dataStoreProxy, branchFactory,
        vehicleFactory);
    BookingService bookingService = new BookingService(bookingStrategy, onboardService);

    this.serviceWrapper = new ServiceWrapper(bookingService, onboardService);

    CommandFactory commandFactory = new CommandFactory(onboardService, bookingService);
    this.inputParser = new InputParser(commandFactory);
  }

  public void run() {
    Scanner sc = new Scanner(System.in);

    while (true) {
      String input = sc.nextLine();
      Command command = this.inputParser.getCommand(input);
      if (command != null) {
        command.execute();
      }
    }
  }
}
