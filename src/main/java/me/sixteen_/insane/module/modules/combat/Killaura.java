package me.sixteen_.insane.module.modules.combat;

import java.util.Iterator;

import me.sixteen_.insane.module.Module;
import me.sixteen_.insane.module.ModuleCategory;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

/**
 * @author 16_
 */
public class Killaura extends Module {

	private MinecraftClient mc;
	private float range;

	public Killaura() {
		super("Killaura", ModuleCategory.COMBAT);
	}

	@Override
	protected void onEnable() {
		mc = MinecraftClient.getInstance();
		range = 6F;
	}

	@Override
	public void onUpdate() {
		final Iterator<Entity> it = mc.world.getEntities().iterator();
		Entity entity;
		while (it.hasNext()) {
			entity = it.next();
			if (entity instanceof LivingEntity) {
				final LivingEntity le = (LivingEntity) entity;
				if (!le.equals(mc.player)) {
					if (mc.player.distanceTo(le) < range) {
						if (!le.isDead()) {
							if (!mc.player.handSwinging) {
								if (mc.player.getAttackCooldownProgress(0) == 1) {
									mc.interactionManager.attackEntity(mc.player, le);
								}
							}
						}
					}
				}
			}
		}
	}
}
