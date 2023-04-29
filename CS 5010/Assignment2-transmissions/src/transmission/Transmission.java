package transmission;
/**
 * 
 *  This is an interface for AutomaticTransmission
 *  @author Kaichun Lee
 * 
 */
public interface Transmission {
    /**
     * Increases current speed by 2
     * @return a Transmission Object
     */
    Transmission increaseSpeed();

    /**
     * Decreases current speed by 2
     * @return a Transmission Object
     */
    Transmission decreaseSpeed();

    /**
     * Gets current speed
     * @return current speed
     */
    int          getSpeed();

    /**
     * Gets current gear
     * @return current gear
     */
    int          getGear();
}
