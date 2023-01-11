package com.factoriaf5.kata;

public class Character {
    private int Health;
    private int Level;
    private Boolean Alive;
    private int Damage;
    private int HealingCapacity;

    public Character() {
        this.Health = 1000;
        this.Level = 1;
        this.Alive = true;
        this.Damage = 10;

    }

    public int getHealth() {
        return Health;
    }
    public void setHealth(int health) {
        if(Health + health <= 1000) Health = health;
        if(Health + health >+ 1000) Health = 1000;
    }
    public int getLevel() {
        return Level;
    }
    public void setLevel(int level) {
        this.Level = level;
    }
    public Boolean getAlive() {
        return Alive;
    }
    public void setAlive(Boolean alive) {
        Alive = alive;
    }
    public int getDamage() {
        return Damage;
    }
    public void setDamage(int damage) {
        Damage = damage;
    }
    public int getHealingCapacity() {
        return HealingCapacity;
    }
    public void setHealingCapacity(int healingCapacity) {
        HealingCapacity = healingCapacity;
    }

    public void atackOtherCharacter(Character objetive){
        objetive.setHealth(objetive.getHealth()-Damage);
    }
    public void HealingOtherCharacter(Character objetive){
        if(objetive.getAlive()) setHealth(objetive.getHealth()+HealingCapacity);
    }
    public void YouDiedOrNot(){
        if(Health<=0) setAlive(false);
    }


    

    
    
}
