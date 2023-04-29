import java.util.HashMap;
import java.util.Map;
/**
 * This class is to imitate an Aviary that holds bird objects
 */
public class Aviary {

    private static final int MAX_SIZE         = 5; // Maximum size of aviary capacity

    private static final String FLIGHTLESS    = "Flightless";
    private static final String BIRDS_OF_PREY = "BirdsOfPrey";
    private static final String WATERFOWL     = "Waterfowl";

    private Bird[]  aviary;      // array to stores birds
    private int     size;        // size of aviary
    private int     houseNum;    // aviafy number

    // need a variable to keep tracking food and the quantity
    Map<String, Integer> foodMap;

    private String  type;
    /** 
     * Constructor 
     **/
    public Aviary(){
        houseNum  = -1;
        aviary    = new Bird[MAX_SIZE];
        size      = 0;
        foodMap   = new HashMap<>();
        type      = "";
    }
    /**
     * Put bird into slot, I didn't handle illegalargumentException because I restrict the input in Conservatory class
     * @param bird  Bird object
     */
    public void put(Bird bird){
        // check aviary capacity
        if (size > MAX_SIZE){
            throw new IndexOutOfBoundsException("There is no more avaliable space for this bird");
        }

        String birdType = bird.getType();
        // change type when first put in
        if (size == 0){
            if (birdType.equals(FLIGHTLESS))
                type = FLIGHTLESS;
            else if (birdType.equals(BIRDS_OF_PREY))
                type = BIRDS_OF_PREY;
            else if (birdType.equals(WATERFOWL))
                type = WATERFOWL;
        }
   
        aviary[size] = bird;
        size++;
    }

    /** 
     * Add into food map to keep tracking the food peference and quantity 
     * @param bird Bird object
     */
    public void recordFoodPeference(Bird bird){
        for (String p: bird.getFoodList()){
            if (!foodMap.containsKey(p)){
                foodMap.put(p, 0);
            }
            int quantity = foodMap.get(p)+1;
            foodMap.put(p, quantity);
        }
    }
    /**
     * Getter for food map
     * @return food map
     */
    public Map<String, Integer> getFoodMap(){
        return foodMap;
    }

    /**
     * Show the birds in aviary
     * @return a String that contains all birds in aviary
     */
    public String displayBirds(){
        String all = "Aviary "+houseNum+ " has:\n" ;
       
        for (int i=0; i<size; i++){
            all += aviary[i]+"\n";
        }

        all += "-------------------------------";
        System.out.println(all);
        return all;
    }
    /**
     * Dispaly required food list
     * @return a String that showing the food list information
     */
    public String displayFoodList(){

        String foodInfo = "Aviary " + houseNum + " food list needs: "+foodMap.toString();

        System.out.println(foodInfo);

        return foodInfo;
    }

    /**
     * Diesplay the detail of bird and the information such as description, food preferene, extict status, etc.
     * @return an output string
     */
    public String displayDetail(){
        String allDetail = "Start to display the detail of Aviary " + houseNum+"\n";

        for (int i=0; i<size; i++){
            allDetail += "Slot " + i +": " + aviary[i]+"\n";
            // add the characteristic description
            allDetail += "Characterics: \n" + aviary[i].getAllCharacteristic();
            // if it's parrot, add the words and favorite word
            if (aviary[i].getType().equals("Parrot")){
                Parrot parrot = (Parrot) aviary[i];
                allDetail += "Words: " + parrot.getWords() + "\n";
                allDetail += "Favorite word: " + parrot.getFavoriteWord();
            }
            // add food preference
            allDetail += "Food preference: "+aviary[i].getAllFood()+"\n";
            allDetail += "\n";
        }

        System.out.printf(allDetail);
        // display the whole food list in this aviary
        displayFoodList();

        System.out.println();
        System.out.println();
        return allDetail;
    }

    /** 
     * Setter for house number
     * @param house number
     */
    public void setHouseNum(int num){
        houseNum = num;
    }
    /** 
     * Getter for house number
     * @return house number
     */
    public int getHouseNum(){
        return houseNum;
    }

    /**
     * Getter for size
     * @return current size
     */
    public int getSize(){
        return size;
    }
    /**
     * Setter for type
     * @param type a String
     */
    public void setType(String type){
        this.type = type;
    }

    /** 
     * Getter for type 
     * @return the type of this aviary
     */
    public String getType(){
        return type;
    }

    /**
     * Getter for aviary
     * @return an Bird array
     */
    public Bird[] getAviary(){
        return aviary;
    }

}
