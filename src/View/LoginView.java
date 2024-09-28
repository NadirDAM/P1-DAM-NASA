package View;

import Controller.LoginController;
import Model.LoginModel;
import java.awt.*;
import javax.swing.*;

public class LoginView extends JFrame {

    private JTextField userText;
    private JPasswordField passText;
    private JComboBox<String> roleCombo;
    private JButton loginButton;

    public LoginView() {
        setBounds(600, 600, 700, 550);
        setTitle("Login");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Font labelFont = new Font("Serif", Font.BOLD, 20);
        Font titleFont = new Font("Arial", Font.BOLD, 24);

        Color labelColor = new Color(0, 0, 0);
        Color buttonColor = new Color(227, 227, 227);

        JPanel panel = new JPanel();
        panel.setLayout(null); // Using null layout for absolute positioning
        panel.setBackground(Color.GRAY);

        JLabel titleLabel = new JLabel("LOGIN");
        titleLabel.setBounds(300, 100, 100, 30);
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(labelColor);
        panel.add(titleLabel);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(200, 200, 100, 30);
        userLabel.setFont(labelFont);
        userLabel.setForeground(labelColor);
        panel.add(userLabel);

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(200, 250, 100, 30);
        passLabel.setFont(labelFont);
        passLabel.setForeground(labelColor);
        panel.add(passLabel);

        JLabel roleLabel = new JLabel("Role");
        roleLabel.setBounds(200, 300, 80, 30);
        roleLabel.setFont(labelFont);
        roleLabel.setForeground(labelColor);
        panel.add(roleLabel);

        userText = new JTextField();
        userText.setBounds(300, 200, 200, 30);
        panel.add(userText);

        passText = new JPasswordField();
        passText.setBounds(300, 250, 200, 30);
        panel.add(passText);

        String[] roles = {"Astronaut", "Physicist", "Admin"};
        roleCombo = new JComboBox<>(roles);
        roleCombo.setBounds(300, 300, 200, 30);
        panel.add(roleCombo);

        loginButton = new JButton("Enter");
        loginButton.setBounds(300, 350, 100, 30);
        loginButton.setBackground(buttonColor);
        panel.add(loginButton);

        add(panel, BorderLayout.CENTER);

        panel.revalidate();
        panel.repaint();

        setVisible(true);
    }

    public String getUsername() {
        return userText.getText();
    }

    public String getPassword() {
        return new String(passText.getPassword());
    }

    public String getSelectedRole() {
        return (String) roleCombo.getSelectedItem();
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public static void main(String[] args) {
        LoginView loginInterface = new LoginView();
        new LoginController(new LoginModel(), loginInterface);
    }
}
