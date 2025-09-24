package toxicstarfall.mymod.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import toxicstarfall.mymod.MyMod;
import toxicstarfall.mymod.registry.ModEffects;

public class AdrenalineShotItem extends ConsumableItem {

	public AdrenalineShotItem(Settings settings) {
		super(settings);
	}
	
	// @Override
	// public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
	// 	user.removeStatusEffect(ModEffects.BLEEDING);
	// 	MyMod.LOGGER.info("Bleeding cleared");
	// 	return super.finishUsing(stack, world, user);

    	// ConsumableComponent consumableComponent = (ConsumableComponent)stack.get(DataComponentTypes.CONSUMABLE);
    	// return consumableComponent != null ? consumableComponent.finishConsumption(world, user, stack) : stack;
//    }
}
