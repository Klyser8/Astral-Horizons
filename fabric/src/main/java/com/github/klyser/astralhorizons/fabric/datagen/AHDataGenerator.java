package com.github.klyser.astralhorizons.fabric.datagen;

import com.github.klyser.astralhorizons.fabric.datagen.tag.AHBiomeTagGenerator;
import com.github.klyser.astralhorizons.fabric.datagen.tag.AHBlockTagGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class AHDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();
        pack.addProvider(AHBlockTagGenerator::new);
        pack.addProvider(AHBlockGenerator::new);
//        pack.addProvider(AHBiomeTagGenerator::new);
    }


}
