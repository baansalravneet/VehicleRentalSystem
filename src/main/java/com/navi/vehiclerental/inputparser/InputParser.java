package com.navi.vehiclerental.inputparser;

import com.navi.vehiclerental.commands.Command;
import com.navi.vehiclerental.commands.CommandFactory;
import com.navi.vehiclerental.commands.CommandType;

public class InputParser {

  private final CommandFactory commandFactory;

  public InputParser(CommandFactory commandFactory) {
    this.commandFactory = commandFactory;
  }

  public Command getCommand(String input) {
    try {
      String[] arguments = input.split(" ");
      CommandType commandType = CommandType.valueOf(arguments[0]);
      return commandType.getCommand(commandFactory, arguments);
    } catch (Exception e) {
      System.out.println("Invalid Input");
      return null;
    }
  }
}
