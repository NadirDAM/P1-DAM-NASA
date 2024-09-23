package View;

import java.awt.*;
import javax.swing.*;

public class AstronautView extends JFrame{

    public AstronautView() {
        // Set the frame properties
        setBounds(600, 600, 1000, 700);
        setTitle("Astronauta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Color labelColor = new Color(0, 0, 0);

        // Create the main panel
        JPanel panel = new JPanel();
        panel.setLayout(null); // Using null layout for absolute positioning
        panel.setBackground(Color.GRAY);

        // Create title label
        JLabel titleLabel = new JLabel("Astronauta");
        titleLabel.setBounds(380, 25, 200, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(labelColor);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBounds(80, 80, 300, 500);
        leftPanel.setBackground(Color.LIGHT_GRAY);
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        // Create left side labels and text fields
        String[] labels = {"Name", "Genre", "Age", "Address", "First flight", "Ok Missions", "KO Missions", "Military Rank"};
        int yOffset = 50;

        for (String label : labels) {
            JLabel tempLabel = new JLabel(label);
            tempLabel.setBounds(30, yOffset, 150, 30);
            tempLabel.setForeground(labelColor);
            tempLabel.setFont(new Font("Arial", Font.BOLD, 13));
            leftPanel.add(tempLabel);

            JTextField tempField = new JTextField();
            tempField.setBounds(130, yOffset, 120, 30);
            leftPanel.add(tempField);

            yOffset += 50;
        }

        // Create the right side section with labels, text fields, and buttons
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBounds(400, 80, 500, 500);
        rightPanel.setBackground(Color.LIGHT_GRAY);
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        JLabel localitzacioLabel = new JLabel("Precise Location");
        localitzacioLabel.setBounds(50, 50, 200, 30);
        localitzacioLabel.setForeground(labelColor);
        localitzacioLabel.setFont(new Font("Arial", Font.BOLD, 16));
        rightPanel.add(localitzacioLabel);

        JTextField localitzacioField1 = new JTextField();
        localitzacioField1.setBounds(50, 90, 100, 30);
        rightPanel.add(localitzacioField1);

        JTextField localitzacioField2 = new JTextField();
        localitzacioField2.setBounds(160, 90, 100, 30);
        rightPanel.add(localitzacioField2);

        JTextField localitzacioField3 = new JTextField();
        localitzacioField3.setBounds(270, 90, 100, 30);
        rightPanel.add(localitzacioField3);

        JButton enviarButton1 = new JButton("SEND");
        enviarButton1.setBounds(390, 90, 80, 30);
        enviarButton1.setBackground(Color.GREEN);
        rightPanel.add(enviarButton1);

        JLabel misatgeLabel = new JLabel("Encrypted Message");
        misatgeLabel.setBounds(50, 170, 200, 30);
        misatgeLabel.setForeground(labelColor);
        misatgeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        rightPanel.add(misatgeLabel);

        JTextField misatgeField = new JTextField();
        misatgeField.setBounds(50, 210, 320, 30);
        rightPanel.add(misatgeField);

        JButton enviarButton2 = new JButton("SEND");
        enviarButton2.setBounds(390, 210, 80, 30);
        enviarButton2.setBackground(Color.GREEN);
        rightPanel.add(enviarButton2);

        // Add right panel to main panel
        panel.add(rightPanel);
        panel.add(leftPanel);

        // Add the main panel to the frame
        add(panel, BorderLayout.CENTER);

        // Ensure components are properly displayed
        panel.revalidate();
        panel.repaint();

        // Finally, make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        AstronautView astronautaInterface = new AstronautView();
    }
    
}
