package game.levels;

import Entity.PLAYER.Player;
import Entity.PLAYER.playerCollisions;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.World;
import game.Game;
import org.jbox2d.common.Vec2;

public abstract class GameLevel extends World implements StepListener {
    private Player player;
    private String levelName;
    private Game game;
    int enemiesDefeated;

    public GameLevel(Game game) {
        player = new Player(this, new Vec2(0, -10));
        this.addStepListener(this);
        playerCollisions pcoll = new playerCollisions(player);
        player.addCollisionListener(pcoll);
        this.game = game;
    }
    public void incrementEnemiesDefeated() {
        enemiesDefeated++;
    }
    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Player getPlayer() {
        return player;
    }

    public abstract boolean isComplete();

    public abstract void preStep(StepEvent stepEvent);

    public abstract void postStep(StepEvent stepEvent);

    public Game getGame() {
        return game;
    }
    public int getBoundleft() {
        return 0;
    }
    public int getBoundRight() {
        return -20;
    }
}