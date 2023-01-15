package com.factoriaf5.kata;

public class MeleFighter extends Character {
    private int DamageRange;

    public MeleFighter(int id, int health, int level, int damage, int healingCapacity) {
        super(id, health, level, damage, healingCapacity);
        DamageRange = 20;
    }

    public int getDamageRange() {
        return DamageRange;
    }

    public void setDamageRange(int damageRange) {
        DamageRange = damageRange;
    }
    
    
}
