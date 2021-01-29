package me.sixteen_.insane.module.modules.render;

import me.sixteen_.insane.module.Module;
import me.sixteen_.insane.module.ModuleCategory;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;

/**
 * @author Steffen
 */
public class Inspect extends Module {

	private float distance;

	public Inspect() {
		super("Inspect", ModuleCategory.RENDER, true);
	}

	@Override
	protected void onEnable() {
		distance = 0.0F;
	}

	public void render(final float swingProgress, final float equipProgress, final MatrixStack matrices) {
		if (swingProgress == 0.0F && equipProgress == 0.0F && distance < 30.0F) {
			distance += 0.005F;
			float f = MathHelper.sin(distance);
			rotate(matrices, 0.0F + (f / 48.0F), 1.8F, 1.8F);
/*			rotate(matrices, -1.8F, 1.35F, 0.0F);
			rotate(matrices, 0.9F, -1.575F, 0.225F);
			rotate(matrices, -0.9F, 1.8F, 0.9F);
			rotate(matrices, -3.25F, 0.9F, -1.35F); */
		} else {
			toggle();
		}
	}

	public void rotate(MatrixStack matrix, final float pitch, final float yaw, final float roll) {
		matrix.translate((double) (-8.0F / 16.0F) + 0.35F, (double) (-8.0F / 16.0F) + 0.75F, (double) (-8.0F / 16.0F));
/*		matrix.translate((double) (-8.0F / 16.0F) + 0.3F, (double) (-8.0F / 16.0F) + 0.6F, (double) (-8.0F / 16.0F));
		matrix.translate((double) (-8.0F / 16.0F) + 0.2F, (double) (-8.0F / 16.0F) - 0.3F, (double) (-8.0F / 16.0F) - 0.9F);
		matrix.translate((double) (-8.0F / 16.0F) + 0.6F, (double) (-8.0F / 16.0F) + 0.75F, (double) (-8.0F / 16.0F) + 0.0F);
		matrix.translate((double) (-8.0F / 16.0F) + 0.2F, (double) (-8.0F / 16.0F) + 0.9F, (double) (-8.0F / 16.0F) - 0.3F); */
		if (roll != 0.0F) {
			matrix.multiply(Vector3f.POSITIVE_Z.getRadialQuaternion(roll));
		}
		if (yaw != 0.0F) {
			matrix.multiply(Vector3f.POSITIVE_Y.getRadialQuaternion(yaw));
		}
		if (pitch != 0.0F) {
			matrix.multiply(Vector3f.POSITIVE_X.getRadialQuaternion(pitch));
		}
	}
}