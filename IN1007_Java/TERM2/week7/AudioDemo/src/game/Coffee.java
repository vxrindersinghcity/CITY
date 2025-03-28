package game;

import city.cs.engine.*;

public class Coffee extends Walker {

    private static final Shape shape = new PolygonShape(-0.429f,0.738f, 0.396f,0.732f, 0.282f,-0.687f, -0.27f,-0.681f);

    private static final BodyImage image =
            new BodyImage("data/coffee.png", 1.5f);


    public Coffee(World world){
        super(world, shape);
        this.addImage(image);
    }
}
