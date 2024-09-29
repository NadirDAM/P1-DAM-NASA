package View;

import Controller.AstronautController;
import Model.AstronautModel;
import java.awt.*;
import javax.swing.*;

public class AstronautView extends JFrame {
    private JTextField[] leftTextFields = new JTextField[8]; // Updated size to 8
    private JTextField misatgeField;
    private JTextField localitzacioField1;
    private JTextField localitzacioField2;
    private JTextField localitzacioField3;
    JButton enviarButton1;
    JButton enviarButton2;

    public AstronautView(int userId) {
        setBounds(600, 600, 1000, 700);
        setTitle("Astronauta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        Color labelColor = new Color(0, 0, 0);
        Color buttonColor = new Color(227, 227, 227);

        BackgroundPanel panel = new BackgroundPanel("../Images/USA_Flag.png");
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);

        JLabel titleLabel = new JLabel("Astronaut");
        titleLabel.setBounds(380, 20, 200, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(labelColor);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBounds(80, 80, 300, 500);
        leftPanel.setBackground(Color.LIGHT_GRAY);
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        String[] labels = {"Name", "Genre", "Age", "Address", "First flight", "Ok Missions", "KO Missions", "Military Rank"};
        int yOffset = 50;

        for (int i = 0; i < labels.length; i++) {
            JLabel tempLabel = new JLabel(labels[i]);
            tempLabel.setBounds(30, yOffset, 150, 30);
            tempLabel.setForeground(labelColor);
            tempLabel.setFont(new Font("Arial", Font.BOLD, 13));
            leftPanel.add(tempLabel);

            JTextField tempField = new JTextField();
            tempField.setBounds(130, yOffset, 120, 30);
            tempField.setEditable(false);
            leftTextFields[i] = tempField; // Store text fields for later access
            leftPanel.add(tempField);

            yOffset += 50;
        }

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

        localitzacioField1 = new JTextField();
        localitzacioField1.setBounds(50, 90, 100, 30);
        rightPanel.add(localitzacioField1);

        localitzacioField2 = new JTextField();
        localitzacioField2.setBounds(160, 90, 100, 30);
        rightPanel.add(localitzacioField2);

        localitzacioField3 = new JTextField();
        localitzacioField3.setBounds(270, 90, 100, 30);
        rightPanel.add(localitzacioField3);

        enviarButton1 = new JButton("SEND");
        enviarButton1.setBounds(390, 90, 80, 30);
        enviarButton1.setBackground(buttonColor);
        rightPanel.add(enviarButton1);

        JLabel misatgeLabel = new JLabel("Encrypted Message");
        misatgeLabel.setBounds(50, 170, 200, 30);
        misatgeLabel.setForeground(labelColor);
        misatgeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        rightPanel.add(misatgeLabel);

        misatgeField = new JTextField();
        misatgeField.setBounds(50, 210, 320, 30);
        rightPanel.add(misatgeField);

        enviarButton2 = new JButton("SEND");
        enviarButton2.setBounds(390, 210, 80, 30);
        enviarButton2.setBackground(buttonColor);
        rightPanel.add(enviarButton2);

        BackgroundPanel nasaImage = new BackgroundPanel("../Images/Nasa_Logo.png");
        nasaImage.setBounds(100, 270, 310, 210);
        nasaImage.setLayout(null);
        rightPanel.add(nasaImage);

        panel.add(rightPanel);
        panel.add(leftPanel);

        add(panel, BorderLayout.CENTER);

        panel.revalidate();
        panel.repaint();

        setVisible(true);
    }

    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String filePath) {
            try {
                backgroundImage = new ImageIcon(getClass().getResource(filePath)).getImage();
            } catch (Exception e) {
                e.printStackTrace();
            }
            setLayout(null);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    public static void main(String[] args) {
        AstronautModel model = new AstronautModel();
        AstronautView view = new AstronautView(1); // Use dummy user ID
        AstronautController controller = new AstronautController(model, view);
    }

    // Getter methods for the controller to access components
    public JTextField getCoordinateField1() {
        return localitzacioField1;
    }

    public JTextField getCoordinateField2() {
        return localitzacioField2;
    }

    public JTextField getCoordinateField3() {
        return localitzacioField3;
    }

    public JTextField getEncryptedMessageField() {
        return misatgeField;
    }

    public JButton getSendButton1() {
        return enviarButton1;
    }

    public JButton getSendButton2() {
        return enviarButton2;
    }

    public void setName(String name) {
        leftTextFields[0].setText(name);
    }

    public void setGenre(String genre) {
        leftTextFields[1].setText(genre);
    }

    public void setAge(int age) {
        leftTextFields[2].setText(String.valueOf(age));
    }

    public void setAddress(String address) {
        leftTextFields[3].setText(address);
    }

    public void setFirstFly(String firstFly) {
        leftTextFields[4].setText(firstFly);
    }

    public void setSuccessMission(int success) {
        leftTextFields[5].setText(String.valueOf(success));
    }

    public void setFailMission(int fail) {
        leftTextFields[6].setText(String.valueOf(fail));
    }

    public void setRange(String range) {
        leftTextFields[7].setText(range);
    }
}
