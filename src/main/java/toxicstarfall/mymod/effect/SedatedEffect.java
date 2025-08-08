package toxicstarfall.mymod.effect;

import java.io.ObjectInputFilter.Status;

import com.google.common.collect.Multimap;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributeModifier.Operation;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;


public class SedatedEffect extends StatusEffect {
	public SedatedEffect() {
		super(StatusEffectCategory.HARMFUL, 0xe9b8b3);
	}

	// Called every tick to check if the effect can be applied or not
	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		// In our case, we just make it return true so that it applies the effect every tick
		return true;
	}

	// Called when the effect is applied.
	public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
		// MobEntity
		// StatusEffectInstance
		// StatusEffects.OOZING
		// OozingStatusEffect

		// if (entity instanceof PlayerEntity) {
		// 	((PlayerEntity) entity).addExperience(1 << amplifier); // Higher amplifier gives you experience faster
		// }

		if (entity instanceof MobEntity) {
			entity.setMovementSpeed(0.0f);
			// entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS));
			// entity.stopMovement();
			// entityAttributeInstance.addTemporaryModifier(new EntityAttributeModifier(POWDER_SNOW_SPEED_MODIFIER_ID, (double)f, Operation.ADD_VALUE));
			
			// entity.addAttributeModifier(Attributes.MOVEMENT_SPEED, "frozen", 0, AttributeModifier.Operation.MULTIPLY_TOTAL);
	
			// entity.getAttributeInstance(null).addTemporaryModifier(new EntityAttributeModifier(null, -1, Operation.ADD_VALUE));
		}
		// final EntityAttributeModifier BABY_SPEED_BONUS = new EntityAttributeModifier(BABY_SPEED_MODIFIER_ID, 0.5, Operation.ADD_MULTIPLIED_BASE);
		// entityAttributeInstance.addTemporaryModifier(BABY_SPEED_BONUS);
		
		return super.applyUpdateEffect(world, entity, amplifier);
	}
}
