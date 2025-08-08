package toxicstarfall.mymod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;


public class HallucinationEffect extends StatusEffect {
	public HallucinationEffect() {
		super(StatusEffectCategory.HARMFUL, 0xcb3dff);	
	}

	public void onApplied(LivingEntity entity, int amplifier) {
		entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA));
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		// if (duration % 80 == 0) {
			// return Math.random() - 0.5f > 0.5;
		// }
		return duration % 80 == 0;
	}

	public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
		// MyMod.LOGGER.info("Growth effect applied this tick");
		if (entity instanceof PlayerEntity) {
			// if full health, damage first
			if (entity.getHealth() == entity.getMaxHealth()) {
				entity.damage(world, null, 1.0f);
				entity.heal(1.0f);
			}
			// else, if damaged, healing first
			else {
				entity.heal(1.0f);
				entity.damage(world, new DamageSource(RegistryKeys.DAMAGE_TYPE, DamageTypes.MAGIC), 1.0f);
			}
		}
		
		return super.applyUpdateEffect(world, entity, amplifier);
	}
}