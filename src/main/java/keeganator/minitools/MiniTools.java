package keeganator.minitools;

import keeganator.minitools.block.ModBlocks;
import keeganator.minitools.entity.ModEntities;
import keeganator.minitools.item.ModItemGroups;
import keeganator.minitools.item.ModItems;
import keeganator.minitools.worldgen.ModPlacedFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Predicate;

public class MiniTools implements ModInitializer {
	public static final String MOD_ID = "minitools";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModEntities.registerModEntities();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModItemGroups.registerItemGroups();


		Predicate<BiomeSelectionContext> selector = BiomeSelectors.tag(BiomeTags.IS_FOREST).or(BiomeSelectors.tag(BiomeTags.IS_BADLANDS))
				.or(BiomeSelectors.tag(BiomeTags.IS_JUNGLE)).or(BiomeSelectors.tag(BiomeTags.IS_TAIGA)
				.or(BiomeSelectors.includeByKey(Biomes.BEACH, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_GRAVELLY_HILLS,
						Biomes.MEADOW, Biomes.STONY_PEAKS, Biomes.CHERRY_GROVE, Biomes.RIVER, Biomes.LUSH_CAVES)));

		BiomeModifications.addFeature(selector, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.ROCK_BLOCK_PLACED);

	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
