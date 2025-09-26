package toxicstarfall.medsandmals.registry;

import java.util.function.Function;

import com.jcraft.jorbis.Block;
import com.mojang.brigadier.context.CommandContext;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassBlock;
import net.minecraft.command.CommandSource;
import net.minecraft.data.loottable.LootTableData;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.command.CommandManager;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.WorldProperties;
import toxicstarfall.medsandmals.MedsAndMals;
import toxicstarfall.medsandmals.item.BandageItem;
import toxicstarfall.medsandmals.item.ConsumableItem;
import toxicstarfall.medsandmals.item.FoodValues;
import toxicstarfall.medsandmals.item.FoodValues.ConsumableValues;


public class ModItems {

	public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
		// Create the item key.
		RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MedsAndMals.MOD_ID, name));
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
			BandageItem::new, new Item.Settings().food(FoodValues.BANDAGE, FoodValues.ConsumableValues.BANDAGE));
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

	// World

	public static final Potion BLEEDING_POTION = Registry.register(
			Registries.POTION,
			Identifier.of(MedsAndMals.MOD_ID, "bleeding"),
			new Potion("bleeding",
				new StatusEffectInstance(ModEffects.BLEEDING, 1200, 1)
			));
	public static final Potion HALLUCINATION_POTION = Registry.register(
			Registries.POTION,
			Identifier.of(MedsAndMals.MOD_ID, "hallucination"),
			new Potion("hallucination",
				new StatusEffectInstance(ModEffects.HALLUCINATION, 1200, 1)
			));
	public static final Potion REBIRTH_POTION = Registry.register(
			Registries.POTION,
			Identifier.of(MedsAndMals.MOD_ID, "rebirth"),
			new Potion("rebirth",
				new StatusEffectInstance(ModEffects.REBIRTH, 1200, 1)
			));


	public static void initialize() {
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(
					Potions.WATER,
					Items.IRON_NUGGET,
					Registries.POTION.getEntry(BLEEDING_POTION)
			);
		});
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(
					Potions.WATER,
					Items.BROWN_MUSHROOM,
					Registries.POTION.getEntry(HALLUCINATION_POTION)
			);
		});
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(
					Potions.WATER,
					Items.GOLDEN_APPLE,
					Registries.POTION.getEntry(REBIRTH_POTION)
			);
		});
		// Blocks
		// Items.WHEAT_SEEDS
		// CommandManager
		// CommandContext
		// LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
		// 	// Let's only modify built-in loot tables and leave data pack loot tables untouched by checking the source.
		// 	// We also check that the loot table ID is equal to the ID we want.
		// 	if (source.isBuiltin() && LootTables.equals(key)) {
		// 		// We make the pool and add an item
		// 		LootPool.Builder poolBuilder = LootPool.builder().with(ItemEntry.builder(Items.EGG));
		// 		tableBuilder.pool(poolBuilder);
		// 	}
		// });
	}

}