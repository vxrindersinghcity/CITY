package Entity.Attack;
import city.cs.engine.*;
import game.levels.GameLevel;
import org.jbox2d.common.Vec2;

public class FireBall extends DynamicBody {
    private static final float INITIAL_SPEED = 15.0f;
    private static final float FIREBALL_GRAVITY = 0.5f;
    private static final float INITIAL_Y_VELOCITY = 3.0f;

    // Path to the fireball image
    private static final String FIREBALL_IMAGE = "data/attacks/fireball.gif";

    public FireBall(GameLevel world, Vec2 startPosition, Vec2 targetPosition, float width, float height, boolean facingRight) {
        super(world);

        // Create a circular shape for the fireball
        Shape fireballShape = new CircleShape(width / 2);
        new SolidFixture(this, fireballShape);

        // Set position
        setPosition(startPosition);
        setGravityScale(FIREBALL_GRAVITY);

        // Add the fireball image
        AttachedImage img = addImage(new BodyImage(FIREBALL_IMAGE, 2.0f)); // Larger size for better visibility

        // Flip the image if shooting left
        if (!facingRight) {
            img.flipHorizontal();
        }

        // Set velocity with horizontal component based on facing direction
        float vx = facingRight ? INITIAL_SPEED : -INITIAL_SPEED;
        float vy = INITIAL_Y_VELOCITY;
        setLinearVelocity(new Vec2(vx, vy));

        // Set initial angle based on velocity vector
        float initialAngle = (float) Math.atan2(vy, Math.abs(vx));
        if (!facingRight) {
            initialAngle = (float) Math.PI - initialAngle;
        }
        setAngle(initialAngle);

        // Add step listener for rotation and timeout
        StepListener timeoutListener = new StepListener() {
            private float timeAlive = 0;

            @Override
            public void preStep(StepEvent e) {}

            @Override
            public void postStep(StepEvent e) {
                // Update angle to match velocity
                Vec2 vel = getLinearVelocity();
                if (vel.lengthSquared() > 0.1f) {
                    float newAngle = (float) Math.atan2(vel.y, Math.abs(vel.x));
                    if (!facingRight) {
                        newAngle = (float) Math.PI - newAngle;
                    }
                    setAngle(newAngle);
                }

                // Destroy after time limit - only if not destroyed by collision
                timeAlive += e.getStep();
                if (timeAlive > 5.0f) {
                    if (getWorld() != null) {  // Check if still in world
                        destroy();
                    }
                    world.removeStepListener(this);
                }
            }
        };

        world.addStepListener(timeoutListener);

        // Handle collisions
        addCollisionListener(new CollisionListener() {
            @Override
            public void collide(CollisionEvent e) {
                // Skip collision with player
                if (e.getOtherBody() instanceof Entity.PLAYER.Player) {
                    return;
                }

                // Destroy enemy if hit AND destroy fireball immediately
                if (e.getOtherBody() instanceof DynamicBody &&
                        !(e.getOtherBody() instanceof Entity.PLAYER.Player)) {
                    e.getOtherBody().destroy();
                    world.removeStepListener(timeoutListener);  // Remove the listener
                    destroy();  // Destroy fireball immediately
                    world.incrementEnemiesDefeated();
                }
                // When hitting any static body, destroy fireball immediately
                else if (e.getOtherBody() instanceof StaticBody) {
                    world.removeStepListener(timeoutListener);  // Remove the listener
                    destroy();  // Destroy fireball immediately
                }
            }
        });
    }

}