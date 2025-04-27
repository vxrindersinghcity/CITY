package Entity.Attack;

import Entity.ENEMY.OpossumEnemy;
import Entity.ENEMY.WolfEnemy;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Attack extends DynamicBody {
    private static final float SPEED = 10.0f;

    public Attack(World world, Vec2 position, boolean facingRight, float width, float height, String imagePath) {
        super(world);

        Shape attackShape = new BoxShape(width / 2, height / 2);
        new SolidFixture(this, attackShape);

        setPosition(position);

        BodyImage attackImage = new BodyImage(imagePath, height);
        addImage(attackImage);

        float direction = facingRight ? 1 : -1;
        setLinearVelocity(new Vec2(direction * SPEED, 0));

        // Timer to destroy attack after 2 seconds
        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                destroy();
            }
        });
        timer.setRepeats(false);
        timer.start();

        addCollisionListener(new CollisionListener() {
            @Override
            public void collide(CollisionEvent e) {
                if (e.getOtherBody() instanceof OpossumEnemy) {
                    applyEffect((OpossumEnemy) e.getOtherBody());
                    destroy();
                }
                if (e.getOtherBody() instanceof WolfEnemy) {
                    applyEffect((WolfEnemy) e.getOtherBody());
                    destroy();
                }

            }
        });
    }

    public void applyEffect(){

    }

    public void applyEffect(OpossumEnemy enemy){}
    public void applyEffect(WolfEnemy enemy){}
}
