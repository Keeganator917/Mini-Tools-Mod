package com.keeganator.minitools.mixin;

import com.keeganator.minitools.item.ModItems;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EnderPearlEntity.class)
public abstract class EnderPearlEntityMixin {

    //If I want to cancel enderpearl damage for enderslayer sword put code here

}
