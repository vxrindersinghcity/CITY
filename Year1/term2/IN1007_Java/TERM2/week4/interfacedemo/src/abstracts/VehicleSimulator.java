package abstracts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VehicleSimulator extends JPanel implements ActionListener  {

    private ArrayList<Vehicle> vehicles;

    public void addVehicle(Vehicle v){
        vehicles.add(v);

    }


    public VehicleSimulator(){
        this.setPreferredSize(new Dimension(800, 400));
        vehicles = new ArrayList<>();

        Timer timer = new Timer(50, this);

        timer.start();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        for (Vehicle v : vehicles) {
            v.travel();
            v.printDebugInformation();
        }
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue);

        //draw road
        g.drawLine(0,100,this.getWidth(), 100);

        //draw vehicles
        for (Vehicle v : vehicles) {
            g.translate(v.getPosition(), 100);
            v.draw(g);
            g.translate(-v.getPosition(), -100);
        }
    }
}
