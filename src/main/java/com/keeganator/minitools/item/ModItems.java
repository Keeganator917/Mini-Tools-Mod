package com.keeganator.minitools.item;

import com.keeganator.minitools.MiniTools;
import com.keeganator.minitools.item.custom.EnderSlayerSword;
import com.keeganator.minitools.item.custom.RockItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class ModItems {

    public static final Item ROCK = registerItem("rock", RockItem::new);
    public static final Item TWIG = registerItem("twig", Item::new);
    public static final Item DIAMOND_NUGGET = registerItem("diamond_nugget", Item::new);
    public static final Item EMERALD_NUGGET = registerItem("emerald_nugget", Item::new);
    public static final Item MINI_WOODEN_SWORD = registerItem("mini_wooden_sword", settings ->
            new Item(settings.sword(ModToolMaterials.MINI_WOOD, 3.0f, -2.4f)));
    public static final Item MINI_WOODEN_PICKAXE = registerItem("mini_wooden_pickaxe", settings ->
            new Item(settings.pickaxe(ModToolMaterials.MINI_WOOD, 1f, -2.8f)));
    public static final Item MINI_WOODEN_AXE = registerItem("mini_wooden_axe", settings ->
            new Item(settings.axe(ModToolMaterials.MINI_WOOD, 6.0f, -3.2f)));
    public static final Item MINI_WOODEN_SHOVEL = registerItem("mini_wooden_shovel", settings ->
            new Item(settings.shovel(ModToolMaterials.MINI_WOOD, 1.5f, -3.0f)));
    public static final Item MINI_WOODEN_HOE = registerItem("mini_wooden_hoe", settings ->
            new Item(settings.hoe(ModToolMaterials.MINI_WOOD, 0f, -3f)));
    public static final Item MINI_STONE_SWORD = registerItem("mini_stone_sword",
            s -> new Item(s.sword(ModToolMaterials.MINI_STONE, 3.0f, -2.4f)));
    public static final Item MINI_STONE_SHOVEL = registerItem("mini_stone_shovel",
            s -> new Item(s.shovel(ModToolMaterials.MINI_STONE, 1.5f, -3.0f)));
    public static final Item MINI_STONE_PICKAXE = registerItem("mini_stone_pickaxe",
            s -> new Item(s.pickaxe(ModToolMaterials.MINI_STONE, 1.0f, -2.8f)));
    public static final Item MINI_STONE_AXE = registerItem("mini_stone_axe",
            s -> new Item(s.axe(ModToolMaterials.MINI_STONE, 7.0f, -3.2f)));
    public static final Item MINI_STONE_HOE = registerItem("mini_stone_hoe",
            s -> new Item(s.hoe(ModToolMaterials.MINI_STONE, -1.0f, -2.0f)));
    public static final Item MINI_GOLDEN_SWORD = registerItem("mini_golden_sword",
            s -> new Item(s.sword(ModToolMaterials.MINI_GOLD, 3.0f, -2.4f)));
    public static final Item MINI_GOLDEN_SHOVEL = registerItem("mini_golden_shovel",
            s -> new Item(s.shovel(ModToolMaterials.MINI_GOLD, 1.5f, -3.0f)));
    public static final Item MINI_GOLDEN_PICKAXE = registerItem("mini_golden_pickaxe",
            s -> new Item(s.pickaxe(ModToolMaterials.MINI_GOLD, 1.0f, -2.8f)));
    public static final Item MINI_GOLDEN_AXE = registerItem("mini_golden_axe",
            s -> new Item(s.axe(ModToolMaterials.MINI_GOLD, 6.0f, -3.0f)));
    public static final Item MINI_GOLDEN_HOE = registerItem("mini_golden_hoe",
            s -> new Item(s.hoe(ModToolMaterials.MINI_GOLD, 0.0f, -3.0f)));
    public static final Item MINI_IRON_SWORD = registerItem("mini_iron_sword",
            s -> new Item(s.sword(ModToolMaterials.MINI_IRON, 3.0f, -2.4f)));
    public static final Item MINI_IRON_SHOVEL = registerItem("mini_iron_shovel",
            s -> new Item(s.shovel(ModToolMaterials.MINI_IRON, 1.5f, -3.0f)));
    public static final Item MINI_IRON_PICKAXE = registerItem("mini_iron_pickaxe",
            s -> new Item(s.pickaxe(ModToolMaterials.MINI_IRON, 1.0f, -2.8f)));
    public static final Item MINI_IRON_AXE = registerItem("mini_iron_axe",
            s -> new Item(s.axe(ModToolMaterials.MINI_IRON, 6.0f, -3.1f)));
    public static final Item MINI_IRON_HOE = registerItem("mini_iron_hoe",
            s -> new Item(s.hoe(ModToolMaterials.MINI_IRON, -2.0f, -1.0f)));
    public static final Item MINI_DIAMOND_SWORD = registerItem("mini_diamond_sword",
            s -> new Item(s.sword(ModToolMaterials.MINI_DIAMOND, 3.0f, -2.4f)));
    public static final Item MINI_DIAMOND_SHOVEL = registerItem("mini_diamond_shovel",
            s -> new Item(s.shovel(ModToolMaterials.MINI_DIAMOND, 1.5f, -3.0f)));
    public static final Item MINI_DIAMOND_PICKAXE = registerItem("mini_diamond_pickaxe",
            s -> new Item(s.pickaxe(ModToolMaterials.MINI_DIAMOND, 1.0f, -2.8f)));
    public static final Item MINI_DIAMOND_AXE = registerItem("mini_diamond_axe",
            s -> new Item(s.axe(ModToolMaterials.MINI_DIAMOND, 5.0f, -3.0f)));
    public static final Item MINI_DIAMOND_HOE = registerItem("mini_diamond_hoe",
            s -> new Item(s.hoe(ModToolMaterials.MINI_DIAMOND, -3.0f, 0.0f)));
    public static final Item ENDER_SLAYER_SWORD = registerItem("ender_slayer_sword",
            s -> new EnderSlayerSword(ModToolMaterials.ENDER_SLAYER, 3.0f, -2.4f, s.rarity(Rarity.RARE)));

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(MiniTools.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MiniTools.MOD_ID, name)))));
    }

    public static void registerModItems() {
        MiniTools.LOGGER.info("Registering Mod Items for " + MiniTools.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            //entries.add(Items.ACACIA_LEAVES);

        });
    }
}
