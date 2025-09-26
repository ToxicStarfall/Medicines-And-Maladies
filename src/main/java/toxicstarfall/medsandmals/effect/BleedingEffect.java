package toxicstarfall.medsandmals.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;

import toxicstarfall.medsandmals.MedsAndMals;
import toxicstarfall.medsandmals.registry.ModEffects;


public class BleedingEffect extends StatusEffect {
	/* 
	 *
	 */
	public BleedingEffect() {
		super(StatusEffectCategory.HARMFUL, 0xa61c23);
	}
	

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return duration % 120 == 0; // applies every 6 seconds
	}

	// Called when the effect is applied.
	public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
		// MedsAndMals.LOGGER.info("Bleeding effect applied this tick");
		
		DamageSource damageSource = new DamageSource(
			world.getRegistryManager()
					.getOrThrow(RegistryKeys.DAMAGE_TYPE)
					.getEntry(ModEffects.BLEEDING_DAMAGE.getValue()).get()
		);

		entity.damage(
			world,
			damageSource,
			amplifier
		);
		return super.applyUpdateEffect(world, entity, amplifier);
	}
}

