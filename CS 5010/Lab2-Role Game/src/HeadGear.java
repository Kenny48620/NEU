
/**
 * This class represent HeadGear and extends from ArmedGear
 */
public class HeadGear extends ArmedGear{
    /**
     * Construcotr of HeadGear
     * @param name    name of gear
     * @param attack  attack strength
     * @param defense defense strength
     */
    public HeadGear(String name, int attack, int defense) {
        super(name, attack, defense);
        // HandGear is only used for defense
        if (attack != 0){
            throw new IllegalArgumentException("Error: attack should be zero for HeadGear");
        }
    }

    @Override
    public ArmedGear createGear(String name, int attack, int defense) {
        return new HeadGear(name, attack, defense);
    }
    
}
