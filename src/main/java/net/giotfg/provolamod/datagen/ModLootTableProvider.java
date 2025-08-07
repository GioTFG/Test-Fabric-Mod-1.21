package net.giotfg.provolamod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.giotfg.provolamod.block.ModBlocks;
import net.giotfg.provolamod.block.custom.StrawberryBushBlock;
import net.giotfg.provolamod.block.custom.TomatoCropBlock;
import net.giotfg.provolamod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
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

        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.TOMATO_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(TomatoCropBlock.AGE, TomatoCropBlock.MAX_AGE));
        this.addDrop(ModBlocks.TOMATO_CROP, this.cropDrops(ModBlocks.TOMATO_CROP, ModItems.TOMATO, ModItems.TOMATO_SEEDS, builder2));


//        Ripreso dal vanilla
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        this.addDrop(
                ModBlocks.STRAWBERRY_BUSH,
                block -> this.applyExplosionDecay(
                        block,
                        LootTable.builder()
                                .pool(
                                        LootPool.builder()
                                                .conditionally(
                                                        BlockStatePropertyLootCondition.builder(ModBlocks.STRAWBERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(StrawberryBushBlock.AGE, 3))
                                                )
                                                .with(ItemEntry.builder(ModItems.STRAWBERRIES))
                                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                                )
                                .pool(
                                        LootPool.builder()
                                                .conditionally(
                                                        BlockStatePropertyLootCondition.builder(ModBlocks.STRAWBERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(StrawberryBushBlock.AGE, 2))
                                                )
                                                .with(ItemEntry.builder(ModItems.STRAWBERRIES))
                                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                                )
                )
        );
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
