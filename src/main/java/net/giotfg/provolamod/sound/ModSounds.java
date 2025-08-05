package net.giotfg.provolamod.sound;

import net.giotfg.provolamod.ProvolaMod;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;


/**
 * I suoni custom devono essere salvati in <code>resources/assets/mod_id/sounds</code> in formato ogg e mono.
 * Inoltre bisogna collegare file al SoundEvent nel file <code>resources/assets/mod_id/sounds.json</code>.
 * <h5>Struttura del file .json</h5>
 * <pre>
 *     {
 *         "id del SoundEvent": {
 *             "subtitles": "record nei vari file di lang (es: sounds.mod_id.sound_id)"
 *             "sounds": [
 *                  "mod_id:nome_file_ogg"
 *             ]
 *         }
 *     }
 * </pre>
 * */

public class ModSounds {


    public static final SoundEvent MAGIC_GINO_USE = registerSoundEvent("magic_gino_use");


    public static final SoundEvent MAGIC_GINO_BLOCK_BREAK = registerSoundEvent("magic_gino_block_break");
    public static final SoundEvent MAGIC_GINO_BLOCK_PLACE = registerSoundEvent("magic_gino_block_place");
    public static final SoundEvent MAGIC_GINO_BLOCK_HIT = registerSoundEvent("magic_gino_block_hit");
    public static final SoundEvent MAGIC_GINO_BLOCK_STEP = registerSoundEvent("magic_gino_block_step");
    public static final SoundEvent MAGIC_GINO_BLOCK_FALL = registerSoundEvent("magic_gino_block_fall");

    public static final BlockSoundGroup MAGIC_GINO_BLOCK_SOUNDS = new BlockSoundGroup(1f, 1f,
            MAGIC_GINO_BLOCK_BREAK, MAGIC_GINO_BLOCK_STEP, MAGIC_GINO_BLOCK_PLACE, MAGIC_GINO_BLOCK_HIT, MAGIC_GINO_BLOCK_FALL);

    public static final SoundEvent SHIRK_HAUNTED = registerSoundEvent("shirk_haunted");
    public static final RegistryKey<JukeboxSong> SHIRK_HAUNTED_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(ProvolaMod.MOD_ID, "shirk_haunted"));

    public static void registerSounds() {
        ProvolaMod.LOGGER.info("Registering mod sounds for " + ProvolaMod.MOD_ID);

    }

    private static SoundEvent registerSoundEvent (String name) {
        Identifier id = Identifier.of(ProvolaMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
}
