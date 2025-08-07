package net.giotfg.provolamod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.giotfg.provolamod.ProvolaMod;
import net.giotfg.provolamod.block.custom.GinoLamp;
import net.giotfg.provolamod.block.custom.MagicGinoBlock;
import net.giotfg.provolamod.block.custom.StrawberryBushBlock;
import net.giotfg.provolamod.block.custom.TomatoCropBlock;
import net.giotfg.provolamod.sound.ModSounds;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

/*
 * Qui si gestiscono tutte le registrazioni dei blocchi
 * A ogni blocco è associato anche un oggetto, quindi oltre alla registrazione del blocco (fatta alla creazione della sua costante chiamando registerBlock c'è anche la registrazione del BlockItem a esso associato
 * Ci sono alcuni blocchi che non devono avere un item associato, (tipo il blocco di un portale), quindi un flag alla registrazione per capire se associare o no si può inserire
 * registerModBlocks si chiama nell'onInitialize() per far partire la registrazione dei blocchi caricando questa classe
 * */
public class ModBlocks {

    //    Creazione di un blocco con new Block e assegnandogli una costante. Per registrarlo il nuovo blocco viene passato a registerBlock insieme al suo ID
//    Aggiungere in resources.assets.provola_mod.blockstates un file id_blocco.json
//    Aggiungere la mappatura json dei modelli alle immagini in resources.assets.provola_mod.models.block con nome_inserito_in_id_blocco.json
//    Aggiungere la texture del blocco in textures.block e del BlockItem in textures.item
//    Aggiungere il modello dell'item in models.item
//    Aggiungere la traduzione di blocco e di item in lang
    public static final Block GINO_BLOCK = registerBlock(
            "gino_block",

//            La prima riga crea il blocco generico, poi si concatenano altri metodi per assegnargli proprietà
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.BONE)
            )
    );
    public static final Block FIRE_GINO_BLOCK = registerBlock(
            "fire_gino_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.NETHERRACK)
            )
    );
    public static final Block GINO_ORE = registerBlock(
            "gino_ore",
            new ExperienceDroppingBlock(
                    UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create()
                            .strength(3f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.STONE)
            )
    );
    public static final Block GINO_DEEPSLATE_ORE = registerBlock(
            "gino_deepslate_ore",
            new ExperienceDroppingBlock(
                    UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create()
                            .strength(4f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.DEEPSLATE)
            )
    );
    public static final Block MAGIC_GINO_BLOCK = registerBlock(
            "magic_gino_block",
            new MagicGinoBlock(AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool()
                    .sounds(ModSounds.MAGIC_GINO_BLOCK_SOUNDS)
            )
    );

    public static final Block GINO_STAIRS = registerBlock(
            "gino_stairs",
            new StairsBlock(ModBlocks.GINO_BLOCK.getDefaultState(), AbstractBlock.Settings.create().strength(2f).requiresTool())
    );
    public static final Block GINO_SLAB = registerBlock(
            "gino_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool())
    );

    public static final Block GINO_BUTTON = registerBlock(
            "gino_button",
            new ButtonBlock(BlockSetType.IRON, 2, AbstractBlock.Settings.create().strength(2f).requiresTool().noCollision())
    );
    public static final Block GINO_PRESSURE_PLATE = registerBlock(
            "gino_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(2f).requiresTool())
    );

    public static final Block GINO_FENCE = registerBlock(
            "gino_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(2f).requiresTool())
    );
    public static final Block GINO_FENCE_GATE = registerBlock(
            "gino_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().strength(2f).requiresTool())
    );
    public static final Block GINO_WALL = registerBlock(
            "gino_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(2f).requiresTool())
    );

    public static final Block GINO_DOOR = registerBlock(
            "gino_door",
            new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque())
    );
    public static final Block GINO_TRAPDOOR = registerBlock(
            "gino_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque())
    );

    public static final Block GINO_LAMP = registerBlock(
            "gino_lamp",
            new GinoLamp(AbstractBlock.Settings.create()
                    .strength(1f).requiresTool().luminance(state -> state.get(GinoLamp.TURNED_ON) ? 15 : 0))
    );

    public static final Block TOMATO_CROP = registerBlockWithoutItem("tomato_crop",
            new TomatoCropBlock(AbstractBlock.Settings.create()
                    .noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));


    public static final Block STRAWBERRY_BUSH = registerBlockWithoutItem("strawberry_bush",
            new StrawberryBushBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)));

    //    Si registra un nuovo blocco, passandogli l'id e l'oggetto blocco da registrare
//    Si chiama anche registerBlockItem per registrare il relativo oggetto
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ProvolaMod.MOD_ID, name), block);
    }

    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(ProvolaMod.MOD_ID, name), block);
    }

    //    Chiamata quando si registra insieme al blocco anche il relativo oggetto
//    Analogo a quando si registra un nuovo item normale
//    Al posto di Item si usa BlockItem per far capire al gioco che è collegato al blocco
    private static void registerBlockItem(String name, Block block) {
        Registry.register(
                Registries.ITEM,
                Identifier.of(ProvolaMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings())
        );
    }

    //    Chiamata all'inizializzazione per far partire il codice per le costanti in alto (i blocchi da registrare)
    public static void registerModBlocks() {
        ProvolaMod.LOGGER.info("Registering mod blocks for " + ProvolaMod.MOD_ID);

//        Per aggiungere i BlockItem ai menù in creativa...
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(GINO_BLOCK);
            entries.add(FIRE_GINO_BLOCK);
        });
    }
}
