package keeganator.minitools.block;

import keeganator.minitools.MiniTools;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;

public class ModBlocks {

    //removed .solid from lanterns, couldn't find equivalent

    public static final Block DIAMOND_LANTERN = registerBlock("diamond_lantern",
            properties -> new LanternBlock(properties.mapColor(MapColor.DIAMOND).strength(3.5f).sound(SoundType.LANTERN).lightLevel((state) -> {
                return 15;
            }).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block DIAMOND_SOUL_LANTERN = registerBlock("diamond_soul_lantern",
            properties -> new LanternBlock(properties.mapColor(MapColor.DIAMOND).strength(3.5f).sound(SoundType.LANTERN).lightLevel((state) -> {
                return 10;
            }).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block EMERALD_LANTERN = registerBlock("emerald_lantern",
            properties -> new LanternBlock(properties.mapColor(MapColor.EMERALD).strength(3.5f).sound(SoundType.LANTERN).lightLevel((state) -> {
                return 15;
            }).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block EMERALD_SOUL_LANTERN = registerBlock("emerald_soul_lantern",
            properties -> new LanternBlock(properties.mapColor(MapColor.EMERALD).strength(3.5f).sound(SoundType.LANTERN).lightLevel((state) -> {
                return 10;
            }).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block GOLDEN_LANTERN = registerBlock("golden_lantern",
            properties -> new LanternBlock(properties.mapColor(MapColor.GOLD).strength(3.5f).sound(SoundType.LANTERN).lightLevel((state) -> {
                return 15;
            }).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block GOLDEN_SOUL_LANTERN = registerBlock("golden_soul_lantern",
            properties -> new LanternBlock(properties.mapColor(MapColor.GOLD).strength(3.5f).sound(SoundType.LANTERN).lightLevel((state) -> {
                return 10;
            }).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block ROCK_BLOCK = registerBlockWithoutBlockItem("rock_block",
            properties -> new FloorItemBlock(properties.mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.STONE).noOcclusion().noCollision()));

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MiniTools.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(MiniTools.MOD_ID, name), toRegister);
    }

    private static Block registerBlockWithoutBlockItem(String name, Function<BlockBehaviour.Properties, Block> function) {
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(MiniTools.MOD_ID, name),
                function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MiniTools.MOD_ID, name)))));
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(MiniTools.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MiniTools.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        MiniTools.LOGGER.info("Registering Mod Blocks for " + MiniTools.MOD_ID);
    }

}
