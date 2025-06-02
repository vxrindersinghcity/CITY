package game.levels;

import javax.swing.*;
import java.awt.*;

public class LevelInfoBox {
    private JFrame frame;
    private JPanel panel;

    public LevelInfoBox(String levelName, String objective) {
        frame = new JFrame();
        frame.setUndecorated(true); // Remove window decorations
        frame.setAlwaysOnTop(true); // Keep it on top
        frame.setSize(600, 150); // Set size of the grey box (made taller)
        frame.setLocationRelativeTo(null); // Center the box

        panel = new JPanel();
        panel.setBackground(Color.GRAY); // Set the background color to grey
        panel.setLayout(new BorderLayout()); // Use BorderLayout for better positioning

        // Create level name label (title at the top)
        JLabel levelLabel = new JLabel(levelName, SwingConstants.CENTER);
        levelLabel.setForeground(Color.WHITE); // Set text color
        levelLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set font and size
        panel.add(levelLabel, BorderLayout.NORTH); // Place at the top of the panel

        // Create objective label (description in the middle)
        JLabel objectiveLabel = new JLabel("Objective: " + objective, SwingConstants.CENTER);
        objectiveLabel.setForeground(Color.WHITE); // Set text color
        objectiveLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font and size
        panel.add(objectiveLabel, BorderLayout.CENTER); // Place in the center of the panel

        // Add the panel to the frame
        frame.add(panel);
        frame.setVisible(true);

        // Close the box after 3 seconds
        Timer timer = new Timer(3000, e -> frame.dispose());
        timer.setRepeats(false);
        timer.start();
    }
}