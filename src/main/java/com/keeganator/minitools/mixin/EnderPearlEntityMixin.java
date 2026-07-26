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

   /* @Redirect(
            method = "onCollision",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/network/ServerPlayerEntity;damage(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/damage/DamageSource;F)V"
            )
    )
    private void minitools$cancelPearlDamageIfEnderSlayer(
            ServerPlayerEntity player,
            ServerWorld world,
            DamageSource source,
            float amount
    ) {
        // If holding EnderSlayerSword, skip damage
        if (player.getMainHandStack().isOf(ModItems.ENDER_SLAYER_SWORD)
                || player.getOffHandStack().isOf(ModItems.ENDER_SLAYER_SWORD)) {
            return;
        }

        // Vanilla behavior otherwise
        player.damage(world, source, amount);
    }
    */
}
