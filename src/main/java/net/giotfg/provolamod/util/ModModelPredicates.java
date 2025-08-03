package net.giotfg.provolamod.util;

import net.giotfg.provolamod.ProvolaMod;
import net.giotfg.provolamod.component.ModDataComponentTypes;
import net.giotfg.provolamod.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicates {
    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.MAGIC_GINO, Identifier.of(ProvolaMod.MOD_ID, "used"),
                ((stack, world, entity, seed) -> stack.get(ModDataComponentTypes.COORDINATES) != null ? 1f : 0f));
    }
}
