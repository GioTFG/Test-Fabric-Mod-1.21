package net.giotfg.provolamod.effect;

import net.giotfg.provolamod.ProvolaMod;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

/**
 * Cose da fare quando si vuole registrare un effetto custom...
 * <ol>
 *     <li>Se l'effetto custom ha un comportamento che va oltre il semplice modificare gli attributi dell'entità a cui è assegnato,
 *     creare una classe custom che estende {@link StatusEffect} e utilizza i suoi metodi per dettare il nuovo comportamento.</li>
 *     <li>Registrare qui in questa classe il nuovo effetto come costante di tipo RegistryEntry (quindi creata con registerReference).</li>
 *     <li>Nella registrazione istanziare il solo e unico oggetto dell'effetto custom (è necessario creare una nuova classe
 *     anche se l'oggetto cambia solo gli attributi perché {@link StatusEffect} è protected.</li>
 *     <li>Aggiungere gli eventuali modificatori di attributi</li>
 *     <li>Sistemare tutti gli asset...<ul>
 *         <li>Aggiungere le traduzioni in <code>lang</code></li>
 *         <li>Aggiungere la texture in <code>textures/mob_effect</code> (un png 18x18)</li>
 *     </ul></li>
 * </ol>*/
public class ModEffects {

    public static final RegistryEntry<StatusEffect> SLIMEY = registerStatusEffect("slimey",
            new SlimeyEffect(StatusEffectCategory.NEUTRAL, 0x36ebab)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(ProvolaMod.MOD_ID, "slimey"), -0.25f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));


//  Per l'effetto "heavy occorrerebbe creare una classe custom che non cambia nulla visto che la superclasse è protetta.

    public static final RegistryEntry<StatusEffect> HEAVY = registerStatusEffect("heavy",
            new HeavyEffect(StatusEffectCategory.HARMFUL, 0x212121)
                    .addAttributeModifier(EntityAttributes.GENERIC_GRAVITY,
                            Identifier.of(ProvolaMod.MOD_ID, "heavy"), 3f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(ProvolaMod.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        ProvolaMod.LOGGER.info("Registering effects for " + ProvolaMod.MOD_ID);
    }
}
