package toxicstarfall.medsandmals.registry;

import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import toxicstarfall.medsandmals.MedsAndMals;
import toxicstarfall.medsandmals.effect.BleedingEffect;
import toxicstarfall.medsandmals.effect.GrowthEffect;
import toxicstarfall.medsandmals.effect.HallucinationEffect;
import toxicstarfall.medsandmals.effect.RebirthEffect;
import toxicstarfall.medsandmals.effect.SedatedEffect;


public class ModEffects {

	public static final RegistryEntry<StatusEffect> BLEEDING =
			Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MedsAndMals.MOD_ID, "bleeding"), new BleedingEffect());
	// public static final RegistryEntry<StatusEffect> DECAY =
	// 		Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MedsAndMals.MOD_ID, "decay"), new DecayEffect());
	public static final RegistryEntry<StatusEffect> GROWTH =
			Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MedsAndMals.MOD_ID, "growth"), new GrowthEffect());
	public static final RegistryEntry<StatusEffect> HALLUCINATION =
			Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MedsAndMals.MOD_ID, "hallucination"), new HallucinationEffect());
	public static final RegistryEntry<StatusEffect> REBIRTH =
			Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MedsAndMals.MOD_ID, "rebirth"), new RebirthEffect());
	public static final RegistryEntry<StatusEffect> SEDATED =
			Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MedsAndMals.MOD_ID, "sedated"), new SedatedEffect());


	public static final RegistryKey<DamageType> BLEEDING_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(MedsAndMals.MOD_ID, "bleeding"));

	
	public static void initialize() {}
}
