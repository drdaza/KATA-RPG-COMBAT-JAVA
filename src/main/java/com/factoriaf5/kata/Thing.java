package com.factoriaf5.kata;

public class Thing extends Character {

    private boolean isDestroyed;


    public Thing(int id, int health, int actualPosition) {
        super(id, health, actualPosition);
        this.isDestroyed = false;
    }

    public boolean isDestroyed() {
        if (this.getHealth() == 0) {
            this.setDestroyed(true);
        }
        return isDestroyed;
    }


    public void setDestroyed(boolean isDestroyed) {
        this.isDestroyed = isDestroyed;
    }

    


    
}
