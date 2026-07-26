package com.keeganator.minitools.item;

import com.keeganator.minitools.util.ModTags;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

public class ModToolMaterials {

    public static final ToolMaterial MINI_WOOD = new ToolMaterial(
            BlockTags.INCORRECT_FOR_WOODEN_TOOL,
            16,          // durability
            2.0F,        // speed (vanilla wood)
            0.0F,        // attack bonus
            15,          // enchantability
            ItemTags.WOODEN_TOOL_MATERIALS
    );

    public static final ToolMaterial MINI_STONE = new ToolMaterial(
            BlockTags.INCORRECT_FOR_STONE_TOOL,
            32,
            4.0F,
            1.0F,
            5,
            ItemTags.STONE_TOOL_MATERIALS
    );

    public static final ToolMaterial MINI_GOLD = new ToolMaterial(
            BlockTags.INCORRECT_FOR_GOLD_TOOL,
            8,
            12.0F,
            0.0F,
            22,
            ItemTags.GOLD_TOOL_MATERIALS
    );

    public static final ToolMaterial MINI_IRON = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            50,
            6.0F,
            2.0F,
            14,
            ItemTags.IRON_TOOL_MATERIALS
    );

    public static final ToolMaterial MINI_DIAMOND = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            100,
            8.0F,
            3.0F,
            10,
            ItemTags.DIAMOND_TOOL_MATERIALS
    );

    public static final ToolMaterial ENDER_SLAYER = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            300,
            8.0f,
            3.0f,
            15,
            ModTags.Items.ENDER_PEARL
    );
}