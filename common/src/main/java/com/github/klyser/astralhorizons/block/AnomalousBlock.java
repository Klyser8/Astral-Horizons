package com.github.klyser.astralhorizons.block;

import com.github.klyser.astralhorizons.client.ClientPacketData;
import com.github.klyser.astralhorizons.registry.AHBlockStateProperties;
import com.mojang.datafixers.util.Pair;
import de.dafuqs.revelationary.api.revelations.RevelationAware;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class AnomalousBlock extends Block implements RevelationAware {
    public static final BooleanProperty DRAGON_DEFEATED = BooleanProperty.create("dragon_defeated");
    public AnomalousBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(DRAGON_DEFEATED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DRAGON_DEFEATED);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (ClientPacketData.isDragonDead()) {
            if (!state.getValue(DRAGON_DEFEATED)) {
                state.setValue(DRAGON_DEFEATED, true);
            }
        }
    }

    @Override
    public ResourceLocation getCloakAdvancementIdentifier() {
        return null;
    }

    @Override
    public Map<BlockState, BlockState> getBlockStateCloaks() {
        return null;
    }

    @Override
    public Tuple<Item, Item> getItemCloak() {
        return null;
    }
}
