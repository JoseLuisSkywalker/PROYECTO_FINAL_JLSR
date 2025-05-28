package edu.tecjerez.topicos.controlador;

import edu.tecjerez.topicos.modelo.Avion;

import java.sql.*;
import java.util.ArrayList;

public class AvionDAO {

    private static AvionDAO instancia;

    private final String URL = "jdbc:mysql://localhost:3306/topicos_2025";
    private final String USUARIO = "root";
    private final String CONTRASENA = "boomboomjoseluis777$";

    private Connection conexion;

    // Constructor privado (Singleton)
    private AvionDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Método público para obtener la única instancia
    public static AvionDAO getInstancia() {
        if (instancia == null) {
            instancia = new AvionDAO();
        }
        return instancia;
    }

    // Insertar nuevo avión
    public boolean insertar(Avion avion) {
        String sql = "INSERT INTO Aviones (numeroRegistro, modelo, capacidadPeso, calificacion1, nssTecnico1, nombreTecnico1, fechaExamen1, tiempoAire1, calificacion2, nssTecnico2, nombreTecnico2, fechaExamen2, tiempoAire2) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, avion.getNumeroRegistro());
            ps.setString(2, avion.getModeloAvion());
            ps.setDouble(3, avion.getCapacidadPeso());
            ps.setInt(4, avion.getCalificacionExamen1());
            ps.setString(5, avion.getNssTecnico1());
            ps.setString(6, avion.getNombreTecnico1());
            ps.setString(7, avion.getFechaExamen1());
            ps.setDouble(8, avion.getTiempoAire1());
            ps.setInt(9, avion.getCalificacionExamen2());
            ps.setString(10, avion.getNssTecnico2());
            ps.setString(11, avion.getNombreTecnico2());
            ps.setString(12, avion.getFechaExamen2());
            ps.setDouble(13, avion.getTiempoAire2());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener todos los aviones
    public ArrayList<Avion> obtenerTodos() {
        ArrayList<Avion> lista = new ArrayList<>();
        String sql = "SELECT * FROM Aviones";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Avion avion = new Avion();
                avion.setNumeroRegistro(rs.getString("numeroRegistro"));
                avion.setModeloAvion(rs.getString("modelo"));
                avion.setCapacidadPeso(rs.getInt("capacidadPeso"));
                avion.setCalificacionExamen1(rs.getInt("calificacion1"));
                avion.setNssTecnico1(rs.getString("nssTecnico1"));
                avion.setNombreTecnico1(rs.getString("nombreTecnico1"));
                avion.setFechaExamen1(rs.getString("fechaExamen1"));
                avion.setTiempoAire1(rs.getInt("tiempoAire1"));
                avion.setCalificacionExamen2(rs.getInt("calificacion2"));
                avion.setNssTecnico2(rs.getString("nssTecnico2"));
                avion.setNombreTecnico2(rs.getString("nombreTecnico2"));
                avion.setFechaExamen2(rs.getString("fechaExamen2"));
                avion.setTiempoAire2(rs.getInt("tiempoAire2"));
                lista.add(avion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Eliminar un avión por su número de registro
    public boolean eliminar(String numeroRegistro) {
        String sql = "DELETE FROM Aviones WHERE numeroRegistro = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, numeroRegistro);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Actualizar datos de un avión existente
    public boolean actualizar(Avion avion) {
        String sql = "UPDATE Aviones SET modelo = ?, capacidadPeso = ?, calificacion1 = ?, nssTecnico1 = ?, nombreTecnico1 = ?, fechaExamen1 = ?, tiempoAire1 = ?, calificacion2 = ?, nssTecnico2 = ?, nombreTecnico2 = ?, fechaExamen2 = ?, tiempoAire2 = ? WHERE numeroRegistro = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, avion.getModeloAvion());
            ps.setDouble(2, avion.getCapacidadPeso());
            ps.setInt(3, avion.getCalificacionExamen1());
            ps.setString(4, avion.getNssTecnico1());
            ps.setString(5, avion.getNombreTecnico1());
            ps.setString(6, avion.getFechaExamen1());
            ps.setDouble(7, avion.getTiempoAire1());
            ps.setInt(8, avion.getCalificacionExamen2());
            ps.setString(9, avion.getNssTecnico2());
            ps.setString(10, avion.getNombreTecnico2());
            ps.setString(11, avion.getFechaExamen2());
            ps.setDouble(12, avion.getTiempoAire2());
            ps.setString(13, avion.getNumeroRegistro());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}