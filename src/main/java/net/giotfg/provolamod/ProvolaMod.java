package net.giotfg.provolamod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.giotfg.provolamod.block.ModBlocks;
import net.giotfg.provolamod.component.ModDataComponentTypes;
import net.giotfg.provolamod.effect.ModEffects;
import net.giotfg.provolamod.item.ModItemGroups;
import net.giotfg.provolamod.item.ModItems;
import net.giotfg.provolamod.sound.ModSounds;
import net.giotfg.provolamod.util.HammerUsageEvent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
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
		ModSounds.registerSounds();
		ModEffects.registerEffects();

		ModDataComponentTypes.registerDataComponentTypes();

		FuelRegistry.INSTANCE.add(ModItems.GINO_FOCOSO, 2000);
		FuelRegistry.INSTANCE.add(ModBlocks.FIRE_GINO_BLOCK, 20000);

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

		AttackEntityCallback.EVENT.register(((player, world, hand, entity, hitResult) -> {

			if (entity instanceof SheepEntity sheepEntity && !world.isClient()) {
				if (player.getMainHandStack().getItem() == Items.END_ROD) {
					player.sendMessage(Text.literal("Just no..."));
					player.getMainHandStack().decrement(1);
					sheepEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 5, 50));
				}
			}

			return ActionResult.PASS;
		}));
	}
}