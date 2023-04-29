/**
 * Owl is a subclass of Bird class 
 */
public class Owl extends Bird{
    /** 
     * Constructor
     * @param name name of Owl
     * @param extinctStatus if is extinct
     */
    public Owl(String name, boolean extinctStatus){
        super(name, extinctStatus);
        this.type = "Owl";

        // add the characteristic
        this.addCharacteristic("distinguished by the facial disks that frame the eyes and bill");

        // add food preference
        this.addFoodToList("small mammals");
        this.addFoodToList("seeds");
        this.addFoodToList("insects");
        this.addFoodToList("fish");
    }

}
