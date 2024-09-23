package View;

import java.awt.*;
import javax.swing.*;

public class FisicView extends JFrame {

    public FisicView() {
        setBounds(600, 600, 1000, 700);
        setTitle("FISIC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        Color labelColor = new Color(0, 0, 0);

        JPanel panel = new JPanel();
        panel.setLayout(null); 
        panel.setBackground(Color.GRAY);

        JLabel titleLabel = new JLabel("FISIC");
        titleLabel.setBounds(400, 50, 200, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(titleLabel);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBounds(80, 100, 300, 500);
        leftPanel.setBackground(Color.LIGHT_GRAY);
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        String[] labels = {"Name", "Genre", "Age", "Address", "City", "Academic Qualifications", "Experience", "Salary"};
        int yOffset = 50;

        for (String label : labels) {
            JLabel tempLabel = new JLabel( label);
            tempLabel.setBounds(20, yOffset, 150, 30);
            tempLabel.setForeground(labelColor);
            leftPanel.add(tempLabel);

            JTextField tempField = new JTextField();
            tempField.setBounds(180, yOffset, 100, 30);
            tempField.setEditable(false);
            leftPanel.add(tempField);

            yOffset += 50;
        }

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBounds(400, 100, 500, 500);
        rightPanel.setBackground(Color.LIGHT_GRAY);
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        JButton entradaButton = new JButton("Check-In");
        entradaButton.setBounds(100, 50, 150, 50);
        entradaButton.setBackground(Color.GREEN);
        rightPanel.add(entradaButton);

        JButton sortidaButton = new JButton("Check-Out");
        sortidaButton.setBounds(260, 50, 150, 50);
        sortidaButton.setBackground(Color.RED);
        rightPanel.add(sortidaButton);

        JLabel planetaLabel = new JLabel("Planet");
        planetaLabel.setBounds(30, 150, 100, 30);
        rightPanel.add(planetaLabel);

        String[] planets = {"SUN", "MERCURY", "VENUS", "MARS", "JUPITER", "SATURN", "URANUS", "NEPTUNE", "PLUTO"};
        JComboBox<String> planetCombo = new JComboBox<>(planets);
        planetCombo.setBounds(80, 150, 370, 30);
        rightPanel.add(planetCombo);

        JButton calcularTimeButton = new JButton("Calculate");
        calcularTimeButton.setBounds(350, 350, 100, 30);
        calcularTimeButton.setBackground(Color.GREEN);
        rightPanel.add(calcularTimeButton);

        JButton calcularAreaButton = new JButton("Calculate");
        calcularAreaButton.setBounds(350, 250, 100, 30);
        calcularAreaButton.setBackground(Color.GREEN);
        rightPanel.add(calcularAreaButton);

        JLabel tempsLabel = new JLabel("Time / Years");
        tempsLabel.setBounds(30, 250, 100, 30);
        rightPanel.add(tempsLabel);

        JTextField tempsField = new JTextField();
        tempsField.setBounds(170, 250, 160, 30);
        rightPanel.add(tempsField);

        JLabel costLabel = new JLabel("Area / Economic cost");
        costLabel.setBounds(30, 350, 150, 30);
        rightPanel.add(costLabel);

        JTextField costField = new JTextField();
        costField.setBounds(170, 350, 160, 30);
        rightPanel.add(costField);

        panel.add(rightPanel);
        panel.add(leftPanel);

        add(panel, BorderLayout.CENTER);

        panel.revalidate();
        panel.repaint();

        setVisible(true);
    }
    
    public static void main(String[] args) {
        FisicView fisicInterface = new FisicView();
    }
}
