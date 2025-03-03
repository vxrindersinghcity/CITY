package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class GCL implements CollisionListener {
    private int counter = 0;

    @Override
    public void collide(CollisionEvent collisionEvent) {
        counter++;
        System.out.print("Collision " + counter + ":\n" +
                "  rep. body:" + collisionEvent.getReportingBody() + "\n" +
                "  oth. body:" + collisionEvent.getOtherBody() + "\n");
    }
}
