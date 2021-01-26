package me.sixteen_.insane.command.commands;

import me.sixteen_.insane.Insane;
import me.sixteen_.insane.command.Command;
import me.sixteen_.insane.module.Module;
import me.sixteen_.insane.module.ModuleManager;

public class ToggleCommand extends Command {
	private final ModuleManager mm;

	public ToggleCommand() {
		super("t");
		mm = Insane.getInsane().getModuleManager();
	}

	@Override
	public void runCommand(String... param) {
		Module m = mm.getModuleByName(param[1]);
		m.toggle();
	}
}
