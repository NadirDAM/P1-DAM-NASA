package View;

import Model.AdminModel;
import Rols.Astronaut;
import Rols.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class UserEditionView extends JFrame {

    public UserEditionView(int id, String function) throws SQLException {
        setVisible(true);
        setTitle("User Edition");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel southPanel = new JPanel(new FlowLayout());
        JPanel centerPanel = new JPanel(new GridLayout(9, 2));

        JButton goBack = new JButton("Go Back");



        ArrayList<String> roles = AdminModel.getRols(id, function.equalsIgnoreCase("Editar"));

        JComboBox<String> rolesBox = new JComboBox<>();
        for (String role : roles) {
            rolesBox.addItem(role);
        }





        southPanel.add(goBack);
        southPanel.add(rolesBox);

        add(southPanel, BorderLayout.NORTH);

        add(centerPanel, BorderLayout.CENTER);

        JButton btnExecute = new JButton(function);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnExecute);
        add(buttonPanel, BorderLayout.SOUTH);

        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        TextField textField4 = new TextField();
        TextField textField5 = new TextField();
        TextField textField6 = new TextField();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        JFormattedTextField dateField1 = new JFormattedTextField(df);
        JFormattedTextField dateField2 = new JFormattedTextField(df);


        if (function.equalsIgnoreCase("crear")) {
            roles.add(0,"mechanic");
            roles.add(1,"spy");
            roles.add(2,"astronaut");
            roles.add(3,"physicist");
            rolesBox.setVisible(false);
            centerPanel.add(new Label("Username"));
            centerPanel.add(textField1);
            centerPanel.add(new Label("Password"));
            centerPanel.add(textField2);
        }
        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        rolesBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    showRoleFields(rolesBox.getSelectedItem().toString());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

            private void showRoleFields(String role) throws SQLException {
                clearCenterPanel();

                Astronaut astronaut = AdminModel.getAtronautByID(id);


                if (role.equalsIgnoreCase("mechanic")) {
                    centerPanel.add(new Label("Name"));
                    centerPanel.add(textField1);
                    centerPanel.add(new Label("Birthday"));
                    centerPanel.add(dateField1);
                    centerPanel.add(new Label("Graduated"));
                    centerPanel.add(dateField2);
                    centerPanel.add(new Label("Workplace"));
                    centerPanel.add(textField2);
                    centerPanel.add(new Label("Gender"));
                    centerPanel.add(textField3);
                    centerPanel.add(new Label("Address"));
                    centerPanel.add(textField4);
                    centerPanel.add(new Label("Salary"));
                    centerPanel.add(textField5);

                    if (function.equalsIgnoreCase("Editar")) {
                        textField1.setText("");
                        dateField1.setText("");
                        dateField2.setText("");
                        textField2.setText("");
                    }
                } else if (role.equalsIgnoreCase("spy")) {
                    centerPanel.add(new Label("Code Name"));
                    centerPanel.add(textField1);
                    centerPanel.add(new Label("Phone"));
                    centerPanel.add(textField2);

                    if (function.equalsIgnoreCase("Editar")) {
                        textField1.setText("");
                        textField2.setText("");
                    }
                } else if (role.equalsIgnoreCase("astronaut")) {
                    centerPanel.add(new Label("Name"));
                    centerPanel.add(textField1);
                    centerPanel.add(new Label("Birthday"));
                    centerPanel.add(dateField1);
                    centerPanel.add(new Label("First Fly"));
                    centerPanel.add(dateField2);
                    centerPanel.add(new Label("Address"));
                    centerPanel.add(textField2);
                    centerPanel.add(new Label("Range"));
                    centerPanel.add(textField3);

                    if (function.equalsIgnoreCase("Editar")) {
                        textField1.setText(astronaut.getAst_name());
                        dateField1.setText(astronaut.getAst_birthday());
                        dateField2.setText(astronaut.getAst_first_fly());
                        textField2.setText(astronaut.getAst_address());
                        textField3.setText(astronaut.getAst_range());
                    }
                } else if (role.equalsIgnoreCase("physicist")) {
                    centerPanel.add(new Label("Name"));
                    centerPanel.add(textField1);
                    centerPanel.add(new Label("Birthday"));
                    centerPanel.add(dateField1);
                    centerPanel.add(new Label("Graduated"));
                    centerPanel.add(dateField2);
                    centerPanel.add(new Label("Degree"));
                    centerPanel.add(textField2);
                    centerPanel.add(new Label("Workplace"));
                    centerPanel.add(textField3);
                    centerPanel.add(new Label("Address"));
                    centerPanel.add(textField4);
                    centerPanel.add(new Label("Gender"));
                    centerPanel.add(textField5);
                    centerPanel.add(new Label("Salary"));
                    centerPanel.add(textField6);

                    if (function.equalsIgnoreCase("Editar")) {
                        textField1.setText("");
                        dateField1.setText("");
                        dateField2.setText("");
                        textField2.setText("");
                        textField3.setText("");
                        textField4.setText("");
                        textField5.setText("");
                        textField6.setText("");
                    }
                }

                centerPanel.revalidate();
                centerPanel.repaint();
            }

            private void clearCenterPanel() {
                centerPanel.removeAll();
                centerPanel.revalidate();
                centerPanel.repaint();
            }

        });

        btnExecute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (function.equalsIgnoreCase("crear")) {
                        AdminModel.crearAstronaut(textField1.getText(), textField2.getText());
                        JOptionPane.showMessageDialog(new AdminView(), "User created!.");
                    }
                    else {
                        String role = rolesBox.getSelectedItem().toString();
                        if (role.equalsIgnoreCase("mechanic")) {
                            if (textField1.getText().isEmpty() || dateField1.getText().isEmpty() || dateField2.getText().isEmpty() || textField2.getText().isEmpty() || textField3.getText().isEmpty() || textField4.getText().isEmpty() || textField5.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(new AdminView(), "All fields are required, there are empty fields.");
                            }
                        } else if (role.equalsIgnoreCase("spy")) {
                            if (textField1.getText().isEmpty() || textField2.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(new AdminView(), "All fields are required, there are empty fields.");
                            }
                        } else if (role.equalsIgnoreCase("astronaut")) {
                            if (textField1.getText().isEmpty() || dateField1.getText().isEmpty() || dateField2.getText().isEmpty() || textField2.getText().isEmpty() || textField3.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(new AdminView(), "All fields are required, there are empty fields.");
                            }
                            else {
                                if (function.equalsIgnoreCase("Editar")){
                                    AdminModel.editarAstronaut(id, textField1.getText(), dateField1.getText(), dateField2.getText(), textField2.getText(), textField3.getText());
                                    JOptionPane.showMessageDialog(new AdminView(), "User Modified.");

                                }
                                else if (function.equalsIgnoreCase("Asignar Rol")) {
                                    AdminModel.asignarRolAstronaut(id, textField1.getText(), dateField1.getText(), dateField2.getText(), textField2.getText(), textField3.getText());
                                    JOptionPane.showMessageDialog(new AdminView(), "Rol Assigned.");

                                }
                            }
                        } else if (role.equalsIgnoreCase("physicist")) {
                            if (textField1.getText().isEmpty() || dateField1.getText().isEmpty() || dateField2.getText().isEmpty() || textField2.getText().isEmpty() || textField3.getText().isEmpty() || textField4.getText().isEmpty() || textField5.getText().isEmpty() || textField6.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(new AdminView(), "All fields are required, there are empty fields.");
                            }
                        }
                    }



                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


    }
}
