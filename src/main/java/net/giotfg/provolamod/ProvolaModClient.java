package net.giotfg.provolamod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.giotfg.provolamod.block.ModBlocks;
import net.giotfg.provolamod.util.ModModelPredicates;
import net.minecraft.client.render.RenderLayer;

public class ProvolaModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
//        Per i blocchi con parti trasparenti
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GINO_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GINO_TRAPDOOR, RenderLayer.getCutout());

        ModModelPredicates.registerModelPredicates();
    }
}
