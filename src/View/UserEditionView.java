package View;

import Model.AdminModel;
import Rols.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class UserEditionView extends JFrame {

    public UserEditionView(int id, String function) throws SQLException {
    System.out.println(id);
    System.out.println(function);
        setVisible(true);
        setTitle("User Edition");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel southPanel = new JPanel(new GridLayout(1,3));
        JPanel centerPanel = new JPanel(new GridLayout(9,2));

        JButton goBack = new JButton("Go Back");

        // Add rols to ComboBox
        ArrayList<String> rols = AdminModel.getRols(id, function.equals("Editar"));
        JComboBox rolsBox = new JComboBox();
        for (String rol : rols) {
            rolsBox.addItem(rol);
        }
        rolsBox.setMaximumSize(new Dimension(1,1));

        // Afegir Botons d'abaix.
        JButton btnExecutar = new JButton(function);
        JPanel buttonPanel = new JPanel();


        // Fields
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        TextField textField4 = new TextField();
        TextField textField5 = new TextField();
        TextField textField6 = new TextField();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        JFormattedTextField dateField1 = new JFormattedTextField(df);
        JFormattedTextField dateField2 = new JFormattedTextField(df);



        buttonPanel.add(btnExecutar);

        southPanel.add(goBack);
        southPanel.add(rolsBox);

        add(southPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        rolsBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRolFields(rolsBox.getSelectedItem().toString());

            }

            private void showRolFields (String rol) {
                clearCenterPanel();

                    if (rol.equalsIgnoreCase("mechanic")) {
                        centerPanel.add(new Label("Name"));
                        centerPanel.add(textField1);
                        centerPanel.add(new Label("Birthday"));
                        centerPanel.add(dateField1);
                        centerPanel.add(new Label("Graduated"));
                        centerPanel.add(dateField2);
                        centerPanel.add(new Label("Workplace"));
                        centerPanel.add(textField2);
                    }

                    else if (rol.equalsIgnoreCase("spy")) {
                        centerPanel.add(new Label("Code Name"));
                        centerPanel.add(textField1);
                        centerPanel.add(new Label("Phone"));
                        centerPanel.add(textField2);
                    }
                    else if (rol.equalsIgnoreCase("astronaut")) {
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
                    }
                    else if (rol.equalsIgnoreCase("physicist")) {
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
                    }
            }
            private void clearCenterPanel () {
                centerPanel.removeAll();
                centerPanel.repaint();
            }


        });

        System.out.println(textField1);
        System.out.println(dateField1);
        System.out.println(dateField2);
        System.out.println(textField2);

        btnExecutar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                String rol = rolsBox.getSelectedItem().toString();
                if (rol.equalsIgnoreCase("mechanic")) {
                    if (textField1.getText().isEmpty() || dateField1.getText().isEmpty() || dateField2.getText().isEmpty() || textField2.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(new AdminView(), "All fields are required, there are empty fields.");
                    }
                }

                else if (rol.equalsIgnoreCase("spy")) {
                    if (textField1.getText().isEmpty() || textField2.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(new AdminView(),"All fields are required, there are empty fields.");

                    }
                }
                else if (rol.equalsIgnoreCase("astronaut")) {
                    if (textField1.getText().isEmpty() || dateField1.getText().isEmpty() || dateField2.getText().isEmpty() ||
                        textField2.getText().isEmpty() || textField3.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(new AdminView(), "All fields are required, there are empty fields.");

                    }
                }
                else if (rol.equalsIgnoreCase("physicist")) {
                    if (textField1.getText().isEmpty() || dateField1.getText().isEmpty() || dateField2.getText().isEmpty() ||
                         textField2.getText().isEmpty() || textField3.getText().isEmpty() || textField4.getText().isEmpty() ||
                         textField5.getText().isEmpty() || textField6.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(new AdminView(), "All fields are required, there are empty fields.");
                    }
                }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}