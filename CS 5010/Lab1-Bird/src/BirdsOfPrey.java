/**
 * BirdsOfPrey is a subclass of Bird class
 */
public class BirdsOfPrey extends Bird{
    /** 
     * Constructor
     * @param name name of BirdsOfPrey
     * @param extinctStatus if is extinct
     **/
    public BirdsOfPrey(String name, boolean extinctStatus){
        super(name, extinctStatus);
        this.type = "BirdsOfPrey";

        // add the characteristic
        this.addCharacteristic("sharp");
        this.addCharacteristic("hooked beaks with visible nostrils");

        // add food preference
        this.addFoodToList("eggs");
        this.addFoodToList("other birds");
        this.addFoodToList("small mammals");
        this.addFoodToList("insects");
    }

}
