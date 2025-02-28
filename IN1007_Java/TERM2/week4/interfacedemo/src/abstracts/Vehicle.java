package abstracts;

import java.awt.*;

public abstract class Vehicle {

    protected int position;
    protected int speed;

    public Vehicle(int startPosition, int startSpeed){
        position = startPosition;
        speed = startSpeed;
    }

    public int getPosition() {
        return position;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public abstract void travel();


    public abstract void draw(Graphics g);

    public abstract void printDebugInformation();
}
