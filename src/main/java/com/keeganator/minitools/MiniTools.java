package com.keeganator.minitools;

import com.keeganator.minitools.block.ModBlocks;
import com.keeganator.minitools.damagetypes.ModDamageTypes;
import com.keeganator.minitools.entity.ModEntities;
import com.keeganator.minitools.item.ModItemGroups;
import com.keeganator.minitools.item.ModItems;
import com.keeganator.minitools.worldgen.ModPlacedFeatures;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.event.registry.DynamicRegistrySetupCallback;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.resource.Resource;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

public class MiniTools implements ModInitializer {
	public static final String MOD_ID = "minitools";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModEntities.registerModEntities();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModItemGroups.registerItemGroups();

		BiomeModifications.addFeature(
				context -> context.getBiomeKey() == BiomeKeys.FOREST
						|| context.getBiomeKey() == BiomeKeys.FLOWER_FOREST
						|| context.getBiomeKey() == BiomeKeys.OLD_GROWTH_BIRCH_FOREST
						|| context.getBiomeKey() == BiomeKeys.BIRCH_FOREST
						|| context.getBiomeKey() == BiomeKeys.DARK_FOREST
						|| context.getBiomeKey() == BiomeKeys.BEACH
						|| context.getBiomeKey() == BiomeKeys.GROVE
						|| context.getBiomeKey() == BiomeKeys.WOODED_BADLANDS
						|| context.getBiomeKey() == BiomeKeys.WINDSWEPT_HILLS
						|| context.getBiomeKey() == BiomeKeys.WINDSWEPT_FOREST
						|| context.getBiomeKey() == BiomeKeys.WINDSWEPT_GRAVELLY_HILLS
						|| context.getBiomeKey() == BiomeKeys.BAMBOO_JUNGLE
						|| context.getBiomeKey() == BiomeKeys.JUNGLE
						|| context.getBiomeKey() == BiomeKeys.SPARSE_JUNGLE
						|| context.getBiomeKey() == BiomeKeys.MEADOW
						|| context.getBiomeKey() == BiomeKeys.STONY_PEAKS
						|| context.getBiomeKey() == BiomeKeys.RIVER
						|| context.getBiomeKey() == BiomeKeys.CHERRY_GROVE
						|| context.getBiomeKey() == BiomeKeys.TAIGA
						|| context.getBiomeKey() == BiomeKeys.LUSH_CAVES
						|| context.getBiomeKey() == BiomeKeys.OLD_GROWTH_PINE_TAIGA,
				GenerationStep.Feature.VEGETAL_DECORATION,
				ModPlacedFeatures.ROCK_BLOCK_PLACED
		);
	}

}