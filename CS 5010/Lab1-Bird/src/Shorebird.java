/**
 * Shorebird is a subclass of WaterBird class
 */
public class Shorebird extends WaterBird{
    /** 
     * Constructor 
     * @param name name of Shorebird
     * @param extinctStatus if is extinct
     **/
    public Shorebird(String name, boolean extinct){
        super(name, extinct);
        this.type = "Shorebird";

        // add characcteristic 
        this.addCharacteristic("one of the very most extensive bird orders");
        this.addCharacteristic("there are about 350 bird species in it");
        this.addCharacteristic("these birds have varied in size from 0.006 to 4.4 pounds");

        // add bodyOfWater they're living 
        this.addBodyOfWater("wetlands");
        this.addBodyOfWater("freshwater");
        this.addBodyOfWater("saltwater");
        this.addBodyOfWater("shorelands");
        this.addBodyOfWater("ocean");

        // add food preference
        this.addFoodToList("fish");
        this.addFoodToList("seeds");
        this.addFoodToList("insects");
        this.addFoodToList("aquatic invertebrates");
        
    }
}
