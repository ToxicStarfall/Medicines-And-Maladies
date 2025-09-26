package toxicstarfall.medsandmals.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import toxicstarfall.medsandmals.MedsAndMals;
import toxicstarfall.medsandmals.registry.ModEffects;

public class BandageItem extends ConsumableItem {

	public BandageItem(Settings settings) {
		super(settings);
	}
	
	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		user.removeStatusEffect(ModEffects.BLEEDING);
		MedsAndMals.LOGGER.info("Bleeding cleared");
		return super.finishUsing(stack, world, user);

    	// ConsumableComponent consumableComponent = (ConsumableComponent)stack.get(DataComponentTypes.CONSUMABLE);
    	// return consumableComponent != null ? consumableComponent.finishConsumption(world, user, stack) : stack;
   }
}
