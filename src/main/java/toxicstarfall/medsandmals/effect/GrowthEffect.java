package toxicstarfall.medsandmals.effect;

import net.minecraft.enchantment.effect.AllOfEnchantmentEffects.EntityEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;

import toxicstarfall.medsandmals.MedsAndMals;


public class GrowthEffect extends StatusEffect {
	/* 
	 * Slowly heal, increasing healing over duration
	 * Gain extra protection(absorbtion), however take that much extra damage.
	 * 
	 * LVL 1 - Duration 30 seconds
	 * +1 hp / 8 seconds, 
	 * 
	 */
	public GrowthEffect() {
		super(StatusEffectCategory.BENEFICIAL, 14545909);
	}
	

	// Called every tick to check if the effect can be applied or not
	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return duration % 160 == 0;
	}

	// Called when the effect is applied.
	public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
		MedsAndMals.LOGGER.info("Growth effect applied this tick");
		
		if (entity instanceof PlayerEntity) {
			// if (entity.getFoodData().getSaturationLevel() > 0.0) {
				// 	return true;
				// }
			if (entity.getHealth() < entity.getMaxHealth()) {
				entity.heal(1.0F);
				MedsAndMals.LOGGER.info("Growth heals for 1.0");
			}
		}
		
		return super.applyUpdateEffect(world, entity, amplifier);
	}
}

