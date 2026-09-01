package keeganator.minitools.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrownEnderpearl;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;

public class EnderSlayerSword extends Item {
    public EnderSlayerSword(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, Properties settings) {
        super(settings.sword(toolMaterial, attackDamage, attackSpeed));
    }

    @Override
    public InteractionResult use(Level level, Player user, InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);

        level.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENDER_PEARL_THROW, SoundSource.NEUTRAL,
                0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));

        if (level instanceof ServerLevel serverLevel) {
            Projectile.spawnProjectileFromRotation(ThrownEnderpearl::new, serverLevel, itemStack, user, 0.0F, 1.5f, 1.0F)
                    .setItem(Items.ENDER_PEARL.getDefaultInstance());
        }

        user.awardStat(Stats.ITEM_USED.get(this));
        itemStack.hurtAndBreak(10, user, hand);
        return InteractionResult.SUCCESS;
    }
}