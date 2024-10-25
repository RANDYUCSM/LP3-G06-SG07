package CONTROLADOR;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import MODELO.Empleado;

public class EmpleadoController {
    private final String archivo = "empleados.txt";

    public List<Empleado> leerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            while (true) {
                Empleado empleado = (Empleado) ois.readObject();
                empleados.add(empleado);
            }
        } catch (EOFException eof) {
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe. No hay empleados almacenados.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return empleados;
    }

    public void agregarEmpleado(Empleado empleado) {
        List<Empleado> empleados = leerEmpleados();
        empleados.add(empleado);
        escribirEmpleados(empleados);
        System.out.println("Empleado agregado exitosamente.");
    }

    public Empleado buscarEmpleado(int numero) {
        for (Empleado emp : leerEmpleados()) {
            if (emp.getNumero() == numero) {
                return emp;
            }
        }
        return null;
    }

    public boolean eliminarEmpleado(int numero) {
        List<Empleado> empleados = leerEmpleados();
        Empleado empleadoEliminar = null;

        for (Empleado emp : empleados) {
            if (emp.getNumero() == numero) {
                empleadoEliminar = emp;
                break;
            }
        }

        if (empleadoEliminar != null) {
            empleados.remove(empleadoEliminar);
            escribirEmpleados(empleados);
            System.out.println("Empleado eliminado exitosamente.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
		return false;
    }

    private void escribirEmpleados(List<Empleado> empleados) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            for (Empleado empleado : empleados) {
                oos.writeObject(empleado);
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public void listarEmpleados() {
        List<Empleado> empleados = leerEmpleados();
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Empleado emp : empleados) {
                System.out.println(emp);
            }
        }
    }
}
