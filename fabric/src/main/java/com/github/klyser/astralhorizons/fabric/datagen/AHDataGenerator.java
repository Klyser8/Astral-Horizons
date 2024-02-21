package com.github.klyser.astralhorizons.fabric.datagen;

import com.github.klyser.astralhorizons.fabric.datagen.lang.AHEnglishLanguageProvider;
import com.github.klyser.astralhorizons.fabric.datagen.sound.AHSoundProvider;
import com.github.klyser.astralhorizons.fabric.datagen.tag.AHBiomeTagGenerator;
import com.github.klyser.astralhorizons.fabric.datagen.tag.AHBlockTagGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class AHDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();
        pack.addProvider(AHBlockTagGenerator::new);
        pack.addProvider(AHModelProvider::new);
        pack.addProvider(AHSoundProvider::new);
        pack.addProvider(AHBiomeTagGenerator::new);
        pack.addProvider(AHEnglishLanguageProvider::new);
        pack.addProvider(AHDynamicDataProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, AHConfiguredFeaturesProvider::bootstrap);
        registryBuilder.add(Registries.PLACED_FEATURE, AHPlacedFeaturesProvider::bootstrap);
    }
}
