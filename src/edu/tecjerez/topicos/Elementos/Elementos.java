package edu.tecjerez.topicos.Elementos;

import edu.tecjerez.topicos.controlador.AvionDAO;
import edu.tecjerez.topicos.modelo.ResultSetTableModel;

import javax.swing.*;
import java.sql.SQLException;

public class Elementos extends JFrame {

    private static Elementos instancia;
    public AvionDAO avionDAO = AvionDAO.getInstancia(); // Usando patrón Singleton

    private Elementos() {
    }

    public static Elementos getInstancia() {
        if (instancia == null) {
            instancia = new Elementos();
        }
        return instancia;
    }

    public void actualizarTabla(JTable tabla) {
        final String CONTROLADOR_JDBC = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/topicos_2025";
        final String CONSULTA = "SELECT * FROM Aviones";

        try {
            ResultSetTableModel modelo = new ResultSetTableModel(CONTROLADOR_JDBC, URL, CONSULTA);
            tabla.setModel(modelo);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void restablecer(JComponent... componentes) {
        for (JComponent c : componentes) {
            if (c instanceof JTextField) {
                ((JTextField) c).setText("");
            } else if (c instanceof JComboBox) {
                ((JComboBox<?>) c).setSelectedIndex(0);
            } else if (c instanceof JRadioButton) {
                ((JRadioButton) c).setSelected(true);
            }
        }
    }

    public boolean validacion(JComponent... componente) {
        boolean cajas = true;
        boolean combos = true;

        for (JComponent c : componente) {
            if (c instanceof JTextField) {
                if (((JTextField) c).getText().trim().isEmpty()) {
                    cajas = false;
                }
            }

            if (c instanceof JComboBox) {
                if (((JComboBox<?>) c).getSelectedIndex() == 0) {
                    combos = false;
                }
            }
        }

        return cajas && combos;
    }
}