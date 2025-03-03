package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;
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

        // make a view
        view = new GameView(world, 500, 500);
        view.setZoom(17);

        StudentController controller = new StudentController(world.getStudent());
        view.addKeyListener(controller);

        view.addMouseListener(new GiveFocus(view));

       // world.addStepListener(new Tracker(view, world.getStudent()));


        // add the view to a frame (Java top level window)
        final JFrame frame = new JFrame("Degree Quest");
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
