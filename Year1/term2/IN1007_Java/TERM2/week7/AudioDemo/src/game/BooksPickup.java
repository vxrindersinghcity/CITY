package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

public class BooksPickup implements CollisionListener {

    private Student student;
    public BooksPickup(Student s){
        this.student = s;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Books) {

            student.addBooks();
            e.getOtherBody().destroy();


        }
    }
}