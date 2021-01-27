package me.sixteen_.insane.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.sixteen_.insane.Insane;
import me.sixteen_.insane.module.Module;
import me.sixteen_.insane.module.ModuleManager;
import me.sixteen_.insane.module.modules.render.ArrayList;
import me.sixteen_.insane.module.modules.render.SprintStatus;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;

/**
 * @author 16_
 */
@Mixin(InGameHud.class)
public class InGameHudMixin {

	@Inject(method = "render", at = @At("HEAD"))
	public void render(MatrixStack matrices, float tickDelta, CallbackInfo info) {
		ModuleManager mm = Insane.getInsane().getModuleManager();
		Module arrayList = mm.getModule(ArrayList.class);
		Module sprintStatus = mm.getModule(SprintStatus.class);
		if (arrayList.isEnabled()) {
			arrayList.render(matrices);
		}
		if (sprintStatus.isEnabled()) {
			sprintStatus.render(matrices);
		}
	}
}
