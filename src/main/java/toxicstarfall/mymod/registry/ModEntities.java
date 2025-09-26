package toxicstarfall.mymod.registry;

import net.minecraft.entity.EntityType.Builder;
import net.minecraft.entity.EntityType.EntityFactory;

import java.util.function.Function;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
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
import toxicstarfall.mymod.entity.CubeEntity;


public class ModEntities {
	
	public void register(String name, Function<EntityType.Builder, Builder> entityBuilder) {}

	public static final EntityType<CubeEntity> CUBE = Registry.register(
		Registries.ENTITY_TYPE,
		Identifier.of(MyMod.MOD_ID, "cube"),
        EntityType.Builder.create(CubeEntity::new, SpawnGroup.CREATURE).dimensions(0.75f, 0.75f)
			.build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MyMod.MOD_ID, "cube")))
	);
	
			
	public static final EntityType<BoneWitchEntity> BONE_WITCH = Registry.register(
		Registries.ENTITY_TYPE,
		Identifier.of(MyMod.MOD_ID, "bone_witch"),
		EntityType.Builder.create(BoneWitchEntity::new, SpawnGroup.MONSTER).dimensions(1.0f, 2.0f)
			.build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MyMod.MOD_ID, "bone_witch")))
	);
 
    public static void initialize() {
		FabricDefaultAttributeRegistry.register(CUBE, CubeEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(BONE_WITCH, BoneWitchEntity.createMobAttributes());
	}
	
	// public static final EntityModelLayer MODEL_CUBE_LAYER = new EntityModelLayer(Identifier.of("entitytesting", "cube"), "main");
    // public void onInitializeClient() {
    //     /*
    //      * Registers our Cube Entity's renderer, which provides a model and texture for the entity.
    //      *
    //      * Entity Renderers can also manipulate the model before it renders based on entity context (EndermanEntityRenderer#render).
    //      */
    //     EntityRendererRegistry.INSTANCE.register(EntityTesting.CUBE, (context) -> {
    //         return new CubeEntityRenderer(context);
    //     });
    //     // In 1.17, use EntityRendererRegistry.register (seen below) instead of EntityRendererRegistry.INSTANCE.register (seen above)
    //     EntityRendererRegistry.register(EntityTesting.CUBE, (context) -> {
    //         return new CubeEntityRenderer(context);
    //     });
 
    //     EntityModelLayerRegistry.registerModelLayer(MODEL_CUBE_LAYER, CubeEntityModel::getTexturedModelData);
    // }
}
