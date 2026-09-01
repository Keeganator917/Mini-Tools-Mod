package keeganator.minitools.item.custom;

import keeganator.minitools.entity.RockEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

public class RockItem extends Item {
    public RockItem(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResult use(Level level, Player user, InteractionHand hand) {
        ItemStack itemstack = user.getItemInHand(hand);

        level.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.SNOWBALL_THROW,
                SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));

        if (!level.isClientSide()) {
            Projectile.spawnProjectileFromRotation((serverLevel, source, stack) -> new RockEntity(serverLevel, source),
                            (ServerLevel) level, itemstack, user, 0.01F, 1.5f, 1.0F).setItem(itemstack);
        }

        user.awardStat(Stats.ITEM_USED.get(this));
        if (!(user.getAbilities().flying && user.getAbilities().instabuild)) {
            itemstack.consume(1, user);
        }

        return level.isClientSide() ? InteractionResult.SUCCESS : InteractionResult.CONSUME;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay displayComponent, Consumer<Component> textConsumer, TooltipFlag type) {
        textConsumer.accept(Component.translatable("tooltip.minitools.rock.tooltip").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(stack, context, displayComponent, textConsumer, type);
    }
}