package me.sixteen_.insane.module.modules.render;

import me.sixteen_.insane.module.Module;
import me.sixteen_.insane.module.ModuleCategory;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

public class Inspect extends Module {

	public Inspect() {
		super("Inspect", ModuleCategory.RENDER, true);
	}

	public void render(final AbstractClientPlayerEntity player, final float tickDelta, final float pitch, final Hand hand, final float swingProgress, final ItemStack item, final float equipProgress, final MatrixStack matrices, final VertexConsumerProvider vertexConsumers, final int light) {
	}
}