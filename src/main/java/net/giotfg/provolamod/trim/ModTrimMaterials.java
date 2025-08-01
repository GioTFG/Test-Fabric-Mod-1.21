package net.giotfg.provolamod.trim;

import net.giotfg.provolamod.ProvolaMod;
import net.giotfg.provolamod.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.trim.ArmorTrimMaterial;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class ModTrimMaterials {
    public static final RegistryKey<ArmorTrimMaterial> GINO = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(ProvolaMod.MOD_ID, "gino"));

//    Si fa partire con datagen
    public static void bootstrap(Registerable<ArmorTrimMaterial> registerable) {
        register(registerable, GINO, Registries.ITEM.getEntry(ModItems.GINO),
                Style.EMPTY.withColor(TextColor.parse("#ff7518").getOrThrow()), 0.5f);
//        itemModelIndex si rifa a dei valori standard degli oggetti vanilla. 0.5 è del rame, più vicino all'arancione che voglio.
    }

    private static void register(Registerable<ArmorTrimMaterial> registerable, RegistryKey<ArmorTrimMaterial> armorTrimKey,
                                 RegistryEntry<Item> item, Style style, float itemModelIndex) {
        ArmorTrimMaterial trimMaterial = new ArmorTrimMaterial(armorTrimKey.getValue().getPath(), item, itemModelIndex, Map.of(),
                Text.translatable(Util.createTranslationKey("trim_material", armorTrimKey.getValue())).fillStyle(style));

        registerable.register(armorTrimKey, trimMaterial);
    }
}
