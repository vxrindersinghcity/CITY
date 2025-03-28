package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StudentController implements KeyListener {

    private static final float WALKING_SPEED = 4;

    private Student student;

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
        if (code == KeyEvent.VK_1) {
            student.startWalking(-WALKING_SPEED);
        } else if (code == KeyEvent.VK_2) {
            student.startWalking(WALKING_SPEED);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_1) {
            student.stopWalking();
        } else if (code == KeyEvent.VK_2) {
            student.stopWalking();
        }
    }
}
