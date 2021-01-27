package me.sixteen_.insane.command;

import java.util.List;

import me.sixteen_.insane.command.commands.ToggleCommand;
import me.sixteen_.insane.utils.Logger;

public class CommandManager {
	
	private final List<Command> commands = new java.util.ArrayList<Command>();
	
	public CommandManager() {
		addCommand(new ToggleCommand());
	}
	
	private void addCommand(Command cmd) {
		commands.add(cmd);
	}
	
	public void commandInput(String input) {
		input = input.substring(1);
		String[] cmd = input.split(" ");
		runCommand(cmd);
	}
	
	private void runCommand(String... cmd) {
		for (Command c : commands) {
			if (c.getName().equalsIgnoreCase(cmd[0])) {
				try {
					c.runCommand(cmd);
				} catch (Exception e) {
					Logger.LOGGER.addChatMessage("Error");
				}
			}
		}
	}
}
