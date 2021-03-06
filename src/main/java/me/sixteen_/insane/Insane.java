package me.sixteen_.insane;

import java.awt.Color;

import me.sixteen_.insane.command.CommandManager;
import me.sixteen_.insane.module.ModuleManager;

/**
 * @author 16_
 */
public class Insane {

	// Instance
	private static Insane insane;
	
	// Client information
	private final String clientName;
	private final String clientVersion;
	
	// Client colors
	private final Color clientColor;
	private final Color clientAccentColor;
	
	// Managers
	private final ModuleManager moduleManager;
	private final CommandManager commandManager;

	public Insane() {
		insane = this;
		moduleManager = new ModuleManager();
		commandManager = new CommandManager();
		clientColor = new Color(20, 20, 20, 191);
		clientAccentColor = new Color(255, 85, 255, 191);
		clientName = "Insane";
		clientVersion = "b1";
	}

	public String getClientName() {
		return clientName;
	}

	public String getClientVersion() {
		return clientVersion;
	}

	public Color getClientColor() {
		return clientColor;
	}

	public Color getClientAccentColor() {
		return clientAccentColor;
	}

	public ModuleManager getModuleManager() {
		return moduleManager;
	}

	public CommandManager getCommandManager() {
		return commandManager;
	}

	public static Insane getInsane() {
		return insane;
	}
	
	public void shutdown() {
		moduleManager.shutdown();
	}
}