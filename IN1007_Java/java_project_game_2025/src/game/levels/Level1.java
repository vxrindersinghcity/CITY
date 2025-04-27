package game.levels;

import Entity.Collectables.Credit;
import Entity.Collectables.healer;
import Entity.ENEMY.OpossumEnemy;
import Entity.ENEMY.WolfEnemy;
import Entity.Platform;
import Entity.Portal;
import city.cs.engine.StepEvent;
import game.Game;
import org.jbox2d.common.Vec2;

public class Level1 extends GameLevel {
    private float highestPlatformY = -3.5f;
    private Game game;
    private boolean gameOverTriggered = false;
    private final float DEATH_HEIGHT = -16.0f; // Height below which player dies

    public Level1(Game game) {
        super(game);
        this.game = game;
        new LevelInfoBox(super.getLevelName(), "collect 5 coins");

        super.setLevelName("Level1");

        setGravity(10);

        // Create the main platform floor
        Platform mainFloor = new Platform(this, new Vec2(0, -14.5f), 40, 3);

        Platform p1 = new Platform(this, new Vec2(10, -7.5f), 10, 1);
        p1.setAngleDegrees(45);
        Platform p2 = new Platform(this, new Vec2(0, -3.5f), 10, 1);
        Platform p3 = new Platform(this, new Vec2(-10, -3.5f), 5, 0.5f);
        p3.setAngleDegrees(-20);

        Credit c1 = new Credit(this, new Vec2(0, 0));

        OpossumEnemy e1 = new OpossumEnemy(this, new Vec2(0, -2.5f));

        Portal portal1 = new Portal(this, new Vec2(-13, -1));
        Portal portal2 = new Portal(this, new Vec2(14, -1));

        // Pair the portals
        portal1.setPairedPortal(portal2);
        portal2.setPairedPortal(portal1);
    }

    @Override
    public boolean isComplete() {
        return super.getPlayer().getCreditCount() == 5;
    }

    // Method to check player fall
    private void checkPlayerFall() {
        if (getPlayer() != null && getPlayer().getPosition().y < DEATH_HEIGHT) {
            // Player has fallen below the death zone
            System.out.println("Player fell out of bounds!");
            gameOverTriggered = true;

            // Stop the current level to prevent further processing
            this.stop();
            // Show game over menu
            game.showGameOverMenu();
        }
    }

    private void generatePlatform() {
        float platformY = highestPlatformY + (float) (Math.random() * 3 + 6);
        float platformX = (float) (Math.random() * (27) + (-12));
        float platformWidth = (float) (Math.random() * 5 + 4);
        float platformHeight = 1;

        Platform platform = new Platform(this, new Vec2(platformX, platformY), platformWidth, platformHeight);
        if (Math.random() < 0.6) {
            float angle = (float) (Math.random() * 20 - 10); // Angle between -10° and 10°
            platform.setAngleDegrees(angle);
        }
        scatterCoinsOrEnemiesOnPlatform(platform); // Add coins or enemies to this platform
        highestPlatformY = platformY; // Update the highest platform Y
    }

    private void scatterCoinsOrEnemiesOnPlatform(Platform platform) {
        if (Math.random() < 0.4) {
            scatterCoinsOnPlatform(platform);
        } else if (Math.random() > 0.4 && Math.random() < 0.5) {
            scatterHealerOnPlatform(platform);
        } else {
            spawnEnemiesOnPlatform(platform);
        }
    }

    private void scatterCoinsOnPlatform(Platform platform) {
        int coinCount = (int) (Math.random() * 2 + 1); // 1 or 2 coins
        for (int i = 0; i < coinCount; i++) {
            float coinX = platform.getPosition().x + (float) (Math.random() * platform.getWidth() - platform.getWidth() / 2);
            float coinY = platform.getPosition().y + 1.5f;
            new Credit(this, new Vec2(coinX, coinY));
        }
    }

    private void scatterHealerOnPlatform(Platform platform) {
        int coinCount = (int) (Math.random() * 2 + 1); // 1 or 2 coins
        for (int i = 0; i < coinCount; i++) {
            float healX = platform.getPosition().x + (float) (Math.random() * platform.getWidth() - platform.getWidth() / 2);
            float healY = platform.getPosition().y + 1.5f;
            new healer(this, new Vec2(healX, healY));
        }
    }

    private void spawnEnemiesOnPlatform(Platform platform) {
        float enemyX = platform.getPosition().x + (float) (Math.random() * platform.getWidth() - platform.getWidth() / 2);
        float enemyY = platform.getPosition().y + 1.5f;
        if (Math.random() < 0.5) {
            new OpossumEnemy(this, new Vec2(enemyX, enemyY));
        } else {
            new WolfEnemy(this, new Vec2(enemyX, enemyY));
        }
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        // Only process if the game is not already in game over state
        if (!gameOverTriggered) {
            if (super.getPlayer().getPosition().y > highestPlatformY - 10) {
                generatePlatform();
            }
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {
        // Not needed
    }

    public int getBoundleft() {
        return -20;
    }

    public int getBoundRight() {
        return 20;
    }
}