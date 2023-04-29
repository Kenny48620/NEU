package transmission;
/**
 *  This class will implement an interface Transmission and automatically determines the current gear by the current 
 *  speed of the car.
 *  @author Kaichun Lee
 */
public class AutomaticTransmission implements Transmission{

    
    private int speed;  // record current speed
    private int gear;   // record current gear

    // to record the upper bound of gears level
    private int gear1UpperBound;
    private int gear2UpperBound;
    private int gear3UpperBound;
    private int gear4UpperBound;
    private int gear5UpperBound;

    /**
     * Constructor of AutomaticTransmission
     * @param g1 the upper bound for gear 1
     * @param g2 the upper bound for gear 2
     * @param g3 the upper bound for gear 3
     * @param g4 the upper bound for gear 4
     * @param g5 the upper bound for gear 5
     * @throws IllegalArgumentException if the parameter is not legal
     */    
    public AutomaticTransmission(int g1, int g2, int g3, int g4, int g5){
        if (g1 <= 0 || g1 >= g2 || g2 >= g3 || g3 >= g4 || g4 >= g5 ){
            throw new IllegalArgumentException("Parameter values must be legal");
        } 

        this.gear1UpperBound = g1;
        this.gear2UpperBound = g2;
        this.gear3UpperBound = g3;
        this.gear4UpperBound = g4;
        this.gear5UpperBound = g5;

        this.speed           = 0; // initialize speed to 0
        this.gear            = 0; // initialize gear  to 1
    }

    /**
     * This method is to increase current speed by 2
     * @return an Transmission Object
     */
    @Override
    public Transmission increaseSpeed() {

        speed += 2;
        if      (speed < gear1UpperBound) gear = 1;
        else if (speed < gear2UpperBound) gear = 2;
        else if (speed < gear3UpperBound) gear = 3;
        else if (speed < gear4UpperBound) gear = 4;
        else if (speed < gear5UpperBound) gear = 5;
        else                              gear = 6;

        return this;
    }
    /**
     * This method is to decrease current speed by 2
     * @return an Transmission Object
     * @throws IllegalStateException is the current speed is not able to be decreased
     */
    @Override
    public Transmission decreaseSpeed() {
        // speed = 1 or 2 or < 0 is illegal to call this method
        if (speed < 2){
            throw new IllegalStateException("The speed will be less than zero");
        }

        speed -= 2;
        if      (speed < gear1UpperBound) gear = 1;
        else if (speed < gear2UpperBound) gear = 2;
        else if (speed < gear3UpperBound) gear = 3;
        else if (speed < gear4UpperBound) gear = 4;
        else if (speed < gear5UpperBound) gear = 5;
        else                              gear = 6;

        return this;
    }
    /**
     * This method is to get the current speed
     * @return current speed
     */
    @Override
    public int getSpeed() {
        return speed;
    }
    /**
     * This method is to get the current gear
     * @return current gear
     */
    @Override
    public int getGear() {
        return gear;
    }
    /**
     * This methos is to print the current speed and gear 
     * @return a format string to show the current speed and gear
     */
    @Override
    public String toString(){
        return String.format("Transmission (speed = %d, gear = %d)", this.speed, this.gear);
    }
}
