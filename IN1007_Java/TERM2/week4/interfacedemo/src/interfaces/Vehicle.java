package interfaces;

import java.awt.*;

public interface Vehicle{

    /** sets the starting position; normally this should
     * only be called once, possibly in a interfaces.Vehicle's constructor */
    public void setStartingPosition(int startingPosition);

    /** returns the interfaces.Vehicle's current position */
    public int getPosition();

    /** updates the interfaces.Vehicle's speed */
    public void setSpeed(int speed);

    /** moves vehicle to a new position (depending on the vehicle's speed) */
    public void travel();

    public void draw(Graphics g);

}
