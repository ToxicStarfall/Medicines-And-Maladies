package toxicstarfall.medsandmals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import toxicstarfall.medsandmals.registry.ModBlocks;
import toxicstarfall.medsandmals.registry.ModEffects;
import toxicstarfall.medsandmals.registry.ModEntities;
import toxicstarfall.medsandmals.registry.ModItems;

public class MedsAndMals implements ModInitializer {
	
	public static final String MOD_ID = "medsandmals";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("Hello Fabric world!");
		
		// LOGGER.info("Lo!");
		ModBlocks.initialize();
		ModItems.initialize();
		ModEffects.initialize();
		ModEntities.initialize();

	}
}