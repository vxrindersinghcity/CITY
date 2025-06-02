package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {


    private static final Image background = new ImageIcon("data/university.gif").getImage();

    public GameView(GameLevel w, int width, int height) {
        super(w, width, height);
    }


    @Override
    protected void paintBackground(Graphics2D g) {

        g.drawImage(background, 0, 130, this);
    }




}
