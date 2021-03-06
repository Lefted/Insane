package me.sixteen_.insane.utils;

import me.sixteen_.insane.Insane;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.MessageType;
import net.minecraft.text.LiteralText;

/**
 * @author 16_
 */
public class Logger {

	private static final Logger LOGGER = new Logger();
	private final MinecraftClient mc = MinecraftClient.getInstance();
	private final Insane insane = Insane.getInsane();

	public void addChatMessage(String message, final boolean prefix) {
		if (prefix) {
			message = String.format("%s : %s", insane.getClientName(), message);
		}
		addChatMessage(message);
	}
	
	public void addChatMessage(final String message) {
		mc.inGameHud.addChatMessage(MessageType.SYSTEM, new LiteralText(message), mc.player.getUuid());
	}

	public static Logger getLogger() {
		return LOGGER;
	}
}