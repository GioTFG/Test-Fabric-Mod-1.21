package net.giotfg.provolamod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.giotfg.provolamod.ProvolaMod;
import net.giotfg.provolamod.item.custom.HammerItem;
import net.giotfg.provolamod.item.custom.MagicGinoItem;
import net.giotfg.provolamod.item.custom.ModFoodComponents;
import net.minecraft.item.*;
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


    public static final Item GINO_SWORD = registerItem("gino_sword",
            new SwordItem(ModToolMaterials.GINO, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.GINO, 3, -2.4f))
            )
    );
    public static final Item GINO_PICKAXE = registerItem(
            "gino_pickaxe",
            new PickaxeItem(ModToolMaterials.GINO, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.GINO, 1, -2.8f))
            )
    );
    public static final Item GINO_SHOVEL = registerItem(
            "gino_shovel",
            new ShovelItem(ModToolMaterials.GINO, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.GINO, 1.5f, -3f))
            )
    );
    public static final Item GINO_AXE = registerItem(
            "gino_axe",
            new AxeItem(ModToolMaterials.GINO, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.GINO, 6f, -3.2f))
            )
    );
    public static final Item GINO_HOE = registerItem(
            "gino_hoe",
            new HoeItem(ModToolMaterials.GINO, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.GINO, 0, -3f))
            )
    );

    public static final Item GINO_HAMMER = registerItem(
            "gino_hammer",
            new HammerItem(ModToolMaterials.GINO, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.GINO, 7, -3.4f))
            )
    );

    public static final Item GINO_HELMET = registerItem(
            "gino_helmet", new ArmorItem(ModArmorMaterials.GINO_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))
            )
    );
    public static final Item GINO_CHESTPLATE = registerItem(
            "gino_chestplate", new ArmorItem(ModArmorMaterials.GINO_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))
            )
    );
    public static final Item GINO_LEGGINGS = registerItem(
            "gino_leggings", new ArmorItem(ModArmorMaterials.GINO_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))
            )
    );
    public static final Item GINO_BOOTS = registerItem(
            "gino_boots", new ArmorItem(ModArmorMaterials.GINO_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))
            )
    );



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
