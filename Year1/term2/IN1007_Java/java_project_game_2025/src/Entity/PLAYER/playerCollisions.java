package Entity.PLAYER;

import Entity.Collectables.Credit;
import Entity.Collectables.healer;
import Entity.Portal;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class playerCollisions implements CollisionListener {
    private final Player player;
    private boolean teleporting = false;

    public playerCollisions(Player player) {
        this.player = player;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Credit) {
            player.addCredits();
            playSound();
            collisionEvent.getOtherBody().destroy();
        }
        if (collisionEvent.getOtherBody() instanceof healer) {
            player.healUP();
            collisionEvent.getOtherBody().destroy();
        }

        // Handle Portal teleportation
        if (collisionEvent.getOtherBody() instanceof Portal && !teleporting) {
            Portal portal = (Portal) collisionEvent.getOtherBody();
            Portal pairedPortal = portal.getPairedPortal();
            if (pairedPortal != null) {
                teleporting = true;

                // Teleport the player to the paired portal's position
                player.setPosition(pairedPortal.getPosition().add(new Vec2(2, 0))); // Slight offset to avoid immediate re-collision

                // Create a timer to reset teleporting after a short delay
                Timer timer = new Timer(500, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        teleporting = false;
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        }
    }

    private void playSound() {
        try {
            SoundClip sound = new SoundClip("data/music/effects/collectables/coincollectsound.wav");
            sound.play();
        } catch (Exception e) {
            System.err.println("Error playing sound: " + e.getMessage());
        }
    }



}
