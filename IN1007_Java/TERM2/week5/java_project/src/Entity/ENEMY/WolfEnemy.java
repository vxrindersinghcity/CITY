package Entity.ENEMY;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import game.levels.GameLevel;
import org.jbox2d.common.Vec2;

public class WolfEnemy extends EnemyBlueprint{
    private static final float WIDTH = 1f;
    private static final float HEIGHT = 0.8f;
    private static final BodyImage ENEMY_IMAGE_LEFT = new BodyImage("data/Enemies/Wolf/WolfLeft.gif",3.5f);
    private static final BodyImage ENEMY_IMAGE_RIGHT = new BodyImage("data/Enemies/Wolf/WolfRight.gif",3.5f);

    private int health;
    private GameLevel level;

    public WolfEnemy(GameLevel level, Vec2 position) {
        super(level, "Wolf", 5, position, WIDTH, HEIGHT, 100, ENEMY_IMAGE_LEFT, ENEMY_IMAGE_RIGHT);

        this.health = 100;
        this.level = level;
        Shape enemyShape = new BoxShape(WIDTH, HEIGHT);
        new SolidFixture(this, enemyShape);

    }
    @Override
    public void windeffect () {
        health -= 30;
        if (health <= 0) {
            destroy();
            level.incrementEnemiesDefeated();
        }
    }
}
