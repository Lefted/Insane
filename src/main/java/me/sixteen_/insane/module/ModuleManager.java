package me.sixteen_.insane.module;

import java.util.List;

import me.sixteen_.insane.module.modules.render.ArrayList;
import me.sixteen_.insane.module.modules.render.Fullbright;

/**
 * @author 16_
 */
public class ModuleManager {

	private final List<Module> modules = new java.util.ArrayList<Module>();

	public ModuleManager() {
		addModule(new Fullbright());
		addModule(new ArrayList());
	}

	private void addModule(Module module) {
		modules.add(module);
	}

	public List<Module> getModules() {
		return modules;
	}

	public Module getModuleByName(String moduleName) {
		for (Module m : modules) {
			if (m.getName().equalsIgnoreCase(moduleName)) {
				return m;
			}
		}
		return null;
	}

	public Module getModule(Class<? extends Module> moduleClass) {
		for (Module m : modules) {
			if (m.getClass() == moduleClass) {
				return m;
			}
		}
		return null;
	}
}
