package me.sixteen_.insane.module.modules.combat;

import java.util.Iterator;

import me.sixteen_.insane.module.Module;
import me.sixteen_.insane.module.ModuleCategory;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.ClientPlayerTickable;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffects;

/**
 * @author 16_
 */
public class Killaura extends Module implements ClientPlayerTickable {

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
	public void tick() {
		if (isEnabled()) {
			onUpdate();
		}
	}

	@Override
	public void onUpdate() {
		final ClientPlayerEntity player = mc.player;
		final Iterator<Entity> it = mc.world.getEntities().iterator();
		Entity entity;
		while (it.hasNext()) {
			entity = it.next();
			if (entity instanceof LivingEntity) {
				final LivingEntity le = (LivingEntity) entity;
				if (!le.equals(player)) {
					if (player.distanceTo(le) < range) {
						if (!le.isDead()) {
							if (player.getAttackCooldownProgress(0) == 1 || le.getHealth() <= attackDamage(player, le)) {
								mc.interactionManager.attackEntity(player, le);
							}
						}
					}
				}
			}
		}
	}

	private float attackDamage(final ClientPlayerEntity player, final LivingEntity target) {
		// Attack damage
		float f = (float) player.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
		// Enchanting attack damage
		float h = EnchantmentHelper.getAttackDamage(player.getMainHandStack(), target.getGroup());
		// Cooldown
		final float i = player.getAttackCooldownProgress(0.5F);
		f *= 0.2F + i * i * 0.8F;
		h *= i;
		// Critical
		boolean bl3 = i > 0.9F && player.fallDistance > 0.0F && !player.isOnGround() && !player.isClimbing() && !player.isTouchingWater() && !player.hasStatusEffect(StatusEffects.BLINDNESS)
				&& !player.hasVehicle() && target instanceof LivingEntity;
		bl3 = bl3 && !player.isSprinting();
		if (bl3) {
			f *= 1.5F;
		}
		// Sum together
		f += h;
		return f;
	}
}
