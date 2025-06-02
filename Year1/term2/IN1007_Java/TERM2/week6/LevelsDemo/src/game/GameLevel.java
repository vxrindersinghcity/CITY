package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public abstract class GameLevel extends World{

    private Student student;
    private Professor professor;

    private Game game;

    public GameLevel(Game game){

        this.game = game;

        // make the ground
        Shape groundShape = new BoxShape(11, 0.5f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0f, -11.5f));

        // make some walls
        Shape wallShape = new BoxShape(0.5f, 6f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-11.5f, -6));

        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(11.5f, -6));


        student = new Student(this);
        student.setPosition(new Vec2(-8,-5));
        student.addCollisionListener(new BooksPickup(student));

        professor = new Professor(this);
        professor.setPosition(new Vec2(8, -5));

        student.addCollisionListener(new ProfessorEncounter(this, game));

    }


    public Student getStudent(){
        return student;
    }
    public  Professor getProfessor(){
        return professor;
    }

    public abstract boolean isComplete();

}
