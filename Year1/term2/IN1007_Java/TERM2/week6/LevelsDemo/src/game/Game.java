package game;

import javax.swing.JFrame;

/**
 * A world with some bodies.
 */
public class Game {

    GameLevel currentLevel;
    GameView view;

    StudentController controller;

    /** Initialise a new Game. */
    public Game() {

        currentLevel = new Level1(this);

        // make a view
        view = new GameView(currentLevel,500, 500);

        controller = new StudentController(currentLevel.getStudent());
        view.addKeyListener(controller);

        view.addMouseListener(new GiveFocus(view));

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

        // start our game world simulation!
        currentLevel.start();
    }

    public void goToNextLevel(){

        System.out.println("Yes, lets go to next level");

       if (currentLevel instanceof Level1) {

           currentLevel.stop();

            Student prevStudent = currentLevel.getStudent();

            currentLevel = new Level2(this);

            Student newStudent = currentLevel.getStudent();

            view.setWorld(currentLevel);

            controller.updateStudent(currentLevel.getStudent());

            currentLevel.start();
        }
        else if (currentLevel instanceof  Level2){
            System.out.println("Game done");
            System.exit(0);
        }


    }



    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
