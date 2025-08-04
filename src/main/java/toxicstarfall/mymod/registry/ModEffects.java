package toxicstarfall.mymod.registry;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import toxicstarfall.mymod.MyMod;
import toxicstarfall.mymod.effect.SedatedEffect;


public class ModEffects {


	public static final RegistryEntry<StatusEffect> SEDATED =
			Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MyMod.MOD_ID, "sedated"), new SedatedEffect());


	public static void initialize() {}
	
}
