package com.factoriaf5.kata;

public class RangedFighter extends Character{
    private int DamageRange;

    public RangedFighter(int id, int health, int level, int damage, int healingCapacity, int actualPosition) {
        super(id, health, level, damage, healingCapacity, actualPosition);
        DamageRange = 20;
    }

    public int getDamageRange() {
        return DamageRange;
    }

    public void setDamageRange(int damageRange) {
        DamageRange = damageRange;
    }
    public boolean inRange(Character objetive, int actualPositionCharacter){
        if(objetive.getActualPosition()-getActualPosition()<=getDamageRange()) return true;
        return false;
    }

    @Override
    public void atackOtherCharacter(Character objetive) {
        if(inRange(objetive, getDamageRange())) super.atackOtherCharacter(objetive);
        
    }
    
}
