package net.giotfg.provolamod.potion;

import net.giotfg.provolamod.ProvolaMod;
import net.giotfg.provolamod.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;


/**
 * Quando si registra una pozione, le tre varianti (bottiglia, splash e lingering) vengono generate automaticamente e inserite nella categoria pozioni.
 * È necessario inserire la traduzione per i tre tipi di pozione, con queste chiavi di traduzione:
 * <ul><code>item.minecraft.potion.effect.id_che_inserisci_qui</code></ul>
 * <ul><code>item.minecraft.splash_potion.effect.id_che_inserisci_qui</code></ul>
 * <ul><code>item.minecraft.lingering_potion.effect.id_che_inserisci_qui</code></ul>
 *
 * Per la registrazione delle ricette, guardare in {@link ProvolaMod}.
 * */
public class ModPotions {

    public static final RegistryEntry<Potion> SLIMEY_POTION = registerPotion("slimey_potion",
            new Potion(new StatusEffectInstance(ModEffects.SLIMEY, 1200, 0)));

    public static final RegistryEntry<Potion> HEAVY_POTION = registerPotion("heavy_potion",
            new Potion(new StatusEffectInstance(ModEffects.HEAVY, 1200, 0)));

    private static RegistryEntry<Potion> registerPotion (String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(ProvolaMod.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        ProvolaMod.LOGGER.info("Registering potions for " + ProvolaMod.MOD_ID);
    }
}
