package net.giotfg.provolamod;

import net.fabricmc.api.ModInitializer;

import net.giotfg.provolamod.block.ModBlocks;
import net.giotfg.provolamod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProvolaMod implements ModInitializer {
	public static final String MOD_ID = "provola_mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}