package Transporte;

import java.sql.SQLException;

public class MAIN {
    public static void main(String[] args) {
        try {
            BaseDatos.conectar();
            BaseDatos.crearTablaCompras();
            RutaVista vista = new RutaVista();
            new RutaControlador(vista);
            vista.setVisible(true);
        } catch (SQLException ex) {
            System.err.println("Error inicializando la base de datos: " + ex.getMessage());
        }
    }
}

