package abstracts;

import java.awt.*;

public class Car extends Vehicle{

    private int fuel;

    public Car(int startPosition, int startSpeed) {
        super(startPosition, startSpeed);
    }

    public void addFuel(int f){
        fuel = f;
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

    @Override
    public void printDebugInformation() {
        System.out.println("Car Pos: " + position);
        System.out.println("Car Speed: " + speed);
        System.out.println("Car Fuel: " + fuel);
    }
}
