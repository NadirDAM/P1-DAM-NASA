package View;

import javax.swing.*;
import java.awt.*;

public class FisicView extends JFrame {

    public FisicView() {
        // Set the frame properties
        setBounds(600, 600, 1000, 700);
        setTitle("FISIC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Color labelColor = new Color(0, 0, 0);

        // Create the main panel
        JPanel panel = new JPanel();
        panel.setLayout(null); // Using null layout for absolute positioning
        panel.setBackground(Color.GRAY);

        // Create title label
        JLabel titleLabel = new JLabel("FISIC");
        titleLabel.setBounds(400, 50, 200, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(titleLabel);

        // Create left side labels and text fields
        String[] labels = {"Nom", "Sexe", "Edat", "Adreça", "Ciutat", "Titulacio Academica", "Anys d'experiencia", "Salari"};
        int yOffset = 100;

        for (String label : labels) {
            JLabel tempLabel = new JLabel( label);
            tempLabel.setBounds(50, yOffset, 150, 30);
            tempLabel.setForeground(labelColor);
            panel.add(tempLabel);

            JTextField tempField = new JTextField();
            tempField.setBounds(200, yOffset, 150, 30);
            tempField.setEditable(false);
            panel.add(tempField);

            yOffset += 50;
        }

        // Create the right side section with buttons, combo box, and text fields
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBounds(400, 100, 500, 500);
        rightPanel.setBackground(Color.LIGHT_GRAY);
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        JButton entradaButton = new JButton("Entrada");
        entradaButton.setBounds(50, 50, 150, 50);
        entradaButton.setBackground(Color.GREEN);
        rightPanel.add(entradaButton);

        JButton sortidaButton = new JButton("Sortida");
        sortidaButton.setBounds(250, 50, 150, 50);
        sortidaButton.setBackground(Color.RED);
        rightPanel.add(sortidaButton);

        JLabel planetaLabel = new JLabel("Planeta");
        planetaLabel.setBounds(50, 150, 100, 30);
        rightPanel.add(planetaLabel);

        String[] planets = {"SOL"};
        JComboBox<String> planetCombo = new JComboBox<>(planets);
        planetCombo.setBounds(100, 150, 150, 30);
        rightPanel.add(planetCombo);

        JButton calcularButton = new JButton("Calcular");
        calcularButton.setBounds(270, 150, 100, 30);
        calcularButton.setBackground(Color.GREEN);
        rightPanel.add(calcularButton);

        JLabel tempsLabel = new JLabel("Temps / Anys");
        tempsLabel.setBounds(50, 250, 100, 30);
        rightPanel.add(tempsLabel);

        JTextField tempsField = new JTextField();
        tempsField.setBounds(200, 250, 200, 30);
        rightPanel.add(tempsField);

        JLabel costLabel = new JLabel("Cost Economic / Area");
        costLabel.setBounds(50, 350, 150, 30);
        rightPanel.add(costLabel);

        JTextField costField = new JTextField();
        costField.setBounds(200, 350, 200, 30);
        rightPanel.add(costField);

        // Add right panel to main panel
        panel.add(rightPanel);

        // Add the main panel to the frame
        add(panel, BorderLayout.CENTER);

        // Ensure components are properly displayed
        panel.revalidate();
        panel.repaint();

        // Finally, make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        FisicView fisicInterface = new FisicView();
    }
}
