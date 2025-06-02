package abstracts;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // add the view to a frame (Java top level window)
        final JFrame frame = new JFrame("Interface demo");

        VehicleSimulator road = new VehicleSimulator();

        Car car = new Car(10,3);
        car.addFuel(100);
        road.addVehicle(car);

        Bicycle bike = new Bicycle(150,1);
        road.addVehicle(bike);

        Vehicle vehicle = new Vehicle(40,2);
        road.addVehicle(vehicle);


        frame.add(road);

// enable the frame to quit the application
// when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
// don't let the frame be resized
        frame.setResizable(false);
// size the frame to fit the world view
        frame.pack();
// finally, make the frame visible
        frame.setVisible(true);
    }
}
