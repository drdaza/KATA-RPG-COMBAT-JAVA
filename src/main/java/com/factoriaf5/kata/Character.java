package com.factoriaf5.kata;

import java.util.ArrayList;

public abstract class Character {
    private int Id;
    private int Health;
    private int Level;
    private Boolean Alive;
    private int Damage;
    private int HealingCapacity;
    private int ActualPosition;
    private ArrayList<String> Factions;

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
        Factions = new ArrayList<String>();
    }

/*     public Character(int id, int health, int level, int damage, int healingCapacity) */
    //#endregion

    

    //#region Getters and Setters
    public int getHealth() {
        return Health;
    }
    public void setHealth(int health) {
        if(Health + health <= 1000) Health = Health + health;
        if(Health + health > 1000) Health = 1000;
    }
    public void setHealthForDamage(int healt){
        Health = Health - healt;
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
    public ArrayList<String> getFactions() {
        return Factions;
    }

    public void setFactions(String faction) {
        Factions.add(faction);
    }
    //#endregion
    
    //#region Damage Methods
    public void atackOtherCharacter(Character objetive){
        if(objetive.getId() != getId() && !isAllied(objetive)){
            objetive.setHealthForDamage(verifyDamager(getLevel(), getDamage(), objetive));
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
        if(objetive.getAlive() && objetive.getId()==getId()) objetive.setHealth(getHealingCapacity());
        if(objetive.getAlive() && isAllied(objetive)) objetive.setHealth(getHealingCapacity()); 
    }
    public void YouDiedOrNot(){
        if(Health<=0) setAlive(false);
    }
    //#endregion

    //#region ActionFactionsCharacter
    public void JoinToNewFaction(String newFaction){
        setFactions(newFaction);
    }
    public void LeaveToFaction(String FactionToLeave){
        int index = Factions.indexOf(FactionToLeave);
        Factions.remove(index);
    }
    public boolean isAllied(Character objetive){
        if(getFactions().size() == 0 && objetive.getFactions().size() == 0) return false;
        for (String faction : objetive.getFactions()){
            if(getFactions().contains(faction)) return true;
        }

        return false;
    }
    //#endregion


    


    


    

    
    
}
