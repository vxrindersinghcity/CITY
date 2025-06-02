package Entity.PLAYER;

import Entity.Attack.FireBall;
import city.cs.engine.SoundClip;
import game.levels.GameLevel;
import org.jbox2d.common.Vec2;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayerMouseAttack extends MouseAdapter {
    private GameLevel level;
    private PlayerController playerController;

    public PlayerMouseAttack(GameLevel level, PlayerController playerController) {
        this.level = level;
        this.playerController = playerController;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Get player position in world coordinates
        Vec2 playerPosition = level.getPlayer().getPosition();

        // Get mouse position in screen coordinates
        int mouseX = e.getX();

        // Determine if mouse is to the left or right of the screen center
        boolean facingRight = mouseX > 400; // Assuming 800x600 window, center is at x=400

        // Make the player face the shooting direction
        if (playerController != null) {
            // If the player is facing right but shooting left, or vice versa, update facing
            boolean currentFacing = playerController.returnfacingRight();
            if (currentFacing != facingRight) {
                // Update player's facing direction based on shot direction
                playerController.updateFacingDirection(facingRight);
            }
        }

        // Create a new position slightly offset in the correct direction
        Vec2 spawnPosition = new Vec2(
                playerPosition.x + (facingRight ? 1.0f : -1.0f),
                playerPosition.y
        );

        // Calculate a more realistic target position with some height
        Vec2 targetPosition = new Vec2(
                playerPosition.x + (facingRight ? 50.0f : -50.0f),
                playerPosition.y + 5.0f  // Aim slightly upwards for a better arc
        );

        playSound();
        // Create a fireball with explicit direction
        new FireBall(level, spawnPosition, targetPosition, 1.5f, 1.5f, facingRight);
    }

    private void playSound() {
        try {
            SoundClip sound = new SoundClip("data/music/effects/attacks/fireballsound.wav");
            sound.play();
        } catch (Exception e) {
            System.err.println("Error playing sound: " + e.getMessage());
        }
    }
}