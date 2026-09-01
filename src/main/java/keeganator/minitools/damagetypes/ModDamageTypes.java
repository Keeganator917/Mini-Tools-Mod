package keeganator.minitools.damagetypes;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

public class ModDamageTypes {

    public static final ResourceKey<DamageType> ROCK = create("rock");

    private static ResourceKey<DamageType> create(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, Identifier.fromNamespaceAndPath("minitools", "rock"));
    }

    public static DamageSource rock(Level world, Object source, Object attacker) {
        Registry<DamageType> registry = world.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE);

        Holder<DamageType> entry = registry.getOrThrow(ROCK);

        return new DamageSource(entry, source instanceof Entity e ? e : null, attacker instanceof Entity e ? e : null);
    }

    private ModDamageTypes() {}

}
