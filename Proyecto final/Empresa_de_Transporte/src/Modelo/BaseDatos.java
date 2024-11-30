package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDatos {
    private static final String URL = "jdbc:sqlite:compras.db";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void crearTablaCompras() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS compras (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nombre TEXT NOT NULL,
                    apellido TEXT NOT NULL,
                    dni TEXT NOT NULL,
                    fechaViaje TEXT NOT NULL,
                    origen TEXT NOT NULL,
                    destino TEXT NOT NULL
                );
                """;
        try (Connection conn = conectar(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    public static void registrarCompra(String nombre, String apellido, String dni, String fechaViaje, String origen, String destino) throws SQLException {
        String sql = "INSERT INTO compras (nombre, apellido, dni, fechaViaje, origen, destino) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setString(3, dni);
            pstmt.setString(4, fechaViaje);
            pstmt.setString(5, origen);
            pstmt.setString(6, destino);
            pstmt.executeUpdate();
        }
    }
}
