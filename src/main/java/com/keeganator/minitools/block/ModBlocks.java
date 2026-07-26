package com.keeganator.minitools.block;

import com.keeganator.minitools.MiniTools;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {

    public static final Block DIAMOND_LANTERN = registerBlock("diamond_lantern",
            properties -> new LanternBlock(properties.mapColor(MapColor.DIAMOND_BLUE).solid().strength(3.5f).sounds(BlockSoundGroup.LANTERN).luminance((state) -> {
                return 15;
            }).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block DIAMOND_SOUL_LANTERN = registerBlock("diamond_soul_lantern",
            properties -> new LanternBlock(properties.mapColor(MapColor.DIAMOND_BLUE).solid().strength(3.5f).sounds(BlockSoundGroup.LANTERN).luminance((state) -> {
                return 10;
            }).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block EMERALD_LANTERN = registerBlock("emerald_lantern",
            properties -> new LanternBlock(properties.mapColor(MapColor.EMERALD_GREEN).solid().strength(3.5f).sounds(BlockSoundGroup.LANTERN).luminance((state) -> {
                return 15;
            }).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block EMERALD_SOUL_LANTERN = registerBlock("emerald_soul_lantern",
            properties -> new LanternBlock(properties.mapColor(MapColor.EMERALD_GREEN).solid().strength(3.5f).sounds(BlockSoundGroup.LANTERN).luminance((state) -> {
                return 10;
            }).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block GOLDEN_LANTERN = registerBlock("golden_lantern",
            properties -> new LanternBlock(properties.mapColor(MapColor.GOLD).solid().strength(3.5f).sounds(BlockSoundGroup.LANTERN).luminance((state) -> {
                return 15;
            }).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block GOLDEN_SOUL_LANTERN = registerBlock("golden_soul_lantern",
            properties -> new LanternBlock(properties.mapColor(MapColor.GOLD).solid().strength(3.5f).sounds(BlockSoundGroup.LANTERN).luminance((state) -> {
                return 10;
            }).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ROCK_BLOCK = registerBlockWithoutBlockItem("rock_block",
            properties -> new FloorItemBlock(properties.mapColor(MapColor.LIGHT_GRAY).sounds(BlockSoundGroup.STONE).nonOpaque().noCollision()));

    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MiniTools.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(MiniTools.MOD_ID, name), toRegister);
    }

    private static Block registerBlockWithoutBlockItem(String name, Function<AbstractBlock.Settings, Block> function) {
        return Registry.register(Registries.BLOCK, Identifier.of(MiniTools.MOD_ID, name),
                function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MiniTools.MOD_ID, name)))));
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MiniTools.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MiniTools.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        MiniTools.LOGGER.info("Registering Mod Blocks for " + MiniTools.MOD_ID);
    }
}