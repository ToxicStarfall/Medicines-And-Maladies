package toxicstarfall.mymod.registry;

import net.minecraft.entity.EntityType.Builder;
import net.minecraft.entity.EntityType.EntityFactory;

import java.util.function.Function;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import toxicstarfall.mymod.MyMod;
import toxicstarfall.mymod.entity.BoneWitchEntity;


public class ModEntities {
	
	public void register(String name, Function<EntityType.Builder, Builder> entityBuilder) {
		// Create the item key.
		// RegistryKey<EntityType> entityKey = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MyMod.MOD_ID, name));
		// Create the item instance.
		// EntityAttribute entity = entityFactory.apply(settings.registryKey(entityKey));
		// Register the item.
		
		// Registry.register(
		// 		Registries.ENTITY_TYPE,
		// 		Identifier.of(MyMod.MOD_ID, name)
		// 		// entityBuilder
		// 		EntityType.Builder.create(CubeEntity::new, SpawnGroup.CREATURE).dimensions(0.75f, 0.75f).build("cube")
		// );
		
		// return entity;
	}

	// public static final EntityType<Entity> CUBE = Registry.register(
	// 	Registries.ENTITY_TYPE,
	// 	Identifier.of(MyMod.MOD_ID, name),
    //     EntityType.Builder.create(CubeEntity::new, SpawnGroup.CREATURE).dimensions(0.75f, 0.75f).build("cube")
	// );
	
			
	// public static final EntityType<BoneWitchEntity> BONE_WITCH = Registry.register(
	// 	Registries.ENTITY_TYPE,
	// 	Identifier.of(MyMod.MOD_ID, "bone_witch"),
	// 	EntityType.Builder.create(BoneWitchEntity::new, SpawnGroup.MONSTER).dimensions(1.0f, 2.0f).build("bone_witch")
	// );

	// public static final Entity BONE_WITCH = register("bone_witch",
	// 		BoneWitchEntity::new,
    //         EntityType.Builder.create( SpawnGroup.MONSTER).dimensions(0.75f, 0.75f).build("cube")
	// 		);
 
    public static void initialize() {}
}
