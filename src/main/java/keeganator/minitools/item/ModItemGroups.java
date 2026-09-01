package keeganator.minitools.item;

import keeganator.minitools.MiniTools;
import keeganator.minitools.block.ModBlocks;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroups {

    public static final ResourceKey<CreativeModeTab> MINI_TOOLS_GROUP_KEY =
            ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(MiniTools.MOD_ID, "minitools"));

    public static final CreativeModeTab MINI_TOOLS_GROUP =
            FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.MINI_STONE_PICKAXE))
                    .title(Component.translatable("itemgroup.mini_tools"))
                    .displayItems((displayContext, entries) -> {
                        entries.accept(ModItems.ROCK);
                        entries.accept(ModItems.TWIG);
                        entries.accept(ModItems.DIAMOND_NUGGET);
                        entries.accept(ModItems.EMERALD_NUGGET);

                        entries.accept(ModItems.MINI_WOODEN_SWORD);
                        entries.accept(ModItems.MINI_WOODEN_PICKAXE);
                        entries.accept(ModItems.MINI_WOODEN_AXE);
                        entries.accept(ModItems.MINI_WOODEN_SHOVEL);
                        entries.accept(ModItems.MINI_WOODEN_HOE);

                        entries.accept(ModItems.MINI_STONE_SWORD);
                        entries.accept(ModItems.MINI_STONE_PICKAXE);
                        entries.accept(ModItems.MINI_STONE_AXE);
                        entries.accept(ModItems.MINI_STONE_SHOVEL);
                        entries.accept(ModItems.MINI_STONE_HOE);

                        entries.accept(ModItems.MINI_GOLDEN_SWORD);
                        entries.accept(ModItems.MINI_GOLDEN_PICKAXE);
                        entries.accept(ModItems.MINI_GOLDEN_AXE);
                        entries.accept(ModItems.MINI_GOLDEN_SHOVEL);
                        entries.accept(ModItems.MINI_GOLDEN_HOE);

                        entries.accept(ModItems.MINI_IRON_SWORD);
                        entries.accept(ModItems.MINI_IRON_PICKAXE);
                        entries.accept(ModItems.MINI_IRON_AXE);
                        entries.accept(ModItems.MINI_IRON_SHOVEL);
                        entries.accept(ModItems.MINI_IRON_HOE);

                        entries.accept(ModItems.MINI_DIAMOND_SWORD);
                        entries.accept(ModItems.MINI_DIAMOND_PICKAXE);
                        entries.accept(ModItems.MINI_DIAMOND_AXE);
                        entries.accept(ModItems.MINI_DIAMOND_SHOVEL);
                        entries.accept(ModItems.MINI_DIAMOND_HOE);

                        entries.accept(ModItems.ENDER_SLAYER_SWORD);

                        entries.accept(ModBlocks.DIAMOND_LANTERN);
                        entries.accept(ModBlocks.DIAMOND_SOUL_LANTERN);
                        entries.accept(ModBlocks.EMERALD_LANTERN);
                        entries.accept(ModBlocks.EMERALD_SOUL_LANTERN);
                        entries.accept(ModBlocks.GOLDEN_LANTERN);
                        entries.accept(ModBlocks.GOLDEN_SOUL_LANTERN);

                    })
                    .build();

    public static void registerItemGroups() {
        MiniTools.LOGGER.info("Registering Item Groups for " + MiniTools.MOD_ID);

        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MINI_TOOLS_GROUP_KEY, MINI_TOOLS_GROUP);
    }

}
