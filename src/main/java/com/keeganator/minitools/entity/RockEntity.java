package com.keeganator.minitools.entity;

import com.keeganator.minitools.block.ModBlocks;
import com.keeganator.minitools.damagetypes.ModDamageTypes;
import com.keeganator.minitools.item.ModItems;
import com.keeganator.minitools.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RockEntity extends ThrownItemEntity {

    private int i = this.random.nextInt(17);
    private int j = 2000;

    public RockEntity(EntityType<? extends RockEntity> type, World world) {
        super(type, world);
    }

    public RockEntity(World world, LivingEntity owner) {
        super(ModEntities.ROCK_ENTITY, world);
        this.setOwner(owner);
        this.setPosition(owner.getX(), owner.getEyeY() - 0.1, owner.getZ());
    }

    public RockEntity(World world, double x, double y, double z) {
        super(ModEntities.ROCK_ENTITY, world);
        this.setPosition(x, y, z);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.ROCK;
    }


    private ParticleEffect getParticle() {
        ItemStack stack = this.getStack();
        return stack.isEmpty()
                ? (ParticleEffect) ParticleTypes.ITEM
                : new ItemStackParticleEffect(ParticleTypes.ITEM, stack);
    }

    @Override
    public void handleStatus(byte status) {
        if (status == 3) {
            ParticleEffect particle = getParticle();
            for (int i = 0; i < 8; i++) {
                this.getEntityWorld().addParticleClient(
                        particle,
                        this.getX(),
                        this.getY(),
                        this.getZ(),
                        0, 0, 0
                );
            }
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult result) {
        super.onEntityHit(result);

        if (this.getEntityWorld().isClient()) {
            return;
        }

        Entity target = result.getEntity();
        float damage = 3f;

        if (target.getType() == EntityType.CHICKEN || target.getType() == EntityType.PARROT) {
            damage = 5f;
        }

        target.damage((ServerWorld) this.getEntityWorld(), ModDamageTypes.rock(this.getEntityWorld(), this, this.getOwner()), damage);
        if (target.getType() != EntityType.IRON_GOLEM) {
            target.addVelocity(
                    (target.getX() - this.getX()) * 0.5,
                    (target.getY() + 0.5 - this.getY()) * 0.5,
                    (target.getZ() - this.getZ()) * 0.5
            );
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult result) {
        super.onBlockHit(result);

        BlockPos pos = result.getBlockPos();
        BlockState state = this.getEntityWorld().getBlockState(pos);

        BlockPos pos2 = result.getBlockPos().up();
        BlockState state2 = this.getEntityWorld().getBlockState(pos2);

        if (!this.getEntityWorld().isClient()) {
            if (state.isIn(ModTags.Blocks.GLASS)) {
                    this.getEntityWorld().breakBlock(pos, false);
            } else if (state2.isIn(ModTags.Blocks.ROCK_REPLACEABLE) || state2.isAir() || state2.getFluidState().isStill()) {
                if (this.getEntityWorld().getBlockState(pos).isSolidBlock(this.getEntityWorld(), pos)) {
                    this.getEntityWorld().setBlockState(pos2, ModBlocks.ROCK_BLOCK.getDefaultState(), Block.NOTIFY_ALL);
                } else {
                    this.dropStack((ServerWorld) this.getEntityWorld(), ModItems.ROCK.getDefaultStack());
                }
            } else {
                this.dropStack((ServerWorld) this.getEntityWorld(), ModItems.ROCK.getDefaultStack());
            }

            this.getEntityWorld().sendEntityStatus(this, (byte) 3);
            this.discard();
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (j-- <= 0) {
            this.discard();
            this.dropStack((ServerWorld) this.getEntityWorld(), this.getStack());
            return;
        }
        if (this.isTouchingWater()) {
            boolean tooDeep = true;
            for (int depth = 1; depth <= 1; depth++) {
                if (this.getEntityWorld().getBlockState(this.getBlockPos().up(depth)).isAir()) {
                    tooDeep = false;
                    break;
                }
            }

            double horizontalSpeedSq = this.getVelocity().horizontalLengthSquared();
            if (horizontalSpeedSq < 0.01) {
                this.i = 0;
            }

            if (i > 0) {
                var currentVel = this.getVelocity();

                this.setVelocity(currentVel.x, (currentVel.y * 0.5) + 0.3, currentVel.z);
                this.setPos(this.getX(), this.getY() + 0.1, this.getZ());
                i--;

                // splash sound?
            }
        }
    }
}