package me.sixteen_.insane.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.sixteen_.insane.Insane;
import net.minecraft.client.gui.screen.Screen;

/**
 * @author 16_
 */
@Mixin(Screen.class)
public class ScreenMixin {

	@Inject(method = "sendMessage(Ljava/lang/String;Z)V", at = @At("HEAD"), cancellable = true)
	private void sendMessage(String message, boolean toHud, CallbackInfo info) {
		if (message.startsWith(".")) {
			Insane.getInsane().getCommandManager().commandInput(message);
			info.cancel();
		}
	}
}
