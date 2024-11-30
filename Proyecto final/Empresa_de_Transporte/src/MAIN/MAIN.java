package MAIN;

import Controlador.RutaControlador;
import Modelo.BaseDatos;
import Vista.RutaVista;

public class MAIN {
    public static void main(String[] args) {
        try {
            BaseDatos.conectar();
            BaseDatos.crearTablaCompras();
            RutaVista vista = new RutaVista();
            new RutaControlador(vista);
            vista.setVisible(true);
        } catch (Exception ex) {
            System.err.println("Error inicializando la aplicación: " + ex.getMessage());
        }
    }
}

