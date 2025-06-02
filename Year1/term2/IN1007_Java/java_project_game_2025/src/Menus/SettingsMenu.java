package Menus;

import game.Game;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsMenu extends JFrame {
    private static float volume = 1.0f; // Default volume level (0.0 to 1.0)

    public SettingsMenu() {
        // Window setup
        setTitle("Settings Menu");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null); // Use absolute layout
        getContentPane().setBackground(Color.BLACK); // Set the JFrame background to black

        // Back Button
        JButton backButton = new JButton();
        ImageIcon icon = new ImageIcon("data/menuItems/backbutton.png");
        icon.setImage(icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        backButton.setIcon(icon);
        backButton.setBackground(Color.BLACK);
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setBounds(20, 20, 50, 50); // Manually set position and size

        // Title Label
        JLabel titleLabel = new JLabel("Settings");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.GREEN);
        titleLabel.setBounds(350, 50, 200, 50); // Manually set position and size

        // Volume Slider
        JLabel volumeLabel = new JLabel("Volume: ");
        volumeLabel.setForeground(Color.GREEN);
        volumeLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        volumeLabel.setBounds(200, 150, 100, 30); // Manually set position and size

        JSlider volumeSlider = new JSlider(0, 100, (int) (volume * 100));
        volumeSlider.setBackground(Color.BLACK); // Ensure slider's background is black
        volumeSlider.setForeground(Color.GREEN);
        volumeSlider.setMajorTickSpacing(25);
        volumeSlider.setMinorTickSpacing(5);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintLabels(true);
        volumeSlider.setBounds(300, 155, 300, 50); // Manually set position and size

        volumeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int sliderValue = volumeSlider.getValue();
                volume = sliderValue / 100.0f; // Convert to 0.0-1.0 range
                adjustVolume(volume);
            }
        });

        // Add components to the frame
        add(backButton);
        add(titleLabel);
        add(volumeLabel);
        add(volumeSlider);

        setVisible(true);

        // Back button action
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current window
                new MainMenu(); // Open the main menu
            }
        });
    }

    // Adjust volume logic
    private void adjustVolume(float volumeLevel) {
        if (volumeLevel > 0) {
            Game.menuMusic.setVolume(volumeLevel);
        }
    }
}