package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class bookpickup implements CollisionListener {
    private Student student;
    public bookpickup(Student s){
        this.student = s;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Books) {
            student.setBooks(student.getBooks()+1);
            e.getOtherBody().destroy();
        }
    }
}
