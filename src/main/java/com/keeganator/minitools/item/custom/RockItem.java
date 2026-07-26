package com.keeganator.minitools.item.custom;

import com.keeganator.minitools.MiniTools;
import com.keeganator.minitools.entity.RockEntity;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.function.Consumer;

public class RockItem extends Item {
    public RockItem(Item.Settings settings) {
        super(settings);
        System.out.println("RockItem constructor called");
    }

    @Override
    public ActionResult use(World pLevel, PlayerEntity pPlayer, Hand pHand) {
        ItemStack itemstack = pPlayer.getStackInHand(pHand);
        pLevel.playSound((PlayerEntity) null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!pLevel.isClient()) {
            RockEntity rock = new RockEntity(pLevel, pPlayer);
            rock.setItem(itemstack);
            rock.setVelocity(pPlayer, pPlayer.getPitch(), pPlayer.getYaw(), 0.0F, 1.5F, 1.0F);
            pLevel.spawnEntity(rock);
        }

        pPlayer.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!pPlayer.getAbilities().creativeMode) {
            itemstack.decrement(1);
        }

        return pLevel.isClient() ? ActionResult.SUCCESS : ActionResult.CONSUME;
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        textConsumer.accept(Text.translatable("tooltip.minitools.rock.tooltip").setStyle(Style.EMPTY.withColor(Formatting.GRAY)));
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
    }
}