package com.factoriaf5.kata;

public abstract class Character {
    private int Id;
    private int Health;
    private int Level;
    private Boolean Alive;
    private int Damage;
    private int HealingCapacity;
    private int ActualPosition;

    //#region Constructor
    public Character() {
        this.Health = 1000;
        this.Level = 1;
        this.Alive = true;
        this.Damage = 10;
        this.HealingCapacity = 20;
        this.Id = 0;
    }
    
    public Character(int id, int health, int level, int damage, int healingCapacity, int actualPosition) {
        Id = id;
        Health = health;
        Alive = true;
        Level = level;
        Damage = damage;
        HealingCapacity = healingCapacity;
        ActualPosition = actualPosition;
    }

/*     public Character(int id, int health, int level, int damage, int healingCapacity) */
    //#endregion

    //#region Getters and Setters
    public int getHealth() {
        return Health;
    }
    public void setHealth(int health) {
        if(Health + health <= 1000) Health = health;
        if(Health + health > 1000) Health = 1000;
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
    public int getHealingCapacity() {
        return HealingCapacity;
    }
    public void setHealingCapacity(int healingCapacity) {
        HealingCapacity = healingCapacity;
    }
    public int getId() {
            return Id;
    }
    public void setId(int id) {
            Id = id;
    }
    public int getActualPosition() {
        return ActualPosition;
    }

    public void setActualPosition(int actualPosition) {
        ActualPosition = actualPosition;
    }
    //#endregion
    
    //#region Damage Methods
    public void atackOtherCharacter(Character objetive){
        if(objetive.getId() != getId()){
            objetive.setHealth(objetive.getHealth()-verifyDamager(getLevel(), getDamage(), objetive));
        }
    }
    public int verifyDamager(int levelFirstCharacter,int damageFirstCharacter, Character SecondCharacter){
        if(levelFirstCharacter-SecondCharacter.getLevel()>=5){
            return damageFirstCharacter+(damageFirstCharacter*1/2);
        }
        if(levelFirstCharacter-SecondCharacter.getLevel()<=-5){
            return damageFirstCharacter-(damageFirstCharacter*1/2);
        }
        return damageFirstCharacter;
    }
    
    //#endregion

    //#region Healing Methods
    public void HealingOtherCharacter(Character objetive){
        if(objetive.getAlive() && objetive.getId()==getId()) objetive.setHealth(objetive.getHealth()+getHealingCapacity());
    }
    public void YouDiedOrNot(){
        if(Health<=0) setAlive(false);
    }
    //#endregion

    


    


    

    
    
}
