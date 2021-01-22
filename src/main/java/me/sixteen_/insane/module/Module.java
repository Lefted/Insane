package me.sixteen_.insane.module;

public abstract class Module {
	
	private final ModuleCategory category;
	private final String name;
	private boolean enabled = false;
	
	public Module(String moduleName, ModuleCategory moduleCategory) {
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
	
	public void onEnable() {}
	public void onDisable() {}
}
