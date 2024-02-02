package com.github.klyser.astralhorizons.block;

import com.github.klyser.astralhorizons.AstralHorizons;
import de.dafuqs.revelationary.api.revelations.RevelationAware;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

/**
 * Interface for blocks that are cloaked by default and can be revealed by advancements.
 * @see RevelationAware
 */
public interface CloakedBlock extends RevelationAware {

    @Override
    default ResourceLocation getCloakAdvancementIdentifier() {
        return AstralHorizons.id("dragon_dead");
    }

    @Override
    default @Nullable Tuple<Item, Item> getItemCloak() {
        return new Tuple<>(getBlock().asItem(), getCloakBlock().asItem());
    }

    @Override
    @Nullable
    default Tuple<Item, MutableComponent> getCloakedItemTranslation() {
        return new Tuple<>(getBlock().asItem(), getCloakBlock().getName());
    }

    @Override
    @Nullable
    default Tuple<Block, MutableComponent> getCloakedBlockTranslation() {
        return new Tuple<>(getBlock(), getCloakBlock().getName());
    }

    default Block getBlock() {
        return getBlockTuple().getA();
    }

    default Block getCloakBlock() {
        return getBlockTuple().getB();
    }

    Tuple<Block, Block> getBlockTuple();
}
