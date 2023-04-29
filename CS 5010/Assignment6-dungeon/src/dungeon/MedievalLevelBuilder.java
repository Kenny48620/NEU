package dungeon;

/**
 * This class is a builder class for Level
 */
public class MedievalLevelBuilder {
    
    private Level level;        // a level in a dungeon
    private int numOfRooms;     // number of rooms it has 
    private int numOfMonsters;  // number of monsters it has 
    private int numOfTreasures; // number of treasures it has 
    private int roomsCount;     // the rooms it currently has

    /* Monster fields */
    private static final int GOBLIN_HITPOINTS = 7;  // hitpoints of goblin
    private static final int ORC_HITPOINTS    = 20; // hitpoints of orc
    private static final int ORGE_HITPOINTS   = 50; // hitpoints of orege
    
    // description of goblin
    private static final String GOBLIN_DESC = "mischievous and very unpleasant, vengeful, "
                                            +"and greedy creature whose primary purpose is to cause trouble to humankind";
    // description of orc
    private static final String ORC_DESC    = "brutish, aggressive, malevolent being serving evil";
    // description of orge
    private static final String ORGE_DESC   = "large, hideous man-like being that likes to eat humans for lunch";
                                    
    /* Treasure fields */
    private static final int POTION_VALUE   = 1;  // the value of potion
    private static final int WEAPON_VALUE   = 10; // the value of weapon

    private static final String POTION_DESC = "a healing potion"; // description of potion
    private static final String GOLD_DESC   = "pieces of gold";   // description of gold

    /**
     * Constructor of Level builder
     * @param levelNum level number
     * @param numOfRooms     number of rooms it has 
     * @param numOfMonsters  number of monsters it has 
     * @param numOfTreasures number of treasures it has 
     */
    public MedievalLevelBuilder(int levelNum, int numOfRooms, int numOfMonsters, int numOfTreasures){
        // throw exception if it takes non-negative arguments
        if (levelNum < 0 || numOfRooms < 0 || numOfMonsters < 0 || numOfTreasures < 0){
            throw new IllegalArgumentException("Error: arguements should be non-negative");
        }

        level               = new Level(levelNum);
        this.numOfRooms     = numOfRooms;
        this.numOfMonsters  = numOfMonsters;
        this.numOfTreasures = numOfTreasures;
        roomsCount          = 0;
    }

    /**
     * Add room to level
     * @param desc description of a room
     */
    public void addRoom(String desc){
        // throw exception if exceed the room capacity of the level
        if (numOfRooms == 0){
            throw new IllegalStateException("ERROR: too many rooms are added to this level");
        }
        level.addRoom(desc);
        numOfRooms--;
        roomsCount++;
    }

    /**
     * Add number of goblins to a room by number 
     * @param roomNum  room number
     * @param numOfGob number of goblins
     */
    public void addGoblins(int roomNum, int numOfGob){
        checkRoomNumber(roomNum);
        for (int i=0; i<numOfGob; i++){
            checkNumOfMonsters();
            level.addMonster(roomNum, new Monster("goblin", GOBLIN_DESC, GOBLIN_HITPOINTS));
            numOfMonsters--;
        }
    }

    /**
     * Add a orc by room number
     * @param roomNum room number
     */
    public void addOrc(int roomNum){
        checkNumOfMonsters();
        checkRoomNumber(roomNum);
        level.addMonster(roomNum, new Monster("orc", ORC_DESC, ORC_HITPOINTS));
        numOfMonsters--;
    }

    /**
     * Add a ogre by room number   
     * @param roomNum room number
     */
    public void addOgre(int roomNum){
        checkNumOfMonsters();
        checkRoomNumber(roomNum);
        level.addMonster(roomNum, new Monster("ogre", ORGE_DESC, ORGE_HITPOINTS));
        numOfMonsters--;
    }

    /**
     * Add a human with room number, name, description and hitpotints
     * @param roomNum   room number
     * @param name      name
     * @param desc      description
     * @param hitpoints hitpoints
     */
    public void addHuman(int roomNum, String name, String desc, int hitpoints){
        checkNumOfMonsters();
        checkRoomNumber(roomNum);
        level.addMonster(roomNum, new Monster(name, desc, hitpoints));
        numOfMonsters--;
    }

    /**
     * Add a potion to a room by room number
     * @param roomNum room number
     */
    public void addPotion(int roomNum){
        checknumOfTreasures();
        checkRoomNumber(roomNum);
        level.addTreasure(roomNum, new Treasure(POTION_DESC, POTION_VALUE));
        numOfTreasures--;
    }

    /**
     * Add pieces of gold to a room by room number
     * @param roomNum room number
     * @param value   value of the pieces of gold
     */
    public void addGold(int roomNum, int value){
        // add "pieces of gold" of the specified value to the specified room.
        checknumOfTreasures();
        checkRoomNumber(roomNum);
        level.addTreasure(roomNum, new Treasure(GOLD_DESC, value));
        numOfTreasures--;
    }

    /**
     * Add a weapon to a room with it's desc by room number
     * @param roomNum room number
     * @param desc    description
     */
    public void addWeapon(int roomNum, String desc){
        checknumOfTreasures();
        checkRoomNumber(roomNum);
        level.addTreasure(roomNum, new Treasure(desc, WEAPON_VALUE));
        numOfTreasures--;
    }

    /**
     * Add the most exclusive treasures with the description and the value to a room by room number
     * @param roomNum room number
     * @param desc    description
     * @param value   value
     */
    public void addSpecial(int roomNum, String desc, int value){
        // can be used to add the most exclusive treasures to the specified room.
        checknumOfTreasures();
        checkRoomNumber(roomNum);
        level.addTreasure(roomNum, new Treasure(desc, value));
        numOfTreasures--;
    }

    /**
     * This method should return the level only after it has been completely constructed
     * @return Level
     */
    public Level build(){
        // If it is called before completion, it should raise an IllegalStateException.
        if (numOfRooms != 0 || numOfMonsters != 0 || numOfTreasures != 0){
            throw new IllegalStateException("ERROR: level is not completed yet");
        }

        return level;
    }

    /**
     * Checck if there is still space for adding a monster
     */
    private void checkNumOfMonsters(){
        if (numOfMonsters == 0){
            throw new IllegalStateException("ERROR: no more space for a monster");
        }
    }
    /**
     * 
     * Checck if there is still space for adding a treasure
     */
    private void checknumOfTreasures(){
        if (numOfTreasures == 0){
            throw new IllegalStateException("ERROR: no more space for a treasure");
        }
    }

    /**
     * Check if the room number is valid
     * @param roomNum room number
     */
    private void checkRoomNumber(int roomNum){
        if (roomsCount < roomNum){
            throw new IllegalArgumentException("ERROR: this room has not yet been created");
        }
    }
}
