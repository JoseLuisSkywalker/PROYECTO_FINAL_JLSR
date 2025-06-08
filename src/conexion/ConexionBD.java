package conexion;

import java.sql.*;

public class ConexionBD {

    private static ConexionBD instanciaConexion;
    private Connection conexion;

    private final String URL = "jdbc:mysql://localhost:3306/aviones_bd";
    private final String USUARIO = "root";
    private final String CONTRASEÑA = "boomboomjoseluis777$";

    private ConexionBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("Conexión establecida con éxito");
        } catch (ClassNotFoundException e) {
            System.out.println("Error en el driver JDBC");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la conexión a MySQL");
        }
    }
    //metodo para obtener la instancia unica
    public static ConexionBD getInstancia() {
        if (instanciaConexion == null) {
            instanciaConexion = new ConexionBD();
        }
        return instanciaConexion;
    }

    public Connection getConexion() {
        return conexion;
    }

    public String getURL() {
        return "jdbc:mysql://localhost:3306/aviones_bd";
    }

    public String getDriver() {
        return "com.mysql.cj.jdbc.Driver";
    }

    public boolean ejecutarInstruccionLMD(String sql, Object... datos) {
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            for (int i = 0; i < datos.length; i++) {
                pstmt.setObject(i + 1, datos[i]);
            }
            return pstmt.executeUpdate() >= 1;
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la instrucción LMD");
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet ejecutarConsultaSQL(String sql, Object... datos) {
        try {
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            for (int i = 0; i < datos.length; i++) {
                pstmt.setObject(i + 1, datos[i]);
            }
            return pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta SQL");
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        ConexionBD conexion = ConexionBD.getInstancia();
    }

}
