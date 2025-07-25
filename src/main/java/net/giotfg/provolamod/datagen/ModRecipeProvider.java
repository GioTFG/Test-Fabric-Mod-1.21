package net.giotfg.provolamod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.giotfg.provolamod.ProvolaMod;
import net.giotfg.provolamod.block.ModBlocks;
import net.giotfg.provolamod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> GINO_SMELTABLES = List.of(
                ModBlocks.GINO_ORE,
                ModBlocks.GINO_DEEPSLATE_ORE
        );

        offerSmelting(recipeExporter, GINO_SMELTABLES, RecipeCategory.MISC, ModItems.GINO, 0.25f, 200, "gino");
        offerBlasting(recipeExporter, GINO_SMELTABLES, RecipeCategory.MISC, ModItems.GINO, 0.25f, 100, "gino");

        offerSmelting(recipeExporter, List.of(ModItems.GINO), RecipeCategory.MISC, ModItems.GINO_FOCOSO, 0.50f, 200, "gino_focoso");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.GINO, RecipeCategory.DECORATIONS, ModBlocks.GINO_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.GINO_FOCOSO, RecipeCategory.DECORATIONS, ModBlocks.FIRE_GINO_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MAGIC_GINO_BLOCK)
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .input('G', ModItems.GINO)
                .input('D', Items.DIAMOND)
                .criterion(hasItem(ModItems.GINO), conditionsFromItem(ModItems.GINO)) // Criterio di sblocco della ricetta
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.APPLE_GINO)
                .input(ModItems.GINO)
                .input(Items.APPLE)
                .criterion(hasItem(ModItems.GINO), conditionsFromItem(ModItems.GINO))
                .offerTo(recipeExporter, Identifier.of(ProvolaMod.MOD_ID, "apple_gino"));
//        Il secondo argomento in offerTo è da passare quando ci sono ricette con lo stesso output, per evitare di avere ricette con lo stesso nome
    }
}
