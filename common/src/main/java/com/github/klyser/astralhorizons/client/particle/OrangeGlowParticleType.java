package com.github.klyser.astralhorizons.client.particle;

import net.fabricmc.api.Environment;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.Nullable;

public class OrangeGlowParticleType extends SimpleAnimatedParticle {
    public static final int MAX_AGE = 120;
    public OrangeGlowParticleType(ClientLevel level, double x, double y, double z, SpriteSet sprites) {
        super(level, x, y, z, sprites, -0.025f);
        xd = random.nextFloat() / 10 - 0.05;
        zd = random.nextFloat() / 10 - 0.05;
        yd = 0;
        roll = 0.05f;
    }

    @Override
    public void tick() {
        if (age > 5) {
            setFadeColor(0x3F9CFF);
        }
        if (age > MAX_AGE / 3) {
            setAlpha(1 - (float) age / MAX_AGE / 2.0f);
        }
        if (age >= MAX_AGE) {
            this.remove();
        }
        super.tick();
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_LIT;
    }

    public static class Factory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public Factory(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new OrangeGlowParticleType(level, x, y, z, spriteSet);
        }
    }
}
