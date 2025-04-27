package Entity.ENEMY;

import Entity.PLAYER.Player;
import city.cs.engine.*;
import game.levels.GameLevel;
import game.levels.Level2;
import org.jbox2d.common.Vec2;

public abstract class EnemyBlueprint extends Walker {
    private int health;
    private BodyImage imageLeft;
    private BodyImage imageRight;
    private Sensor platformSensor;
    private Sensor playerSensor;
    private Shape platformSensorShape;
    private Shape playerSensorShape;
    private final float SPEED;
    private float WIDTH;
    private float HEIGHT;
    private String name;
    private GameLevel level;

    public EnemyBlueprint(GameLevel level, String name, float SPEED, Vec2 position, float WIDTH, float HEIGHT, int initialHealth, BodyImage imagePathLeft, BodyImage imagePathRight) {
        super(level);

        this.level = level;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.SPEED = SPEED;
        this.name = name;
        this.imageLeft = imagePathLeft;
        this.imageRight = imagePathRight;

        this.health = initialHealth;

        setPosition(position);

        createPlatformEdgeSensor();
        createPlayerDamageSensor();

        startMoving();
    }

    // Abstract method for starting movement, to be implemented by subclasses
    protected abstract void windeffect();

    /**
     * Update the image based on the movement direction.
     */
    protected void updateImageBasedOnDirection() {
        removeAllImages();
        if (getLinearVelocity().x > 0) {
            addImage(imageLeft);
        } else {
            addImage(imageRight);
        }
    }

    /**
     * Create a sensor to detect platform edges and reverse direction.
     */
    private void createPlatformEdgeSensor() {
        platformSensorShape = new BoxShape(WIDTH / 2, 0.4f, new Vec2(0, -1));
        platformSensor = new Sensor(this, platformSensorShape);

        platformSensor.addSensorListener(new SensorListener() {
            @Override
            public void beginContact(SensorEvent e) {
            }

            @Override
            public void endContact(SensorEvent e) {
                if (e.getContactBody() instanceof StaticBody) {
                    startWalking(-getLinearVelocity().x);
                    updateImageBasedOnDirection();
                    updateSensorPositions();
                }
            }
        });
    }

    /**
     * Create a sensor for detecting players.
     */
    private void createPlayerDamageSensor() {
        playerSensorShape = new BoxShape(WIDTH / 2, HEIGHT / 3, new Vec2(1, 0));
        playerSensor = new Sensor(this, playerSensorShape);

        playerSensor.addSensorListener(new SensorListener() {
            @Override
            public void beginContact(SensorEvent e) {
                if (e.getContactBody() instanceof Player) {
                    Player player = (Player) e.getContactBody();
                    player.decreaseHealth(name);
                }
            }

            @Override
            public void endContact(SensorEvent e) {
                if (e.getContactBody() instanceof Player) {
                }
            }
        });
    }

    /**
     * Updates the positions of the platform and player sensors based on the enemy's direction.
     */
    private void updateSensorPositions() {
        float sensorOffset = getLinearVelocity().x > 0 ? -1 : 1; // Update player sensor
        if (playerSensor != null) {
            playerSensor.destroy();
        }
        playerSensorShape = new BoxShape(WIDTH/2, HEIGHT / 3, new Vec2(sensorOffset, 0));
        playerSensor = new Sensor(this, playerSensorShape);
        playerSensor.addSensorListener(new SensorListener() {
            @Override
            public void beginContact(SensorEvent e) {
                if (e.getContactBody() instanceof Player) {
                    Player player = (Player) e.getContactBody();
                    player.decreaseHealth(name);
                }
            }

            @Override
            public void endContact(SensorEvent e) {
                if (e.getContactBody() instanceof Player) {

                }
            }
        });
    }

    /**
     * Start the enemy's movement.
     */
    public void startMoving() {
        startWalking(SPEED);
        updateImageBasedOnDirection();
    }
}