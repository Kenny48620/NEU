/**
 * Waterfowl is a subclass of WaterBird class
 */
public class Waterfowl extends WaterBird{
    /** 
     * Constructor 
     * @param name name of Waterfowl
     * @param extinctStatus if is extinct
     * */
    public Waterfowl(String name, boolean extinct){
        super(name, extinct);
        this.type = "Waterfowl";

        // add characteristic 
        this.addCharacteristic("webbed");
        this.addCharacteristic("feet");
        this.addCharacteristic("round bodies");
        this.addCharacteristic("long necks");
        this.addCharacteristic("small wings");

        // add bodyOfWater they're living
        this.addBodyOfWater("fresh water source");
        this.addBodyOfWater("salt water source");

        // add food preference
        this.addFoodToList("berries");
        this.addFoodToList("fish");
        this.addFoodToList("insects");
        this.addFoodToList("aquatic invertebrates");
    }
}
