package toxicstarfall.mymod.registry;

import java.util.function.Function;

import com.jcraft.jorbis.Block;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

import toxicstarfall.mymod.MyMod;
import toxicstarfall.mymod.item.ConsumableItem;
import toxicstarfall.mymod.item.FoodValues;
import toxicstarfall.mymod.item.FoodValues.ConsumableValues;


public class ModItems {

	public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
		// Create the item key.
		RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MyMod.MOD_ID, name));
		// Create the item instance.
		Item item = itemFactory.apply(settings.registryKey(itemKey));
		// Register the item.
		Registry.register(Registries.ITEM, itemKey, item);
		
		return item;
	}


	// public static final ToolMaterial GUIDITE_TOOL_MATERIAL = new ToolMaterial(
	// 	BlockTags.INCORRECT_FOR_WOODEN_TOOL,  //Blocks which wont drop
	// 	455, // Durability
	// 	5.0F, // Tool speed
	// 	1.5F, // Damage bonus
	// 	22, // Echantability
	// 	GuiditeArmorMaterial.REPAIRS_GUIDITE_ARMOR // Allows material to repair Tools made with it
	// );

	// public static final Item GUIDITE_SWORD = register(
	// 	"guidite_sword",
	// 	settings -> new SwordItem(GUIDITE_TOOL_MATERIAL, 1f, 1f, settings),
	// 	new Item.Settings()
	// );

	public static final Item BANDAGE = register("bandage",
			ConsumableItem::new, new Item.Settings().food(FoodValues.BANDAGE, FoodValues.ConsumableValues.BANDAGE));
	public static final Item POPPY_SEED = register("poppy_seed",
			ConsumableItem::new, new Item.Settings().food(FoodValues.POPPY_SEED, FoodValues.ConsumableValues.POPPY_SEED));
	public static final Item POPPY_CRACKER = register("poppy_cracker",
			ConsumableItem::new, new Item.Settings().food(FoodValues.POPPY_CRACKER));
	public static final Item SHROOM = register("shroom",
			ConsumableItem::new, new Item.Settings().food(FoodValues.SHROOM, FoodValues.ConsumableValues.SHROOM));
	public static final Item SOME_ITEM = register("some_item",
			ConsumableItem::new, new Item.Settings().food(FoodValues.SOME_ITEM));
	
	// public static final Item ANTIDOTE = register("shroom", Item::new, new Item.Settings());
	// public static final Item CLOTH = register("shroom", Item::new, new Item.Settings());
	// public static final Item HEMP = register("shroom", Item::new, new Item.Settings());
	// public static final Item HERBAL_TEA = register("shroom", Item::new, new Item.Settings());
	// public static final Item NIGHTSHADE = register("shroom", Item::new, new Item.Settings());

	// public static final Item NECROTIC_ARROW = register("shroom", Item::new, new Item.Settings());

	
	public static void initialize() {}

}