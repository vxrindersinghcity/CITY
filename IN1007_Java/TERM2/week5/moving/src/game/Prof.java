package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Prof extends Walker implements StepListener{

    private static final BodyImage profImage = new BodyImage("data/prof.png", 4.5f);
    private static final Shape profShape = new BoxShape(1,2);
    private final int SPEED = 4;

    /*
    This implementation of moving is useful for multiple enemies with independent movement as
    each instance you create moves relative to its starting position. The range value can be
    increased to increase the amount of movement.
     */
    
    private float left, right;
    private final int RANGE = 3;

    public Prof(World world) {
        super(world, profShape);
        addImage(profImage);
        world.addStepListener(this);
        startWalking(SPEED);
    }

    @Override
    public void setPosition(Vec2 position) {
        super.setPosition(position);
        left = position.x-RANGE;
        right = position.x+RANGE;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().x > right){
            startWalking(-SPEED);
        }
        if (getPosition().x < left){
            startWalking(SPEED);
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
