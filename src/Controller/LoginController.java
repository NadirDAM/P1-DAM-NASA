package Controller;

import Model.LoginModel;
import Model.AstronautModel;
import View.AstronautView;
import View.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private LoginModel model;
    private LoginView view;

    public LoginController(LoginModel model, LoginView view) {
        this.model = model;
        this.view = view;

        addListeners();
    }

    private void addListeners() {
        view.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });
    }

    private void handleLogin() {
        String username = view.getUsername();
        String password = view.getPassword();
        String role = view.getSelectedRole();

        if (model.validateUser(username, password)) {
            int userId = model.getUserId(username);
            if (role.equals("Astronaut")) {
                // Create an instance of AstronautModel to pass to the view and controller
                AstronautModel astronautModel = new AstronautModel();
                AstronautView astronautView = new AstronautView(userId);
                // Create the AstronautController to connect the model and view
                new AstronautController(astronautModel, astronautView);
                view.dispose(); // Close the login view
            } else {
                JOptionPane.showMessageDialog(view, "Access granted for role: " + role);
                view.dispose(); // Close the login view
            }
        } else {
            JOptionPane.showMessageDialog(view, "Invalid username or password");
        }
    }
}
