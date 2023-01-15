package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CharacterTest {
    
    //#region iteration One
    @Test
    public void All_characters_when_created_have(){
        Character myCharacter = new Character();

        assertEquals(1000, myCharacter.getHealth());
        assertEquals(true, myCharacter.getAlive());
        assertEquals(1, myCharacter.getLevel());
    }
    @Test
    public void Characters_can_deal_damage_to_characters(){
        Character myFirstCharacter = new Character();
        Character mySecondCharacter = new Character(2, 1000, 10, 10, 10);

        myFirstCharacter.atackOtherCharacter(mySecondCharacter);
        assertEquals(995, mySecondCharacter.getHealth());
    }
    @Test
    public void Character_Die(){
        Character myFirstCharacter = new Character();
        Character mySecondCharacter = new Character(2, 1000, 1, 10, 10);

        myFirstCharacter.setDamage(1000);
        myFirstCharacter.atackOtherCharacter(mySecondCharacter);
        
        mySecondCharacter.YouDiedOrNot();
        assertEquals(false, mySecondCharacter.getAlive());
    }
    @Test
    public void Characters_can_heal_to_characters(){
        Character myFirstCharacter = new Character();
        Character mySecondCharacter = new Character();

        mySecondCharacter.setHealth(350);

        myFirstCharacter.HealingOtherCharacter(mySecondCharacter);
        

        assertEquals(370, mySecondCharacter.getHealth());
    }
    //#endregion

    //#region iteration Two
    @Test 
    public void A_character_canoot_deal_damage_to_itself(){
        Character myCharacter = new Character();
        myCharacter.setId(0);

        myCharacter.atackOtherCharacter(myCharacter);

        assertEquals(1000, myCharacter.getHealth());
    }
    @Test
    public void A_character_can_only_heal_itself(){
        Character myFirstCharacter = new Character();
        Character mySecondCharacter = new Character();
        myFirstCharacter.setId(0);
        mySecondCharacter.setId(1);
        mySecondCharacter.setHealth(100);

        myFirstCharacter.HealingOtherCharacter(mySecondCharacter);

        assertEquals(100, mySecondCharacter.getHealth());
    }
    @Test
    public void damage_diference_levels(){
        Character myFirstCharacter = new Character(0, 250, 10, 10,10);
        Character mySecondCharacter = new Character(1, 250, 4, 10,10);
        
        myFirstCharacter.atackOtherCharacter(mySecondCharacter);
        
        

        assertEquals(235, mySecondCharacter.getHealth());
    }

    //#endregion

    //#region iteration three

    //#endregion
}
