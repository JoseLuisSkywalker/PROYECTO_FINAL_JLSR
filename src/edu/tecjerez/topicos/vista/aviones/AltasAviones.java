package edu.tecjerez.topicos.vista.aviones;

import javax.swing.*;
import java.awt.*;

public class AltasAviones {
    public static AltasAviones instancia;
    JInternalFrame ventanaAltas;
    JDesktopPane desktopPaneAltas;


    public AltasAviones(){
        this.desktopPaneAltas = new JDesktopPane();
        ventanaAltas = new JInternalFrame();
        ventanaAltas.setSize(500, 700);
        ventanaAltas.setClosable(true);
        ventanaAltas.setIconifiable(true);
        ventanaAltas.setResizable(true);
        ventanaAltas.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ventanaAltas.getContentPane().setLayout(new GridLayout());

        JPanel panelCampos = new JPanel(new GridLayout(15, 2, 5, 5));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelCampos.setBackground(new Color(181, 213, 183));

        // 1. Número de registro
        panelCampos.add(new JLabel("Número de registro:"));
        JTextField campoRegistro = new JTextField();
        panelCampos.add(campoRegistro);

        // 2. Modelo de avión
        panelCampos.add(new JLabel("Modelo de avión:"));
        JTextField campoModelo = new JTextField();
        panelCampos.add(campoModelo);

        // 3. Capacidad de peso
        panelCampos.add(new JLabel("Capacidad de peso en kilogramos:"));
        JTextField campoPeso = new JTextField();
        panelCampos.add(campoPeso);

        // 4. Examen 1 - Velocidad
        JCheckBox checkExamen1 = new JCheckBox("Examen 1: Velocidad (especificar calificación en el campo)");
        panelCampos.add(checkExamen1);

        // 5. Calificación 1
        SpinnerNumberModel modeloCal1 = new SpinnerNumberModel(0, 0, 100, 1);
        JSpinner spinnerCal1 = new JSpinner(modeloCal1);
        spinnerCal1.setEnabled(false);
        panelCampos.add(spinnerCal1);

        // 6. Examen 2 - Altitud Máxima
        JCheckBox checkExamen2 = new JCheckBox("Examen 2: Altitud Máxima (especificar calificación en el campo");
        panelCampos.add(checkExamen2);

        // 7. Calificación 2
        SpinnerNumberModel modeloCal2 = new SpinnerNumberModel(0, 0, 100, 1);
        JSpinner spinnerCal2 = new JSpinner(modeloCal2);
        spinnerCal2.setEnabled(false);
        panelCampos.add(spinnerCal2);

        // 8. SSN técnico Examen 1
        panelCampos.add(new JLabel("NSS técnico Examen 1:"));
        JTextField campoSSN1 = new JTextField();
        campoSSN1.setEnabled(false);
        panelCampos.add(campoSSN1);

        // 9. Nombre técnico Examen 1
        panelCampos.add(new JLabel("Nombre técnico Examen 1:"));
        JTextField campoNombreTec1 = new JTextField();
        campoNombreTec1.setEnabled(false);
        panelCampos.add(campoNombreTec1);

        // 10. SSN técnico Examen 2
        panelCampos.add(new JLabel("NSS técnico Examen 2:"));
        JTextField campoSSN2 = new JTextField();
        campoSSN2.setEnabled(false);
        panelCampos.add(campoSSN2);

        // 11. Nombre técnico Examen 2
        panelCampos.add(new JLabel("Nombre técnico Examen 2:"));
        JTextField campoNombreTec2 = new JTextField();
        campoNombreTec2.setEnabled(false);
        panelCampos.add(campoNombreTec2);

        // 12. Fecha examen 1
        panelCampos.add(new JLabel("Fecha Examen 1:"));
        JPanel panelFecha1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JSpinner dia1 = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
        JSpinner mes1 = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
        JSpinner año1 = new JSpinner(new SpinnerNumberModel(2024, 1900, 2100, 1));
        dia1.setEnabled(false); mes1.setEnabled(false); año1.setEnabled(false);
        panelFecha1.add(dia1); panelFecha1.add(mes1); panelFecha1.add(año1);
        panelCampos.add(panelFecha1);

        // 13. Fecha examen 2
        panelCampos.add(new JLabel("Fecha Examen 2:"));
        JPanel panelFecha2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JSpinner dia2 = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
        JSpinner mes2 = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
        JSpinner año2 = new JSpinner(new SpinnerNumberModel(2024, 1900, 2100, 1));
        dia2.setEnabled(false); mes2.setEnabled(false); año2.setEnabled(false);
        panelFecha2.add(dia2); panelFecha2.add(mes2); panelFecha2.add(año2);
        panelCampos.add(panelFecha2);

        // 14. Tiempo en aire examen 1
        panelCampos.add(new JLabel("Tiempo en aire examen 1 (min):"));
        JSpinner tiempo1 = new JSpinner(new SpinnerNumberModel(0, 0, 999, 1));
        tiempo1.setEnabled(false);
        panelCampos.add(tiempo1);

        // 15. Tiempo en aire examen 2
        panelCampos.add(new JLabel("Tiempo en aire examen 2 (min):"));
        JSpinner tiempo2 = new JSpinner(new SpinnerNumberModel(0, 0, 999, 1));
        tiempo2.setEnabled(false);
        panelCampos.add(tiempo2);

        // Agregar lógica para habilitar campos cuando se seleccionen los checkboxes
        checkExamen1.addActionListener(e -> {
            boolean activo = checkExamen1.isSelected();
            spinnerCal1.setEnabled(activo);
            campoSSN1.setEnabled(activo);
            campoNombreTec1.setEnabled(activo);
            dia1.setEnabled(activo);
            mes1.setEnabled(activo);
            año1.setEnabled(activo);
            tiempo1.setEnabled(activo);
        });

        checkExamen2.addActionListener(e -> {
            boolean activo = checkExamen2.isSelected();
            spinnerCal2.setEnabled(activo);
            campoSSN2.setEnabled(activo);
            campoNombreTec2.setEnabled(activo);
            dia2.setEnabled(activo);
            mes2.setEnabled(activo);
            año2.setEnabled(activo);
            tiempo2.setEnabled(activo);
        });

        ventanaAltas.add(panelCampos, BorderLayout.CENTER);
        ventanaAltas.pack();
    }

    //altas aviones singleton verificacion ----------

    public static AltasAviones getInstancia() {
        if (instancia == null) {
            instancia = new AltasAviones();
        }
        return instancia;
    }

    public JInternalFrame getVentana() {
        return ventanaAltas;
    }
}

