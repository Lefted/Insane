package me.sixteen_.insane.module.modules.render;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import me.sixteen_.insane.Insane;
import me.sixteen_.insane.module.Module;
import me.sixteen_.insane.module.ModuleCategory;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;

public class ArrayList extends Module {

	private List<Module> modules;
	private TextRenderer tr;
	
	public ArrayList() {
		super("ArrayList", ModuleCategory.RENDER);
	}
	
	private void sortModules() {
		Collections.sort(modules, new Comparator<Module>() {
			@Override
			public int compare(Module m1, Module m2) {
				if (tr.getWidth(m1.getName()) > tr.getWidth(m2.getName())) {
					return -1;
				}
				if (tr.getWidth(m1.getName()) < tr.getWidth(m2.getName())) {
					return 1;
				}
				return 0;
			}
		});
	}
	
	@SuppressWarnings("resource")
	@Override
	public void onEnable() {
		modules = Insane.getInsane().getModuleManager().getModules();
		tr = Insane.getInsane().getMinecraft().textRenderer;
		sortModules();
	}
	
	public void render(MatrixStack matrices) {
		for (Module m : modules) {
			if (m.isEnabled()) {
				tr.draw(matrices, m.getName(), 0, 10, -1);
			}
		}
	}
}
