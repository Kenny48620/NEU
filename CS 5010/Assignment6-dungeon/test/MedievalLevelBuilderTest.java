package dungeon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dungeon.Level;
import dungeon.MedievalLevelBuilder;

public class MedievalLevelBuilderTest {

    /**
     * Test constructor throwing illegalargument exception for negative argument 
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorIllegalArgumentException0(){
        MedievalLevelBuilder mb = new MedievalLevelBuilder(-1, 1, 1, 1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorIllegalArgumentException1(){
        MedievalLevelBuilder mb = new MedievalLevelBuilder(1, -1, 1, 1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorIllegalArgumentException2(){
        MedievalLevelBuilder mb = new MedievalLevelBuilder(1, 1, -1, 1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorIllegalArgumentException4(){
        MedievalLevelBuilder mb = new MedievalLevelBuilder(1, 1, 1, -1);
    }

    /**
     * Test number of rooms out of bound exception
     */
    @Test(expected = IllegalStateException.class)
    public void testAddTooManyRoomIllegalStateException(){
        MedievalLevelBuilder mb = new MedievalLevelBuilder(1, 1, 1, 1);
        mb.addRoom("room 1");
        mb.addRoom("room 2");
    }

    /**
     * Test invalid room number exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRoomNumberIllegalArgumentException(){
        MedievalLevelBuilder mb = new MedievalLevelBuilder(1, 2, 1, 1);
        mb.addRoom("room 1");
        mb.addGoblins(2, 1);
    }

    /**
     * Test number of monsters out of bound exception
     */
    @Test(expected = IllegalStateException.class)
    public void testMonsterNumberOutOfRangeIllegalStateException(){
        MedievalLevelBuilder mb = new MedievalLevelBuilder(1, 2, 1, 1);
        mb.addRoom("room 1");
        mb.addGoblins(0, 2);
    }

    /**
     * Test number of treasure out of bound exception
     */
    @Test(expected = IllegalStateException.class)
    public void testTreasureNumberOutOfRangeIllegalStateException(){
        MedievalLevelBuilder mb = new MedievalLevelBuilder(1, 2, 1, 1);
        mb.addRoom("room 1");
        mb.addPotion(0);
        mb.addPotion(0);
    }

    /**
     * Test incomplete number of rooms exception
     */
    @Test(expected = IllegalStateException.class)
    public void testFewRoomsIllegalStateException(){
        MedievalLevelBuilder mb = new MedievalLevelBuilder(1, 5, 1, 1);
        mb.addRoom("room 1");
        mb.addOrc(0);
        mb.addPotion(0);
        mb.build();
    }

    /**
     * Test incomplete number of monsters exception
     */
    @Test(expected = IllegalStateException.class)
    public void testFewMonstersIllegalStateException(){
        MedievalLevelBuilder mb = new MedievalLevelBuilder(1, 1, 5, 1);
        mb.addRoom("room 1");
        mb.addOrc(0);
        mb.addPotion(0);
        mb.build();
    }
    /**
     * Test incomplete number of treasures exception
     */
    @Test(expected = IllegalStateException.class)
    public void testFewTreasuresIllegalStateException(){
        MedievalLevelBuilder mb = new MedievalLevelBuilder(1, 1, 1, 5);
        mb.addRoom("room 1");
        mb.addOrc(0);
        mb.addPotion(0);
        mb.build();
    }

    /**
     * Test if MedievalLevelBuilder can finally build a level
     */
    public void testBuild(){
        MedievalLevelBuilder mb = new MedievalLevelBuilder(11,3, 8, 4);
        mb.addRoom("room 1");mb.addRoom("room 2");mb.addRoom("room 3");
        mb.addGoblins(0, 3); mb.addOrc(0);
        mb.addOgre(1); mb.addHuman(1, "human 1", "male", 1);
        mb.addHuman(2, "human 2", "male", 1);
        mb.addHuman(2, "human 3", "male", 2);

        mb.addPotion(0);
        mb.addGold(1, 10);
        mb.addWeapon(1, "sword");
        mb.addSpecial(2, "golden shiled", 30);
        
        Level level = mb.build();

        assertEquals(11, level.getLevelNumber());
    }

}
