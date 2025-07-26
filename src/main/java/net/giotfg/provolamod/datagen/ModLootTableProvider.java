package net.giotfg.provolamod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.giotfg.provolamod.block.ModBlocks;
import net.giotfg.provolamod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
//        Questi droppano sé stessi
        addDrop(ModBlocks.GINO_BLOCK);
        addDrop(ModBlocks.FIRE_GINO_BLOCK);
        addDrop(ModBlocks.MAGIC_GINO_BLOCK);

        addDrop(ModBlocks.GINO_ORE, oreDrops(ModBlocks.GINO_ORE, ModItems.GINO));
        addDrop(ModBlocks.GINO_DEEPSLATE_ORE, multipleOreDrops(ModBlocks.GINO_DEEPSLATE_ORE, ModItems.GINO, 3.0f, 6.0f));

        addDrop(ModBlocks.GINO_STAIRS);
        addDrop(ModBlocks.GINO_WALL);
        addDrop(ModBlocks.GINO_FENCE);
        addDrop(ModBlocks.GINO_FENCE_GATE);
        addDrop(ModBlocks.GINO_TRAPDOOR);

        addDrop(ModBlocks.GINO_SLAB, slabDrops(ModBlocks.GINO_SLAB));
        addDrop(ModBlocks.GINO_DOOR, doorDrops(ModBlocks.GINO_DOOR));
    }

    /*
    * Funzione presa direttamente da KaupenJoe per minerali che possono essere droppati di più
    * Inserire il blocco stesso in drop, l'oggetto che droppa in item, numero minimo di item che droppa e numero massimo
    * */
    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
