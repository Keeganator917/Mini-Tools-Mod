package keeganator.minitools.entity;

import keeganator.minitools.MiniTools;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {

    public static final ResourceKey<EntityType<?>> ROCK_ENTITY_KEY =
            ResourceKey.create(BuiltInRegistries.ENTITY_TYPE.key(), Identifier.fromNamespaceAndPath(MiniTools.MOD_ID, "rock_entity"));

    public static final EntityType<RockEntity> ROCK_ENTITY =
            Registry.register(BuiltInRegistries.ENTITY_TYPE, ROCK_ENTITY_KEY,
                    EntityType.Builder.<RockEntity>of(RockEntity::new, MobCategory.MISC)
                            .sized(0.4F, 0.4F).updateInterval(10).build(ROCK_ENTITY_KEY)
            );

    public static void registerModEntities() {
        MiniTools.LOGGER.info("Registering Mod Entities for " + MiniTools.MOD_ID);
    }

}
