package keeganator.minitools.util;

import keeganator.minitools.MiniTools;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks {

        public static final TagKey<Block> ROCK_REPLACEABLE = createTag("rock_replaceable");

        public static final TagKey<Block> GLASS = createTag("glass");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MiniTools.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> ENDER_PEARL = createTag("ender_pearl");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MiniTools.MOD_ID, name));
        }
    }

}
