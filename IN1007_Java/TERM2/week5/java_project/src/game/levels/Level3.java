package game.levels;

import Entity.Collectables.Credit;
import Entity.Collectables.healer;
import Entity.ENEMY.OpossumEnemy;
import Entity.ENEMY.WolfEnemy;
import Entity.Platform;
import Entity.Portal;
import city.cs.engine.*;
import game.Game;
import org.jbox2d.common.Vec2;

public class Level3 extends GameLevel {
    private Game game;

    // Objective tracking variables
    private int requiredCredits = 10;
    private int requiredEnemiesDefeated = 5;

    // Special object for player to find
    private StaticBody keyItem;
    private boolean keyItemCollected = false;

    public Level3(Game game) {
        super(game);
        this.game = game;

        // Set Level2 details with challenging objective
        new LevelInfoBox(super.getLevelName(),
                "Collect 10 credits,defeat 5 enemies,and find the key item!");
        super.setLevelName("Level2");
        setGravity(10);

        // Initial ground floor
        Platform mainFloor = new Platform(this, new Vec2(0, -14.5f), 40, 3);

        // Create the complete static level layout
        createStaticMap();

        // Create key item
        createKeyItem();

        // Place coins manually on platforms
        placeCoinsManually();
    }

    private void createStaticMap() {

        // Make sure platforms have good vertical spacing (at least 4 units)
        Platform mid1 = new Platform(this, new Vec2(28, -8), 15, 1);
        mid1.setAngleDegrees(-5); // Slight angle


        Platform mid2 = new Platform(this, new Vec2(50, -8), 18, 1);
        mid2.setAngleDegrees(7); // Slight angle

        // GAP 1: First major gap that needs a portal

        // SECTION 2: Middle area with platforms
        Platform enemyPlatform1 = new Platform(this, new Vec2(70, -10), 15, 1);


        Platform enemyPlatform2 = new Platform(this, new Vec2(95, -12), 15, 1);


        // Higher platforms (with good vertical spacing)
        Platform high1 = new Platform(this, new Vec2(65, -4), 10, 1);


        Platform high2 = new Platform(this, new Vec2(85, -4), 15, 1);
        high2.setAngleDegrees(-6);

        // GAP 2: Second major gap that needs a portal

        // SECTION 3: Advanced area
        Platform adv1 = new Platform(this, new Vec2(110, -8), 15, 1);

        Platform adv2 = new Platform(this, new Vec2(130, -6), 10, 1);
        adv2.setAngleDegrees(8);

        Platform adv3 = new Platform(this, new Vec2(150, -8), 20, 1);


        Platform adv4 = new Platform(this, new Vec2(175, -10), 15, 1);


        // Highest platforms
        Platform top1 = new Platform(this, new Vec2(120, 0), 12, 1);


        Platform top2 = new Platform(this, new Vec2(140, 0), 18, 1);


        Platform top3 = new Platform(this, new Vec2(165, -2), 20, 1);


        // GAP 3: Third major gap that needs a portal

        // Add isolated challenge platforms
        Platform challenge1 = new Platform(this, new Vec2(100, 5), 10, 1);


        Platform challenge2 = new Platform(this, new Vec2(180, 4), 10, 1);


        // Place enemies on different platforms - one enemy per platform
        // One enemy per platform in the starting section
        new OpossumEnemy(this, new Vec2(16, -10.5f));
        new WolfEnemy(this, new Vec2(45, -10.5f));

        // One enemy per platform in the middle sectiondddddddddddddddddd
        new OpossumEnemy(this, new Vec2(70, -8.5f));
        new WolfEnemy(this, new Vec2(95, -10.5f));

        // One enemy per platform in the upper sections
        new OpossumEnemy(this, new Vec2(65, -2.5f));
        new WolfEnemy(this, new Vec2(85, -2.5f));

        new WolfEnemy(this, new Vec2(110, -5f));

        // One enemy per platform in advanced areas
        new OpossumEnemy(this, new Vec2(120, 1.5f));
        new WolfEnemy(this, new Vec2(155, -6.5f));
        new OpossumEnemy(this, new Vec2(175, -8.5f));

        // Portal pair 1: Helps cross the gap between middle and advanced sections
        Portal portal2A = new Portal(this, new Vec2(95, 7));
        Portal portal2B = new Portal(this, new Vec2(95, -2));
        portal2A.setPairedPortal(portal2B);
        portal2B.setPairedPortal(portal2A);

        // Portal pair 3: Helps reach the isolated challenge areas with key item
        Portal portal3A = new Portal(this, new Vec2(140, 2));
        Portal portal3B = new Portal(this, new Vec2(180, 6));
        portal3A.setPairedPortal(portal3B);
        portal3B.setPairedPortal(portal3A);

        // Add healers in difficult-to-reach spots
        new healer(this, new Vec2(65, 0));
        new healer(this, new Vec2(120, 4));
        new healer(this, new Vec2(150, -4));
    }

    private void placeCoinsManually() {

        // Mid platforms - placed on gap
        new Credit(this, new Vec2(38, 2f));  // Left edge of mid1

        // Enemy platforms - coins away from enemy pathing
        new Credit(this, new Vec2(75, -7f));  // Right side of enemyPlatform1
        new Credit(this, new Vec2(90, -9f));  // Left side of enemyPlatform2, enemy is at 95

        // Higher platforms - coins on edges
        new Credit(this, new Vec2(60, -1f));  // Left side of high1, enemy is at 65
        new Credit(this, new Vec2(70, -1f));  // Right side of high1

        // Advanced area - coins on edges and corners
        new Credit(this, new Vec2(105, -4.5f));  // Left side of adv1aaaa
        new Credit(this, new Vec2(115, -4.5f));  // Right side of adv1

        new Credit(this, new Vec2(180, -6.5f));  // Right side of adv4

        // Top platforms - coins on edges
        new Credit(this, new Vec2(115, 3f));  // Left side of top1, enemy is at 120
        new Credit(this, new Vec2(125, 3f));  // Right side of top1
        new Credit(this, new Vec2(135, 3f));  // Left side of top2


        // Challenge platforms - coins as rewards
        new Credit(this, new Vec2(100, 6.5f));  // Middle of challenge1

        // Challenge platform near key - add extra coins as reward
        new Credit(this, new Vec2(175, 5.5f));  // Left side of challenge2
        new Credit(this, new Vec2(185, 7.5f));  // Right side of challenge2
    }

    private void createKeyItem() {
        // Create a special key item the player needs to find
        Shape keyShape = new CircleShape(1);
        keyItem = new StaticBody(this);
        new SolidFixture(keyItem, keyShape);

        // Place the key in a challenging to reach location
        keyItem.setPosition(new Vec2(182, 10));

        // Add image to the key item
        BodyImage keyImage = new BodyImage("data/collectables/key.gif", 2);
        keyItem.addImage(keyImage);

        // Add collision listener for key item
        keyItem.addCollisionListener(new CollisionListener() {
            @Override
            public void collide(CollisionEvent e) {
                if (e.getOtherBody() == getPlayer()) {
                    System.out.println("Key item collected!");
                    keyItemCollected = true;
                    keyItem.destroy();
                }
            }
        });
    }

    @Override
    public boolean isComplete() {
        // Level is complete when all objectives are met (no checkpoints)
        return getPlayer().getCreditCount() >= requiredCredits &&
                enemiesDefeated >= requiredEnemiesDefeated &&
                keyItemCollected;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (!gameOverTriggered) {
            // Check if player has fallen below death zone
            checkPlayerFall();

            // Check level completion (your existing code)
            checkLevelCompletion();
        }
    }


    @Override
    public void postStep(StepEvent stepEvent) {
        // Optional: Additional post-step behavior
    }

    public void checkLevelCompletion() {
        if (this.isComplete()) {
            System.out.println("Level 2 complete!");
            game.goToNextLevel();
        }
    }

    public int getBoundleft() {
        return -5; // Prevent going too far back
    }

    public int getBoundRight() {
        return 200; // Set limit to match the size of our static map
    }

    // Accessor methods for objective tracking
    public int getRequiredCredits() {
        return requiredCredits;
    }

    public int getRequiredEnemiesDefeated() {
        return requiredEnemiesDefeated;
    }

    public int getEnemiesDefeated() {
        return super.enemiesDefeated;
    }

    public boolean isKeyItemCollected() {
        return keyItemCollected;
    }

    private final float DEATH_ZONE_Y = -25.0f;  // Set below your lowest platform at -14.5f

    // Flag to track if game over has been triggered
    private boolean gameOverTriggered = false;

    // Method to check player fall
    private void checkPlayerFall() {
        if (getPlayer() != null && getPlayer().getPosition().y < DEATH_ZONE_Y) {
            // Player has fallen below the death zone
            System.out.println("Player fell out of bounds!");
            gameOverTriggered = true;

            // Stop the current level to prevent further processing
            this.stop();

            // Show game over menu
            game.showGameOverMenu();
        }
    }
}