package me.sixteen_.insane.module;

import net.minecraft.client.util.math.MatrixStack;

/**
 * @author 16_
 */
public abstract class Module {

	private final ModuleCategory category;
	private final String name;
	private final boolean visible;
	private boolean enabled;

	public Module(final String moduleName, final ModuleCategory moduleCategory) {
		visible = true;
		enabled = false;
		category = moduleCategory;
		name = moduleName;
	}

	public Module(final String moduleName, final ModuleCategory moduleCategory, final boolean visible) {
		this.visible = visible;
		enabled = false;
		category = moduleCategory;
		name = moduleName;
	}

	public void toggle() {
		enabled = !enabled;
		if (enabled) {
			onEnable();
		} else {
			onDisable();
		}
	}

	public ModuleCategory getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public boolean isVisible() {
		return visible;
	}
	
	public void render(final MatrixStack matrices) {
	}

	protected void onEnable() {
	}

	protected void onDisable() {
	}
}
