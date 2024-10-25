package VISTA;

import java.util.InputMismatchException;
import java.util.Scanner;

import CONTROLADOR.EmpleadoController;
import MODELO.Empleado;

public class EmpleadoView {
    private final EmpleadoController controlador;
    private final Scanner scanner;

    public EmpleadoView(EmpleadoController controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = -1;

        while (opcion != 5) {
            System.out.println("\nMenú de Empleados");
            System.out.println("1. Listar todos los empleados");
            System.out.println("2. Agregar un nuevo empleado");
            System.out.println("3. Buscar un empleado por su número");
            System.out.println("4. Eliminar un empleado por su número");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); 
                continue;
            }

            switch (opcion) {
                case 1:
                    controlador.listarEmpleados();
                    break;
                case 2:
                    agregarNuevoEmpleado();
                    break;
                case 3:
                    buscarEmpleado();
                    break;
                case 4:
                    eliminarEmpleado();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        scanner.close(); 
    }

    private void agregarNuevoEmpleado() {
        try {
            System.out.print("Ingrese el número del empleado: ");
            int numero = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Ingrese el nombre del empleado: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el sueldo del empleado: ");
            double sueldo = scanner.nextDouble();

            Empleado empleado = new Empleado(numero, nombre, sueldo);
            controlador.agregarEmpleado(empleado);
            System.out.println("Empleado agregado exitosamente.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor, ingrese un dato válido.");
            scanner.next(); 
        }
    }

    private void buscarEmpleado() {
        try {
            System.out.print("Ingrese el número del empleado a buscar: ");
            int numero = scanner.nextInt();
            Empleado empleado = controlador.buscarEmpleado(numero);
            if (empleado != null) {
                System.out.println("Empleado encontrado: " + empleado);
            } else {
                System.out.println("Empleado no encontrado.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor, ingrese un número válido.");
            scanner.next(); 
        }
    }

    private void eliminarEmpleado() {
        try {
            System.out.print("Ingrese el número del empleado a eliminar: ");
            int numero = scanner.nextInt();
            if (controlador.eliminarEmpleado(numero)) {
                System.out.println("Empleado eliminado exitosamente.");
            } else {
                System.out.println("No se pudo eliminar el empleado. Verifique el número.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor, ingrese un número válido.");
            scanner.next(); 
        }
    }
}