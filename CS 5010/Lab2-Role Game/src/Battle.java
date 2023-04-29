

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
/**
 * A driver class that represnts a battle 
 */
public class Battle {

    private Character  c1; // character 1
    private Character  c2; // character 2
    private List<ArmedGear> gearPool; // a list of gears


    private boolean c1Turn;  // turn of c1
    private boolean c2Turn;  // turn of c2
    private int     curTurn; // current turn

    private static final int GAME_TURN = 10; // total turns a battle has

    private static List<String> out = new ArrayList<>();

    /**
     * Constructor of Battle
     * @param c1 // character 1
     * @param c2 // character 2
     * @param gearPool // a list of gears
     */
    public Battle(Character c1, Character c2, List<ArmedGear> gearPool){
        this.c1 = c1;
        this.c2 = c2;

        this.gearPool = gearPool;
        
        c1Turn  = false;
        c2Turn  = false;
        curTurn = 0;
    }

    /**
     * Start the battle 
     */
    public void start(){
        System.out.println("Battle start...\n");
        determineWhoseTurn();  // determine whose turn is it

        while (!isGameOver()){
            System.out.println("Turn " + curTurn);
            if (c1Turn){
                ArmedGear gear = c1.seekGear(gearPool);
                c1.pickUpGear(gear);
                c1.showCharacterInfro();
                notifyAnother();
            }else if (c2Turn){
                ArmedGear gear = c2.seekGear(gearPool);
                c2.pickUpGear(gear);
                notifyAnother();
                c2.showCharacterInfro();
            }
            curTurn++;
        }
        displayWinner();
    }

    /**
     * Determine whose turn is it
     */
    private void determineWhoseTurn(){
        Random    rd = new Random();
        int whosTurn = rd.nextInt(2)+1;
        if (whosTurn == 1){
            c1Turn = true;
        }else{
            c2Turn = true;
        }
    }

    /**
     * Notify another when one is finish its turn
     */
    private void notifyAnother(){
        if (c1Turn){
            c1Turn = false;
            c2Turn = true;
        }else{
            c1Turn = true;
            c2Turn = false;
        }
    }
    
    /**
     * Check if the game is over
     * @return the status of the game
     */
    private boolean isGameOver(){
        return curTurn == GAME_TURN;
    }
    
    /**
     * Display the inforation and show the winner
     */
    private void displayWinner(){
        // Player 1 information
        String palyer1Info = "Player 1 has " + c1.attack() + " attack points and " + c1.defense() +" defense strength.\n";
        // Player 2 information
        String palyer2Info = "Player 2 has " + c2.attack() + " attack points and " + c2.defense() +" defense strength.\n";
        
        int c1Damge = c2.attack() - c1.defense();
        int c2Damge = c1.attack() - c2.defense();
        //  final information
        String endInfo     = "The battle ends with Player 1 having " + c1Damge + " units of damage"
                                        + " and Player 2 having " + c2Damge + " units of damage.\n";
        String winnerInfo;

        if (c1Damge == c2Damge){
            winnerInfo = "The game ended in a tie.\n";
        }else if (c1Damge < c2Damge){
            winnerInfo = "Player 1 wins.\n";
        }else {
            winnerInfo = "Player 2 wins.\n";
        }

        StringBuilder all = new StringBuilder();
        all.append(palyer1Info);
        all.append(palyer2Info);
        all.append(endInfo);
        all.append(winnerInfo);
        System.out.println(all.toString());


        out.add(winnerInfo);
    }

    /**
     * scenario 1 for Battle
     */
    public static void scenario1(){
        System.out.println("Scenario 1 start...");
        List<ArmedGear> gearPool = new ArrayList<>();
        // head 
        gearPool.add(new HeadGear("Golden Helmet", 0, 5));
        gearPool.add(new HeadGear("Copper Helmet", 0, 2));

        // hand
        gearPool.add(new HandGear("Wooden Sword", 3, 0));
        gearPool.add(new HandGear("Iron Sword", 5, 0));
        gearPool.add(new HandGear("Wooden Shield", 2, 0));
        gearPool.add(new HandGear("Vibranium shield", 7, 0));
        // foot 
        gearPool.add(new FootGear("Wooden Boot", 1, 2));
        gearPool.add(new FootGear("Iron Boot", 2, 3));
        gearPool.add(new FootGear("Golden Hoverboard", 3, 4));
        gearPool.add(new FootGear("Golden Hoverboard", 3, 4));

        // shuffle the elements using Collections.shuffle()
        Collections.shuffle(gearPool);
        Character c1 = new Character("Gandalf", 0, 0);
        Character c2 = new Character("Aragorn", 0, 0);

        Battle battle = new Battle(c1, c2, gearPool);
        battle.start();
    }

    /**
     * scenario 2 for Battle
     */
    public static void scenario2(){
        System.out.println("Scenario 2 start...");
        List<ArmedGear> gearPool = new ArrayList<>();

        // hand
        gearPool.add(new HandGear("Red Sword", 1, 0));
        gearPool.add(new HandGear("Iron Sword", 5, 0));
        gearPool.add(new HandGear("Wooden Shield", 2, 0));
        gearPool.add(new HandGear("Vibranium Shield", 7, 0));

        gearPool.add(new HandGear("Soft Sword", 2, 0));
        gearPool.add(new HandGear("Happy Shield", 1, 0));


        gearPool.add(new HandGear("Rough Sword", 3, 0));
        gearPool.add(new HandGear("Small Sword", 3, 0));

        gearPool.add(new HandGear("9 Sword", 3, 0));
        gearPool.add(new HandGear("10 Sword", 3, 0));

        // shuffle the elements using Collections.shuffle()
        Collections.shuffle(gearPool);
        Character c1 = new Character("Gandalf", 0, 0);
        Character c2 = new Character("Aragorn", 0, 0);

        Battle battle = new Battle(c1, c2, gearPool);
        battle.start();
    }
    

    /**
     * Main function where the code start
     * @param args none
     */
    public static void main(String[] args){
        
        scenario1();
        scenario2();
    }
}
