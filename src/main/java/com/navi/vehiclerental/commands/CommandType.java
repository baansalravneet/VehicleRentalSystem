package com.navi.vehiclerental.commands;

public enum CommandType {

  ADD_BRANCH {
    @Override
    public Command getCommand(CommandFactory commandFactory, String[] arguments) {
      return commandFactory.getAddBranchCommand(arguments);
    }
  },
  ADD_VEHICLE {
    @Override
    public Command getCommand(CommandFactory commandFactory, String[] arguments) {
      return commandFactory.getAddVehicleCommand(arguments);
    }
  },
  BOOK {
    @Override
    public Command getCommand(CommandFactory commandFactory, String[] arguments) {
      return commandFactory.getBookCommand(arguments);
    }
  },
  DISPLAY_VEHICLES {
    @Override
    public Command getCommand(CommandFactory commandFactory, String[] arguments) {
      return commandFactory.getDisplayVehiclesCommand(arguments);
    }
  };

  public abstract Command getCommand(CommandFactory commandFactory, String[] arguments);

}
