package net.giotfg.provolamod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.giotfg.provolamod.item.ModItems;
import net.giotfg.provolamod.util.ModTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.GINO)
                .add(ModItems.GINO_FOCOSO)
                .add(ModItems.MAGIC_GINO)
                .add(ModItems.APPLE_GINO)
                .add(Items.CARROT_ON_A_STICK);

        getOrCreateTagBuilder(ItemTags.SWORDS).add(ModItems.GINO_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES).add(ModItems.GINO_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS).add(ModItems.GINO_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES).add(ModItems.GINO_AXE);
        getOrCreateTagBuilder(ItemTags.HOES).add(ModItems.GINO_HOE);

//        Necessario per avere le armature con i trim
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.GINO_HELMET)
                .add(ModItems.GINO_CHESTPLATE)
                .add(ModItems.GINO_LEGGINGS)
                .add(ModItems.GINO_BOOTS);

        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.GINO);

        getOrCreateTagBuilder(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.GINO_SMITHING_TEMPLATE);
    }
}
