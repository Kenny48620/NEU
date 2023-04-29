import java.util.ArrayList;
import java.util.List;
/**
 * WaterBird is an abstract subclass of Bird class
 */
public abstract class WaterBird extends Bird
{   
    private List<String> bodyOfWater;   // a list that records the body of water that they live by
    /** 
     * Constructor 
     * @param name name of WaterBird
     * @param extinct if is extinct
     **/
    public WaterBird(String name, boolean extinct){
        super(name, extinct);
        bodyOfWater = new ArrayList<>();
    }

    /**  
     * Setter for bodyOfWater 
     * @param bodyOfWater the body of water that they live by
     */
    public void addBodyOfWater(String bodyOfWater){
        this.bodyOfWater.add(bodyOfWater);
    }
    /**  
     * Getter for bodyOfWater 
     * @return a list that records the body of water that they live by
     */
    public List<String> getBodyOfWater(){
        return this.bodyOfWater;
    }

}
