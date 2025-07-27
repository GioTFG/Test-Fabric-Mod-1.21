package net.giotfg.provolamod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.giotfg.provolamod.block.ModBlocks;
import net.giotfg.provolamod.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.GINO_BLOCK)
                .add(ModBlocks.FIRE_GINO_BLOCK)
                .add(ModBlocks.GINO_ORE)
                .add(ModBlocks.GINO_DEEPSLATE_ORE)
                .add(ModBlocks.MAGIC_GINO_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GINO_DEEPSLATE_ORE);
        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.GINO_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.GINO_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.GINO_WALL);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.MAGIC_GINO_BLOCK);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_GINO_TOOL)
                .add(ModBlocks.MAGIC_GINO_BLOCK)
                .addTag(BlockTags.NEEDS_IRON_TOOL);
//        Il tag inverso si fa manuale in resources/data/provola_mod/tags/block
    }
}
