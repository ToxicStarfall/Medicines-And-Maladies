package toxicstarfall.mymod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import toxicstarfall.mymod.MyMod;


public class HallucinationEffect extends StatusEffect {
	public HallucinationEffect() {
		super(StatusEffectCategory.HARMFUL, 0xcb3dff);	
	}

	public void onApplied(LivingEntity entity, int amplifier) {
		entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA));
		MyMod.LOGGER.info("applied nausea with HallucinationEffect");
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		// 50% chance to apply every 3 seconds
		if (duration % 60 == 0) {
			if (Math.random() - 0.5f > 0.5) {
				return true;
			}
			else { return false; }
		}
		else { return false; }
		// return duration % 80 == 0;
	}

	public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
		// MyMod.LOGGER.info("Growth effect applied this tick");
		if (entity instanceof PlayerEntity) {
			// if full health, damage first
			// if (entity.getHealth() == entity.getMaxHealth()) {
			// 	entity.damage(world, null, 1.0f);
			// 	entity.heal(1.0f);
			// }
			// else, if damaged, healing first
			// else {
			// DamageSources
			entity.heal(1.0f);
			entity.damage(world, entity.getDamageSources().magic(), 1.0f);
		}
		
		return super.applyUpdateEffect(world, entity, amplifier);
	}
}