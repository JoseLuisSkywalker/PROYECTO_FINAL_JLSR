package edu.tecjerez.topicos.vista.aviones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BajasAviones implements ActionListener {
    public static BajasAviones instancia;
    JInternalFrame ventanaBajas;
    JDesktopPane desktopPaneBajas;
    JPanel panelCajas;
    JTextField cajaRegistro, cajaModelo;
    JButton btnBuscar, btnBorrar, btnRestablecer;

    public BajasAviones() {
        desktopPaneBajas = new JDesktopPane();
        ventanaBajas = new JInternalFrame();
        ventanaBajas.setSize(1000, 400);
        ventanaBajas.setClosable(true);
        ventanaBajas.setIconifiable(true);
        ventanaBajas.setResizable(true);
        ventanaBajas.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ventanaBajas.getContentPane().setLayout(new BorderLayout());

        GridLayout layout = new GridLayout(4, 2, 5, 5);
        panelCajas = new JPanel();
        panelCajas.setLayout(layout);
        EmptyBorder borde = new EmptyBorder(10, 10, 10, 10);
        panelCajas.setBorder(borde);
        Color colorFondo = new Color(213, 181, 181);
        panelCajas.setBackground(colorFondo);

        panelCajas.add(new JLabel("Número de registro:"));
        cajaRegistro = new JTextField();
        panelCajas.add(cajaRegistro);

        panelCajas.add(new JLabel("Modelo de avión:"));
        cajaModelo = new JTextField();
        panelCajas.add(cajaModelo);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(new Color(140, 68, 68));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFocusPainted(false);
        btnBuscar.setBorderPainted(false);
        btnBuscar.setOpaque(true);
        btnBuscar.setContentAreaFilled(true);
        panelCajas.add(btnBuscar);

        btnBuscar.getModel().addChangeListener(e -> {
            ButtonModel model = (ButtonModel) e.getSource();
            if (model.isPressed()) {
                btnBuscar.setBackground(new Color(100, 50, 50));
            } else {
                btnBuscar.setBackground(new Color(140, 68, 68));
            }
        });

        btnBorrar = new JButton("Borrar");
        btnBorrar.setBackground(new Color(140, 68, 68));
        btnBorrar.setForeground(Color.WHITE);
        btnBorrar.setFocusPainted(false);
        btnBorrar.setBorderPainted(false);
        btnBorrar.setOpaque(true);
        btnBorrar.setContentAreaFilled(true);
        panelCajas.add(btnBorrar);

        btnBorrar.getModel().addChangeListener(e -> {
            ButtonModel model = (ButtonModel) e.getSource();
            if (model.isPressed()) {
                btnBorrar.setBackground(new Color(100, 50, 50));
            } else {
                btnBorrar.setBackground(new Color(140, 68, 68));
            }
        });

        btnRestablecer = new JButton("Restablecer");
        btnRestablecer.setBackground(new Color(140, 68, 68, 255));
        btnRestablecer.setForeground(Color.WHITE);
        btnRestablecer.setFocusPainted(false);
        btnRestablecer.setBorderPainted(false);
        btnRestablecer.setOpaque(true);
        btnRestablecer.setContentAreaFilled(true);
        panelCajas.add(btnRestablecer);

        btnRestablecer.getModel().addChangeListener(e -> {
            ButtonModel model = (ButtonModel) e.getSource();
            if (model.isPressed()) {
                btnRestablecer.setBackground(new Color(100, 50, 50));
            } else {
                btnRestablecer.setBackground(new Color(140, 68, 68));
            }
        });

        String[][] filas = new String[34][13];
        for (int i = 0; i < filas.length; i++) {
            for (int j = 0; j < filas[i].length; j++) {
                filas[i][j] = "";
            }
        }

        String[] columnas = {
                "Número de registro", "Modelo de Avión", "Capacidad de Peso",
                "Calificación Examen 1", "NSS Técnico Ex 1", "Nombre Técnico 1", "Fecha Ex 1", "Tiempo Aire 1",
                "Calificación Examen 2", "NSS Técnico Ex 2", "Nombre Técnico 2", "Fecha Ex 2", "Tiempo Aire 2"
        };

        JTable tablaAviones = new JTable(filas, columnas);
        tablaAviones.setEnabled(false);
        tablaAviones.setFillsViewportHeight(true);
        tablaAviones.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tablaAviones.setGridColor(Color.BLACK);
        tablaAviones.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane scrollTabla = new JScrollPane(tablaAviones);
        scrollTabla.setPreferredSize(new Dimension(480, 150));

        ventanaBajas.add(panelCajas, BorderLayout.CENTER);
        ventanaBajas.add(scrollTabla, BorderLayout.SOUTH);


        btnBuscar.addActionListener(this);
        btnBorrar.addActionListener(this);
        btnRestablecer.addActionListener(this);
    }

    public static BajasAviones getInstancia() {
        if (instancia == null) {
            instancia = new BajasAviones();
        }
        return instancia;
    }

    public JInternalFrame getVentana() {
        return ventanaBajas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();

        if (componente == btnRestablecer) {
            cajaRegistro.setText("");
            cajaModelo.setText("");
        }

        if (componente == btnBuscar) {
            JOptionPane.showMessageDialog(null, "Buscar función no implementada todavía.");
        }

        if (componente == btnBorrar) {
            JOptionPane.showMessageDialog(null, "Borrar función no implementada todavía.");
        }
    }
}