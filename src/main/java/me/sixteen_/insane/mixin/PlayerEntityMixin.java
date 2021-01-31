package me.sixteen_.insane.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.sixteen_.insane.Insane;
import me.sixteen_.insane.module.Module;
import me.sixteen_.insane.module.modules.combat.Killaura;
import net.minecraft.entity.player.PlayerEntity;

/**
 * @author 16_
 */
@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
	
	@Inject(method = "tick", at = @At("HEAD"))
	private void tick(CallbackInfo info) {
		final Module killaura = Insane.getInsane().getModuleManager().getModule(Killaura.class);
		if (killaura.isEnabled()) {
			killaura.onUpdate();
		}
	}
}
