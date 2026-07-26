package com.keeganator.minitools.damagetypes;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public final class ModDamageTypes {

    public static final RegistryKey<DamageType> ROCK = create("rock");

    private static RegistryKey<DamageType> create(String name) {
        return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of("minitools", "rock"));
    }

    public static DamageSource rock(World world, Object source, Object attacker) {
        Registry<DamageType> registry =
                world.getRegistryManager().getOrThrow(RegistryKeys.DAMAGE_TYPE);

        RegistryEntry<DamageType> entry =
                registry.getOrThrow(ROCK);

        return new DamageSource(entry, source instanceof net.minecraft.entity.Entity e ? e : null,
                attacker instanceof net.minecraft.entity.Entity e ? e : null);
    }

    private ModDamageTypes() {}
}