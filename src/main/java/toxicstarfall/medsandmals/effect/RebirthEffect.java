package toxicstarfall.medsandmals.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.Entity.RemovalReason;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

import toxicstarfall.medsandmals.MedsAndMals;


public class RebirthEffect extends StatusEffect {
	public RebirthEffect() {
		super(StatusEffectCategory.BENEFICIAL, 0xe9b8b3);
	}

	public void onEntityRemoval(ServerWorld world, LivingEntity entity, int amplifier, Entity.RemovalReason reason) {
		if (reason == RemovalReason.KILLED) {
			// MedsAndMals.LOGGER.info("Applying Rebirth LVL-{}", amplifier);
			Float spawnChance = 0.4f;
			for (int i = 0; i < amplifier - 1; i++) {
				spawnChance = spawnChance + spawnChance * 0.5f;
			}
			
			// MedsAndMals.LOGGER.info("Rebirth effect chance:{}", spawnChance);
			if (spawnChance >= Math.random()) {
				this.respawnEntity(entity.getWorld(), entity.getX(), entity.getY() + 0.5, entity.getZ(), entity);
			}
		}
	}
	
	private void respawnEntity(World world, double x, double y, double z, Entity entity) {
		Entity entityToSpawn = entity.getType().create(world, SpawnReason.TRIGGERED);
		
		if (entityToSpawn != null) {
			entityToSpawn.refreshPositionAndAngles(x, y, z, world.getRandom().nextFloat() * 360.0F, 0.0F);
			world.spawnEntity(entityToSpawn);
		}
	}
}
