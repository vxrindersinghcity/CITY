package Menus;

import city.cs.engine.SoundClip;
import game.Game;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class MainMenu extends JFrame {
    private Image backgroundImage;

    public MainMenu() {

        backgroundImage = new ImageIcon("data/menuItems/wallpaper.gif").getImage();



        setTitle("Main Menu");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        JPanel contentPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the background image
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setOpaque(false); // Ensure panel transparency

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.add(Box.createVerticalStrut(200));

        JLabel titleLabel = new JLabel("Jungle Runner 2D", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 80));
        titleLabel.setForeground(Color.green);
        titlePanel.add(titleLabel);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setOpaque(false);

        // Create buttons
        JButton startButton = new JButton("Start Game");
        JButton exitButton = new JButton("Exit");
        JButton settingsButton = new JButton("Settings");

        // Customize buttons
        customizeButton(startButton);
        customizeButton(exitButton);
        customizeButton(settingsButton);

        // Add action listeners to buttons
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Game.menuMusic != null) {
                    Game.menuMusic.stop();
                }
                dispose();
                new Game();
            }
        });

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new SettingsMenu();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        addHoverEffect1(startButton);
        addHoverEffect2(exitButton);

        buttonPanel.add(Box.createVerticalStrut(30));
        buttonPanel.add(startButton);
        buttonPanel.add(Box.createVerticalStrut(20)); // Space between buttons
        buttonPanel.add(settingsButton);
        buttonPanel.add(Box.createVerticalStrut(20));
        buttonPanel.add(exitButton);
        buttonPanel.add(Box.createVerticalGlue());

        contentPanel.add(titlePanel, BorderLayout.NORTH);
        contentPanel.add(buttonPanel, BorderLayout.CENTER);

        add(contentPanel);

        setVisible(true);
    }

    private void customizeButton(JButton button) {
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBackground(Color.GRAY);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 20));
    }

    private void addHoverEffect1(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setForeground(Color.GREEN);
            }

            public void mouseExited(MouseEvent e) {
                button.setForeground(Color.WHITE);
            }
        });
    }

    private void addHoverEffect2(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setForeground(Color.RED);
            }

            public void mouseExited(MouseEvent e) {
                button.setForeground(Color.WHITE);
            }
        });
    }
}
