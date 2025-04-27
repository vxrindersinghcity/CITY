package game;

import city.cs.engine.UserView;
import game.levels.GameLevel;
import game.levels.Level3;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {
    private final Image plx1, plx2, plx3, plx4, plx5, bg2,bg3;
    private GameLevel level;
    private Game game;
    private JButton skipButton;

    public GameView(GameLevel level,Game game, int width, int height) {
        super(level, width, height);
        this.level = level;
        this.game=game;
        plx1 = new ImageIcon("data/JunglePack/parallax background/plx-1.png").getImage();
        plx2 = new ImageIcon("data/JunglePack/parallax background/plx-2.png").getImage();
        plx3 = new ImageIcon("data/JunglePack/parallax background/plx-3.png").getImage();
        plx4 = new ImageIcon("data/JunglePack/parallax background/plx-4.png").getImage();
        plx5 = new ImageIcon("data/JunglePack/parallax background/plx-5.png").getImage();
        bg2 = new ImageIcon("data/JunglePack/parallax background/bg2.jpg").getImage();
        bg3= new ImageIcon("data/JunglePack/parallax background/redbg.gif").getImage();
    }

    @Override
    public void paintBackground(Graphics2D g) {
        if (level.getLevelName().equals("Level1")) {
            g.drawImage(plx1, 0, 0, getWidth(), getHeight(), this);
            g.drawImage(plx2, 0, 0, getWidth(), getHeight(), this);
            g.drawImage(plx3, 0, 0, getWidth(), getHeight(), this);
            g.drawImage(plx4, 0, 0, getWidth(), getHeight(), this);
            g.drawImage(plx5, 0, 0, getWidth(), getHeight(), this);
        } else if (level.getLevelName().equals("Level2")) {
            g.drawImage(bg2, 0, 0, getWidth(), getHeight(), this);
        } else if (level.getLevelName().equals("Level3")) {
            g.drawImage(bg3, 0, 0, getWidth(), getHeight(), this);
        }
        // Initialize the button
        skipButton = new JButton("Skip Level");
        skipButton.setFont(new Font("Arial", Font.BOLD, 14));
        skipButton.setForeground(Color.WHITE);
        skipButton.setBackground(Color.RED);

        // Position at the bottom-left
        setLayout(null);
        skipButton.setBounds(10, getHeight() - 50, 120, 30);

        // Add button functionality
        skipButton.addActionListener(e -> skipLevel());

        // Add to view
        add(skipButton);

    }

    public void skipLevel() {
        // Implement logic to switch to the next level
        game.goToNextLevel(); // Assuming you have this method
    }


    @Override
    public void paintForeground(Graphics2D g) {
        super.paintForeground(g);

        // Get player information
        int currentCreditcount = level.getPlayer().getCreditCount();
        Vec2 playerPosition = level.getPlayer().getPosition();
        int playerHealth = level.getPlayer().getHealth();
        int maxHealth = 100;

        // Set up common fonts and colors
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font valueFont = new Font("Arial", Font.BOLD, 20);
        Color labelColor = Color.WHITE;
        Color valueColor = Color.WHITE;
        Color bgColor = new Color(0, 0, 0, 150); // Semi-transparent black

        // Draw credits count
        g.setColor(bgColor);
        g.fillRoundRect(getWidth() - 150, 10, 140, 30, 10, 10);
        g.setColor(labelColor);
        g.setFont(labelFont);
        g.drawString("Credits:", getWidth() - 140, 30);
        g.setFont(valueFont);
        g.setColor(valueColor);
        g.drawString(String.valueOf(currentCreditcount), getWidth() - 70, 30);

        // Draw player position
        g.setColor(bgColor);
        g.fillRoundRect(10, 10, 280, 30, 10, 10);
        g.setColor(labelColor);
        g.setFont(labelFont);
        g.drawString("Position:", 20, 30);
        g.setFont(valueFont);
        g.setColor(valueColor);
        g.drawString("(" + (int) playerPosition.x + ", " + (int) playerPosition.y + ")", 100, 30);

        // Draw health bar
        int healthBarWidth = 200;
        int healthBarHeight = 20;
        int filledWidth = (int) ((playerHealth / (float) maxHealth) * healthBarWidth);

        g.setColor(bgColor);
        g.fillRoundRect(10, 50, healthBarWidth + 50, 40, 10, 10);

        // Draw the health bar background (unfilled part)
        g.setColor(Color.RED);
        g.fillRect(20, 60, healthBarWidth, healthBarHeight);

        // Draw the filled part of the health bar
        g.setColor(Color.GREEN);
        g.fillRect(20, 60, filledWidth, healthBarHeight);

        // Draw the health bar border
        g.setColor(Color.BLACK);
        g.drawRect(20, 60, healthBarWidth, healthBarHeight);

        // Draw health value
        g.setColor(Color.WHITE);
        g.setFont(valueFont);
        g.drawString(String.valueOf(playerHealth), 225, 76);

        // For Level2, draw objectives progress
        if (level instanceof Level3) {
            Level3 level3 = (Level3) level;

            // Calculate starting Y position for objectives
            int objY = 100;
            int objPadding = 30;

            // Draw objectives background
            g.setColor(bgColor);
            g.fillRoundRect(10, objY, 300, 140, 10, 10);

            // Draw title
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Arial", Font.BOLD, 16));
            g.drawString("LEVEL 2 OBJECTIVES:", 20, objY + 20);

            // Draw credits objective
            g.setColor(labelColor);
            g.setFont(labelFont);
            g.drawString("Credits:", 20, objY + 20 + objPadding);
            g.setColor(valueColor);
            String creditsStatus = currentCreditcount + "/" + level3.getRequiredCredits();
            g.drawString(creditsStatus, 150, objY + 20 + objPadding);

            // Draw enemies objective
            g.setColor(labelColor);
            g.drawString("Enemies Defeated:", 20, objY + 20 + objPadding * 2);
            g.setColor(valueColor);
            String enemiesStatus = level3.getEnemiesDefeated() + "/" + level3.getRequiredEnemiesDefeated();
            g.drawString(enemiesStatus, 200, objY + 20 + objPadding * 2);

            // Draw key item objective
            g.setColor(labelColor);
            g.drawString("Key Item:", 20, objY + 20 + objPadding * 3);
            g.setColor(level3.isKeyItemCollected() ? Color.GREEN : Color.RED);
            g.drawString(level3.isKeyItemCollected() ? "FOUND" : "NOT FOUND", 150, objY + 20 + objPadding * 3);

        }
    }

    public void setLevel(GameLevel level) {
        this.level = level;
    }
}