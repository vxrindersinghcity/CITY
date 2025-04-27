package game;

import Entity.PLAYER.PlayerController;
import Entity.PLAYER.PlayerMouseAttack;
import Menus.GameWonmenu;
import Menus.GameoverMenu;
import Menus.MainMenu;
import city.cs.engine.DebugViewer;
import city.cs.engine.SoundClip;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import game.levels.GameLevel;
import game.levels.Level1;
import game.levels.Level2;
import game.levels.Level3;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Your main game entry point
 */
public class Game implements StepListener {

    private GameLevel Currentlevel;
    private GameView view;
    private PlayerController playerController;
    private PlayerMouseAttack mouseAttack;
    final JFrame frame;
    public static SoundClip menuMusic;

    enum GameState {
        LEVEL1, LEVEL2, LEVEL3, GAME_OVER;
    }
    private GameState gameState;

    /** Initialise a new Game. */
    public Game() {
        //1. make an empty game world
        Currentlevel = new Level1(this);
        gameState = GameState.LEVEL1;

        //3. make a view to look into the game world
        view = new GameView(Currentlevel,this, 800, 600);
        //optional: draw a 1-metre grid over the view
        //view.setGridResolution(1);

        frame = new JFrame("City Game");
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
        frame.setLocationRelativeTo(null);

        playerController = new PlayerController(Currentlevel.getPlayer(), this, Currentlevel);
        playerController.createEnemySensor();
        playerController.createEdgeSensor();
        view.addKeyListener(playerController);
        view.setFocusable(true); // Ensure the view can receive key events
        Currentlevel.addStepListener(playerController);
        view.addMouseListener(new GiveFocus());

        // Create the PlayerMouseAttack with a direct reference to the playerController
        mouseAttack = new PlayerMouseAttack(Currentlevel,playerController);
        view.addMouseListener(mouseAttack);

        Tracker tracker = new Tracker(view, Currentlevel.getPlayer());
        Currentlevel.addStepListener(tracker);

        // Add this class as a step listener to update the PlayerMouseAttack
        Currentlevel.addStepListener(this);

        // start our game world simulation!
        Currentlevel.start();

        //optional: uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(Currentlevel, 800, 600);
    }

    public static void main(String[] args) {
        new MainMenu();

        // Initialize and play background music
        try {
            menuMusic = new SoundClip("data/music/menu/bgsound.wav"); // Use a separate music file for the main menu
            menuMusic.loop(); // Play in a loop
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Error loading menu music: " + e);
        }
    }

    private boolean gameOverShown = false;

    public void showGameOverMenu() {
        if (!gameOverShown) {
            gameOverShown = true;
            // Code to display the Game Over menu
            frame.dispose();
            new GameoverMenu();
        }
        gameOverShown = false;
    }

    private boolean gamewonShown = false;

    public void showGamewonMenu() {
        if (!gamewonShown) {
            gamewonShown = true;
            // Code to display the Game Over menu
            frame.dispose();
            new GameWonmenu();
        }
    }

    public void goToNextLevel() {
        Currentlevel.stop();
        switch (gameState) {
            case LEVEL1:
                gameState = GameState.LEVEL2;
                Currentlevel = new Level2(this);
                break;
            case LEVEL2:
                gameState = GameState.LEVEL3;
                Currentlevel = new Level3(this);
                break;
            case LEVEL3:
                gameState = GameState.GAME_OVER;
                Currentlevel.stop();
                frame.dispose();
                showGamewonMenu();
                return;
        }
        levelSetup();
    }

    public void levelSetup() {
        // Update the view and controllers for the new level
        view.setWorld(Currentlevel); // Update the world in the view
        view.setLevel(Currentlevel);
        playerController.setPlayer(Currentlevel.getPlayer()); // Update the player in the controller
        playerController.createEdgeSensor();
        playerController.createEnemySensor();
        playerController.setlevel(Currentlevel);

        Currentlevel.addStepListener(playerController); // Add the controller as a step listener

        // Update the mouse attack with the new level
        mouseAttack = new PlayerMouseAttack(Currentlevel,playerController);
        // Remove old mouse listener and add the new one
        for(java.awt.event.MouseListener ml : view.getMouseListeners()) {
            if(ml instanceof PlayerMouseAttack) {
                view.removeMouseListener(ml);
            }
        }
        view.addMouseListener(mouseAttack);

        // Add any other step listeners or sensors specific to the new level
        Tracker tracker = new Tracker(view, Currentlevel.getPlayer());
        Currentlevel.addStepListener(tracker);

        // Add this class as a step listener to update the PlayerMouseAttack
        Currentlevel.addStepListener(this);


        // Start the new level
        Currentlevel.start();
    }

    public void checkPlayerHealth() {
        if (Currentlevel.getPlayer().getHealth() <= 0) {
            showGameOverMenu();
        }
    }

    @Override
    public void preStep(StepEvent e) {
        checkPlayerHealth();


    }

    @Override
    public void postStep(StepEvent e) {
        // Update the PlayerMouseAttack if needed
    }
}