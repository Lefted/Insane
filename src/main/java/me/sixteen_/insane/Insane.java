package me.sixteen_.insane;

import java.awt.Color;

import me.sixteen_.insane.command.CommandManager;
import me.sixteen_.insane.module.ModuleManager;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;

/**
 * @author 16_
 */
public class Insane implements ModInitializer {

	// Instance
	private static Insane insane;
	
	// Client information
	private String clientName;
	private String clientVersion;
	
	// Client colors
	private Color clientColor;
	private Color clientAccentColor;
	
	// Managers
	private ModuleManager moduleManager;
	private CommandManager commandManager;

	@Override
	public void onInitialize() {
		insane = new Insane();
	}

	public Insane() {
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
}
