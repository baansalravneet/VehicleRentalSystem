package com.navi.vehiclerental;

import com.navi.vehiclerental.commands.CommandFactory;
import com.navi.vehiclerental.factory.BranchFactory;
import com.navi.vehiclerental.factory.VehicleFactory;
import com.navi.vehiclerental.inputparser.InputParser;
import com.navi.vehiclerental.models.Branch;
import com.navi.vehiclerental.models.Slot;
import com.navi.vehiclerental.models.Vehicle;
import com.navi.vehiclerental.services.BookingService;
import com.navi.vehiclerental.services.OnboardService;
import com.navi.vehiclerental.store.DataStoreProxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public abstract class BaseTest {

  protected Branch branch;
  protected Vehicle vehicle;
  protected Slot slot;
  protected List<Vehicle> vehicles;

  protected InputParser inputParser;
  protected BookingService bookingService;

  @BeforeAll
  public void setup() {
    branch = new Branch("B1", new HashSet<String>(){{add("CAR");}});
    vehicle = new Vehicle("V1", "CAR", 100);
    slot = new Slot(1, 2);
    vehicles = new ArrayList<>();
    vehicles.add(new Vehicle("V1", "CAR", 100));
    vehicles.add(new Vehicle("V2", "CAR", 1000));
    vehicles.add(new Vehicle("V3", "CAR", 10));
    vehicles.add(new Vehicle("V4", "CAR", 102));
    vehicles.add(new Vehicle("V5", "CAR", 17));
    vehicles.add(new Vehicle("V6", "CAR", 108));


    DataStoreProxy dataStoreProxy = new DataStoreProxy();
    BranchFactory branchFactory = new BranchFactory();
    VehicleFactory vehicleFactory = new VehicleFactory();

    OnboardService onboardService = new OnboardService(dataStoreProxy, branchFactory,
        vehicleFactory);
    bookingService = new BookingService(onboardService);

    CommandFactory commandFactory = new CommandFactory(onboardService, bookingService);
    inputParser = new InputParser(commandFactory);

    onboardService.addBranch("B1", "CAR");
    onboardService.addVehicle("B1", "V1", "CAR", 10);
    onboardService.addVehicle("B1", "V2", "CAR", 10);
    onboardService.addVehicle("B1", "V3", "CAR", 10);
    onboardService.addVehicle("B1", "V4", "CAR", 10);
    onboardService.addVehicle("B1", "V5", "CAR", 10);

  }

}
