/**
 * Flightless is a subclass of Bird class
 */
public class Flightless extends Bird{
    /** 
     * Constructor
     * @param name name of Flightless
     * @param extinctStatus if is extinct
     **/
    public Flightless(String name, boolean extinctStatus){
        super(name, extinctStatus);
        this.type  = "Flightless";
        this.wings = 0;

        // add the characteristic
        this.addCharacteristic("live on the ground");
        this.addCharacteristic("have no wings");

        // add food preference
        this.addFoodToList("buds");
        this.addFoodToList("seeds");
        this.addFoodToList("nuts");
        this.addFoodToList("berries");
    }
}
