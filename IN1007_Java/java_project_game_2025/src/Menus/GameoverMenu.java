package Menus;

import game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameoverMenu extends JFrame {
    public GameoverMenu() {
        setTitle("Game Over");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Set the window size
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setBackground(Color.RED);

        JLabel gameOverLabel = new JLabel("GAME OVER", SwingConstants.CENTER);
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 32)); // Set font style and size
        gameOverLabel.setForeground(Color.BLACK); // Set text color
        gameOverLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        gameOverLabel.setBorder(BorderFactory.createEmptyBorder(200, 0, 20, 0)); // Add padding
        add(gameOverLabel);

        JButton mainMenuButton = new JButton("Main Menu");

        customizeButton(mainMenuButton);


        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Game.menuMusic != null) {
                    Game.menuMusic.loop();
                }
                dispose();
                new MainMenu();
            }
        });

        mainMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(mainMenuButton);
        add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing between buttons

        setVisible(true); // Make the frame visible
    }
    private void customizeButton(JButton button) {
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBackground(Color.GRAY);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 20));
    }
}
