package abstracts;

import java.awt.*;

public class Bicycle extends Vehicle{

    private int drawCount = 0;
    private boolean bentLeg = false;

    public Bicycle(int startPosition, int startSpeed) {
        super(startPosition, startSpeed);
    }

    @Override
    public void travel() {
        position += speed;
    }

    @Override
    public void draw(Graphics g) {
        drawCount++;
        if (drawCount % 3 == 0)
            bentLeg = !bentLeg;

        g.setColor(Color.black);
        //draw wheels
        g.drawOval(-4,-4, 4, 4);
        g.drawOval(4,-4, 4, 4);

        //draw head
        g.drawOval(0,-10, 3, 3);

        //draw body
        g.drawLine(1, -8, 1, -5);

        if (bentLeg) {
            //draw bent leg
            g.drawLine(1, -5, 4, -5);
            g.drawLine(4, -5, 1, -1);
        }else {
            //draw straight leg
            g.drawLine(1, -5, 1, -1);
        }
    }

    @Override
    public void printDebugInformation() {
        System.out.println("Bicycle Pos: " + position);
        System.out.println("Bicycle Speed: " + speed);
    }
}
