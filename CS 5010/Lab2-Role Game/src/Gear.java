import java.util.List;
/**
 * This class is a interface that be used to determine what behaviors gear have
 */
public interface Gear {
    /**
     * Getter of adjective part of a gear
     * @return an array list of adjectives
     */
    List<String> getAdjective();
    /**
     * Getter of gear name
     * @return a String gear name 
     */
    String getName();
    /**
     * Getter of gear attack
     * @return int that represents attack strength
     */
    int getAttack();
    /**
     * Getter of gear defense
     * @return int that represents defense strength
     */
    int getDefense();
    /**
     * Combime this gear with another 
     * @param another a gear that we're going to combime with
     * @return a new gear 
     */
    Gear combineWith(Gear another);
}
