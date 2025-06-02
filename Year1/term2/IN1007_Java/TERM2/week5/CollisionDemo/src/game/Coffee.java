package game;

import city.cs.engine.*;
import city.cs.engine.Shape;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

public class Coffee extends StaticBody {

    private static final Shape coffeeShape = new BoxShape(0.5f,1f);

    private static final BodyImage image =
            new BodyImage("data/coffee.png", 2f);

    public Coffee(World world) {
        super(world, coffeeShape);
        addImage(image);
    }

}
