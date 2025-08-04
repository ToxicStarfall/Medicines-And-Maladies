package toxicstarfall.mymod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;


public class BasicItem extends Item {
	public BasicItem(Settings settings) {
		super(settings);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.SEARCH)
			.register((itemGroup) -> itemGroup.add(this));
	}

	// public static Item addItemGroup(Item item, ItemGroups itemGroupEnum) {
	// 	ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
	// 		.register((itemGroup) -> itemGroup.add(ModItems.SOME_ITEM));
	// 	return item;
	// }
	
}
