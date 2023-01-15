package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MeleFighterTest {
    @Test
    public void Characters_have_an_attack_Max_Range(){
        MeleFighter myFirstCharacter = new MeleFighter(0, 1000, 2, 10, 10, 3);
        RangedFighter mySecondCharacter = new RangedFighter(1, 1000, 2, 10, 2, 4);

        assertEquals(true, myFirstCharacter.inRange(mySecondCharacter, myFirstCharacter.getActualPosition()));
    }
    @Test
    public void Characters_must_be_in_range_to_deal_damage_to_a_target(){
        MeleFighter myFirstCharacter = new MeleFighter(0, 1000, 2, 10, 10, 3);
        RangedFighter mySecondCharacter = new RangedFighter(1, 1000, 2, 10, 2, 4);
        
        myFirstCharacter.atackOtherCharacter(mySecondCharacter);
        
        

        assertEquals(990, mySecondCharacter.getHealth());
    }
}
