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
    private DefaultTableModel modeloTabla;
    private ArrayList<User> listaUsuarios;

    private final Color nasaBlue = new Color(10, 61, 145);
    private final Color nasaWhite = new Color(255, 255, 255);
    private final Color nasaRed = new Color(179, 27, 27);
    private final Color backgroundDark = new Color(23, 28, 36);

    public AdminView() throws SQLException {
        listaUsuarios = AdminModel.getUsers();
        setTitle("NASA User Management System");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(15, 15));

        JLabel title = new JLabel("User Administration", JLabel.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 28));
        title.setOpaque(true);
        title.setBackground(nasaBlue);
        title.setForeground(nasaWhite);
        title.setPreferredSize(new Dimension(getWidth(), 80));
        add(title, BorderLayout.NORTH);

        String[] columnas = {"Id", "Username", "Roles"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaUsuarios = new JTable(modeloTabla);
        tablaUsuarios.setFillsViewportHeight(true);
        tablaUsuarios.setRowHeight(28);
        tablaUsuarios.setFont(new Font("SansSerif", Font.PLAIN, 16));
        tablaUsuarios.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));
        tablaUsuarios.getTableHeader().setBackground(nasaBlue);
        tablaUsuarios.getTableHeader().setForeground(nasaWhite);
        tablaUsuarios.setSelectionBackground(nasaRed);
        tablaUsuarios.setGridColor(nasaBlue);
        JScrollPane scrollPane = new JScrollPane(tablaUsuarios);
        add(scrollPane, BorderLayout.CENTER);
        loadUsersInTable();

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotones.setBackground(backgroundDark);

        JButton btnCrear = createStyledButton("Create User");
        JButton btnEditar = createStyledButton("Edit User");
        JButton btnEliminar = createStyledButton("Delete User");
        JButton btnAsignarRol = createStyledButton("Assign Role");
        JButton btnRefresh = createStyledButton("Refresh");

        panelBotones.add(btnCrear);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnAsignarRol);
        panelBotones.add(btnRefresh);
        add(panelBotones, BorderLayout.SOUTH);

        btnCrear.addActionListener(e -> abrirEdicion(-1, "Crear"));
        btnEditar.addActionListener(e -> abrirEdicionObtenerFila("Editar"));
        btnEliminar.addActionListener(e -> deleteUser("Eliminar"));
        btnAsignarRol.addActionListener(e -> abrirEdicionObtenerFila("Asignar Rol"));
        btnRefresh.addActionListener(e -> {try {loadUsersInTable();} catch (SQLException ex) {throw new RuntimeException(ex);}});
    }

    private void abrirEdicionObtenerFila(String accion) {
        try {
            int filaSeleccionada = tablaUsuarios.getSelectedRow();
            if (filaSeleccionada != -1) {
                int userId = (int) tablaUsuarios.getValueAt(filaSeleccionada, 0);
                new UserEditionView(userId, accion);
            } else {
                mostrarMensaje("Please select a user to " + accion.toLowerCase() + ".");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteUser(String accion) {
        try {
            int filaSeleccionada = tablaUsuarios.getSelectedRow();
            if (filaSeleccionada != -1) {
                int userId = (int) tablaUsuarios.getValueAt(filaSeleccionada, 0);
                AdminModel.deleteUser(userId);
            } else {
                mostrarMensaje("Please select a user to " + accion.toLowerCase() + ".");
            }
            loadUsersInTable();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void abrirEdicion(int id, String accion) {
        try {
            new UserEditionView(id, accion);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void loadUsersInTable() throws SQLException {
        listaUsuarios = AdminModel.getUsers();

        modeloTabla.setRowCount(0);

        for (User usuario : listaUsuarios) {
            String roles = String.join(", ", AdminModel.getRols(usuario.getId(), true));
            modeloTabla.addRow(new Object[]{usuario.getId(), usuario.getNombre(), roles});
        }

        tablaUsuarios.revalidate();
        tablaUsuarios.repaint();
    }


    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("SansSerif", Font.PLAIN, 16));
        button.setBackground(nasaBlue);
        button.setForeground(nasaWhite);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(nasaRed);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(nasaBlue);
            }
        });
        return button;
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) throws SQLException {
        SwingUtilities.invokeLater(() -> {
            try {
                new AdminView().setVisible(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
    }
}
