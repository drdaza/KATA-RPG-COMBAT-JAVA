package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CharacterTest {
    
    @Test
    public void ExampleTest() {
        assertEquals(2, 2);
    }
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
        Character mySecondCharacter = new Character();

        myFirstCharacter.atackOtherCharacter(mySecondCharacter);
        assertEquals(990, mySecondCharacter.getHealth());
    }
    @Test
    public void Character_Die(){
        
    }


}
