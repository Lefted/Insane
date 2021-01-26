package me.sixteen_.insane.command;

import java.util.List;

import me.sixteen_.insane.command.commands.ToggleCommand;

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
	
	public void runCommand(String... cmd) {
		for (Command c : commands) {
			if (c.getName().equalsIgnoreCase(cmd[0])) {
				c.runCommand(cmd);
			}
		}
	}
}
