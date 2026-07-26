package com.keeganator.minitools.util;

import com.keeganator.minitools.MiniTools;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> ROCK_REPLACEABLE = createTag("rock_replaceable");
        public static final TagKey<Block> GLASS = createTag("glass");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MiniTools.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> ENDER_PEARL = createTag("ender_pearl");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(MiniTools.MOD_ID, name));
        }
    }
}
