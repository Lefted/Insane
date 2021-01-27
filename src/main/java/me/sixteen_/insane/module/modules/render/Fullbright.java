package me.sixteen_.insane.module.modules.render;

import me.sixteen_.insane.module.Module;
import me.sixteen_.insane.module.ModuleCategory;

/**
 * @author 16_
 */
public class Fullbright extends Module {

	private float previousGamma;

	public Fullbright() {
		super("Fullbright", ModuleCategory.RENDER);
	}

	@Override
	public void onEnable() {
		previousGamma = -1.0F;
	}

	public void onDisable() {
	}
}
