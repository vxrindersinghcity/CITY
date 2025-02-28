package interfaces;

import java.awt.*;

/*public class Bicycle implements Vehicle{

    private int position;
    private int speed;

    private int drawCount = 0;
    private boolean bentLeg = false;

    @Override
    public void setStartingPosition(int startingPosition) {
        position = startingPosition;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void travel() {
        position += speed;
    }

    @Override
    public void draw(Graphics g) {

        //every three draws the cyclist
        //pedals once (bentLeg -> straightLeg -> bentLeg...)
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

}*/
