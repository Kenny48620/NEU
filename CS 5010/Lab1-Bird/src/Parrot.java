import java.util.HashSet;
import java.util.Set;
/**
 * Parrot is a subclass of Bird class
 */
public class Parrot extends Bird{

    private Set<String>  wordsSet;  // a set that stores words
    private String       favWord;   // favorite word

    /** 
     * Constructor 
     * @param name name of Parrot
     * @param extinctStatus if is extinct
     **/
    public Parrot(String name, boolean extinctStatus){
        super(name, extinctStatus);
        this.type = "Parrot";
        wordsSet  = new HashSet<>();
        favWord   = "";

        // add the characteristic
        this.addCharacteristic("have a short, curved beak and are known for their intelligence and ability to mimic sounds");
        this.addCharacteristic("can learn a vocabulary of up to 100 words and often adopt a single favorite saying");
        // add food preference
        this.addFoodToList("berries");
        this.addFoodToList("seeds");
        this.addFoodToList("vegetation");
        this.addFoodToList("nuts");
    }

    
    /**
     * Add a word to wordsSet
     * @param word a word
     */
    public void addWord(String word){
        wordsSet.add(word);
    }
    /**
     * Getter for wordsSet
     * @return a set with words
     */
    public Set<String> getWords(){
        return wordsSet;
    }


    /**
     * Setter for favWord
     * @param word
     */
    public void setFavWord(String word){
        // if the word is not in set
        if (!wordsSet.contains(word)){
            throw new IllegalArgumentException("There is no this word in set");
        }

        favWord = word;
    }
    /**
     * Getter for favWord
     * @return favorite word for Parrot
     */
    public String getFavoriteWord(){
        return favWord;
    }

}
