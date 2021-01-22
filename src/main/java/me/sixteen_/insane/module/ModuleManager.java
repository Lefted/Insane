package me.sixteen_.insane.module;

import java.util.List;

import me.sixteen_.insane.module.modules.render.ArrayList;
import me.sixteen_.insane.module.modules.render.Fullbright;

public class ModuleManager {
	
	private final List<Module> modules = new java.util.ArrayList<Module>();
	
	public ModuleManager() {
		modules.add(new Fullbright());
		modules.add(new ArrayList());
	}
	
	public List<Module> getModules() {
		return modules;
	}
	
	public Module getModule(Class moduleClass) {
		for (Module m : modules) {
			if (m.getClass() == moduleClass) {
				return m;
			}
		}
		return null;
	}
}
