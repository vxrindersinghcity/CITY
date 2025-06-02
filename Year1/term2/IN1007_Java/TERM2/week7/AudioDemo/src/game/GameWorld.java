package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {

    private Student student;

    public GameWorld(){

        // make the ground
        Shape shape = new BoxShape(11, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        // make a platform
        Shape platform1Shape = new BoxShape(4, 0.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-9, 6.5f));

        // add another platform here
        StaticBody platform2 = new StaticBody(this, platform1Shape);
        platform2.setPosition(new Vec2(5, 2.5f));

        // add another platform here
        Shape wallShape = new BoxShape(0.5f, 6f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-11.5f, -6));

        // add another platform here
        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(11.5f, -6));

       student = new Student(this);
       student.setPosition(new Vec2(8, -10));
       BooksPickup pickup = new BooksPickup(student);
       student.addCollisionListener(pickup);

       // add more bodies here
       Professor professor = new Professor(this);
       professor.setPosition(new Vec2(0,-10));
       student.addCollisionListener(new ProfessorEncounter());
    }

    public Student getStudent(){
        return student;
    }
}
