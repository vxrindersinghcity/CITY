package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class ProfessorEncounter implements CollisionListener {

    GameLevel level;
    Game g;
    public ProfessorEncounter(GameLevel level, Game game){
        this.level = level;
        g = game;
    }

    @Override
    public void collide(CollisionEvent e) {

        if (e.getOtherBody() instanceof Professor){
            System.out.println("Student collided with prof");
          //  Student s = (Student)e.getReportingBody();
          //  s.setCredits(s.getCredits()+15);
            if (level.isComplete()){
                g.goToNextLevel();
            }
        }
    }
}
