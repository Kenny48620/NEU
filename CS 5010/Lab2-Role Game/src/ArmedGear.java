

import java.util.ArrayList;
import java.util.List;
/**
 * This class is an abstract class that implements from Gear
 */
public abstract class ArmedGear implements Gear{

    private String name;    // nmae of gear
    private int    attack;  // attack strength
    private int    defense; // defense strength

    private List<String> adjectives; // a list that stores the adjectives of name 
    private String noun;                  // nound of name

    /**
     * Constructor of ArmedGear
     * @param name name of gear 
     * @param attack attack strength
     * @param defense defense strength
     */
    public ArmedGear(String name, int attack, int defense){
        this.name    = name;
        this.attack  = attack;
        this.defense = defense;

        // get the adjectives
        String[] nameArr = name.split(" ");
        adjectives = new ArrayList<>();
        for (int i=0; i<nameArr.length-1; i++){
            adjectives.add(nameArr[i]);
        }
        // assign the noun
        noun = nameArr[nameArr.length-1];
    }

    @Override
    public List<String> getAdjective() {
        return adjectives;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getDefense() {  
        return defense;
    }
    /**
     * An helper that helps create a type of gear
     * @param name  name of gear 
     * @param attack attack strength
     * @param defense defense strength
     * @return an Armedgear
     */
    public abstract ArmedGear createGear(String name, int attack, int defense);
    
    @Override
    public Gear combineWith(Gear another) {
        // check type
        if (this.getClass() != another.getClass()){
            throw new IllegalArgumentException("ERROR: cannot combime diffrent type of gear");
        }

        StringBuilder     sb = new StringBuilder();
        List<String> anotherAjectives = another.getAdjective();
        
        for (int i=0; i<anotherAjectives.size(); i++){
            sb.append(anotherAjectives.get(i)+" ");
        }
        sb.append(", ");
        for (int i=0;i<adjectives.size(); i++){
            sb.append(adjectives.get(i)+" ");
        }

        sb.append(noun);
        System.out.println("New name: " + sb);
        int newAtk = attack+another.getAttack();
        int newDef = defense+another.getDefense();

        return createGear(sb.toString(), newAtk, newDef);
    }
    
    @Override
    public String toString(){
        return name;
    }
}
