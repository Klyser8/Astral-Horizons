package com.github.klyser.astralhorizons.registry;

import com.github.klyser.astralhorizons.AstralHorizons;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

import java.util.function.Supplier;

import static com.github.klyser.astralhorizons.platform.CommonPlatformHelper.registerCreativeTab;

public class AHCreativeModeTabs {

    public static void init() {

    }

    public static final Supplier<CreativeModeTab> ITEMS = registerCreativeTab("items",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                    .title(Component.translatable("itemGroup." + AstralHorizons.MOD_ID + ".items"))
                    .icon(() -> AHItems.COSMIC_CRYSTAL.get().getDefaultInstance())
                    .displayItems((features, entries) -> {
                        entries.accept(AHItems.COSMIC_CRYSTAL.get());
                    }).build()
    );

    public static final Supplier<CreativeModeTab> BLOCKS = registerCreativeTab("blocks",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                    .title(Component.translatable("itemGroup." + AstralHorizons.MOD_ID + ".blocks"))
                    .icon(() -> AHItems.ANOMADIRT.get().getDefaultInstance())
                    .displayItems((features, entries) -> {
                        entries.accept(AHItems.STARFLARE_BLOSSOM.get());
                        entries.accept(AHItems.ANOMADIRT.get());
                        entries.accept(AHItems.ANOMAGRASS_BLOCK.get());
                        entries.accept(AHItems.ANOMASTONE.get());
                        entries.accept(AHItems.LUTIEL.get());
                        entries.accept(AHItems.ANOMASTONE_SLAB.get());
                        entries.accept(AHItems.ANOMASTONE_STAIRS.get());
                        entries.accept(AHItems.ANOMASTONE_PRESSURE_PLATE.get());
                        entries.accept(AHItems.ANOMASTONE_BUTTON.get());
                        entries.accept(AHItems.COBBLED_ANOMASTONE.get());
                        entries.accept(AHItems.COBBLED_ANOMASTONE_SLAB.get());
                        entries.accept(AHItems.COBBLED_ANOMASTONE_STAIRS.get());
                        entries.accept(AHItems.COBBLED_ANOMASTONE_WALL.get());
                        entries.accept(AHItems.ANOMASTONE_BRICKS.get());
                        entries.accept(AHItems.ANOMASTONE_BRICK_STAIRS.get());
                        entries.accept(AHItems.ANOMASTONE_BRICK_SLAB.get());
                        entries.accept(AHItems.ANOMASTONE_BRICK_WALL.get());
                        entries.accept(AHItems.CHISELED_ANOMASTONE_BRICKS.get());
                        entries.accept(AHItems.CHLORITE.get());
                        entries.accept(AHItems.CHLORITE_SLAB.get());
                        entries.accept(AHItems.CHLORITE_STAIRS.get());
                        entries.accept(AHItems.CHLORITE_WALL.get());
                        entries.accept(AHItems.CHLORITE_BRICKS.get());
                        entries.accept(AHItems.CHLORITE_BRICK_SLAB.get());
                        entries.accept(AHItems.CHLORITE_BRICK_STAIRS.get());
                        entries.accept(AHItems.CHLORITE_BRICK_WALL.get());
                        entries.accept(AHItems.SIDEROCK.get());
                        entries.accept(AHItems.SIDEROCK_SLAB.get());
                        entries.accept(AHItems.SIDEROCK_STAIRS.get());
                        entries.accept(AHItems.SIDEROCK_WALL.get());
                        entries.accept(AHItems.SIDEROCK_BRICKS.get());
                        entries.accept(AHItems.SIDEROCK_BRICK_SLAB.get());
                        entries.accept(AHItems.SIDEROCK_BRICK_STAIRS.get());
                        entries.accept(AHItems.SIDEROCK_BRICK_WALL.get());
                        entries.accept(AHItems.AURANITE.get());
                        entries.accept(AHItems.AURANITE_SLAB.get());
                        entries.accept(AHItems.AURANITE_STAIRS.get());
                        entries.accept(AHItems.AURANITE_WALL.get());
                        entries.accept(AHItems.AURANITE_BRICKS.get());
                        entries.accept(AHItems.AURANITE_BRICK_SLAB.get());
                        entries.accept(AHItems.AURANITE_BRICK_STAIRS.get());
                        entries.accept(AHItems.AURANITE_BRICK_WALL.get());
                        entries.accept(AHItems.ANOMASAND.get());
                        entries.accept(AHItems.ANOMASANDSTONE.get());
                        entries.accept(AHItems.ANOMASANDSTONE_SLAB.get());
                        entries.accept(AHItems.ANOMASANDSTONE_STAIRS.get());
                        entries.accept(AHItems.ANOMASANDSTONE_WALL.get());
                        entries.accept(AHItems.SMOOTH_ANOMASANDSTONE.get());
                        entries.accept(AHItems.SMOOTH_ANOMASANDSTONE_SLAB.get());
                        entries.accept(AHItems.SMOOTH_ANOMASANDSTONE_STAIRS.get());
                        entries.accept(AHItems.CUT_ANOMASANDSTONE.get());
                        entries.accept(AHItems.CUT_ANOMASANDSTONE_SLAB.get());
                        entries.accept(AHItems.ANOMALICE.get());
                        entries.accept(AHItems.ANOMASNOW_BLOCK.get());
                        entries.accept(AHItems.SCURANE_LOG.get());
                        entries.accept(AHItems.SCURANE_WOOD.get());
                        entries.accept(AHItems.STRIPPED_SCURANE_LOG.get());
                        entries.accept(AHItems.STRIPPED_SCURANE_WOOD.get());
                        entries.accept(AHItems.SCURANE_LEAVES.get());
                        entries.accept(AHItems.SCURANE_PLANKS.get());
                        entries.accept(AHItems.SCURANE_SLAB.get());
                        entries.accept(AHItems.SCURANE_STAIRS.get());
                        entries.accept(AHItems.SCURANE_FENCE.get());
                        entries.accept(AHItems.SCURANE_FENCE_GATE.get());
                        entries.accept(AHItems.SCURANE_PRESSURE_PLATE.get());
                        entries.accept(AHItems.SCURANE_BUTTON.get());
                        entries.accept(AHItems.SCURANE_TRAPDOOR.get());
                        entries.accept(AHItems.SCURANE_DOOR.get());
//                        entries.accept(AHItems.SCURANE_SIGN.get());
//                        entries.accept(AHItems.SCURANE_HANGING_SIGN.get());
                        entries.accept(AHItems.ANOMALOUS_SHORT_GRASS.get());
                        entries.accept(AHItems.SICKENED_SHRUB.get());
                        entries.accept(AHItems.ANOMALOUS_SEAGRASS.get());
                    }).build()
    );

}
