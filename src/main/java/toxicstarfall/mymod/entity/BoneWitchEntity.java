package toxicstarfall.mymod.entity;

import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.mob.WitchEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.thrown.SplashPotionEntity;
import net.minecraft.entity.raid.RaiderEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BoneWitchEntity extends WitchEntity {
	public BoneWitchEntity(EntityType<? extends WitchEntity> entityType, World world) {
      super(entityType, world);
   }

//    @Override
   public void shootAt(LivingEntity target, float pullProgress) {
      if (!this.isDrinking()) {
         Vec3d vec3d = target.getVelocity();
         double d = target.getX() + vec3d.x - this.getX();
         double e = target.getEyeY() - 1.100000023841858 - this.getY();
         double f = target.getZ() + vec3d.z - this.getZ();
         double g = Math.sqrt(d * d + f * f);
         RegistryEntry<Potion> registryEntry = Potions.HARMING;
         if (target instanceof RaiderEntity) {
            if (target.getHealth() <= 4.0F) {
               registryEntry = Potions.HEALING;
            } else {
               registryEntry = Potions.REGENERATION;
            }

            this.setTarget((LivingEntity)null);
         } else if (g >= 8.0 && !target.hasStatusEffect(StatusEffects.SLOWNESS)) {
            registryEntry = Potions.SLOWNESS;
         } else if (target.getHealth() >= 8.0F && !target.hasStatusEffect(StatusEffects.POISON)) {
            registryEntry = Potions.POISON;
         } else if (g <= 3.0 && !target.hasStatusEffect(StatusEffects.WEAKNESS) && this.random.nextFloat() < 0.25F) {
            registryEntry = Potions.WEAKNESS;
         }

         World var14 = this.getWorld();
         if (var14 instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld)var14;
            // ItemStack itemStack = PotionContentsComponent.createStack(Items.SPLASH_POTION, registryEntry);
            // ProjectileEntity.spawnWithVelocity(SplashPotionEntity::new, serverWorld, itemStack, this, d, e + g * 0.2, f, 0.75F, 8.0F);

			Entity skeletonReinforcement = EntityType.SKELETON.create(serverWorld, SpawnReason.REINFORCEMENT);
			// SkeletonEntity.create
			serverWorld.spawnEntity(skeletonReinforcement);
			// world.spawnEntity(entityToSpawn);
         }

         if (!this.isSilent()) {
            this.getWorld().playSound((Entity)null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_WITCH_THROW, this.getSoundCategory(), 1.0F, 0.8F + this.random.nextFloat() * 0.4F);
         }

      }
   }

}