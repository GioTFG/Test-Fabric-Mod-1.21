package net.giotfg.provolamod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.giotfg.provolamod.ProvolaMod;
import net.giotfg.provolamod.item.custom.MagicGinoItem;
import net.giotfg.provolamod.item.custom.ModFoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
//    Si registrano tutti gli oggetti, salvati come costanti.
    public static final Item GINO = registerItem("gino", new Item(new Item.Settings()));
    public static final Item GINO_FOCOSO = registerItem("gino_focoso", new Item(new Item.Settings()));
    public static final Item MAGIC_GINO = registerItem("magic_gino", new MagicGinoItem(new Item.Settings().maxDamage(32)));

//    Per aggiungere un oggetto cibo, bisogna passare nelle settings un food component, creato nella classe ModFoodComponents
    public static final Item APPLE_GINO = registerItem("apple_gino", new Item(new Item.Settings().food(ModFoodComponents.APPLE_GINO)) {
//        Uso una classe anonima per estendere Item e aggiungere cose senza usare una classe per un oggetto custom
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.provola_mod.apple_gino"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

//    Metodo helepr per registrare il singolo oggetto. 'name' sarà l'id, quindi tutto minuscolo e solo underscore
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ProvolaMod.MOD_ID, name), item);
    }

//    Metodo invocato all'inizializzazione della mod per registrare tutti gli oggetti
    public static void registerModItems() {
        ProvolaMod.LOGGER.info("Registering mod items for " + ProvolaMod.MOD_ID);

//        Per aggiungere oggetti ad un determinato gruppo di oggetti.
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(GINO);
            entries.add(GINO_FOCOSO);
        });
    }
}
