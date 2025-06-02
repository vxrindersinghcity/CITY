package game;

import Entity.PLAYER.Player;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class Tracker implements StepListener {
    private GameView view;
    private Player player;
    private float trackingHeight; // The height above which tracking should start

    public Tracker(GameView view, Player player) {
        this.view = view;
        this.player = player;
    }

    @Override
    public void postStep(StepEvent e) {
         view.setCentre(new Vec2(player.getPosition().x, player.getPosition().y+5));
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        // No changes needed here
    }
}
