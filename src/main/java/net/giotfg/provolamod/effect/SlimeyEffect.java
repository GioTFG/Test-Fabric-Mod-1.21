package net.giotfg.provolamod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.Vec3d;

// Climbing Effect by SameDifferent: https://github.com/samedifferent/TrickOrTreat/blob/master/LICENSE
// MIT License!
// Preso dal tutorial di KaupenJoe (https://youtu.be/h185gY9tIzs)
public class SlimeyEffect extends StatusEffect {

    public SlimeyEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    /**
     * Questo metodo viene chiamato ogni tick su ogni entità che possiede questo effetto
     * */
    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.horizontalCollision) {
            Vec3d initialVec = entity.getVelocity();
            Vec3d climbVec = new Vec3d(initialVec.x, 0.2D, initialVec.z);
            entity.setVelocity(climbVec.multiply(0.96d));
            return true;
        }

        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
