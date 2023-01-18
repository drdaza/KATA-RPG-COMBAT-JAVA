package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

public class CharacterTest {
    
    //#region iteration One
    @Test
    public void All_characters_when_created_have(){
        MeleFighter myCharacter = new MeleFighter(1, 1000, 1, 10, 10, 0);

        assertEquals(1000, myCharacter.getHealth());
        assertEquals(true, myCharacter.getAlive());
        assertEquals(1, myCharacter.getLevel());
    }
    @Test
    public void Characters_can_deal_damage_to_characters(){
        MeleFighter myFirstCharacter = new MeleFighter(1, 1000, 10, 10, 10, 0);
        MeleFighter mySecondCharacter = new MeleFighter(2, 1000, 10, 10, 10,2);

        
        myFirstCharacter.atackOtherCharacter(mySecondCharacter);
        System.out.println(mySecondCharacter.getHealth());
        assertEquals(990, mySecondCharacter.getHealth());
    }
    @Test
    public void Character_Die(){
        MeleFighter myFirstCharacter = new MeleFighter(1, 1000, 10, 10, 10, 0);
        MeleFighter mySecondCharacter = new MeleFighter(2, 1000, 10, 10, 10,2);

        myFirstCharacter.setDamage(1000);
        myFirstCharacter.atackOtherCharacter(mySecondCharacter);
        
        mySecondCharacter.YouDiedOrNot();
        assertEquals(false, mySecondCharacter.getAlive());
    }
    @Test
    public void Characters_can_heal_to_characters(){
        MeleFighter myFirstCharacter = new MeleFighter(1, 1000, 10, 10, 10, 0);
        MeleFighter mySecondCharacter = new MeleFighter(2, 350, 10, 10, 10,2);

        myFirstCharacter.JoinToNewFaction("myFirstFaction");
        mySecondCharacter.JoinToNewFaction("myFirstFaction");
        

        myFirstCharacter.HealingOtherCharacter(mySecondCharacter);
        

        assertEquals(360, mySecondCharacter.getHealth());
    }
    //#endregion

    //#region iteration Two
    @Test 
    public void A_character_canoot_deal_damage_to_itself(){
        MeleFighter myCharacter = new MeleFighter(1, 1000, 10, 10, 10, 0);
        

        myCharacter.atackOtherCharacter(myCharacter);

        assertEquals(1000, myCharacter.getHealth());
    }
    @Test
    public void A_character_can_only_heal_itself(){
        MeleFighter myFirstCharacter = new MeleFighter(1, 1000, 10, 10, 10, 0);
        MeleFighter mySecondCharacter = new MeleFighter(2, 100, 10, 10, 10,2);
        
      

        myFirstCharacter.HealingOtherCharacter(mySecondCharacter);

        assertEquals(100, mySecondCharacter.getHealth());
    }
    @Test
    public void damage_diference_levels(){
        MeleFighter myFirstCharacter = new MeleFighter(1, 1000, 10, 10, 10, 0);
        MeleFighter mySecondCharacter = new MeleFighter(2, 1000, 4, 10, 10,2);
        
        myFirstCharacter.atackOtherCharacter(mySecondCharacter);
        
        

        assertEquals(985, mySecondCharacter.getHealth());
    }

    //#endregion

    //#region iteration three
    @Test
    public void Characters_have_an_attack_Max_Range_mele_fighter(){
        MeleFighter myFirstCharacter = new MeleFighter(0, 1000, 2, 10, 10, 3);
        RangedFighter mySecondCharacter = new RangedFighter(1, 1000, 2, 10, 2, 4);

        assertEquals(true, myFirstCharacter.inRange(mySecondCharacter, myFirstCharacter.getActualPosition()));
    }
    @Test
    public void Characters_must_be_in_range_to_deal_damage_to_a_target_mele_fighter(){
        MeleFighter myFirstCharacter = new MeleFighter(0, 1000, 2, 10, 10, 3);
        RangedFighter mySecondCharacter = new RangedFighter(1, 1000, 2, 10, 2, 4);
        
        myFirstCharacter.atackOtherCharacter(mySecondCharacter);
        
        

        assertEquals(990, mySecondCharacter.getHealth());
    }
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
    //#endregion
    
    //#region iteration four
    @Test
    public void Newly_created_Characters_belong_to_no_Faction(){
        MeleFighter myCharacFighter = new MeleFighter(0, 1000, 12, 29, 2, 0);
        assertEquals(0, myCharacFighter.getFactions().size());
    }
    @Test
    public void A_Character_may_Join_or_Leave_one_or_more_Factions(){
        MeleFighter myCharacFighter = new MeleFighter(0, 1000, 12, 29, 2, 0);

        myCharacFighter.JoinToNewFaction("myFirstFaction");
        myCharacFighter.JoinToNewFaction("mySecondFaction");
        myCharacFighter.JoinToNewFaction("myThirdFaction");
        myCharacFighter.LeaveToFaction("myThirdFaction");
        
        assertEquals(2, myCharacFighter.getFactions().size());
    }
    @Test
    public void Players_belonging_to_the_same_Faction_are_considered_Allies(){
        MeleFighter myFirstCharacter = new MeleFighter(1, 1000, 10, 10, 10, 0);
        MeleFighter mySecondCharacter = new MeleFighter(2, 1000, 10, 10, 10,2);
        myFirstCharacter.JoinToNewFaction("myFirstFaction");
        myFirstCharacter.JoinToNewFaction("mySecondFaction");
        mySecondCharacter.JoinToNewFaction("mySecondFaction");

        assertEquals(true, myFirstCharacter.isAllied(mySecondCharacter));
        assertEquals(true, mySecondCharacter.isAllied(myFirstCharacter));
        
    }
    @Test
    public void Allies_cannot_Deal_Damage_to_one_another(){
        MeleFighter myFirstCharacter = new MeleFighter(1, 1000, 10, 10, 10, 0);
        MeleFighter mySecondCharacter = new MeleFighter(2, 1000, 10, 10, 10,2);

        myFirstCharacter.JoinToNewFaction("myFirstFaction");
        myFirstCharacter.JoinToNewFaction("mySecondFaction");
        mySecondCharacter.JoinToNewFaction("mySecondFaction");

        myFirstCharacter.atackOtherCharacter(mySecondCharacter);

        assertEquals(1000, mySecondCharacter.getHealth());
    }
    
    @Test 
    public void Allies_can_Heal_one_another(){
        MeleFighter myFirstCharacter = new MeleFighter(1, 250, 10, 10, 10, 0);
        MeleFighter mySecondCharacter = new MeleFighter(2, 1000, 10, 10, 10,2);

        myFirstCharacter.JoinToNewFaction("myFirstFaction");
        myFirstCharacter.JoinToNewFaction("mySecondFaction");
        mySecondCharacter.JoinToNewFaction("mySecondFaction");

        mySecondCharacter.HealingOtherCharacter(myFirstCharacter);

        assertEquals(260, myFirstCharacter.getHealth());
    }
    //#endregion

    //#region iteration five
    @Test
    public void Characters_can_damage_non_character_things(){
        MeleFighter myMeleFighter = new MeleFighter(0, 250, 3, 10, 10, 0);
        Thing myTree = new Thing(1, 2000, 2);

        myMeleFighter.atackOtherCharacter(myTree);

        assertEquals(1990, myTree.getHealth());
    }
    @Test
    public void These_things_cannot_be_Healed_and_they_do_not_Deal_Damage(){
        /* MeleFighter myMeleFighter = new MeleFighter(0, 250, 3, 10, 10, 0);
        Thing myTree = new Thing(1, 2000, 2); */

        /* myTree.atackOtherCharacter(myMeleFighter); */
       /* myTree.HealingOtherCharacter(myMeleFighter); */
       /* myMeleFighter.HealingOtherCharacter(myTree); */
        
    }
    @Test 
    public void When_reduced_to_0_Health_things_are_Destroyed(){
        Thing myTree = new Thing(0, 2000, 0);
        MeleFighter myMeleFighter = new MeleFighter(1, 250, 3, 2000, 10, 0);

        myMeleFighter.atackOtherCharacter(myTree);

        assertEquals(true, myTree.isDestroyed());
    }
    //#endregion
}
