package game.levels;

import Entity.Collectables.Credit;
import Entity.Collectables.healer;
import Entity.ENEMY.eagle;
import Entity.ENEMY.OpossumEnemy;
import Entity.PLAYER.Player;
import Entity.Platform;
import Entity.Portal;
import city.cs.engine.StepEvent;
import game.Game;
import org.jbox2d.common.Vec2;

public class Level2 extends GameLevel {
    private float farthestPlatformX = 20f;
    private Game game;
    private final float DEATH_HEIGHT = -16.0f; // Height below which player dies
    private boolean gameOverTriggered = false;

    public Level2(Game game) {
        super(game);
        this.game = game;
        new LevelInfoBox(super.getLevelName(), "collect 10 coins");

        super.setLevelName("Level2");

        setGravity(10);

        // Create the main platform floor extending across the level
        Platform mainFloor = new Platform(this, new Vec2(0, -14.5f), 40, 3);

        // Create initial platforms with smaller gaps between them
        Platform p1 = new Platform(this, new Vec2(8, -7.5f), 5, 1);
        Platform p2 = new Platform(this, new Vec2(15, -5.5f), 4, 1);
        Platform p3 = new Platform(this, new Vec2(22, -3.5f), 5, 1);
        Platform p4 = new Platform(this, new Vec2(30, -6.5f), 4, 1);
        Platform p5 = new Platform(this, new Vec2(38, -4.5f), 5, 1);

        // Add platforms at varying heights for vertical exploration
        Platform high1 = new Platform(this, new Vec2(12, 2.5f), 4, 1);
        Platform high2 = new Platform(this, new Vec2(25, 4.5f), 5, 1);
        Platform high3 = new Platform(this, new Vec2(35, 3.0f), 4, 1);

        Platform low1 = new Platform(this, new Vec2(18, -10.5f), 4, 1);
        Platform low2 = new Platform(this, new Vec2(28, -12.0f), 5, 1);

        // Add initial collectables
        Credit c1 = new Credit(this, new Vec2(8, -5));
        Credit c2 = new Credit(this, new Vec2(15, -3));
        Credit c3 = new Credit(this, new Vec2(12, 4));

        // Add initial eagles flying above platforms
        addEagleAbovePlatform(p2); // Eagle above platform at (15, -5.5)
        addEagleAbovePlatform(p4); // Eagle above platform at (30, -6.5)
        addEagleAbovePlatform(high2); // Eagle above high platform

        // Create portals for vertical movement
        Portal portal1 = new Portal(this, new Vec2(5, -10));
        Portal portal2 = new Portal(this, new Vec2(25, 6));

        // Pair the portals
        portal1.setPairedPortal(portal2);
        portal2.setPairedPortal(portal1);
    }

    @Override
    public boolean isComplete() {
        return super.getPlayer().getCreditCount() == 10;
    }

    private void generatePlatform() {
        // Generate platforms closer together (5-8 units apart instead of 10-15)
        float platformX = farthestPlatformX + (float) (Math.random() * 3 + 5);

        // Increase vertical range for platforms (-15 to +15 instead of -10 to +10)
        float platformY = (float) (Math.random() * 30 - 15);

        float platformWidth = (float) (Math.random() * 3 + 3); // Slightly smaller platforms
        float platformHeight = 1;

        Platform platform = new Platform(this, new Vec2(platformX, platformY), platformWidth, platformHeight);
        if (Math.random() < 0.4) {
            float angle = (float) (Math.random() * 20 - 10); // Angle between -10° and 10°
            platform.setAngleDegrees(angle);
        }

        scatterItemsOnPlatform(platform);

        // Always add an eagle above newly generated platforms
        if (Math.random() < 0.6) { // 60% chance for an eagle
            addEagleAbovePlatform(platform);
        }

        farthestPlatformX = platformX; // Update the farthest platform X
    }

    private void scatterItemsOnPlatform(Platform platform) {
        double rand = Math.random();
        if (rand < 0.5) {
            scatterCoinsOnPlatform(platform);
        } else if (rand < 0.7) {
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
        int healerCount = (int) (Math.random() * 2 + 1); // 1 or 2 healers
        for (int i = 0; i < healerCount; i++) {
            float healX = platform.getPosition().x + (float) (Math.random() * platform.getWidth() - platform.getWidth() / 2);
            float healY = platform.getPosition().y + 1.5f;
            new healer(this, new Vec2(healX, healY));
        }
    }

    private void spawnEnemiesOnPlatform(Platform platform) {
        float enemyX = platform.getPosition().x + (float) (Math.random() * platform.getWidth() - platform.getWidth() / 2);
        float enemyY = platform.getPosition().y + 1.5f;

        // Only spawn Opossum on platforms
        new OpossumEnemy(this, new Vec2(enemyX, enemyY));
    }

    private void addEagleAbovePlatform(Platform platform) {
        float eagleX = platform.getPosition().x;
        // Place eagle 4 units directly above the platform
        float eagleY = platform.getPosition().y + 4f;

        new eagle(this, new Vec2(eagleX, eagleY));
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

    @Override
    public void preStep(StepEvent stepEvent) {
        // Generate new platforms as player moves right
        // Reduced the distance threshold to generate platforms more frequently
        if (super.getPlayer().getPosition().x > farthestPlatformX - 20) {
            generatePlatform();
        }

        // Check if player has fallen below lowest platform
        checkPlayerFall();
    }

    @Override
    public void postStep(StepEvent stepEvent) {
        // Not needed for now
    }

    public int getBoundleft() {
        return -10; // Allow some movement to the left
    }

    public int getBoundRight() {
        return Integer.MAX_VALUE; // No right boundary - infinite generation
    }

    // Add methods to get the vertical boundaries for camera
    public int getBoundBottom() {
        return -20; // Lower vertical boundary
    }

    public int getBoundTop() {
        return 20; // Upper vertical boundary
    }
}