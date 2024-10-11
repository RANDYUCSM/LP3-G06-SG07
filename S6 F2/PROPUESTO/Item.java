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

    public void agregarItem() {
        String nombre = vista.solicitarDato("Introduce el nombre del item: ");
        int cantidad = vista.solicitarCantidad("Introduce la cantidad: ");
        String tipo = vista.solicitarDato("Introduce el tipo (Arma, Poción, etc.): ");
        String descripcion = vista.solicitarDato("Introduce la descripción: ");

        Item item = new Item(nombre, cantidad, tipo, descripcion);
        modelo.agregarItem(item);
        vista.mostrarMensaje("Item agregado: " + nombre);
    }

    public void eliminarItem() {
        String nombre = vista.solicitarDato("Introduce el nombre del item a eliminar: ");
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

    public void buscarItem() {
        String nombre = vista.solicitarDato("Introduce el nombre del item a buscar: ");
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
            mostrarMensaje("El inventario está vacío.");
        } else {
            mostrarMensaje("Inventario:");
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    public String solicitarDato(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public int solicitarCantidad(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor, introduce un número entero.");
            scanner.next(); // Descarta la entrada no válida
        }
        return scanner.nextInt();
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
            System.out.println("\n--- Sistema de Gestión de Inventario ---");
            System.out.println("1. Agregar Item");
            System.out.println("2. Ver Inventario");
            System.out.println("3. Buscar Item");
            System.out.println("4. Eliminar Item");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    controlador.agregarItem();
                    break;
                case "2":
                    controlador.verInventario();
                    break;
                case "3":
                    controlador.buscarItem();
                    break;
                case "4":
                    controlador.eliminarItem();
                    break;
                case "5":
                    System.out.println("Saliendo del inventario");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (!opcion.equals("5"));

        scanner.close();
    }
}

