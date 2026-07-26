package com.keeganator.minitools.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;

public class RockEntityRenderer<T extends ThrownItemEntity>
        extends FlyingItemEntityRenderer<T> {

    public RockEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }
}