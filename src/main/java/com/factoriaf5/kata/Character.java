package com.factoriaf5.kata;

public class Character {
    private int Health;
    private int Level;
    private Boolean Alive;
    private int Damage;

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
        Health = health;
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
    public void atackOtherCharacter(Character objetive){
        objetive.setHealth(objetive.getHealth()-Damage);
    }
    public void YouDied(){
        if(Health<=0) setAlive(false);
    }

    
    
}
