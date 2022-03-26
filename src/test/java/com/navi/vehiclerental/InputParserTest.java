package com.navi.vehiclerental;

import com.navi.vehiclerental.commands.Command;
import com.navi.vehiclerental.commands.impl.AddBranchCommand;
import com.navi.vehiclerental.commands.impl.AddVehicleCommand;
import com.navi.vehiclerental.commands.impl.BookCommand;
import com.navi.vehiclerental.commands.impl.DisplayVehicleCommand;
import org.junit.jupiter.api.Test;

public class InputParserTest extends BaseTest {

  @Test
  public void testAddBranchCommand() {
    Command command = inputParser.getCommand("ADD_BRANCH B1 CAR,BIKE,VAN");
    assert(command instanceof AddBranchCommand);
  }

  @Test
  public void testAddVehicleCommand() {
    Command command = inputParser.getCommand("ADD_VEHICLE B1 CAR V1 500");
    assert(command instanceof AddVehicleCommand);
  }

  @Test
  public void testBookCommand() {
    Command command = inputParser.getCommand("BOOK B1 VAN 1 5");
    assert(command instanceof BookCommand);
  }

  @Test
  public void testDisplayVehiclesCommand() {
    Command command = inputParser.getCommand("DISPLAY_VEHICLES B1 1 5");
    assert(command instanceof DisplayVehicleCommand);
  }

  @Test
  public void testInvalidCommand() {
    Command command = inputParser.getCommand("COMMAND");
    assert(command == null);
  }
}
