package me.sixteen_.insane.command;

import java.util.List;

import me.sixteen_.insane.command.commands.BindCommand;
import me.sixteen_.insane.command.commands.HelpCommand;
import me.sixteen_.insane.command.commands.ToggleCommand;
import me.sixteen_.insane.utils.Logger;

/**
 * @author 16_
 */
public class CommandManager {

	private final List<Command> commands = new java.util.ArrayList<Command>();

	public CommandManager() {
		addCommand(new ToggleCommand());
		addCommand(new BindCommand());
		addCommand(new HelpCommand());
	}

	private void addCommand(final Command cmd) {
		commands.add(cmd);
	}

	public void commandInput(final String input) {
		String[] cmd = input.substring(1).split(" ");
		runCommand(cmd);
	}
	
	public List<Command> getCommands() {
		return commands;
	}

	private void runCommand(final String... cmd) {
		for (Command c : commands) {
			for (String name : c.getName()) {
				if (name.equalsIgnoreCase(cmd[0])) {
					try {
						c.runCommand(cmd);
					} catch (Exception e) {
						Logger.getLogger().addChatMessage("Could not run command!", true);
					}
					return;
				}
			}
		}
	}
}