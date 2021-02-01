package me.sixteen_.insane.module.modules.combat;

import java.util.Iterator;
import java.util.Map.Entry;

import com.google.common.collect.Multimap;

import me.sixteen_.insane.module.Module;
import me.sixteen_.insane.module.ModuleCategory;
import me.sixteen_.insane.utils.Logger;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.ClientPlayerTickable;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;

/**
 * @author 16_
 */
public class Killaura extends Module implements ClientPlayerTickable {

    private MinecraftClient mc;
    private float range;
    private static boolean waitTick = false;

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

    public void onDamage(DamageSource source, float amount) {
	// String msg = String.format("source %s damage %s", source.name, amount);
	// Logger.getLogger().addChatMessage(msg);
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
			    if (player.getAttackCooldownProgress(0f) >= 1f) {
				if (!waitTick) {
				    waitTick = true;
				    return;
				} else {
				    waitTick = false;
				    mc.interactionManager.attackEntity(player, le);
				}
			    } else {
				if (le.getHealth() <= getAttackDamage(player, le)) {
				    mc.interactionManager.attackEntity(player, le);
				}
			    }
			}
		    }
		}
	    }
	}
    }

    private float getAttackDamage(final ClientPlayerEntity player, final LivingEntity target) {

	// Attack damage
	float f = (float) getGenericAttackDamage();
	// float f = (float) player.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);

	// Enchanting attack damage
	float h = EnchantmentHelper.getAttackDamage(player.getMainHandStack(), target.getGroup());

	// Cooldown
	final float i = player.getAttackCooldownProgress(0.5F);
	f *= 0.2F + i * i * 0.8F;
	h *= i;

	// Critical
	boolean bl3 = i > 0.9F && player.fallDistance > 0.0F && !player.isOnGround() && !player.isClimbing() && !player.isTouchingWater() && !player
	    .hasStatusEffect(StatusEffects.BLINDNESS) && !player.hasVehicle() && target instanceof LivingEntity;
	bl3 = bl3 && !player.isSprinting();
	if (bl3) {
	    f *= 1.5F;
	}

	// Sum together
	f += h;
	return f;
    }

    private double getGenericAttackDamage() {
	ItemStack stack = mc.player.getMainHandStack();
	Multimap<EntityAttribute, EntityAttributeModifier> multimap = stack.getAttributeModifiers(EquipmentSlot.MAINHAND);
	double attackDamage = 0;

	if (!multimap.isEmpty()) {
	    Iterator var11 = multimap.entries().iterator();
	    while (var11.hasNext()) {
		Entry<EntityAttribute, EntityAttributeModifier> entry = (Entry) var11.next();
		EntityAttributeModifier entityAttributeModifier = (EntityAttributeModifier) entry.getValue();
		double d = entityAttributeModifier.getValue();
		boolean bl = false;
		if (((EntityAttribute) entry.getKey()).equals(EntityAttributes.GENERIC_ATTACK_DAMAGE)) {
		    d += mc.player.getAttributeBaseValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
		    d += (double) EnchantmentHelper.getAttackDamage(stack, EntityGroup.DEFAULT);
		    bl = true;
		}

		if (entityAttributeModifier.getOperation() != EntityAttributeModifier.Operation.MULTIPLY_BASE && entityAttributeModifier
		    .getOperation() != EntityAttributeModifier.Operation.MULTIPLY_TOTAL) {
		    if (((EntityAttribute) entry.getKey()).equals(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE)) {
			attackDamage = d * 10.0D;
		    } else {
			attackDamage = d;
		    }
		} else {
		    attackDamage = d * 100.0D;
		}

		if (bl) {
		    return attackDamage;
		}
	    }
	}
	return 0;
    }
}