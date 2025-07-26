package net.giotfg.provolamod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GinoLamp extends Block {
    public GinoLamp(Settings settings) {
        super(settings);

//        Stato di default
        setDefaultState(this.getDefaultState().with(TURNED_ON, false));
    }

//    Aggiungere proprietà custom per i blockstate
    public static final BooleanProperty TURNED_ON = BooleanProperty.of("turned_on");


    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        if (!world.isClient) {
            world.setBlockState(pos, state.cycle(TURNED_ON));
        }

        return ActionResult.SUCCESS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TURNED_ON);
    }
}
