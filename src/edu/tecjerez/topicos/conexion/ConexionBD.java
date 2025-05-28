package edu.tecjerez.topicos.conexion;

import java.sql.*;

public class ConexionBD {

    private static ConexionBD instancia = null;
    private Connection conexion;

    private ConexionBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/topicos_2025";
            conexion = DriverManager.getConnection(URL, "root", "boomboomjoseluis777$");
            System.out.println("Conexión establecida correctamente.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver de MySQL.");
        } catch (SQLException e) {
            System.out.println("Error: Falló la conexión con MySQL.");
            e.printStackTrace();
        }
    }

    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void cerrarConexion() {
        try {
            if (conexion != null) {
                conexion.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión.");
            e.printStackTrace();
        }
    }
}