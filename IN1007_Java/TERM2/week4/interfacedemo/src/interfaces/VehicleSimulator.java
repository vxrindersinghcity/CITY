package interfaces;

import interfaces.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VehicleSimulator extends JPanel implements ActionListener  {

    private ArrayList<Vehicle> vehicles;

    /**
     * We can add vehicles to the VehicleSimulator;
     * these are all added in the vehicles ArrayList
     */
    public void addVehicle(Vehicle v){
        vehicles.add(v);
    }

    /**
     * Simulates the travel of each vehicle in the simulator
     */
    private void simulateVehicles(){
        for (Vehicle v : vehicles) {
            v.travel();
            //v.printDebugInformation();
        }
    }

    /**
     * Draws each vehicle in the simulator
     */
    private void drawVehicles(Graphics g){

        //draw road
        g.setColor(Color.darkGray);
        g.drawLine(0,100,this.getWidth(), 100);

        //draw vehicles
        for (Vehicle v : vehicles) {
            g.translate(v.getPosition(), 100);
            v.draw(g);
            g.translate(-v.getPosition(), -100);
        }
    }


    public VehicleSimulator(){
        this.setPreferredSize(new Dimension(800, 400));
        vehicles = new ArrayList<>();

        Timer timer = new Timer(50, this);

        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       simulateVehicles();
       this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawVehicles(g);
    }
}
