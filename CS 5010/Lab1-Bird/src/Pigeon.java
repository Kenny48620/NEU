/**
 * Pigeon is a subclass of Bird class 
 */
public class Pigeon extends Bird{
    /** 
     * Constructor 
     * @param name name of Pigeon
     * @param extinctStatus if is extinct
     **/
    public Pigeon(String name, boolean extinctStatus){
        super(name, extinctStatus);
        this.type = "Pigeon";

        // add the characteristic
        this.addCharacteristic("feeding their young \"bird milk\" very similar to the milk of mammals");
        // add food preference
        this.addFoodToList("nuts");
        this.addFoodToList("eggs");
        this.addFoodToList("fruit");
        this.addFoodToList("berries");
    }

}