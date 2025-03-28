package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class ProfessorEncounter implements CollisionListener {



    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Professor){
            e.getOtherBody().destroy();
        }
    }
}
