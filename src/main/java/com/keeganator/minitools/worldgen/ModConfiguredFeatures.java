package com.keeganator.minitools.worldgen;

import com.keeganator.minitools.MiniTools;
import com.keeganator.minitools.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> ROCK_BLOCK =
            RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE,
                    Identifier.of(MiniTools.MOD_ID, "rock_block"));

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        context.register(
                ROCK_BLOCK,
                new ConfiguredFeature<>(
                        Feature.RANDOM_PATCH,
                        new RandomPatchFeatureConfig(
                                82,
                                7,
                                3,
                                PlacedFeatures.createEntry(
                                        Feature.SIMPLE_BLOCK,
                                        new SimpleBlockFeatureConfig(
                                                BlockStateProvider.of(ModBlocks.ROCK_BLOCK)
                                        )
                                )
                        )
                )
        );
    }
}
