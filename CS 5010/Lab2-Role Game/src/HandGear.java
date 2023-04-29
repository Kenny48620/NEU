/**
 * This class represent HandGear and extends from ArmedGear
 */
public class HandGear extends ArmedGear{
    /**
     * Construcotr of HandGear
     * @param name    name of gear
     * @param attack  attack strength
     * @param defense defense strength
     */
    public HandGear(String name, int attack, int defense) {
        super(name, attack, defense);
        // HandHear is only used for attack
        if (defense != 0){
            throw new IllegalArgumentException("Error: defense should be zero for HandGear");
        }
    }

    @Override
    public ArmedGear createGear(String name, int attack, int defense) {
       return new HandGear(name, attack, defense);
    }
    
}
