package Controller;

import Model.LoginModel;
import Model.AstronautModel;
import Model.AdminModel;
import View.AstronautView;
import View.LoginView;
import View.AdminView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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

            if ("Astronaut".equals(role) && model.isAstronaut(userId)) {
                AstronautModel astronautModel = new AstronautModel();
                astronautModel.fetchAstronautDetails(userId);
                AstronautView astronautView = new AstronautView(userId);
                AstronautController astronautController = new AstronautController(astronautModel, astronautView);
                view.dispose();
            } else if ("Admin".equals(role) && model.isAdmin(userId)) {
                try {
                    AdminView adminView = new AdminView();
                    view.dispose();
                    adminView.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(view, "Access granted for role: " + role);
                view.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(view, "Invalid username or password");
        }
    }
}
