package Entity.ENEMY;

import city.cs.engine.*;
import game.levels.GameLevel;
import org.jbox2d.common.Vec2;

public class eagle extends EnemyBlueprint implements StepListener {
    private static final float WIDTH = 0.8f;
    private static final float HEIGHT = 0.6f;
    private static final BodyImage ENEMY_IMAGE_LEFT = new BodyImage("data/Enemies/Eagle/eagleLeft.gif", 2.5f);
    private static final BodyImage ENEMY_IMAGE_RIGHT = new BodyImage("data/Enemies/Eagle/eagleRight.gif", 2.5f);
    private static final int SPEED = 4;

    private GameLevel level;
    private int health;
    private float flyHeight;

    public eagle(GameLevel level, Vec2 position) {
        super(level, "Eagle", SPEED, position, WIDTH, HEIGHT, 80, ENEMY_IMAGE_LEFT, ENEMY_IMAGE_RIGHT);

        this.level = level;
        this.health = 80;
        this.flyHeight = position.y;

        Shape enemyShape = new BoxShape(WIDTH, HEIGHT);
        new SolidFixture(this, enemyShape);

        // Register this class as a step listener to the world
        level.addStepListener(this);
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        // Maintain flying height
        setPosition(new Vec2(getPosition().x, flyHeight));
    }

    @Override
    public void postStep(StepEvent stepEvent) {
        // Not needed
    }

    @Override
    public void windeffect() {
    }

    @Override
    public void destroy() {
        // Make sure to remove the step listener when the eagle is destroyed
        level.removeStepListener(this);
        super.destroy();
    }
}