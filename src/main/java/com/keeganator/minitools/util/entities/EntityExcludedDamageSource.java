package com.keeganator.minitools.util.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;

import java.util.Arrays;
import java.util.List;

public class EntityExcludedDamageSource extends DamageSource {

    protected final List<EntityType<?>> excludedEntities;

    public EntityExcludedDamageSource(RegistryEntry<DamageType> type, EntityType<?>... excludedEntities) {
        super(type);
        this.excludedEntities = Arrays.asList(excludedEntities);
    }

    @Override
    public Text getDeathMessage(LivingEntity victim) {
        LivingEntity attacker = victim.getPrimeAdversary();

        String baseKey = "death.attack." + this.getType().msgId();
        String playerKey = baseKey + ".player";

        if (attacker != null) {
            for (EntityType<?> excluded : excludedEntities) {
                if (attacker.getType() == excluded) {
                    return Text.translatable(baseKey, victim.getDisplayName());
                }
            }
            return Text.translatable(playerKey, victim.getDisplayName(), attacker.getDisplayName());
        }

        return Text.translatable(baseKey, victim.getDisplayName());
    }
}