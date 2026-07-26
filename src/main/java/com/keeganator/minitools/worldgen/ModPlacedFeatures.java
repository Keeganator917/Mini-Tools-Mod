package com.keeganator.minitools.worldgen;

import com.keeganator.minitools.MiniTools;
import com.keeganator.minitools.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightmapPlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> ROCK_BLOCK_PLACED =
            RegistryKey.of(RegistryKeys.PLACED_FEATURE,
                    Identifier.of(MiniTools.MOD_ID, "rock_block_placed"));

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        context.register(
                ROCK_BLOCK_PLACED,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(ModConfiguredFeatures.ROCK_BLOCK),
                        List.of(
                                RarityFilterPlacementModifier.of(60),
                                SquarePlacementModifier.of(),
                                HeightmapPlacementModifier.of(Heightmap.Type.WORLD_SURFACE_WG),
                                BiomePlacementModifier.of()
                        )
                )
        );
    }
}
