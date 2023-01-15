package com.factoriaf5.kata;

public class MeleFighter extends Character {
    private int DamageRange;

    public MeleFighter(int id, int health, int level, int damage, int healingCapacity, int actualPosition) {
        super(id, health, level, damage, healingCapacity, actualPosition);
        DamageRange = 2;
    }

    public int getDamageRange() {
        return DamageRange;
    }

    public void setDamageRange(int damageRange) {
        DamageRange = damageRange;
    }
    
    @Override
    public void HealingOtherCharacter(Character objetive) {
        // TODO Auto-generated method stub
        super.HealingOtherCharacter(objetive);
    }

    @Override
    public void YouDiedOrNot() {
        // TODO Auto-generated method stub
        super.YouDiedOrNot();
    }

    @Override
    public void atackOtherCharacter(Character objetive) {
        if(inRange(objetive, DamageRange)) super.atackOtherCharacter(objetive);
        
    }

    @Override
    public int verifyDamager(int levelFirstCharacter, int damageFirstCharacter, Character SecondCharacter) {
        // TODO Auto-generated method stub
        return super.verifyDamager(levelFirstCharacter, damageFirstCharacter, SecondCharacter);
    }

    public boolean inRange(Character objetive, int actualPositionCharacter){
        if(objetive.getActualPosition()-getActualPosition()<=getDamageRange()) return true;
        return false;
    }
}
