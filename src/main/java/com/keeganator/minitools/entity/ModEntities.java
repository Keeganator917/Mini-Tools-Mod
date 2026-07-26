package com.keeganator.minitools.entity;

import com.keeganator.minitools.MiniTools;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final RegistryKey<EntityType<?>> ROCK_ENTITY_KEY =
            RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of(MiniTools.MOD_ID, "rock_entity"));

    public static final EntityType<RockEntity> ROCK_ENTITY =
            Registry.register(Registries.ENTITY_TYPE, ROCK_ENTITY_KEY,
                    EntityType.Builder.<RockEntity>create(RockEntity::new, SpawnGroup.MISC)
                            .dimensions(0.4F, 0.4F) .trackingTickInterval(10).build(ROCK_ENTITY_KEY)
            );

    public static void registerModEntities() {
        MiniTools.LOGGER.info("Registering Mod Entities for " + MiniTools.MOD_ID);
    }
}
