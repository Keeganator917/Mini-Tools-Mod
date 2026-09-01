package keeganator.minitools.entity;

import keeganator.minitools.block.ModBlocks;
import keeganator.minitools.damagetypes.ModDamageTypes;
import keeganator.minitools.item.ModItems;
import keeganator.minitools.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class RockEntity extends ThrowableItemProjectile {

    private int i = this.random.nextInt(17);
    private int j = 2000;

    public RockEntity(EntityType<? extends RockEntity> type, Level level) {
        super(type, level);
    }

    public RockEntity(Level level, LivingEntity owner) {
        super(ModEntities.ROCK_ENTITY, level);
        this.setOwner(owner);
        this.setPos(owner.getX(), owner.getEyeY() - 0.1, owner.getZ());
    }

    public RockEntity(Level level, double x, double y, double z) {
        super(ModEntities.ROCK_ENTITY, level);
        this.setPos(x, y, z);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.ROCK;
    }


    private ParticleOptions getParticle() {
        ItemStack stack = this.getItem();
        return stack.isEmpty() ? (ParticleOptions) ParticleTypes.ITEM : new ItemParticleOption(ParticleTypes.ITEM, stack.getItem());
    }

    @Override
    public void handleEntityEvent(byte status) {
        if (status == 3) {
            ParticleOptions particle = getParticle();
            for (int i = 0; i < 8; i++) {
                this.level().addParticle(particle, this.getX(), this.getY(), this.getZ(), 0, 0, 0);
            }
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);

        if (this.level().isClientSide()) {
            return;
        }

        Entity target = result.getEntity();
        float damage = 3f;

        if (target.getType() == EntityTypes.CHICKEN || target.getType() == EntityTypes.PARROT) {
            damage = 5f;
        }

        target.hurtServer((ServerLevel) this.level(), ModDamageTypes.rock(this.level(), this, this.getOwner()), damage);
        this.discard();
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);

        BlockPos pos = result.getBlockPos();
        BlockState state = this.level().getBlockState(pos);

        BlockPos pos2 = result.getBlockPos().above();
        BlockState state2 = this.level().getBlockState(pos2);

        if (!this.level().isClientSide()) {
            if (state.is(ModTags.Blocks.GLASS)) {
                this.level().destroyBlock(pos, false);
            } else if (state2.is(ModTags.Blocks.ROCK_REPLACEABLE)) {
                if (this.level().getBlockState(pos).isCollisionShapeFullBlock(this.level(), pos)) {
                    this.level().setBlock(pos2, ModBlocks.ROCK_BLOCK.defaultBlockState(), Block.UPDATE_ALL);
                } else {
                    this.spawnAtLocation((ServerLevel) this.level(), ModItems.ROCK.getDefaultInstance());
                }
            } else {
                this.spawnAtLocation((ServerLevel) this.level(), ModItems.ROCK.getDefaultInstance());
            }

            this.level().broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (j-- <= 0) {
            this.discard();
            this.spawnAtLocation((ServerLevel) this.level(), this.getItem());
            return;
        }
        if (this.isInWater()) {
            boolean tooDeep = true;
            for (int depth = 1; depth <= 1; depth++) {
                if (this.level().getBlockState(this.blockPosition().above(depth)).isAir()) {
                    tooDeep = false;
                    break;
                }
            }

            double horizontalSpeedSq = this.getDeltaMovement().horizontalDistanceSqr();
            if (horizontalSpeedSq < 0.01) {
                this.i = 0;
            }

            if (i > 0) {
                var currentVel = this.getDeltaMovement();

                this.setDeltaMovement(currentVel.x, (currentVel.y * 0.5) + 0.3, currentVel.z);
                this.setPosRaw(this.getX(), this.getY() + 0.1, this.getZ());
                i--;

                // splash sound?
            }
        }
    }
}