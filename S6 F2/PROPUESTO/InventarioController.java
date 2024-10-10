//Controlador
package controlador;

import modelo.InventarioModel;
import modelo.Item;
import vista.InventarioView;

public class InventarioController {
    private InventarioModel modelo;
    private InventarioView vista;

    public InventarioController(InventarioModel modelo, InventarioView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarItem(String nombre, int cantidad, String tipo, String descripcion) {
        Item item = new Item(nombre, cantidad, tipo, descripcion);
        modelo.agregarItem(item);
        vista.mostrarMensaje("Item agregado: " + nombre);
    }

    public void eliminarItem(String nombre) {
        Item item = modelo.buscarItem(nombre);
        if (item != null) {
            modelo.eliminarItem(item);
            vista.mostrarMensaje("Item eliminado: " + nombre);
        } else {
            vista.mostrarMensaje("Item no encontrado.");
        }
    }

    public void verInventario() {
        vista.mostrarInventario(modelo.obtenerItems());
    }

    public void mostrarDetalles(String nombre) {
        Item item = modelo.buscarItem(nombre);
        vista.mostrarDetallesItem(item);
    }

    public void buscarItem(String nombre) {
        Item item = modelo.buscarItem(nombre);
        vista.mostrarDetallesItem(item);
    }
}
//MODELO
package modelo;

public class Item {
    private String nombre;
    private int cantidad;
    private String tipo; 
    private String descripcion;

    public Item(String nombre, int cantidad, String tipo, String descripcion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String toString() {
        return nombre + " (" + tipo + ") - " + descripcion + " [Cantidad: " + cantidad + "]";
    }
}
//INVENTARIO
package modelo;

import java.util.ArrayList;
import java.util.List;

public class InventarioModel {
    private List<Item> items;

    public InventarioModel() {
        this.items = new ArrayList<>();
    }

    public void agregarItem(Item item) {
        items.add(item);
    }

    public void eliminarItem(Item item) {
        items.remove(item);
    }

    public List<Item> obtenerItems() {
        return items;
    }

    public Item buscarItem(String nombre) {
        for (Item item : items) {
            if (item.getNombre().equalsIgnoreCase(nombre)) {
                return item;
            }
        }
        return null;
    }
}
//VISTA
package vista;

import modelo.Item;

import java.util.List;
import java.util.Scanner;

public class InventarioView {
    private Scanner scanner;

    public InventarioView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarInventario(List<Item> items) {
        if (items.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("Inventario:");
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    public String solicitarNombreItem() {
        System.out.print("Introduce el nombre del item: ");
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarDetallesItem(Item item) {
        if (item != null) {
            System.out.println("Detalles del item: " + item);
        } else {
            System.out.println("Item no encontrado.");
        }
    }
}
//MAIN
package principal;

import controlador.InventarioController;
import modelo.InventarioModel;
import vista.InventarioView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventarioModel modelo = new InventarioModel();
        InventarioView vista = new InventarioView();
        InventarioController controlador = new InventarioController(modelo, vista);

        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\n :3--- Sistema de Gestión de Inventario --- :3");
            System.out.println("1. Agregar Item");
            System.out.println("2. Ver Inventario");
            System.out.println("3. Buscar Item");
            System.out.println("4. Eliminar Item");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":

                    System.out.print("Introduce el nombre del item: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Introduce la cantidad: ");
                    int cantidad = Integer.parseInt(scanner.nextLine());

                    System.out.print("Introduce el tipo (Arma, Poción, etc.): ");
                    String tipo = scanner.nextLine();

                    System.out.print("Introduce la descripción: ");
                    String descripcion = scanner.nextLine();

                    controlador.agregarItem(nombre, cantidad, tipo, descripcion);
                    break;

                case "2":
    
                    controlador.verInventario();
                    break;

                case "3":
       
                    System.out.print("Introduce el nombre del item a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    controlador.buscarItem(nombreBuscar);
                    break;

                case "4":
           
                    System.out.print("Introduce el nombre del item a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    controlador.eliminarItem(nombreEliminar);
                    break;

                case "5":
          
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (!opcion.equals("5"));

        scanner.close();
    }
}
