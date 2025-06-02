package game;

import city.cs.engine.SoundClip;

import javax.swing.JFrame;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * A world with some bodies.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private GameWorld world;

    /** A graphical display of the world (a specialised JPanel). */
    private GameView view;

    private SoundClip gameMusic;

    /** Initialise a new Game. */
    public Game() {

        // make the world
        GameWorld world = new GameWorld();

        try {
            gameMusic = new SoundClip("data/gametheme.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }

        // make a view
        view = new GameView(world, 500, 500);
        view.setZoom(20);

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // add some mouse actions
        // add this to the view, so coordinates are relative to the view
        view.addMouseListener(new MouseHandler(world, view));

        StudentController controller = new StudentController(world.getStudent());
        view.addKeyListener(controller);

        view.addMouseListener(new GiveFocus(view));

        //world.addStepListener(new Tracker(view, world.getStudent()));

        // add the view to a frame (Java top level window)
        final JFrame frame = new JFrame("Basic world");
        frame.add(view);
        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);

        // start our game world simulation!
        world.start();
    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
