package net.giotfg.provolamod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.giotfg.provolamod.ProvolaMod;
import net.giotfg.provolamod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/*
* Classe per gestire gli Item Groups, categorie di oggetti corrispondenti alle sezioni del menù in creativa
* */
public class ModItemGroups {

//    Per creare e registrare un nuovo Item Group
//    Si usa il FabricItemGroup.builder()
//    Si usano i vari metodi per settare le varie caratteristiche
//    Si registra con Registry.register
    public static final ItemGroup GINO_ITEMS_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(ProvolaMod.MOD_ID, "gino_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.GINO))
                    .displayName(Text.translatable("itemgroup.provola_mod.gino_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.GINO);
                        entries.add(ModItems.GINO_FOCOSO);
                        entries.add(ModItems.MAGIC_GINO);
                        entries.add(ModItems.APPLE_GINO);

                        entries.add(ModItems.GINO_SWORD);
                        entries.add(ModItems.GINO_PICKAXE);
                        entries.add(ModItems.GINO_SHOVEL);
                        entries.add(ModItems.GINO_AXE);
                        entries.add(ModItems.GINO_HOE);
                        entries.add(ModItems.GINO_HAMMER);

                        entries.add(ModItems.GINO_HELMET);
                        entries.add(ModItems.GINO_CHESTPLATE);
                        entries.add(ModItems.GINO_LEGGINGS);
                        entries.add(ModItems.GINO_BOOTS);

                        entries.add(ModItems.GINO_HORSE_ARMOR);

                        entries.add(ModItems.GINO_SMITHING_TEMPLATE);

                        entries.add(ModItems.GINO_BOW);

                        entries.add(ModItems.SHIRK_HAUNTED_MUSIC_DISC);

                        entries.add(ModItems.TOMATO);
                        entries.add(ModItems.TOMATO_SEEDS);

                        entries.add(ModItems.STRAWBERRIES);
                    })
                    .build()
    );
    public static final ItemGroup GINO_BLOCKS_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(ProvolaMod.MOD_ID, "gino_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.GINO_BLOCK))
                    .displayName(Text.translatable("itemgroup.provola_mod.gino_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.GINO_BLOCK);
                        entries.add(ModBlocks.FIRE_GINO_BLOCK);

                        entries.add(ModBlocks.GINO_ORE);
                        entries.add(ModBlocks.GINO_DEEPSLATE_ORE);

                        entries.add(ModBlocks.MAGIC_GINO_BLOCK);

                        entries.add(ModBlocks.GINO_STAIRS);
                        entries.add(ModBlocks.GINO_SLAB);

                        entries.add(ModBlocks.GINO_BUTTON);
                        entries.add(ModBlocks.GINO_PRESSURE_PLATE);

                        entries.add(ModBlocks.GINO_FENCE);
                        entries.add(ModBlocks.GINO_FENCE_GATE);
                        entries.add(ModBlocks.GINO_WALL);

                        entries.add(ModBlocks.GINO_DOOR);
                        entries.add(ModBlocks.GINO_TRAPDOOR);

                        entries.add(ModBlocks.GINO_LAMP);
                    })
                    .build()
    );

    public static void registerItemGroups() {
        ProvolaMod.LOGGER.info("Registering item groups for " + ProvolaMod.MOD_ID);
    }
}
