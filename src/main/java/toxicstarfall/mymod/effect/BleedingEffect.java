package toxicstarfall.mymod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;


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
		// MyMod.LOGGER.info("Growth effect applied this tick");
		
		entity.damage(world, null, amplifier);
		
		return super.applyUpdateEffect(world, entity, amplifier);
	}
}

