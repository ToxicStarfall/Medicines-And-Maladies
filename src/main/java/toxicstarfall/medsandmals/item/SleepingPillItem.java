package toxicstarfall.medsandmals.item;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import toxicstarfall.medsandmals.MedsAndMals;
import toxicstarfall.medsandmals.registry.ModEffects;


public class SleepingPillItem extends ConsumableItem {

	public SleepingPillItem(Settings settings) {
		super(settings);
	}
	
	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		// MedsAndMals.LOGGER.info("Bleeding cleared");
		// world.getTime()
		
		
		return super.finishUsing(stack, world, user);

    	// ConsumableComponent consumableComponent = (ConsumableComponent)stack.get(DataComponentTypes.CONSUMABLE);
    	// return consumableComponent != null ? consumableComponent.finishConsumption(world, user, stack) : stack;
   }
}