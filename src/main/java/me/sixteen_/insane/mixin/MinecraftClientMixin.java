package me.sixteen_.insane.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.sixteen_.insane.Insane;
import net.minecraft.client.MinecraftClient;

/**
 * @author Steffen
 */
@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

	@Inject(method = "<init>", at = @At("RETURN"))
	private void init(final CallbackInfo info) {
		new Insane();
	}
	
	@Inject(method = "stop", at = @At("HEAD"))
	private void stop(final CallbackInfo info) {
		Insane.getInsane().shutdown();
	}
}
