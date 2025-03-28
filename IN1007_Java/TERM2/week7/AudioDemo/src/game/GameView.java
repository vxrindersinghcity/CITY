package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {
    private Image background;
    public GameView(World w, int width, int height) {
        super(w, width, height);
        background = new ImageIcon("data/university.gif").getImage();
    }

    @Override
    protected void paintBackground(Graphics2D g) {

        g.drawImage(background, 0, 130, this);
    }




}
