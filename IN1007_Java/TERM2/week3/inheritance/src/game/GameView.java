package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {
    private Image bg;
    public GameView(World w, int width, int height) {
        super(w, width, height);
        bg=new ImageIcon("data/university.gif").getImage();
    }
   @Override
    public void paint(Graphics g) {
        g.drawImage(bg,0,0,getWidth(),getHeight(),this);
    }
}
