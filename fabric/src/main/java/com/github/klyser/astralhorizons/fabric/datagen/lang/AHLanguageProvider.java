package com.github.klyser.astralhorizons.fabric.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import java.nio.file.Path;

public abstract class AHLanguageProvider extends FabricLanguageProvider {

    protected TranslationBuilder translationBuilder = null;
    protected AHLanguageProvider(FabricDataOutput dataOutput, String languageCode) {
        super(dataOutput, languageCode);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        this.translationBuilder = translationBuilder;
        addItemTranslations();
        addBlockTranslations();
        addItemGroupTranslations();
        addEntityTypeTranslations();
        addEnchantmentTranslations();
        addEntityAttributeTranslations();
        addStatTypeTranslations();
        addStatusEffectTranslations();
        addIdentifierTranslations();
//        try {
//            Path existingFilePath = dataOutput.getModContainer().findPath("../../../common/assets/astralhorizons/lang/en_us.existing.json").get();
//            translationBuilder.add(existingFilePath);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to add existing language file!", e);
//        }
    }

    protected void addItemTranslations() {}
    protected void addBlockTranslations() {}
    protected void addItemGroupTranslations() {}
    protected void addEntityTypeTranslations() {}
    protected void addEnchantmentTranslations() {}
    protected void addEntityAttributeTranslations() {}
    protected void addStatTypeTranslations() {}
    protected void addStatusEffectTranslations() {}
    protected void addIdentifierTranslations() {}
}
