package MAIN;

import CONTROLADOR.EmpleadoController;
import VISTA.EmpleadoView;

public class Main {
    public static void main(String[] args) {
        EmpleadoController controlador = new EmpleadoController();
        EmpleadoView vista = new EmpleadoView(controlador);
        
        controlador.listarEmpleados();
        
        vista.mostrarMenu();
    }
}
