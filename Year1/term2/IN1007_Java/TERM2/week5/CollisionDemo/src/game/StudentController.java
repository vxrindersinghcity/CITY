package game;

import city.cs.engine.Body;
import city.cs.engine.BodyImage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class StudentController implements KeyListener {

    private static final float WALKING_SPEED = 3;

    private Student student;

    private HashMap<Body, BodyImage> hiddenImages = null;

    public StudentController(Student s){
        student = s;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_LEFT) {
            student.startWalking(-WALKING_SPEED);
        } else if (code == KeyEvent.VK_RIGHT) {
            student.startWalking(WALKING_SPEED*2);
        }
        else if (code == KeyEvent.VK_UP){
            student.jump(12);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            student.stopWalking();
        } else if (code == KeyEvent.VK_RIGHT) {
            student.stopWalking();
        }
    }
}
