package interfaces;

import interfaces.Vehicle;

import java.awt.*;

public class Car implements Vehicle {

    private int position;
    private int speed;

    private int fuel;

    public void addFuel(int f){
        fuel = f;
    }

    @Override
    public void setStartingPosition(int startingPosition) {
        position = startingPosition;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void travel() {
        if (fuel > 0) {
            position += speed;
            fuel = fuel -1;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.black);
        //draw wheels
        g.drawOval(-4,-4, 4, 4);
        g.drawOval(1,-4, 4, 4);
        g.drawRect(-5,-10, 10, 5);
        g.drawRect(-1,-12, 4, 2);

    }
}
