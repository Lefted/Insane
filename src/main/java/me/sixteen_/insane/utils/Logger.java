package me.sixteen_.insane.utils;

import me.sixteen_.insane.Insane;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.MessageType;
import net.minecraft.text.LiteralText;

public class Logger {
	
	public static final Logger LOGGER = new Logger();
	private final MinecraftClient mc = MinecraftClient.getInstance();
	private final Insane insane = Insane.getInsane();
	
	public void addChatMessage(String message) {
		mc.inGameHud.addChatMessage(MessageType.SYSTEM, new LiteralText(String.format("%s : %s",  insane.getClientName(), message)), mc.player.getUuid());
	}
}
