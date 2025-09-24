package toxicstarfall.mymod.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import net.minecraft.item.Items;
// import net.minecraft.item.Items.COD;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;



@Mixin(Items.class)
public class SalmonellaMixin {
	// @Shadow 
	// public static final COD = Items.register("cod",
	// 	(new Item.Settings()).food(
	// 		FoodComponents.COD,
	// 		ConsumableComponents.food()
	// 			.consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HUNGER, 10*20, 1), 1.0f))
	// 			.build()
	// 	));
	@Shadow @Mutable @Final public static Item COD;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void onItemsInit(CallbackInfo ci) {
        // create a replacement Item with your custom food component
        Settings cod = (new Item.Settings()).food(
			FoodComponents.COD,
			// new FoodComponent.Builder()
			// .saturationModifier(0.1F)
            // .consumeEffect(new ApplyEffectsConsumeEffect(
			// 	new StatusEffectInstance(StatusEffects.HUNGER, 5 * 20, 1), 1.0f))
			// 	.build();,
			ConsumableComponents.food()
				.consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HUNGER, 10*20, 1), 1.0f))
				.build()
		);

        COD = new Item(cod);//new Item.Settings().food(salmonellaFood));
    }

	// @Redirect(method = "<clinit>", at = @At(value = "NEW", target = "net/minecraft/item/CodItem"))
	// private static SnowballItem modifySnowball(Item.Settings settings) {
	// 	return new SnowballItem(new Item.Settings().maxCount(32)); // modify stack size to 32
	// }
	
	// @Mixin(MinecraftClient.class)
	// public interface MinecraftClientAccessor {
		// 	@Accessor
		// 	int getItemUseCooldown();
		// }
	// @Inject(at = @At("HEAD"), method = "init()V")

	// public void onInitialize() {
    //     // Replace raw cod's food component
    //     replaceFood(Items.COD, new FoodComponent.Builder()
    //             // .hunger(2) // original hunger value
    //             .saturationModifier(0.1F) // original saturation
    //             // .consumeEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.3F) 
    //             // Hunger effect: 30% chance, 30s duration (600 ticks), amplifier 0
	// 			.consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HUNGER, 5 * 20, 1), 1.0f))
    //             .build());
	// }

	// @ModifyArg(method = "foo()V", at = @At(value = "INVOKE", target = "La/b/c/Something;doSomething(ZIII)V"), index = 2)
	// private int injected(int x) {
	// 	return x * 3;
	// }	

	// @ModifyArg(method = "foo()V", at = @At(value = "INVOKE", target = "LItems;doSomething(LFoodComponent;LConsumableComponent)V"), index = 2)
	// private int injected(int x) {
	// 	return x * 3;
	// }

	// @ModifyConstant(method = "Items.COD()V", constant = @Constant(intValue = 4))
	// private int injected(int value) {
	// 	return ++value;
	// }


}
