package Entity.PLAYER;

import Entity.ENEMY.OpossumEnemy;
import Entity.Platform;
import city.cs.engine.*;
import game.Game;
import game.levels.GameLevel;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

public class PlayerController implements KeyListener, StepListener {
    private Player player;
    private static final BodyImage walkImage = new BodyImage("data/JunglePack/Character/run.gif", 4f);
    private static final BodyImage walkImageFlipped = new BodyImage("data/JunglePack/Character/runLeft.gif", 4f);
    private static final BodyImage idleImage = new BodyImage("data/JunglePack/Character/idle.gif", 4f);
    private static final BodyImage idleImageFlipped = new BodyImage("data/JunglePack/Character/idleLeft.gif", 4f);
    private static final BodyImage jumpImage = new BodyImage("data/JunglePack/Character/jump.png", 4f);
    private static final BodyImage jumpImageFlipped = new BodyImage("data/JunglePack/Character/jumpLeft.png", 4f);
    private static final BodyImage enemyDeath = new BodyImage("data/Enemies/enemydeath/Preview.gif");

    private boolean moveLeft, moveRight, jump;
    private boolean facingRight = true; // Track the direction the player is facing
    private boolean isOnPlatform = false;
    private Game game;
    private GameLevel level;

    public PlayerController(Player player, Game game, GameLevel level) {
        this.player = player;
        this.level = level;
        this.game = game;
    }

    public void moveLeft() {
        moveLeft = true;
        if (facingRight) {
            facingRight = false;
        }
    }

    public void moveRight() {
        moveRight = true;
        if (!facingRight) {
            facingRight = true;
        }
    }

    public void jump() {
        jump = true;
    }

    public void stopMovingLeft() {
        moveLeft = false;
    }

    public void stopMovingRight() {
        moveRight = false;
    }

    // New method added to update facing direction from mouse position
    public void updateFacingDirection(boolean isFacingRight) {
        facingRight = isFacingRight;
        // Update player image based on new direction
        player.removeAllImages();
        if (player.getLinearVelocity().y != 0) {
            // Player is jumping/falling
            player.addImage(facingRight ? jumpImage : jumpImageFlipped);
        } else if (moveLeft || moveRight) {
            // Player is walking
            player.addImage(facingRight ? walkImage : walkImageFlipped);
        } else {
            // Player is idle
            player.addImage(facingRight ? idleImage : idleImageFlipped);
        }
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (player.getGameLevel().isComplete()){
            player.resetCredits();
            game.goToNextLevel();
        }
        // Boundary check for x-direction
        float positionX = player.getPosition().x;

        if (jump && isOnPlatform) {
            player.jump(15);
            player.removeAllImages();
            player.addImage(facingRight ? jumpImage : jumpImageFlipped);
            jump = false;
        } else if (moveLeft && positionX > level.getBoundleft()) {
            movePlayer(-5, walkImageFlipped);
        } else if (moveRight && positionX < level.getBoundRight()) {
            movePlayer(5, walkImage);
        } else {
            movePlayer(0, facingRight ? idleImage : idleImageFlipped);
        }
    }

    // Helper method for movement and image updates
    private void movePlayer(float speed, BodyImage image) {
        player.startWalking(speed);
        player.removeAllImages();
        player.addImage(image);
    }

    @Override
    public void postStep(StepEvent stepEvent) {
        // Optional: Logic after each step, if needed
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                moveLeft();
                break;
            case KeyEvent.VK_D:
                moveRight();
                break;
            case KeyEvent.VK_W:
                jump();
                break;
            case KeyEvent.VK_SPACE:
                playSound();
                player.spawnWindAttack(facingRight);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_A) {
            stopMovingLeft();
        } else if (key == KeyEvent.VK_D) {
            stopMovingRight();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    private void playSound() {
        try {
            SoundClip sound = new SoundClip("data/music/effects/attacks/wind.wav");
            sound.play();
        } catch (Exception e) {
            System.err.println("Error playing sound: " + e.getMessage());
        }
    }

    public void createEnemySensor() {
        // Define the shape of the sensor to detect the platform
        Shape EnemySensorShape = new BoxShape(0.7f, 0.1f, new Vec2(0, -1.7f));
        Sensor EnemySensor = new Sensor(player, EnemySensorShape);

        EnemySensor.addSensorListener(new SensorListener() {
            @Override
            public void beginContact(SensorEvent e) {
                if (e.getContactBody() instanceof OpossumEnemy) {
                    e.getContactBody().removeAllImages();
                    e.getContactBody().addImage(enemyDeath);

                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            synchronized (player.getWorld()){
                                e.getContactBody().destroy();
                            }
                        }
                    }, 200);
                }
            }

            @Override
            public void endContact(SensorEvent e) {
                // Not used
            }
        });
    }

    public void createEdgeSensor(){
        Shape platformEdge = new BoxShape(1.3f, 1.8f, new Vec2(0, -0.2f));
        Sensor platformDetector = new Sensor(player, platformEdge);
        platformDetector.addSensorListener(new SensorListener() {

            @Override
            public void beginContact(SensorEvent sensorEvent) {
                if (sensorEvent.getContactBody() instanceof Platform) {
                    isOnPlatform = true; // Player is on a platform
                }
            }

            @Override
            public void endContact(SensorEvent sensorEvent) {
                if (sensorEvent.getContactBody() instanceof Platform) {
                    isOnPlatform = false; // Player has left the platform
                }
            }
        });
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setlevel(GameLevel currentlevel) {
        level = currentlevel;
    }

    public Boolean returnfacingRight() {
        return facingRight;
    }
}