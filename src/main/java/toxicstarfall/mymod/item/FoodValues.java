package toxicstarfall.mymod.item;

import net.minecraft.component.type.FoodComponent;
// import net.minecraft.component.type.FoodComponents;
// import net.minecraft.component.type.Consumable;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
// import net.minecraft.item.Item;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;


public class FoodValues {
	// public static final FoodComponent ANTI_BIOTIC = (new FoodComponent.Builder())
	// 		.nutrition(0).saturationModifier(0.0F).build();
	public static final FoodComponent BANDAGE = (new FoodComponent.Builder())
			.nutrition(0).saturationModifier(0.0F).build();
	public static final FoodComponent POPPY_SEED = (new FoodComponent.Builder())
			.nutrition(0).saturationModifier(0.1F).alwaysEdible().build();
	public static final FoodComponent POPPY_CRACKER = (new FoodComponent.Builder())
			.nutrition(3).saturationModifier(0.3F).build();
	public static final FoodComponent SHROOM = (new FoodComponent.Builder())
			.nutrition(4).saturationModifier(0.3F).build();
	public static final FoodComponent SOME_ITEM = (new FoodComponent.Builder())
			.nutrition(4).saturationModifier(0).build();
	// public static final FoodComponent Ophiocordyceps = (new FoodComponent.Builder())
	// 		.nutrition(4).saturationModifier(0.3F).build();
	

	public class ConsumableValues {
		// Duration is in ticks, 20 ticks = 1 second

		// General Consumable Effects
		public static final ConsumableComponent POISON_FOOD_CONSUMABLE_COMPONENT = ConsumableComponents.food()
			.consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 6 * 20, 1), 1.0f))
			.build();


		// Specific Consumables Effects
		public static final ConsumableComponent BANDAGE = ConsumableComponents.food()
			.consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, -1), 1.0f))
			.consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 10 * 20, 1), 0.1f))
			.build();
		public static final ConsumableComponent POPPY_SEED = ConsumableComponents.food()
			.consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HUNGER, 5 * 20, 1), 1.0f))
			.build();
		public static final ConsumableComponent SHROOM = ConsumableComponents.food()
			.consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 1), 1.0f))
			.consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20 * 20, 2), 1.0f))
			.consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 20, 1), 1.0f))
			// .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects., 20 * 20, 1), 1.0f))
			.build();
		// public static final ConsumableComponent NIGHTSHADE = ConsumableComponents.food()
		// 	.consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 10 * 20, 1), 0.25f))
		// 	.build();

		
		// public static final ConsumableComponent AASD = ConsumableComponent.food();//defaultDrink()

		// public static final Consumable APPLE_CIDER = Consumables.defaultDrink()
		// 	.onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.ABSORPTION, 1200, 0)))
		// 	.build();
	}
}