package vista;

import controlador.AvionDAO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BajasAviones extends JInternalFrame implements ActionListener {
    JPanel panelCajas;
    JTextField cajaRegistro, cajaModelo;
    JButton btnBuscar, btnBorrarContenido, btnRestablecer;
    JTable tablaAviones;


    public BajasAviones(){
        this.setSize(1000, 400);
        this.setClosable(true);
        this.setIconifiable(true);
        this.setResizable(true);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());

        GridLayout layout = new GridLayout(4, 2, 5, 5);
        panelCajas = new JPanel();
        panelCajas.setLayout(layout);
        EmptyBorder borde = new EmptyBorder(10, 10, 10, 10);
        panelCajas.setBorder(borde);
        Color colorFondo = new Color(213, 181, 181);
        panelCajas.setBackground(colorFondo);

        // Etiqueta y campo para número de registro
        panelCajas.add(new JLabel("Número de registro:"));
        cajaRegistro = new JTextField();

        // KeyListener: solo acepta números
        cajaRegistro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '\b') {
                    e.consume(); // Bloquea letras y símbolos
                    Toolkit.getDefaultToolkit().beep(); // Beep opcional
                }
            }
        });


        panelCajas.add(cajaRegistro);

        //panelCajas.add(new JLabel("Modelo de avión:"));
        cajaModelo = new JTextField();
       // panelCajas.add(cajaModelo);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(new Color(140, 68, 68));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFocusPainted(false);
        btnBuscar.setBorderPainted(false);
        btnBuscar.setOpaque(true);
        btnBuscar.setContentAreaFilled(true);

        btnBuscar.getModel().addChangeListener(e -> {
            ButtonModel model = (ButtonModel) e.getSource();
            if (model.isPressed()) {
                btnBuscar.setBackground(new Color(100, 50, 50));
            } else {
                btnBuscar.setBackground(new Color(140, 68, 68));
            }
        });
       // panelCajas.add(btnBuscar);


        btnBorrarContenido = new JButton("Borrar");
        btnBorrarContenido.setBackground(new Color(140, 68, 68));
        btnBorrarContenido.setForeground(Color.WHITE);
        btnBorrarContenido.setFocusPainted(false);
        btnBorrarContenido.setBorderPainted(false);
        btnBorrarContenido.setOpaque(true);
        btnBorrarContenido.setContentAreaFilled(true);



        btnBorrarContenido.getModel().addChangeListener(e -> {
            ButtonModel model = (ButtonModel) e.getSource();
            if (model.isPressed()) {
                btnBorrarContenido.setBackground(new Color(100, 50, 50));
            } else {
                btnBorrarContenido.setBackground(new Color(140, 68, 68));
            }
        });

        panelCajas.add(btnBorrarContenido);


        btnRestablecer = new JButton("Restablecer");
        btnRestablecer.setBackground(new Color(140, 68, 68));
        btnRestablecer.setForeground(Color.WHITE);
        btnRestablecer.setFocusPainted(false);
        btnRestablecer.setBorderPainted(false);
        btnRestablecer.setOpaque(true);
        btnRestablecer.setContentAreaFilled(true);

        btnRestablecer.getModel().addChangeListener(e -> {
            ButtonModel model = (ButtonModel) e.getSource();
            if (model.isPressed()) {
                btnRestablecer.setBackground(new Color(100, 50, 50));
            } else {
                btnRestablecer.setBackground(new Color(140, 68, 68));
            }
        });

        panelCajas.add(btnRestablecer);

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

        //tablaAviones = new JTable(filas, columnas);
       // tablaAviones.setEnabled(false);


        JScrollPane scrollTabla = new JScrollPane(tablaAviones);
        scrollTabla.setPreferredSize(new Dimension(480, 150));

        this.add(panelCajas, BorderLayout.CENTER);


        btnBuscar.addActionListener(this);
        btnBorrarContenido.addActionListener(this);
        btnRestablecer.addActionListener(this);


    }

    public void restablecer(){
        cajaRegistro.setText("");
        cajaModelo.setText("");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnBorrarContenido){
            AvionDAO dao = new AvionDAO();
            int numRegistro = Integer.parseInt(cajaRegistro.getText());

            dao.eliminarAvion(numRegistro);
            JOptionPane.showMessageDialog(this, "Datos borrados correctamente");

        }

        if (e.getSource() == btnRestablecer) {
            restablecer();
        }
    }
}
