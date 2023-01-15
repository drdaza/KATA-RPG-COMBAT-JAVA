package com.factoriaf5.kata;

public class RangedFighter extends Character{
    private int DamageRange;

    public RangedFighter(int id, int health, int level, int damage, int healingCapacity) {
        super(id, health, level, damage, healingCapacity);
        DamageRange = 2;
    }

    public int getDamageRange() {
        return DamageRange;
    }

    public void setDamageRange(int damageRange) {
        DamageRange = damageRange;
    }
    
}
