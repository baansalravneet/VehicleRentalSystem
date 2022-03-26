package com.navi.vehiclerental;

import com.navi.vehiclerental.commands.Command;
import com.navi.vehiclerental.commands.CommandFactory;
import com.navi.vehiclerental.factory.BranchFactory;
import com.navi.vehiclerental.factory.VehicleFactory;
import com.navi.vehiclerental.inputparser.InputParser;
import com.navi.vehiclerental.services.BookingService;
import com.navi.vehiclerental.services.OnboardService;
import com.navi.vehiclerental.store.DataStoreProxy;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Application class
 */
public class Application {

  private InputParser inputParser;

  public static void main(String[] args) throws FileNotFoundException {
    Application driver = new Application();
    driver.initialize();

    driver.run(args);
  }

  public void initialize() {
    DataStoreProxy dataStoreProxy = new DataStoreProxy();
    BranchFactory branchFactory = new BranchFactory();
    VehicleFactory vehicleFactory = new VehicleFactory();

    OnboardService onboardService = new OnboardService(dataStoreProxy, branchFactory,
        vehicleFactory);
    BookingService bookingService = new BookingService(onboardService);

    CommandFactory commandFactory = new CommandFactory(onboardService, bookingService);
    this.inputParser = new InputParser(commandFactory);
  }

  public void run(String[] args) throws FileNotFoundException {
//    Scanner sc = new Scanner(System.in);

//    System.out.println("Enter test file path");
//    String path = sc.nextLine();

    File file = new File(args[0]);
    Scanner fileScanner = new Scanner(file);

    while (fileScanner.hasNext()) {
      String input = fileScanner.nextLine();
      Command command = this.inputParser.getCommand(input);
      if (command != null) {
        command.execute();
      }
    }

//    while (true) {
//      String input = sc.nextLine();
//      Command command = this.inputParser.getCommand(input);
//      if (command != null) {
//        command.execute();
//      }
//    }
  }
}
