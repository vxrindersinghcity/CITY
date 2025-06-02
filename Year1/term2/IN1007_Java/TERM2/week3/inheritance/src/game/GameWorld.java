package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {

    public GameWorld(){

        //make the ground
        Shape shape = new BoxShape(11, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        // make two platforms
        Shape platformShape = new BoxShape(3.5f, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-8, 5.5f));
        platform1.setAngleDegrees(-45);

        StaticBody platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(8, 5.5f));

        //make a ball, placed on the first platform
        Shape ballShape = new CircleShape(1.5f);
        DynamicBody ball = new DynamicBody(this, ballShape);
        ball.setPosition(new Vec2(-8, 7f));

        //make the walls
        Shape wallShape = new BoxShape(0.5f,8);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-11.5f,-4));

        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(11.5f,-4));

        Student student = new Student(this);
        student.setPosition(new Vec2(7,-6));
    }
}
