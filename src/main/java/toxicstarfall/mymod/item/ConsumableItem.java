package toxicstarfall.mymod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;

import toxicstarfall.mymod.MyMod;


public class ConsumableItem extends Item {

	public ConsumableItem(Settings settings) {
		super(settings);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
			.register((itemGroup) -> itemGroup.add(this));
	}

}