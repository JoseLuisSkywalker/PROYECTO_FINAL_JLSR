package controlador;

import conexion.ConexionBD;
import modelo.Avion;
import modelo.ResultSetTableModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class AvionDAO {
    public static AvionDAO instancia;

    private ConexionBD conexionBD;
    public AvionDAO(){
        conexionBD = ConexionBD.getInstancia();
    }

    public static AvionDAO getInstancia() {
        if(instancia == null){
            instancia = new AvionDAO();
        }
        return instancia;
    }


    public static void actualizarTablaAvion(JTable tabla, int numeroRegistro) {
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setIndeterminate(false);
        progressBar.setStringPainted(true);

        JOptionPane optionPane = new JOptionPane(progressBar, JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        JDialog dialog = optionPane.createDialog("Consultando avión...");
        dialog.setModal(false);
        dialog.setVisible(true);


        new Thread(() -> {
            try {
                // Animación de progreso
                for (int i = 0; i <= 100; i += 10) {
                    final int value = i;
                    SwingUtilities.invokeLater(() -> progressBar.setValue(value));
                    Thread.sleep(50); // Más rápido para consulta individual
                }

                final String CONTROLADOR_JDBC = ConexionBD.getInstancia().getDriver();
                final String URL = ConexionBD.getInstancia().getURL();
                final String CONSULTA = "SELECT * FROM aviones WHERE numero_registro = ?";

                ResultSetTableModel modelo = new ResultSetTableModel(CONTROLADOR_JDBC, URL, CONSULTA, numeroRegistro);

                SwingUtilities.invokeLater(() -> {
                    tabla.setModel(modelo);
                    dialog.dispose();

                    if (modelo.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(null,
                                "No se encontró el avión con número de registro: " + numeroRegistro);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Avión encontrado y mostrado en la tabla.");
                    }
                });

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                dialog.dispose();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                dialog.dispose();
                SwingUtilities.invokeLater(() ->
                        JOptionPane.showMessageDialog(null,
                                "Error al consultar el avión con número de registro: " + numeroRegistro)
                );
            }
        }).start();
    }
    //---------------- altas
    public boolean agregarAvion(Avion avion){
        String sql = "INSERT INTO Aviones (numero_registro, modelo_avion, capacidad_peso, calif_examen1, nss_tecnico1, nombre_tecnico1, fecha_examen1, tiempo_aire1, calif_examen2, nss_tecnico2, nombre_tecnico2, fecha_examen2, tiempo_aire) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        return conexionBD.ejecutarInstruccionLMD(sql,
                avion.getNumeroRegistro(),
                avion.getModeloAvion(),
                avion.getCapacidadPeso(),
                avion.getCalificacionExamen1(),
                avion.getNssTecnico1(),
                avion.getNombreTecnico1(),
                avion.getFechaExamen1(),
                avion.getTiempoAire1(),
                avion.getCalificacionExamen2(),
                avion.getNssTecnico2(),
                avion.getNombreTecnico2(),
                avion.getFechaExamen2(),
                avion.getTiempoAire2());
    }

    public boolean existeAvion(String numAvion){
        String sql = "SELECT numero_registro FROM aviones WHERE numero_registro = ?";
        ResultSet rs = conexionBD.ejecutarConsultaSQL(sql, numAvion);
        try{
            return rs != null && rs.next();
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }


    // --------------- bajas
    public boolean eliminarAvion(int numAvion){
        String sql = "DELETE FROM aviones WHERE numero_registro = ?";
        return conexionBD.ejecutarInstruccionLMD(sql, numAvion);
    }

    // ---------------- modificaciones
    public boolean editarAvion(Avion avion){
        String sql = "UPDATE Aviones SET modelo_avion = ?, capacidad_peso = ?, calif_examen1 = ?, nss_tecnico1 = ?, nombre_tecnico1 = ?, fecha_examen1 = ?, tiempo_aire1 = ?, calif_examen2 = ?, nss_tecnico2 = ?, nombre_tecnico2 = ?, fecha_examen2 = ?, tiempo_aire = ? WHERE numero_registro = ?";

        return conexionBD.ejecutarInstruccionLMD(sql,

                avion.getModeloAvion(),
                avion.getCapacidadPeso(),
                avion.getCalificacionExamen1(),
                avion.getNssTecnico1(),
                avion.getNombreTecnico1(),
                avion.getFechaExamen1(),
                avion.getTiempoAire1(),
                avion.getCalificacionExamen2(),
                avion.getNssTecnico2(),
                avion.getNombreTecnico2(),
                avion.getFechaExamen2(),
                avion.getTiempoAire2(),
                avion.getNumeroRegistro());
    }

    public ResultSetTableModel obtenerAvionesFiltrados(String campo, Object valor) {
        String consulta = "SELECT * FROM aviones WHERE " + campo + " = ?";
        try {

            return new ResultSetTableModel(
                    conexionBD.getDriver(),
                    conexionBD.getURL(),
                    consulta,
                    valor
            );
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Error al obtener aviones ya filtrados", e);
        }
    }

    public ResultSetTableModel obtenerAviones() {
        String consulta = "SELECT * FROM aviones";
        try {
            return new ResultSetTableModel(
                    conexionBD.getDriver(),
                    conexionBD.getURL(),
                    consulta
            );
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Error al obtener los aviones", e);
        }
    }

    public Avion obtenerAvion(int numeroRegistro){
        String sql = "SELECT * FROM aviones WHERE numero_registro = ?";
        ResultSet rs = conexionBD.ejecutarConsultaSQL(sql, numeroRegistro);

        try {
            if (rs != null && rs.next()) {
                Avion avion = new Avion();
                avion.setNumeroRegistro(rs.getInt("numero_registro"));
                avion.setModeloAvion(rs.getString("modelo_avion"));
                avion.setCapacidadPeso(rs.getInt("capacidad_peso"));
                avion.setCalificacionExamen1(rs.getInt("calif_examen1"));
                avion.setNssTecnico1(rs.getString("nss_tecnico1"));
                avion.setNombreTecnico1(rs.getString("nombre_tecnico1"));
                avion.setFechaExamen1(rs.getString("fecha_examen1"));
                avion.setTiempoAire1(rs.getInt("tiempo_aire1"));
                avion.setCalificacionExamen2(rs.getInt("calif_examen2"));
                avion.setNssTecnico2(rs.getString("nss_tecnico2"));
                avion.setNombreTecnico2(rs.getString("nombre_tecnico2"));
                avion.setFechaExamen2(rs.getString("fecha_examen2"));
                avion.setTiempoAire2(rs.getInt("tiempo_aire"));
                return avion;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Si no se encuen
    }


    public ArrayList<Avion> consultarPorModelo(String modelo) {
        ArrayList<Avion> lista = new ArrayList<>();
        try {
            Connection conexion = ConexionBD.getInstancia().getConexion();
            String sql = "SELECT * FROM aviones WHERE modelo_avion LIKE ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, "%" + modelo + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Avion a = new Avion();
                a.setNumeroRegistro(rs.getInt("numero_registro"));
                a.setModeloAvion(rs.getString("modelo_avion"));
                a.setCapacidadPeso(rs.getInt("capacidad_peso"));
                a.setCalificacionExamen1(rs.getInt("calificacion_examen1"));
                a.setNssTecnico1(rs.getString("nss_tecnico1"));
                a.setNombreTecnico1(rs.getString("nombre_tecnico1"));
                a.setFechaExamen1(rs.getString("fecha_examen1"));
                a.setTiempoAire1(rs.getInt("tiempo_aire1"));
                a.setCalificacionExamen2(rs.getInt("calificacion_examen2"));
                a.setNssTecnico2(rs.getString("nss_tecnico2"));
                a.setNombreTecnico2(rs.getString("nombre_tecnico2"));
                a.setFechaExamen2(rs.getString("fecha_examen2"));
                a.setTiempoAire2(rs.getInt("tiempo_aire2"));
                lista.add(a);
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }



}