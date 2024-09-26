package View;

import Model.AdminModel;
import Rols.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminView extends JFrame {
    private JTable tablaUsuarios;

    public JTable getTablaUsuarios() {
        return tablaUsuarios;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public ArrayList<User> getListaUsuarios() {
        return listaUsuarios;
    }

    private DefaultTableModel modeloTabla;
    private ArrayList<User> listaUsuarios;

    public AdminView() throws SQLException {

        listaUsuarios = AdminModel.getUsers();


        setTitle("Administrador de Usuarios");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        String[] columnas = {"ID", "Nombre", "Rol"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaUsuarios = new JTable(modeloTabla);
        loadUsersInTable();

        JScrollPane scrollPane = new JScrollPane(tablaUsuarios);
        add(scrollPane, BorderLayout.CENTER);
        AdminModel.getUsers();

        JButton btnCrear = new JButton("Crear");

        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnAsignarRol = new JButton("Asignar Rol");
        JPanel panelBotones = new JPanel();

        panelBotones.add(btnCrear);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnAsignarRol);
        add(panelBotones, BorderLayout.SOUTH);

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (tablaUsuarios.getSelectedRow() != -1) {
                        new UserEditionView((int) tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0), "Editar");
                    }
                    else {
                        JOptionPane.showMessageDialog(new AdminView(), "Selecciona un usuario para editar.");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnAsignarRol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (tablaUsuarios.getSelectedRow() != -1) {
                        new UserEditionView((int) tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0), "Asignar Rol");
                    }
                    else {
                        JOptionPane.showMessageDialog(new AdminView(), "Selecciona un usuario para editar.");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (tablaUsuarios.getSelectedRow() != -1) {
                        new UserEditionView(-1, "Crear");
                    }
                    else {
                        JOptionPane.showMessageDialog(new AdminView(), "Selecciona un usuario para editar.");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (tablaUsuarios.getSelectedRow() != -1) {
                        new UserEditionView((int) tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0), "Eliminar");
                    }
                    else {
                        JOptionPane.showMessageDialog(new AdminView(), "Selecciona un usuario para editar.");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }

    private void loadUsersInTable() {
        modeloTabla.setRowCount(0);
        for (User usuario : listaUsuarios) {
            Object[] fila = {usuario.getId(), usuario.getNombre(), usuario.getRol()};
            modeloTabla.addRow(fila);
        }
    }


    private void eliminarUsuario() {
        int filaSeleccionada = tablaUsuarios.getSelectedRow();
        if (filaSeleccionada != -1) {
            listaUsuarios.remove(filaSeleccionada);
            loadUsersInTable();
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un usuario para eliminar.");
        }
    }

    private void asignarRol() {
        int filaSeleccionada = tablaUsuarios.getSelectedRow();
        if (filaSeleccionada != -1) {
            String nuevoRol = JOptionPane.showInputDialog(this, "Asignar nuevo rol:",
                    tablaUsuarios.getValueAt(filaSeleccionada, 2).toString());
            if (nuevoRol != null && !nuevoRol.isEmpty()) {
                listaUsuarios.get(filaSeleccionada).setRol(nuevoRol);
                loadUsersInTable();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un usuario para asignar un rol.");
        }
    }

    public static void main(String[] args) throws SQLException {
        new AdminView().setVisible(true);
    }
}