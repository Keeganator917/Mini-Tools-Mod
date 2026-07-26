package com.keeganator.minitools.item;

import com.keeganator.minitools.MiniTools;
import com.keeganator.minitools.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup MINI_TOOLS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MiniTools.MOD_ID, "minitools"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.MINI_STONE_PICKAXE))
                    .displayName(Text.translatable("itemgroup.mini_tools"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ROCK);
                        entries.add(ModItems.TWIG);
                        entries.add(ModItems.DIAMOND_NUGGET);
                        entries.add(ModItems.EMERALD_NUGGET);

                        entries.add(ModItems.MINI_WOODEN_SWORD);
                        entries.add(ModItems.MINI_WOODEN_PICKAXE);
                        entries.add(ModItems.MINI_WOODEN_AXE);
                        entries.add(ModItems.MINI_WOODEN_SHOVEL);
                        entries.add(ModItems.MINI_WOODEN_HOE);
                        entries.add(ModItems.MINI_STONE_SWORD);
                        entries.add(ModItems.MINI_STONE_PICKAXE);
                        entries.add(ModItems.MINI_STONE_AXE);
                        entries.add(ModItems.MINI_STONE_SHOVEL);
                        entries.add(ModItems.MINI_STONE_HOE);
                        entries.add(ModItems.MINI_GOLDEN_SWORD);
                        entries.add(ModItems.MINI_GOLDEN_PICKAXE);
                        entries.add(ModItems.MINI_GOLDEN_AXE);
                        entries.add(ModItems.MINI_GOLDEN_SHOVEL);
                        entries.add(ModItems.MINI_GOLDEN_HOE);
                        entries.add(ModItems.MINI_IRON_SWORD);
                        entries.add(ModItems.MINI_IRON_PICKAXE);
                        entries.add(ModItems.MINI_IRON_AXE);
                        entries.add(ModItems.MINI_IRON_SHOVEL);
                        entries.add(ModItems.MINI_IRON_HOE);
                        entries.add(ModItems.MINI_DIAMOND_SWORD);
                        entries.add(ModItems.MINI_DIAMOND_PICKAXE);
                        entries.add(ModItems.MINI_DIAMOND_AXE);
                        entries.add(ModItems.MINI_DIAMOND_SHOVEL);
                        entries.add(ModItems.MINI_DIAMOND_HOE);

                        entries.add(ModItems.ENDER_SLAYER_SWORD);

                        entries.add(ModBlocks.DIAMOND_LANTERN);
                        entries.add(ModBlocks.DIAMOND_SOUL_LANTERN);
                        entries.add(ModBlocks.EMERALD_LANTERN);
                        entries.add(ModBlocks.EMERALD_SOUL_LANTERN);
                        entries.add(ModBlocks.GOLDEN_LANTERN);
                        entries.add(ModBlocks.GOLDEN_SOUL_LANTERN);

                    }).build());


    public static void registerItemGroups() {
        MiniTools.LOGGER.info("Registering Item Groups for " + MiniTools.MOD_ID);
    }
}
