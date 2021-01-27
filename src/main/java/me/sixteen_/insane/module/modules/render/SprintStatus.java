package me.sixteen_.insane.module.modules.render;

import me.sixteen_.insane.module.Module;
import me.sixteen_.insane.module.ModuleCategory;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;

/**
 * @author 16_
 */
public class SprintStatus extends Module {

	private MinecraftClient mc;
	private TextRenderer tr;

	public SprintStatus() {
		super("SprintStatus", ModuleCategory.RENDER, false);
	}

	@Override
	public void onEnable() {
		mc = MinecraftClient.getInstance();
		tr = mc.textRenderer;
	}

	@Override
	public void render(MatrixStack matrices) {
		String status;
		if (mc.options.sprintToggled && mc.options.keySprint.isPressed()) {
			status = "Toggled";
		} else if (mc.options.keySprint.isPressed()) {
			status = "Key Held";
		} else if (mc.player.isSprinting()) {
			status = "Vanilla";
		} else {
			status = "Disabled";
		}
		status = String.format("[Sprinting (%s)]", status);
		tr.draw(matrices, status, 0, 2, -1);
	}
}
