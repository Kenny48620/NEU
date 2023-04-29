

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * This class is to represnt a Character
 */
public class Character {
    private String name; // name of Character
    private final int baseAttack;  // base attack
    private final int baseDefense; // base defense


    private int attack;  // attack strength
    private int defense; // defese strength


    private HeadGear       headWearing; // curreting wearing of head
    private List<HandGear> handWearing; // curreting wearing of hands
    private List<FootGear> footWearing; // curreting wearing of foot

    private static final int HEAD_MAX_HOLD = 1; // maximum items head can hold
    private static final int HAND_MAX_HOLD = 2; // maximum items hands can hold
    private static final int FOOT_MAX_HOLD = 2; // maximum items foot can hold

    /**
     * Constructor of Character
     * @param name    // name of Character
     * @param attack  // attack strength
     * @param defense // defese strength
     */
    public Character(String name, int baseAttack, int baseDefense){
        this.name    = name;
        this.baseAttack  = baseAttack;
        this.baseDefense = baseDefense;
        
        attack  = 0 + baseAttack;
        defense = 0 + baseDefense;

        handWearing = null;
        handWearing = new ArrayList<>();
        footWearing = new ArrayList<>();
    }

    /**
     * Search for the appropriate gear from gear pool
     * @param gearPool a list of armed gear
     * @return a armed gear we're looking for 
     */
    public ArmedGear seekGear(List<ArmedGear> gearPool){
        // if the gearPool has no gear left
        if (gearPool.size() == 0){
            throw new IllegalArgumentException("Error: there is no gear lieft");
        }
        
        int headHold = 0;
        if (headWearing != null){
            headHold = 1;
        }
        ArmedGear gear;
        // rule 1
        if (headHold+handWearing.size()+footWearing.size() == HEAD_MAX_HOLD+HAND_MAX_HOLD+FOOT_MAX_HOLD-1){
            if (headHold == 0){
                System.out.println("Here");
                gear = findByType(gearPool, HeadGear.class);
                if (gear != null){
                    return gear;
                }
            }else if (handWearing.size() != HAND_MAX_HOLD){
                gear = findByType(gearPool, HandGear.class);
                if (gear != null){
                    return gear;
                }
            }else{
                gear = findByType(gearPool, FootGear.class);
                if (gear != null){
                    return gear;
                }
            }
        }
    
        // rule 2 find highest atk
        gear = findHighestAtk(gearPool);
        if (gear != null){
            return gear;
        }
        // rule 3 find highest def
        gear = findHighestDef(gearPool);
        if (gear != null){
            return gear;
        }
        // rule 4 random pick
        gear = randomFind(gearPool);
        
        return gear;
    }

    /**
     * Rule2. Find the gear that has the highest attack. If there is
     * a tie, return null.
     * @param gearPool a list of armed gear
     * @return a gear with highset attack
     */
    private ArmedGear findHighestAtk(List<ArmedGear> gearPool){
        int        count     = 1;
        int        index     = 0;
        for (int i=1; i<gearPool.size(); i++){
            if (gearPool.get(i).getAttack() > gearPool.get(index).getAttack()){
                index   = i;
                count   = 1;
            }else if (gearPool.get(i).getAttack() == gearPool.get(index).getAttack()){
                count++;
            }
        }
        return count == 1? gearPool.remove(index): null;
    }

    /**
     * Rule 3. Find the gear that has the highest defense. If there is
     * a tie, return null.
     * @param gearPool a list of armed gear
     * @return a gear with highset defense
     */
    private ArmedGear findHighestDef(List<ArmedGear> gearPool){
        int        count     = 1;
        int index  = 0;
        for (int i=1; i<gearPool.size(); i++){
            if (gearPool.get(i).getDefense() > gearPool.get(index).getDefense()){
                index = i;
                count   = 1;
            }else if (gearPool.get(i).getDefense() == gearPool.get(index).getDefense()){
                count++;
            }
        }
        return count == 1? gearPool.remove(index): null;
    }

    /**
     * Rule4. Randomly find a gear
     * @param gearPool a list of armed gear
     * @return a gear that we randomly found
     */
    private ArmedGear randomFind(List<ArmedGear> gearPool){
        Random random = new Random();
        int index     = random.nextInt(gearPool.size());
        return gearPool.remove(index);
    }

    /**
     * Find a gear by a given class, If not found return null
     * @param gearPool a list of armed gear
     * @param cls a class that character is going to match
     * @return a gear that matchec the same type with cls
     */
    private ArmedGear findByType(List<ArmedGear> gearPool, Class cls){
        for (int i=0; i<gearPool.size(); i++){
            if (gearPool.get(i).getClass() == cls){
                return gearPool.remove(i);
            }
        }

        return null;
    }
    
    /**
     * Pick up a gear
     * @param gear a gear that character is going to pick up
     */
    public void pickUpGear(ArmedGear gear){
        if (gear instanceof HeadGear){

            if (headWearing == null){
                headWearing = (HeadGear) gear;
            }else{
                headWearing = (HeadGear) headWearing.combineWith(gear);
            }
            defense += gear.getDefense();

        }else if (gear instanceof HandGear){
            if (handWearing.size() < HAND_MAX_HOLD){
                handWearing.add((HandGear) gear);
            }else{
                HandGear less;
                HandGear left  = handWearing.get(0);
                HandGear right = handWearing.get(1);
                if (left.getAdjective().size() > right.getAdjective().size()){
                    handWearing.set(1, (HandGear) handWearing.get(1).combineWith(gear));
                }else{
                    handWearing.set(0, (HandGear) handWearing.get(0).combineWith(gear));
                }
            }
            attack += gear.getAttack();

        }else if (gear instanceof FootGear){
            if (footWearing.size() < FOOT_MAX_HOLD){
                footWearing.add((FootGear) gear);
            }else{
                FootGear less;
                FootGear left  = footWearing.get(0);
                FootGear right = footWearing.get(1);
                if (left.getAdjective().size() > right.getAdjective().size()){
                    footWearing.set(1, (FootGear) footWearing.get(1).combineWith(gear));
                }else{
                    footWearing.set(0, (FootGear) footWearing.get(1).combineWith(gear));
                
                }
               // less.combineWith(gear);
            }
            attack  += gear.getAttack();
            defense += gear.getDefense();
        }
    }

    /**
     * Getter of Character name
     * @return String name
     */
    public String getName(){
        return name;
    }

    /**
     * Getter of attack strength
     * @return int attack
     */
    public int attack(){
        return attack;
    }

    /**
     * Getter of defense strength
     * @return defense
     */
    public int defense(){
        return defense;
    }

    /**
     * Display Character information
     * @return a String that contains information of Character
     */
    public String showCharacterInfro(){
        StringBuilder sb = new StringBuilder();
        sb.append("Character: " + name);
        sb.append("\nHead Gear:");
        if (headWearing != null){
            sb.append(" " + headWearing.getName());
        }
        sb.append("\nHand Gaer:");
        if (handWearing.size() == 1){
            sb.append(" " + handWearing.get(0).getName());
        }else if (handWearing.size() == HAND_MAX_HOLD){
            sb.append(" " + handWearing.get(0).getName() + " | " + handWearing.get(1).getName());
        }
        sb.append("\nFoot Gaer:");
        if (footWearing.size() == 1){
            sb.append(" " + footWearing.get(0).getName());
        }else if (footWearing.size() == HAND_MAX_HOLD){
            sb.append(" " + footWearing.get(0).getName() + " | " + footWearing.get(1).getName());
        }

        sb.append("\n");
        sb.append("Attack: " + attack + ", " + "Defense: " + defense + "\n");

        String all = sb.toString();
        System.out.println(all);
        return all;
    }
}
