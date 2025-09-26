package toxicstarfall.mymod.registry;

import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import toxicstarfall.mymod.MyMod;
import toxicstarfall.mymod.effect.BleedingEffect;
import toxicstarfall.mymod.effect.GrowthEffect;
import toxicstarfall.mymod.effect.HallucinationEffect;
import toxicstarfall.mymod.effect.RebirthEffect;
import toxicstarfall.mymod.effect.SedatedEffect;


public class ModEffects {

	public static final RegistryEntry<StatusEffect> BLEEDING =
			Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MyMod.MOD_ID, "bleeding"), new BleedingEffect());
	// public static final RegistryEntry<StatusEffect> DECAY =
	// 		Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MyMod.MOD_ID, "decay"), new DecayEffect());
	public static final RegistryEntry<StatusEffect> GROWTH =
			Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MyMod.MOD_ID, "growth"), new GrowthEffect());
	public static final RegistryEntry<StatusEffect> HALLUCINATION =
			Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MyMod.MOD_ID, "hallucination"), new HallucinationEffect());
	public static final RegistryEntry<StatusEffect> REBIRTH =
			Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MyMod.MOD_ID, "rebirth"), new RebirthEffect());
	public static final RegistryEntry<StatusEffect> SEDATED =
			Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MyMod.MOD_ID, "sedated"), new SedatedEffect());


	public static final RegistryKey<DamageType> BLEEDING_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(MyMod.MOD_ID, "bleeding"));

	
	public static void initialize() {}
}
