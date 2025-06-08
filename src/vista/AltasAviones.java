package vista;

import controlador.AvionDAO;
import modelo.Avion;
import modelo.ResultSetTableModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltasAviones extends JInternalFrame implements ActionListener {
    JPanel panelCajas, panelTabla, panelBotones;
    JTextField cajaRegistro, cajaModelo, cajaPeso, campoNSS1, campoNSS2, campoNombreTec1, campoNombreTec2;
    JComboBox<Integer> dia1, mes1, año1, dia2, mes2, año2;
    JSpinner spinnerCal1, spinnerCal2, tiempo1, tiempo2;
    JButton btnAgregar, btnLimpiar, btnActualizar;
    JTable tablaAviones;
    JScrollPane scrollPane;

    public AltasAviones() {
        this.setTitle("Agregar Aviones");
        this.setSize(1200, 700);
        this.setClosable(true);
        this.setIconifiable(true);
        this.setResizable(true);
        this.setMaximizable(true);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());

        inicializarComponentes();
        configurarEventos();
        actualizarTablaAviones();
    }

    private void inicializarComponentes() {
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JPanel panelIzquierdo = new JPanel(new BorderLayout());
        panelIzquierdo.setPreferredSize(new Dimension(500, 800));

        panelCajas = new JPanel(new GridLayout(16, 2, 5, 5));
        panelCajas.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelCajas.setBackground(new Color(159, 195, 130, 255));

        // Campo registro
        panelCajas.add(new JLabel("Número de registro:"));
        cajaRegistro = new JTextField();
        panelCajas.add(cajaRegistro);

        // Campo modelo
        panelCajas.add(new JLabel("Modelo de avión:"));
        cajaModelo = new JTextField();
        panelCajas.add(cajaModelo);

        // Campo peso
        panelCajas.add(new JLabel("Capacidad de peso (kg):"));
        cajaPeso = new JTextField();
        panelCajas.add(cajaPeso);

        // Calificación examen 1
        panelCajas.add(new JLabel("Examen 1 (vuelo) calificación:"));
        spinnerCal1 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelCajas.add(spinnerCal1);

        // NSS técnico 1
        panelCajas.add(new JLabel("NSS técnico Examen 1:"));
        campoNSS1 = new JTextField();
        panelCajas.add(campoNSS1);

        // Nombre técnico 1
        panelCajas.add(new JLabel("Nombre técnico Examen 1:"));
        campoNombreTec1 = new JTextField();
        panelCajas.add(campoNombreTec1);

        // Fecha examen 1
        panelCajas.add(new JLabel("Fecha Examen 1:"));
        JPanel panelFecha1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dia1 = new JComboBox<>();
        mes1 = new JComboBox<>();
        año1 = new JComboBox<>();
        for (int i = 1; i <= 31; i++) dia1.addItem(i);
        for (int i = 1; i <= 12; i++) mes1.addItem(i);
        for (int i = 1900; i <= 2100; i++) año1.addItem(i);
        panelFecha1.add(dia1);
        panelFecha1.add(mes1);
        panelFecha1.add(año1);
        panelCajas.add(panelFecha1);

        // Tiempo aire 1
        panelCajas.add(new JLabel("Tiempo en aire examen 1 (min):"));
        tiempo1 = new JSpinner(new SpinnerNumberModel(0, 0, 999, 1));
        panelCajas.add(tiempo1);

        // Calificación examen 2
        panelCajas.add(new JLabel("Examen 2 (altura) calificación:"));
        spinnerCal2 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelCajas.add(spinnerCal2);

        // NSS técnico 2
        panelCajas.add(new JLabel("NSS técnico Examen 2:"));
        campoNSS2 = new JTextField();
        panelCajas.add(campoNSS2);

        // Nombre técnico 2
        panelCajas.add(new JLabel("Nombre técnico Examen 2:"));
        campoNombreTec2 = new JTextField();
        panelCajas.add(campoNombreTec2);

        // Fecha examen 2
        panelCajas.add(new JLabel("Fecha Examen 2:"));
        JPanel panelFecha2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dia2 = new JComboBox<>();
        mes2 = new JComboBox<>();
        año2 = new JComboBox<>();
        for (int i = 1; i <= 31; i++) dia2.addItem(i);
        for (int i = 1; i <= 12; i++) mes2.addItem(i);
        for (int i = 1900; i <= 2100; i++) año2.addItem(i);
        panelFecha2.add(dia2);
        panelFecha2.add(mes2);
        panelFecha2.add(año2);
        panelCajas.add(panelFecha2);

        // Tiempo aire 2
        panelCajas.add(new JLabel("Tiempo en aire examen 2 (min):"));
        tiempo2 = new JSpinner(new SpinnerNumberModel(0, 0, 999, 1));
        panelCajas.add(tiempo2);

        panelBotones = new JPanel(new FlowLayout());
        btnAgregar = new JButton("Agregar Avión");
        btnLimpiar = new JButton("Limpiar Campos");
        btnActualizar = new JButton("Actualizar Tabla");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnActualizar);

        panelIzquierdo.add(panelCajas, BorderLayout.CENTER);
        panelIzquierdo.add(panelBotones, BorderLayout.SOUTH);

        JPanel panelDerecho = new JPanel(new BorderLayout());
        panelDerecho.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel lblTabla = new JLabel("Lista de Aviones", JLabel.CENTER);
        lblTabla.setFont(new Font("Arial", Font.BOLD, 16));
        panelDerecho.add(lblTabla, BorderLayout.NORTH);

        tablaAviones = new JTable();
        tablaAviones.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tablaAviones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane = new JScrollPane(tablaAviones);
        panelDerecho.add(scrollPane, BorderLayout.CENTER);

        splitPane.setLeftComponent(panelIzquierdo);
        splitPane.setRightComponent(panelDerecho);
        splitPane.setDividerLocation(500);
        splitPane.setResizeWeight(0.4);

        this.add(splitPane, BorderLayout.CENTER);
    }

    private void configurarEventos() {
        btnAgregar.addActionListener(this);
        btnLimpiar.addActionListener(this);
        btnActualizar.addActionListener(this);

        cajaRegistro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soloNumeros(evt);
            }
        });
        cajaPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soloNumeros(evt);
            }
        });
        campoNSS1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soloNumeros(evt);
            }
        });
        campoNSS2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soloNumeros(evt);
            }
        });
        campoNombreTec1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soloLetras(evt);
            }
        });
        campoNombreTec2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soloLetras(evt);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgregar) {
            agregarAvion();
        } else if (e.getSource() == btnLimpiar) {
            limpiarCampos();
        } else if (e.getSource() == btnActualizar) {
            actualizarTablaAviones();
        }
    }

    private void agregarAvion() {
        try {
            if (cajaRegistro.getText().trim().isEmpty() ||
                    cajaModelo.getText().trim().isEmpty() ||
                    cajaPeso.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Los campos Número de registro, Modelo y Peso son obligatorios.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int numRegistro = Integer.parseInt(cajaRegistro.getText().trim());
            String modelo = cajaModelo.getText().trim();
            int peso = Integer.parseInt(cajaPeso.getText().trim());

            AvionDAO dao = new AvionDAO();
            if (dao.existeAvion(String.valueOf(numRegistro))) {
                JOptionPane.showMessageDialog(this, "Ya existe un avión con el número de registro: " + numRegistro, "Avión duplicado", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Avion avion = new Avion();
            avion.setNumeroRegistro(numRegistro);
            avion.setModeloAvion(modelo);
            avion.setCapacidadPeso(peso);

            avion.setCalificacionExamen1((int) spinnerCal1.getValue());
            avion.setNssTecnico1(campoNSS1.getText().trim());
            avion.setNombreTecnico1(campoNombreTec1.getText().trim());
            avion.setFechaExamen1(año1.getSelectedItem() + "-" +
                    String.format("%02d", (Integer) mes1.getSelectedItem()) + "-" +
                    String.format("%02d", (Integer) dia1.getSelectedItem()));
            avion.setTiempoAire1((int) tiempo1.getValue());

            avion.setCalificacionExamen2((int) spinnerCal2.getValue());
            avion.setNssTecnico2(campoNSS2.getText().trim());
            avion.setNombreTecnico2(campoNombreTec2.getText().trim());
            avion.setFechaExamen2(año2.getSelectedItem() + "-" +
                    String.format("%02d", (Integer) mes2.getSelectedItem()) + "-" +
                    String.format("%02d", (Integer) dia2.getSelectedItem()));
            avion.setTiempoAire2((int) tiempo2.getValue());

            if (dao.agregarAvion(avion)) {
                JOptionPane.showMessageDialog(this, "Avión registrado correctamente.");
                limpiarCampos();
                actualizarTablaAviones();
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar el avión.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "El número de registro y el peso deben ser números enteros válidos.",
                    "Error de formato",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        cajaRegistro.setText("");
        cajaModelo.setText("");
        cajaPeso.setText("");
        campoNSS1.setText("");
        campoNombreTec1.setText("");
        campoNSS2.setText("");
        campoNombreTec2.setText("");
        spinnerCal1.setValue(0);
        tiempo1.setValue(0);
        spinnerCal2.setValue(0);
        tiempo2.setValue(0);
        dia1.setSelectedIndex(0);
        mes1.setSelectedIndex(0);
        año1.setSelectedIndex(0);
        dia2.setSelectedIndex(0);
        mes2.setSelectedIndex(0);
        año2.setSelectedIndex(0);
    }

    private void actualizarTablaAviones() {
        AvionDAO dao = new AvionDAO();
        ResultSetTableModel modelo = dao.obtenerAviones();
        if (modelo != null) {
            tablaAviones.setModel(modelo);
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo actualizar la tabla.");
        }
    }

    private void soloNumeros(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '\b') {
            evt.consume();
        }
    }

    private void soloLetras(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && !Character.isWhitespace(c) && c != '\b') {
            evt.consume();
        }
    }
}