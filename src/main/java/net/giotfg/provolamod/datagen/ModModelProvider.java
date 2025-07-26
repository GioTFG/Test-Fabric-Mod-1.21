package net.giotfg.provolamod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.giotfg.provolamod.block.ModBlocks;
import net.giotfg.provolamod.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool ginoPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GINO_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FIRE_GINO_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GINO_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GINO_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_GINO_BLOCK);

        ginoPool.stairs(ModBlocks.GINO_STAIRS);
        ginoPool.slab(ModBlocks.GINO_SLAB);
        ginoPool.button(ModBlocks.GINO_BUTTON);
        ginoPool.pressurePlate(ModBlocks.GINO_PRESSURE_PLATE);
        ginoPool.fence(ModBlocks.GINO_FENCE);
        ginoPool.fenceGate(ModBlocks.GINO_FENCE_GATE);
        ginoPool.wall(ModBlocks.GINO_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.GINO_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.GINO_TRAPDOOR);
    }

//    Textures di tutti gli oggetti
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.GINO, Models.GENERATED);
        itemModelGenerator.register(ModItems.GINO_FOCOSO, Models.GENERATED);
        itemModelGenerator.register(ModItems.APPLE_GINO, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGIC_GINO, Models.GENERATED);
    }
}
