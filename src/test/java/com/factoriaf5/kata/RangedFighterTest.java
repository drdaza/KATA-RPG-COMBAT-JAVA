package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RangedFighterTest {
    @Test
    public void Characters_have_an_attack_Max_Range_range_fighter(){
        MeleFighter myFirstCharacter = new MeleFighter(0, 1000, 2, 10, 10, 3);
        RangedFighter mySecondCharacter = new RangedFighter(1, 1000, 2, 10, 2, 4);

        assertEquals(true, myFirstCharacter.inRange(mySecondCharacter, myFirstCharacter.getActualPosition()));
    }
    @Test
    public void Characters_must_be_in_range_to_deal_damage_to_a_target_range_fighter(){
        MeleFighter myFirstCharacter = new MeleFighter(0, 1000, 2, 10, 10, 20);
        RangedFighter mySecondCharacter = new RangedFighter(1, 1000, 2, 10, 2, 4);
        
        mySecondCharacter.atackOtherCharacter(myFirstCharacter);
        
        

        assertEquals(990, myFirstCharacter.getHealth());
    }
}
