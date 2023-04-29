import java.util.ArrayList;
import java.util.List;
/**
 * A abstract class is used to be the base class of all type of birds
 */
public abstract class Bird {
    
    protected String       name;        // bird name
    protected String       type;        // bird type
    protected int          wings;       // numbers of wings
    protected List<String> foodList;    // food preference list
    protected List<String> characList;  // characteristic list
    protected boolean      isExtinct;   // extinct status
    protected int          aviaryNum;   // aviary location number
    
    /** 
     * Constructor 
     * @param name a String name of a bird
     * @param extinctStatus if it is extinct
     **/
    public Bird(String name, boolean extinctStatus){
        this.name       = name;
        this.type       = "bird";
        this.wings      = 2;
        this.foodList   = new ArrayList<>();
        this.characList = new ArrayList<>();
        this.isExtinct  = extinctStatus;
    }

    /**
     * Setter for type
     * @param type bird type
     */
    public void setType(String type){
        this.type = type;
    }

    /**
     * Getter for type
     * @return bird type
     */
    public String getType(){
        return type;
    }


    /**
     * Setter for wings
     * @param wings number of wings
     */
    public void setWings(int wings){
        this.wings = wings;
    }
    /**
     * Getter for wings
     * @return number of wings
     */
    public int  getWings(){
        return wings;
    }


    /**
     * Add food preference to food list
     * @param food food preference 
     */
    public void addFoodToList(String food){
        foodList.add(food);
    }
    /**
     * Getter for food list
     * @return food preference list
     */
    public String getAllFood(){
        String preference = "";
        for (String p:foodList){
            preference += p + ",";
        }
        if (preference.length()>2){
            preference = preference.substring(0, preference.length()-1);
        }
        return preference;
    }
    /**
     * Getter for food list
     * @return food preference list
     */
    public List<String> getFoodList(){

        return this.foodList;
    }


    /**
     * Add characteristic to characteristic list
     * @param characteristic the characteristic of the bird
     */
    public void addCharacteristic(String characteristic){
        characList.add(characteristic);
    }
    /**
     * Getter characteristic list
     * @return  characteristic list
     */
    public List<String> getCharacList(){
        return characList;
    }

    /**
     * Get all characteristic in the characList
     * @return a string that has all characteristic in characList
     */
    public String getAllCharacteristic(){
        String all = "";
        for (String c: characList){
            all +=  c+"\n";
        }
        return all;
    }


    /**
     * Setter for isExtinct
     * @param status extinct status
     */
    public void setExtinctStatus(boolean status){
        this.isExtinct = status;
    }
    /**
     * Getter for isExtinct
     * @return the extinct status of the bird
     */
    public boolean getExtinctStatus(){
        return this.isExtinct;
    }


    /**
     * Setter for aviaryNum
     * @param num hosue number
     */
    public void setAviaryNumber(int num){
        aviaryNum = num;
    }
    /**
     * Getter for aviaryNum
     * @return hosue number
     */
    public int getAviaryNumber(){
        return aviaryNum;
    }

    /**
     * Setter for name
     * @param num a String
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Getter for name
     * @return name of bird
     */
    public String getName(){
        return name;
    }

    /**
     * Override toString() method
     * @return a String 
     */
    @Override
    public String toString(){
        return this.name;
    }

}
