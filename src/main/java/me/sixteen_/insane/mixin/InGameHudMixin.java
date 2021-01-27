package me.sixteen_.insane.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.sixteen_.insane.Insane;
import me.sixteen_.insane.module.modules.render.ArrayList;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;

@Mixin(InGameHud.class)
public class InGameHudMixin {
	
	@Inject(method = "render", at = @At("HEAD"))
	public void render(MatrixStack matrices, float tickDelta, CallbackInfo info) {
		if (Insane.getInsane().getModuleManager().getModule(ArrayList.class).isEnabled()) {
			((ArrayList)Insane.getInsane().getModuleManager().getModule(ArrayList.class)).render(matrices);
		}
	}
}
