package net.giotfg.provolamod.util;

import net.giotfg.provolamod.ProvolaMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {

//        Metodo helper per la creazione di un tag per blocchi
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(ProvolaMod.MOD_ID, name));
        }
    }

    public static class Items {

        /*
        * Definizione delle tags
        * Il name passato alla <code>createTag</code> corrisponde al nome del file json.
        * */
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");


        //        Metodo helper per la creazione di un tag per oggetti
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(ProvolaMod.MOD_ID, name));
        }
    }
}
