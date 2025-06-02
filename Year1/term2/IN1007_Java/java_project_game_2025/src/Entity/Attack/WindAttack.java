package Entity.Attack;

import Entity.ENEMY.OpossumEnemy;
import Entity.ENEMY.WolfEnemy;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class WindAttack extends Attack {
    private static final float WIDTH = 1.0f;
    private static final float HEIGHT = 3.0f;
    private static final String FIREBALL_IMAGE_PATH = "data/attacks/windattack.gif";

    public WindAttack(World world, Vec2 position, boolean facingRight) {
        super(world, position, facingRight, WIDTH, HEIGHT, FIREBALL_IMAGE_PATH);
    }

    @Override
    public void applyEffect(OpossumEnemy enemy) {
        enemy.windeffect();
    }

    @Override
    public void applyEffect(WolfEnemy enemy) {
        enemy.windeffect();
    }
}
