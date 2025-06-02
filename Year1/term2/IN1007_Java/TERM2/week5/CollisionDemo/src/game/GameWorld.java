package game;

import city.cs.engine.*;
import org.jbox2d.collision.Collision;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {

    private Student student;

    public GameWorld(){

      // make the ground
        Shape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));
        ground.addImage(new BodyImage("./data/ground.png", 1f));

        // make a platform
        Shape platform1Shape = new BoxShape(3, 0.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-8, -4f));
        platform1.addImage(new BodyImage("./data/platform.png", 1f));

        // add another platform here
        StaticBody platform2 = new StaticBody(this, platform1Shape);
        platform2.setPosition(new Vec2(4, -5f));
        platform2.addImage(new BodyImage("./data/platform.png", 1f));

        StaticBody platform3 = new StaticBody(this, platform1Shape);
        platform3.setPosition(new Vec2(1, 4f));
        platform3.addImage(new BodyImage("./data/platform.png", 1f));


        StaticBody platform4 = new StaticBody(this, platform1Shape);
        platform4.setPosition(new Vec2(12, 1f));
        platform4.addImage(new BodyImage("./data/platform.png", 1f));


       student = new Student(this);
       student.setPosition(new Vec2(8, -10));

       // add more bodies here
       Professor professor = new Professor(this);
       professor.setPosition(new Vec2(-5,-10));

       new Coffee(this).setPosition(new Vec2(-11,-8));
       new Coffee(this).setPosition(new Vec2(5,-3.5f));

       new Books(this).setPosition(new Vec2(-9.5f,3));
       new Books(this).setPosition(new Vec2(12,2));

        GCL gcl = new GCL();
        ground.addCollisionListener(gcl);
        bookpickup pickup = new bookpickup(student);
        student.addCollisionListener(pickup);

    }

    public Student getStudent(){
        return student;
    }
}
