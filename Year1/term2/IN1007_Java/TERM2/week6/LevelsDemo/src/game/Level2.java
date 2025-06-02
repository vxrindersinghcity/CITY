package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

public class Level2 extends GameLevel{

    public Level2(Game game){
        super(game);

        // make a platform
        Shape shape = new BoxShape(3, 0.5f);
        StaticBody platform = new StaticBody(this, shape);
        platform.setPosition(new Vec2(-5f, 4));

        // make another platform
        StaticBody platform2 = new StaticBody(this, shape);
        platform2.setPosition(new Vec2(-5f, 6));

        for (int i=0; i<6; i++){
            Books b = new Books(this);
            b.setPosition(new Vec2(-7 + i*3, 10));
        }


    }

    @Override
    public boolean isComplete() {
        return getStudent().getBookCount() > 3;
    }
}
