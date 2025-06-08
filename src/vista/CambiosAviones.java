package vista;

import controlador.AvionDAO;
import modelo.Avion;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CambiosAviones extends JInternalFrame implements ActionListener {
    JPanel panelCajas;
    JTextField cajaRegistro, cajaModelo, cajaPeso, campoNSS1, campoNSS2, campoNombreTec1, campoNombreTec2;
    JComboBox<Integer> dia1, mes1, año1, dia2, mes2, año2;
    JSpinner spinnerCal1, spinnerCal2, tiempo1, tiempo2;
    JButton btnModificar, btnRestablecer, btnBuscar;
    JCheckBox checkExamen1, checkExamen2;

    public CambiosAviones() {
        this.setSize(1000, 800);
        this.setClosable(true);
        this.setIconifiable(true);
        this.setResizable(true);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());

        panelCajas = new JPanel(new GridLayout(18, 2, 5, 5));
        panelCajas.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelCajas.setBackground(new Color(213, 211, 181));

        // Fila 1
        panelCajas.add(new JLabel("Número de registro:"));
        cajaRegistro = new JTextField();
        panelCajas.add(cajaRegistro);

        panelCajas.add(new JLabel("Modelo de avión:"));
        cajaModelo = new JTextField();
        panelCajas.add(cajaModelo);

        panelCajas.add(new JLabel("Capacidad de peso en kilogramos:"));
        cajaPeso = new JTextField();
        panelCajas.add(cajaPeso);

        checkExamen1 = new JCheckBox("Activar Examen 1");
        //panelCajas.add(checkExamen1);
        checkExamen2 = new JCheckBox("Activar Examen 2");
       // panelCajas.add(checkExamen2);

        // Spinners
        panelCajas.add(new JLabel("Calificación Examen 1:"));
        spinnerCal1 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelCajas.add(spinnerCal1);

        panelCajas.add(new JLabel("Calificación Examen 2:"));
        spinnerCal2 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        panelCajas.add(spinnerCal2);

        // NSS y nombres técnicos
        panelCajas.add(new JLabel("NSS técnico Examen 1:"));
        campoNSS1 = new JTextField();
        panelCajas.add(campoNSS1);

        panelCajas.add(new JLabel("Nombre técnico Examen 1:"));
        campoNombreTec1 = new JTextField();
        panelCajas.add(campoNombreTec1);

        panelCajas.add(new JLabel("NSS técnico Examen 2:"));
        campoNSS2 = new JTextField();
        panelCajas.add(campoNSS2);

        panelCajas.add(new JLabel("Nombre técnico Examen 2:"));
        campoNombreTec2 = new JTextField();
        panelCajas.add(campoNombreTec2);

        // Fechas
        panelCajas.add(new JLabel("Fecha Examen 1:"));
        JPanel panelFecha1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dia1 = new JComboBox<>();
        mes1 = new JComboBox<>();
        año1 = new JComboBox<>();
        for (int i = 1; i <= 31; i++) dia1.addItem(i);
        for (int i = 1; i <= 12; i++) mes1.addItem(i);
        for (int i = 1900; i <= 2100; i++) año1.addItem(i);
        panelFecha1.add(dia1); panelFecha1.add(mes1); panelFecha1.add(año1);
        panelCajas.add(panelFecha1);

        panelCajas.add(new JLabel("Fecha Examen 2:"));
        JPanel panelFecha2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dia2 = new JComboBox<>();
        mes2 = new JComboBox<>();
        año2 = new JComboBox<>();
        for (int i = 1; i <= 31; i++) dia2.addItem(i);
        for (int i = 1; i <= 12; i++) mes2.addItem(i);
        for (int i = 1900; i <= 2100; i++) año2.addItem(i);
        panelFecha2.add(dia2); panelFecha2.add(mes2); panelFecha2.add(año2);
        panelCajas.add(panelFecha2);

        panelCajas.add(new JLabel("Tiempo en aire examen 1 (min):"));
        tiempo1 = new JSpinner(new SpinnerNumberModel(0, 0, 999, 1));
        panelCajas.add(tiempo1);

        panelCajas.add(new JLabel("Tiempo en aire examen 2 (min):"));
        tiempo2 = new JSpinner(new SpinnerNumberModel(0, 0, 999, 1));
        panelCajas.add(tiempo2);

        // Botones
        btnBuscar = new JButton("Buscar");
        panelCajas.add(btnBuscar);
        btnModificar = new JButton("Modificar");
        panelCajas.add(btnModificar);
        btnRestablecer = new JButton("Restablecer");
        panelCajas.add(btnRestablecer);

        this.add(panelCajas, BorderLayout.CENTER);

        // Eventos
        checkExamen1.addActionListener(this);
        checkExamen2.addActionListener(this);
        btnBuscar.addActionListener(this);
        btnModificar.addActionListener(this);
        btnRestablecer.addActionListener(this);

        // Deshabilitar todo por defecto
        deshabilitarCampos();
    }

    private void deshabilitarCampos() {
        cajaModelo.setEnabled(false);
        cajaPeso.setEnabled(false);
        spinnerCal1.setEnabled(false);
        campoNSS1.setEnabled(false);
        campoNombreTec1.setEnabled(false);
        dia1.setEnabled(false);
        mes1.setEnabled(false);
        año1.setEnabled(false);
        tiempo1.setEnabled(false);

        spinnerCal2.setEnabled(false);
        campoNSS2.setEnabled(false);
        campoNombreTec2.setEnabled(false);
        dia2.setEnabled(false);
        mes2.setEnabled(false);
        año2.setEnabled(false);
        tiempo2.setEnabled(false);
    }

    private void habilitarCampos() {
        cajaModelo.setEnabled(true);
        cajaPeso.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBuscar) {
            if (encontrarExistencia()) {
                int numRegistro = Integer.parseInt(cajaRegistro.getText());
                AvionDAO dao = new AvionDAO();
                Avion avion = dao.obtenerAvion(numRegistro);

                if (avion != null) {
                    llenarCampos(avion);
                    JOptionPane.showMessageDialog(this, "Avión encontrado. Puedes modificar los datos.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró el avión.");
                }

            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el avión.");
            }

        } else if (e.getSource() == checkExamen1) {
            boolean activo = checkExamen1.isSelected();
            spinnerCal1.setEnabled(activo);
            campoNSS1.setEnabled(activo);
            campoNombreTec1.setEnabled(activo);
            dia1.setEnabled(activo);
            mes1.setEnabled(activo);
            año1.setEnabled(activo);
            tiempo1.setEnabled(activo);

        } else if (e.getSource() == checkExamen2) {
            boolean activo = checkExamen2.isSelected();
            spinnerCal2.setEnabled(activo);
            campoNSS2.setEnabled(activo);
            campoNombreTec2.setEnabled(activo);
            dia2.setEnabled(activo);
            mes2.setEnabled(activo);
            año2.setEnabled(activo);
            tiempo2.setEnabled(activo);

        } else if (e.getSource() == btnRestablecer) {
            botonRestablecerActionPerformed(e);

        } else if (e.getSource() == btnModificar) {
            try {
                int numRegistro = Integer.parseInt(cajaRegistro.getText());
                String modelo = cajaModelo.getText();
                int peso = Integer.parseInt(cajaPeso.getText());

                Avion avion = new Avion();
                avion.setNumeroRegistro(numRegistro);
                avion.setModeloAvion(modelo);
                avion.setCapacidadPeso(peso);

                // Si Examen 1 está activo
                if (checkExamen1.isSelected()) {
                    avion.setCalificacionExamen1((int) spinnerCal1.getValue());
                    avion.setNssTecnico1(campoNSS1.getText());
                    avion.setNombreTecnico1(campoNombreTec1.getText());
                    String fecha1 = año1.getSelectedItem() + "-" + mes1.getSelectedItem() + "-" + dia1.getSelectedItem();
                    avion.setFechaExamen1(fecha1);
                    avion.setTiempoAire1((int) tiempo1.getValue());
                } else {
                    avion.setCalificacionExamen1(0);
                    avion.setNssTecnico1(null);
                    avion.setNombreTecnico1(null);
                    avion.setFechaExamen1(null);
                    avion.setTiempoAire1(0);
                }

                // Si Examen 2 está activo
                if (checkExamen2.isSelected()) {
                    avion.setCalificacionExamen2((int) spinnerCal2.getValue());
                    avion.setNssTecnico2(campoNSS2.getText());
                    avion.setNombreTecnico2(campoNombreTec2.getText());
                    String fecha2 = año2.getSelectedItem() + "-" + mes2.getSelectedItem() + "-" + dia2.getSelectedItem();
                    avion.setFechaExamen2(fecha2);
                    avion.setTiempoAire2((int) tiempo2.getValue());
                } else {
                    avion.setCalificacionExamen2(0);
                    avion.setNssTecnico2(null);
                    avion.setNombreTecnico2(null);
                    avion.setFechaExamen2(null);
                    avion.setTiempoAire2(0);
                }

                actualizar(avion);
                JOptionPane.showMessageDialog(this, "Avión modificado correctamente.");
                botonRestablecerActionPerformed(null); // Limpia los campos

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error en los datos. Verifica los campos numéricos.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al modificar el avión: " + ex.getMessage());
            }
        }
    }

    public boolean encontrarExistencia() {
        try {
            int numRegistro = Integer.parseInt(cajaRegistro.getText());
            AvionDAO avionDAO = new AvionDAO();
            Avion avion = avionDAO.obtenerAvion(numRegistro);
            return avion != null;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Número de registro inválido.");
            return false;
        }
    }


    public void modoEdicion(boolean activo){
        cajaRegistro.setEnabled(!activo);
        cajaModelo.setEnabled(activo);
        cajaPeso.setEnabled(activo);
        spinnerCal1.setEnabled(activo);
        spinnerCal2.setEnabled(activo);
        campoNSS1.setEnabled(activo);
        campoNombreTec1.setEnabled(activo);
        campoNSS2.setEnabled(activo);
        campoNombreTec2.setEnabled(activo);
        dia1.setEnabled(activo);
        mes1.setEnabled(activo);
        año1.setEnabled(activo);
        dia2.setEnabled(activo);
        mes2.setEnabled(activo);
        año2.setEnabled(activo);
        tiempo1.setEnabled(activo);
        tiempo2.setEnabled(activo);
    }

    private void botonRestablecerActionPerformed(ActionEvent e) {
        // Desactiva el modo edición (bloquea los campos)
        modoEdicion(false);

        // Borra los contenidos de todos los campos de texto
        cajaRegistro.setText("");
        cajaModelo.setText("");
        cajaPeso.setText("");
        spinnerCal1.setValue(0);
        spinnerCal2.setValue(0);
        campoNSS1.setText("");
        campoNombreTec1.setText("");
        campoNSS2.setText("");
        campoNombreTec2.setText("");

        // Restablece los valores de las fechas y tiempos a vacíos o valores por defecto
        dia1.setSelectedIndex(0);
        mes1.setSelectedIndex(0);
        año1.setSelectedIndex(0);
        dia2.setSelectedIndex(0);
        mes2.setSelectedIndex(0);
        año2.setSelectedIndex(0);

        tiempo1.setValue(0);
        tiempo2.setValue(0);

    }

    public void actualizar(Avion avion){
        AvionDAO dao = new AvionDAO();
        dao.editarAvion(construirObjetoAvionDesdeCampos());
    }


    public void llenarCampos(Avion avion) {
        modoEdicion(true);
        cajaRegistro.setEnabled(false);

        cajaRegistro.setText(String.valueOf(avion.getNumeroRegistro()));
        cajaModelo.setText(avion.getModeloAvion());
        cajaPeso.setText(String.valueOf(avion.getCapacidadPeso()));


        if (avion.getNssTecnico1() != null && !avion.getNssTecnico1().isEmpty()) {
            checkExamen1.setSelected(true);
            spinnerCal1.setEnabled(true);
            campoNSS1.setEnabled(true);
            campoNombreTec1.setEnabled(true);
            dia1.setEnabled(true);
            mes1.setEnabled(true);
            año1.setEnabled(true);
            tiempo1.setEnabled(true);

            spinnerCal1.setValue(avion.getCalificacionExamen1());
            campoNSS1.setText(avion.getNssTecnico1());
            campoNombreTec1.setText(avion.getNombreTecnico1());

            String[] fecha1 = avion.getFechaExamen1().split("-");
            año1.setSelectedItem(Integer.parseInt(fecha1[0]));
            mes1.setSelectedItem(Integer.parseInt(fecha1[1]));
            dia1.setSelectedItem(Integer.parseInt(fecha1[2]));

            tiempo1.setValue(avion.getTiempoAire1());
        } else {
            checkExamen1.setSelected(false);
        }

        // Examen 2
        if (avion.getNssTecnico2() != null && !avion.getNssTecnico2().isEmpty()) {
            checkExamen2.setSelected(true);
            spinnerCal2.setEnabled(true);
            campoNSS2.setEnabled(true);
            campoNombreTec2.setEnabled(true);
            dia2.setEnabled(true);
            mes2.setEnabled(true);
            año2.setEnabled(true);
            tiempo2.setEnabled(true);

            spinnerCal2.setValue(avion.getCalificacionExamen2());
            campoNSS2.setText(avion.getNssTecnico2());
            campoNombreTec2.setText(avion.getNombreTecnico2());

            String[] fecha2 = avion.getFechaExamen2().split("-");
            año2.setSelectedItem(Integer.parseInt(fecha2[0]));
            mes2.setSelectedItem(Integer.parseInt(fecha2[1]));
            dia2.setSelectedItem(Integer.parseInt(fecha2[2]));

            tiempo2.setValue(avion.getTiempoAire2());
        } else {
            checkExamen2.setSelected(false);
        }
    }


    private Avion construirObjetoAvionDesdeCampos() throws NumberFormatException {
        Avion avion = new Avion();

        int numRegistro = Integer.parseInt(cajaRegistro.getText());
        String modelo = cajaModelo.getText();
        int peso = Integer.parseInt(cajaPeso.getText());

        avion.setNumeroRegistro(numRegistro);
        avion.setModeloAvion(modelo);
        avion.setCapacidadPeso(peso);

        if (checkExamen1.isSelected()) {
            avion.setCalificacionExamen1((int) spinnerCal1.getValue());
            avion.setNssTecnico1(campoNSS1.getText());
            avion.setNombreTecnico1(campoNombreTec1.getText());
            String fecha1 = año1.getSelectedItem() + "-" + mes1.getSelectedItem() + "-" + dia1.getSelectedItem();
            avion.setFechaExamen1(fecha1);
            avion.setTiempoAire1((int) tiempo1.getValue());
        } else {
            avion.setCalificacionExamen1(0);
            avion.setNssTecnico1(null);
            avion.setNombreTecnico1(null);
            avion.setFechaExamen1(null);
            avion.setTiempoAire1(0);
        }

        if (checkExamen2.isSelected()) {
            avion.setCalificacionExamen2((int) spinnerCal2.getValue());
            avion.setNssTecnico2(campoNSS2.getText());
            avion.setNombreTecnico2(campoNombreTec2.getText());
            String fecha2 = año2.getSelectedItem() + "-" + mes2.getSelectedItem() + "-" + dia2.getSelectedItem();
            avion.setFechaExamen2(fecha2);
            avion.setTiempoAire2((int) tiempo2.getValue());
        } else {
            avion.setCalificacionExamen2(0);
            avion.setNssTecnico2(null);
            avion.setNombreTecnico2(null);
            avion.setFechaExamen2(null);
            avion.setTiempoAire2(0);
        }

        return avion;
    }


}
