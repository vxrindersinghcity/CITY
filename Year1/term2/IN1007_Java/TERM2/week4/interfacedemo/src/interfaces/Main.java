package interfaces;

//import interfaces.Bicycle;
import interfaces.Car;
import interfaces.VehicleSimulator;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // add the view to a frame (Java top level window)
        final JFrame frame = new JFrame("Interface demo");

        VehicleSimulator road = new VehicleSimulator();

        //create and set up a car
        Car car = new Car();
        car.setStartingPosition(10);
        car.addFuel(100);
        car.setSpeed(3);
        //add the car to the road
        road.addVehicle(car);

       /* Bicycle bike = new Bicycle();
        bike.setStartingPosition(150);
        bike.setSpeed(1);
        road.addVehicle(bike); */

        Vehicle vehicle = new Vehicle();
        vehicle.setStartingPosition(20);
        vehicle.setSpeed(5);
        road.addVehicle(vehicle);

        frame.add(road);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}