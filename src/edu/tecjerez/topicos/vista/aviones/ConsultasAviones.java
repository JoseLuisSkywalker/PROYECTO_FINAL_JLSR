package edu.tecjerez.topicos.vista.aviones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultasAviones implements ActionListener {
    public static ConsultasAviones instancia;
    JInternalFrame ventanaBusquedas;
    JDesktopPane desktopPaneBusquedas;
    JPanel panelCajas;
    JTextField cajaRegistro, cajaModelo;
    JButton btnBuscar, btnRestablecer;

    public ConsultasAviones() {
        desktopPaneBusquedas = new JDesktopPane();
        ventanaBusquedas = new JInternalFrame();
        ventanaBusquedas.setSize(1000, 400);
        ventanaBusquedas.setClosable(true);
        ventanaBusquedas.setIconifiable(true);
        ventanaBusquedas.setResizable(true);
        ventanaBusquedas.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ventanaBusquedas.getContentPane().setLayout(new BorderLayout());

        GridLayout layout = new GridLayout(3, 2, 5, 5);
        panelCajas = new JPanel();
        panelCajas.setLayout(layout);
        EmptyBorder borde = new EmptyBorder(10, 10, 10, 10);
        panelCajas.setBorder(borde);
        Color colorFondo = new Color(181, 195, 213);
        panelCajas.setBackground(colorFondo);

        panelCajas.add(new JLabel("Número de registro:"));
        cajaRegistro = new JTextField();
        panelCajas.add(cajaRegistro);

        panelCajas.add(new JLabel("Modelo de avión:"));
        cajaModelo = new JTextField();
        panelCajas.add(cajaModelo);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(new Color(68, 93, 140));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFocusPainted(false);
        btnBuscar.setBorderPainted(false);
        btnBuscar.setOpaque(true);
        btnBuscar.setContentAreaFilled(true);
        panelCajas.add(btnBuscar);

        btnBuscar.getModel().addChangeListener(e -> {
            ButtonModel model = (ButtonModel) e.getSource();
            if (model.isPressed()) {
                btnBuscar.setBackground(new Color(37, 74, 143));
            } else {
                btnBuscar.setBackground(new Color(68, 88, 140));
            }
        });

        btnRestablecer = new JButton("Restablecer");
        btnRestablecer.setBackground(new Color(68, 72, 140));
        btnRestablecer.setForeground(Color.WHITE);
        btnRestablecer.setFocusPainted(false);
        btnRestablecer.setBorderPainted(false);
        btnRestablecer.setOpaque(true);
        btnRestablecer.setContentAreaFilled(true);
        panelCajas.add(btnRestablecer);

        btnRestablecer.getModel().addChangeListener(e -> {
            ButtonModel model = (ButtonModel) e.getSource();
            if (model.isPressed()) {
                btnRestablecer.setBackground(new Color(37, 74, 143));
            } else {
                btnRestablecer.setBackground(new Color(68, 88, 140));
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

        ventanaBusquedas.add(panelCajas, BorderLayout.CENTER);
        ventanaBusquedas.add(scrollTabla, BorderLayout.SOUTH);

        btnBuscar.addActionListener(this);
        btnRestablecer.addActionListener(this);
    }

    public static ConsultasAviones getInstancia() {
        if (instancia == null) {
            instancia = new ConsultasAviones();
        }
        return instancia;
    }

    public JInternalFrame getVentana() {
        return ventanaBusquedas;
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
    }
}