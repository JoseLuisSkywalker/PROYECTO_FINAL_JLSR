package edu.tecjerez.topicos.vista.aviones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltasAviones implements ActionListener {
    public static AltasAviones instancia;
    JInternalFrame ventanaAltas;
    JDesktopPane desktopPaneAltas;
    JPanel panelCajas;
    JTextField cajaRegistro, cajaModelo, cajaPeso, campoNSS1, campoNSS2,campoNombreTec1, campoNombreTec2;
    JComboBox dia1, mes1, año1, dia2, mes2, año2;
    JSpinner spinnerCal1, spinnerCal2, tiempo1, tiempo2;
    JButton btnAgregar, btnRestablecer;
    JCheckBox checkExamen1, checkExamen2;


    public AltasAviones(){
        desktopPaneAltas = new JDesktopPane();
        ventanaAltas = new JInternalFrame();
        ventanaAltas.setSize(500, 700);
        ventanaAltas.setClosable(true);
        ventanaAltas.setIconifiable(true);
        ventanaAltas.setResizable(true);
        ventanaAltas.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ventanaAltas.getContentPane().setLayout(new BorderLayout());

        GridLayout layout = new GridLayout(16, 2, 5, 5);
        panelCajas = new JPanel();
        panelCajas.setLayout(layout);
        EmptyBorder borde = new EmptyBorder(10, 10, 10, 10);
        panelCajas.setBorder(borde);
        Color colorFondo = new Color(181, 213, 183);
        panelCajas.setBackground(colorFondo);

        panelCajas.add(new JLabel("Número de registro:"));
        cajaRegistro = new JTextField();
        panelCajas.add(cajaRegistro);

        panelCajas.add(new JLabel("Modelo de avión:"));
        cajaModelo = new JTextField();
        panelCajas.add(cajaModelo);

        panelCajas.add(new JLabel("Capacidad de peso en kilogramos:"));
        cajaPeso = new JTextField();
        panelCajas.add(cajaPeso);

        checkExamen1 = new JCheckBox("Examen 1: Velocidad (especificar calificación en el campo):");
        panelCajas.add(checkExamen1);

        SpinnerNumberModel modeloCal1 = new SpinnerNumberModel(0, 0, 100, 1);
        spinnerCal1 = new JSpinner(modeloCal1);
        spinnerCal1.setEnabled(false);
        panelCajas.add(spinnerCal1);

        checkExamen2 = new JCheckBox("Examen 2: Altitud Máxima (especificar calificación en el campo):");
        panelCajas.add(checkExamen2);

        SpinnerNumberModel modeloCal2 = new SpinnerNumberModel(0, 0, 100, 1);
        spinnerCal2 = new JSpinner(modeloCal2);
        spinnerCal2.setEnabled(false);
        panelCajas.add(spinnerCal2);

        panelCajas.add(new JLabel("NSS técnico Examen 1:"));
        campoNSS1 = new JTextField();
        campoNSS1.setEnabled(false);
        panelCajas.add(campoNSS1);

        panelCajas.add(new JLabel("Nombre técnico Examen 1:"));
        campoNombreTec1 = new JTextField();
        campoNombreTec1.setEnabled(false);
        panelCajas.add(campoNombreTec1);

        panelCajas.add(new JLabel("NSS técnico Examen 2:"));
        campoNSS2 = new JTextField();
        campoNSS2.setEnabled(false);
        panelCajas.add(campoNSS2);

        panelCajas.add(new JLabel("Nombre técnico Examen 2:"));
        campoNombreTec2 = new JTextField();
        campoNombreTec2.setEnabled(false);
        panelCajas.add(campoNombreTec2);


        panelCajas.add(new JLabel("Fecha Examen 1:"));
        JPanel panelFecha1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dia1 = new JComboBox();
        for(int i = 1; i < 32; i++){
            dia1.addItem(i);
        }
        mes1 = new JComboBox();
        for(int i = 1; i < 13; i++){
            mes1.addItem(i);
        }
        año1 = new JComboBox();
        for(int i = 1900; i < 2101; i++){
            año1.addItem(i);
        }
        dia1.setEnabled(false);
        mes1.setEnabled(false);
        año1.setEnabled(false);

        panelFecha1.add(dia1);
        panelFecha1.add(mes1);
        panelFecha1.add(año1);
        panelCajas.add(panelFecha1);

        panelCajas.add(new JLabel("Fecha Examen 2:"));
        JPanel panelFecha2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dia2 = new JComboBox();
        for(int i = 1; i < 32; i++){
            dia2.addItem(i);
        }
        mes2 = new JComboBox();
        for(int i = 1; i < 13; i++){
            mes2.addItem(i);
        }
        año2 = new JComboBox();
        for(int i = 1900; i < 2101; i++){
            año2.addItem(i);
        }

        dia2.setEnabled(false);
        mes2.setEnabled(false);
        año2.setEnabled(false);

        panelFecha2.add(dia2);
        panelFecha2.add(mes2);
        panelFecha2.add(año2);
        panelCajas.add(panelFecha2);


        panelCajas.add(new JLabel("Tiempo en aire examen 1 (min):"));
        tiempo1 = new JSpinner(new SpinnerNumberModel(0, 0, 999, 1));
        tiempo1.setEnabled(false);
        panelCajas.add(tiempo1);


        panelCajas.add(new JLabel("Tiempo en aire examen 2 (min):"));
        tiempo2 = new JSpinner(new SpinnerNumberModel(0, 0, 999, 1));
        tiempo2.setEnabled(false);
        panelCajas.add(tiempo2);

        btnAgregar = new JButton("Agregar");
        btnAgregar.setBackground(new Color(68, 140, 79));
        panelCajas.add(btnAgregar);
        btnAgregar.setBackground(new Color(68, 140, 79));
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.setFocusPainted(false);
        btnAgregar.setBorderPainted(false);
        btnAgregar.setOpaque(true);
        btnAgregar.setContentAreaFilled(true);

        btnAgregar.getModel().addChangeListener(e -> {
            ButtonModel model = (ButtonModel) e.getSource();
            if (model.isPressed()) {
                btnAgregar.setBackground(new Color(50, 100, 60));
            } else {
                btnAgregar.setBackground(new Color(68, 140, 79));
            }
        });

        btnRestablecer = new JButton("Restablecer");
        btnRestablecer.setBackground(new Color(68, 140, 79));
        panelCajas.add(btnRestablecer);
        btnRestablecer.setBackground(new Color(68, 140, 79));
        btnRestablecer.setForeground(Color.WHITE);
        btnRestablecer.setFocusPainted(false);
        btnRestablecer.setBorderPainted(false);
        btnRestablecer.setOpaque(true);
        btnRestablecer.setContentAreaFilled(true);

        btnRestablecer.getModel().addChangeListener(e -> {
            ButtonModel model = (ButtonModel) e.getSource();
            if (model.isPressed()) {
                btnRestablecer.setBackground(new Color(50, 100, 60));
            } else {
                btnRestablecer.setBackground(new Color(68, 140, 79));
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

        ventanaAltas.add(panelCajas, BorderLayout.CENTER);
        ventanaAltas.add(scrollTabla, BorderLayout.SOUTH);
        ventanaAltas.pack();



        //lista de action listeners ---------
        checkExamen1.addActionListener(this);
        checkExamen2.addActionListener(this);
        btnAgregar.addActionListener(this);
        btnRestablecer.addActionListener(this);


        ventanaAltas.add(panelCajas, BorderLayout.CENTER);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();

        if(componente == checkExamen1){
            boolean activo = checkExamen1.isSelected();
            spinnerCal1.setEnabled(activo);
            campoNSS1.setEnabled(activo);
            campoNombreTec1.setEnabled(activo);
            dia1.setEnabled(activo);
            mes1.setEnabled(activo);
            año1.setEnabled(activo);
            tiempo1.setEnabled(activo);
        }

        if(componente == checkExamen2){
            boolean activo = checkExamen2.isSelected();
            spinnerCal2.setEnabled(activo);
            campoNSS2.setEnabled(activo);
            campoNombreTec2.setEnabled(activo);
            dia2.setEnabled(activo);
            mes2.setEnabled(activo);
            año2.setEnabled(activo);
            tiempo2.setEnabled(activo);
        }
    }
}

