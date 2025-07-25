package net.giotfg.provolamod.item.custom;

import net.giotfg.provolamod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class MagicGinoItem extends Item {

    private static final Map<Block, Block> BLOCK_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.DIRT, ModBlocks.GINO_BLOCK,
                    Blocks.NETHERITE_BLOCK, ModBlocks.FIRE_GINO_BLOCK
            );

    public MagicGinoItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if (BLOCK_MAP.containsKey(clickedBlock)) {
            if (!world.isClient) {
                world.setBlockState(context.getBlockPos(), BLOCK_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(
                        1,
                        ((ServerWorld) world),
                        ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND)
                        );

                world.playSound(
                        null,
                        context.getBlockPos(),
                        SoundEvents.BLOCK_ENDER_CHEST_OPEN,
                        SoundCategory.BLOCKS
                );
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.provola_mod.magic_gino"));

        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.provola_mod.magic_gino.shift_down"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
