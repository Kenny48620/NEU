/**
 * This class represent FootGear and extends from ArmedGear
 */
public class FootGear extends ArmedGear{
    /**
     * Construcotr of FootGear
     * @param name    name of gear
     * @param attack  attack strength
     * @param defense defense strength
     */
    public FootGear(String name, int attack, int defense) {
        super(name, attack, defense);
    }

    @Override
    public ArmedGear createGear(String name, int attack, int defense) {
        return new FootGear(name, attack, defense);
    }
}
