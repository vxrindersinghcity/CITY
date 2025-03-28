package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Books extends DynamicBody {

    private static final Shape booksShape = new CircleShape(1);

    private static SoundClip booksSound;
    static {
        try {
            booksSound = new SoundClip("data/booksound.wav");
            System.out.println("Loading books sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private static final BodyImage image =
            new BodyImage("data/books.png", 2f);

    public Books(World w) {
        super(w,booksShape);
        addImage(image);



    }

    @Override
    public void destroy()
    {
        booksSound.play();
        super.destroy();
    }
}
