package keeganator.minitools.entity.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;

public class RockEntityRenderer<T extends ThrowableItemProjectile> extends ThrownItemRenderer<T> {

    public RockEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }
}
