package Entity.ENEMY;

import city.cs.engine.*;
import game.levels.GameLevel;
import org.jbox2d.common.Vec2;

public class OpossumEnemy extends EnemyBlueprint {

    private static final float WIDTH = 0.7f;
    private static final float HEIGHT = 0.5f;
    private static final BodyImage ENEMY_IMAGE_LEFT = new BodyImage("data/Enemies/Oposum/oposumLeft.gif",2);
    private static final BodyImage ENEMY_IMAGE_RIGHT = new BodyImage("data/Enemies/Oposum/oposumRight.gif",2);
    private static final int SPEED = 3;
    private GameLevel level;

    private int health;

    public OpossumEnemy(GameLevel level, Vec2 position) {
        super(level, "Opossum", 3, position, WIDTH, HEIGHT, 100, ENEMY_IMAGE_LEFT, ENEMY_IMAGE_RIGHT);
        this.level = level;
        this.health = 100;

        Shape enemyShape = new BoxShape(WIDTH, HEIGHT);
        new SolidFixture(this, enemyShape);

    }
    @Override
    public void windeffect () {
        health -= 50;
        if (health <= 0) {
            destroy();
            level.incrementEnemiesDefeated();

        }
    }
}
