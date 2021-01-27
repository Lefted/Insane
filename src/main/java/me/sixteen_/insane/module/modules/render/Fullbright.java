package me.sixteen_.insane.module.modules.render;

import me.sixteen_.insane.module.Module;
import me.sixteen_.insane.module.ModuleCategory;
import net.minecraft.client.MinecraftClient;

/**
 * @author 16_
 */
public class Fullbright extends Module {

	private MinecraftClient mc;
	private double previousGamma;

	public Fullbright() {
		super("Fullbright", ModuleCategory.RENDER);
	}

	@Override
	public void onEnable() {
		mc = MinecraftClient.getInstance();
		previousGamma = mc.options.gamma;
		mc.options.gamma = 69.0D;
	}

	public void onDisable() {
		mc.options.gamma = previousGamma;
	}
}
