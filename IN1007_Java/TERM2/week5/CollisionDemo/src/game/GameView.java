package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

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
