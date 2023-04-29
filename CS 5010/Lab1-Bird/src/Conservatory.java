import java.util.ArrayList;
import java.util.Collections;
/**
 *  This class is to imitate a Conservatory that holds aviary and the bird objects
 */

public class Conservatory {
    private static final int MAX_AVIARY  = 20;  // Maximum number of 20 aviaries in a conservatory
    private static final int AVIARY_SIZE = 5;   // Maximum size of each aviary

    private static final String FLIGHTLESS    = "Flightless";
    private static final String BIRDS_OF_PREY = "BirdsOfPrey";
    private static final String WATERFOWL     = "Waterfowl";

    public Aviary[] aviary;               // an array to store aviaries
    private ArrayList<String> birdsRecod; // store bird in alphabetical order and their location
    
    /** 
     * Constructor 
     */
    public Conservatory(){
        aviary = new Aviary[MAX_AVIARY];
        birdsRecod = new ArrayList<>();

        // Initialize aviaries and add assign house number to each 
        initAviary();
    }

    /** 
     * Put bird into an aviary 
     * @param Bird object
     **/
    public void sendToAviary(Bird bird){
        // check extinct status
        if (bird.getExtinctStatus()){
            throw new IllegalArgumentException("Bird must not be extinct");
        }

        // find an avaliable aviary
        for (int i=0; i<MAX_AVIARY; i++){
            Aviary curAviary = aviary[i];
            // Put into the aviary if there is no one in it. So no restrictions
            if (curAviary.getSize() == 0){
           //     System.out.println(bird);
                curAviary.put(bird);
                curAviary.recordFoodPeference(bird);
                recordBirdLoc(bird, i);
                // Done
                return;
            }

            // There is at least a bird in the aviary
            if (curAviary.getSize() < AVIARY_SIZE){
                // Three special cases
                // If the bird type match the aviary type
                if (bird.getType().equals(FLIGHTLESS)){
                    if (curAviary.getType().equals(FLIGHTLESS)){
                        curAviary.put(bird);
                        curAviary.recordFoodPeference(bird);
                        recordBirdLoc(bird, i);
                        return;
                    }else{
                        continue;
                    }
                } else if (bird.getType().equals(BIRDS_OF_PREY)){
                    if (curAviary.getType().equals(BIRDS_OF_PREY)){
                        curAviary.put(bird);
                        curAviary.recordFoodPeference(bird);
                        recordBirdLoc(bird, i);
                        return;
                    }else{
                        continue;
                    }
                }else if (bird.getType().equals(WATERFOWL)){
                    if (curAviary.getType().equals(WATERFOWL)){
                        curAviary.put(bird);
                        curAviary.recordFoodPeference(bird);
                        recordBirdLoc(bird, i);
                        return;
                    }else{
                        continue;
                    }
                }
                // Normal bird prevent to be put into three special aviaries
                else {
                    if (!curAviary.getType().equals(FLIGHTLESS) 
                    &&  !curAviary.getType().equals(BIRDS_OF_PREY) 
                    &&  !curAviary.getType().equals(WATERFOWL) ){
                        curAviary.put(bird);
                        curAviary.recordFoodPeference(bird);
                        recordBirdLoc(bird, i);
                        return;
                    }
                }
            }
        }
        // If all aviaries are full, we come to this line, print error msg
        System.out.println("ERROR: All aviaries is full");
    }

    /** 
     * Show up the birds in aviary by aviary number 
     * @param aviaryNum location of aviary
     **/
    public String displayAviary(int aviaryNum){
        if (aviaryNum < 0 || aviaryNum >= MAX_AVIARY){
            throw new IllegalArgumentException("The aviary number is illegal");
        }

        // display the birds in aviary by the aviary Number
        String output = aviary[aviaryNum].displayBirds();
        return output;
    }
    /**
     * Show up the specific aviary detail by the location which is aviary number
     * @param aviaryNum hosue number
     * @return a String that shows the detail
     */
    public String displayAviaryInDetail(int aviaryNum){
      //  aviary[aviaryNum].displayDetail();
        return aviary[aviaryNum].displayDetail();
    }

    /**
     * Display a “map” that lists all the aviaries by location and the birds they house
     * @return a String that lists all the aviaries by location and the birds they house
     */
    public String displayAllAviaries(){
        String output = "";
        for (int i=0; i < MAX_AVIARY; i++){
            output += aviary[i].displayBirds();
         //   aviary[i].displayBirds();
        }
        return output;
    }
    /**
     * Display all birds in conservatory in alphabetical order and their location
     * @return a String that displays all birds in conservatory in alphabetical order and their location
     */
    public String displayByAlphOrder(){
        String output = "";
        Collections.sort(birdsRecod);
        for (String bird: birdsRecod){
            output += bird.toString()+"";
            System.out.println(bird);
        }

        return output;
    }

    /**
     *  Initialize aviaries and assign house humber to each 
     */
    private void initAviary(){
        for (int i=0; i<MAX_AVIARY; i++){
            aviary[i] = new Aviary();
            aviary[i].setHouseNum(i);
        }
    }
    /**
     * Record the bird's location and name
     * @param bird     Bird object
     * @param location the aviary number of the bird
     * @return a String bird location
     */
    private String recordBirdLoc(Bird bird, int location){
        birdsRecod.add(bird + " at aviary " + location);
        String output = bird + " at aviary " + location;
        return output;
    }

    /**
     * Getter for aviary 
     * @return Aviary[]
     */
    public Aviary[] getAviary(){
        return aviary;
    }
    
    /**
     * Getter for birdsRecord
     * @return birdsRecod
     */
    public ArrayList<String> getbirdsRecord(){
        return birdsRecod;
    }
}
