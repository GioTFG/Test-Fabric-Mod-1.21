package net.giotfg.provolamod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.giotfg.provolamod.block.ModBlocks;
import net.giotfg.provolamod.component.ModDataComponentTypes;
import net.giotfg.provolamod.item.ModItemGroups;
import net.giotfg.provolamod.item.ModItems;
import net.giotfg.provolamod.util.HammerUsageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProvolaMod implements ModInitializer {
	public static final String MOD_ID = "provola_mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModDataComponentTypes.registerDataComponentTypes();

		FuelRegistry.INSTANCE.add(ModItems.GINO_FOCOSO, 2000);
		FuelRegistry.INSTANCE.add(ModBlocks.FIRE_GINO_BLOCK, 20000);

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
	}
}