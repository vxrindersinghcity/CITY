package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Lift extends StaticBody implements StepListener {

    private static final Shape liftShape = new BoxShape(2, 0.2f);
    private Vec2 startPosition;
    private float top, bottom;
    private float delta;

    /*
    This implementation works for static bodies that don't have a startWalking method. The body
    is moved using multiple calls to setPosition();
     */

    public Lift(World w) {
        super(w, liftShape);
        startPosition = this.getPosition();
        bottom = startPosition.y;
        top = startPosition.y+10;
        delta=0.08f;
        w.addStepListener(this);
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().y < bottom){
            this.setPosition(startPosition);
            delta*=-1;
        }
        if (getPosition().y > top){
            delta*=-1;
        }
        this.setPosition(new Vec2(this.getPosition().x, this.getPosition().y+delta));
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
