//Controlador
package Controlador;

import java.util.List;
import Modelo.CarritoModelo;
import Modelo.Producto;
import Modelo.CompraModelo;
import Vista.CarritoVista;

public class CarritoControlador {
    private CarritoModelo carrito;
    private CarritoVista vista;
    private CompraModelo historialCompras;

    public CarritoControlador(CarritoModelo carrito, CarritoVista vista, CompraModelo historialCompras) {
        this.carrito = carrito;
        this.vista = vista;
        this.historialCompras = historialCompras;
    }

    public void agregarProducto(Producto producto) {
        carrito.agregarProducto(producto);
        vista.mostrarMensaje("Producto agregado al carrito: " + producto.getNombre());
    }

    public void listarProductos() {
        List<Producto> productos = carrito.getProductos();
        if (productos.isEmpty()) {
            vista.mostrarMensaje("No hay productos en el carrito.");
        } else {
            vista.mostrarProductos(productos);
        }
    }

    public void eliminarProducto(String nombreProducto) {
        if (carrito.eliminarProducto(nombreProducto)) {
            vista.mostrarMensaje("Producto eliminado: " + nombreProducto);
        } else {
            vista.mostrarMensaje("Producto no encontrado en el carrito.");
        }
    }

    public void aplicarDescuento(double porcentaje) {
        double descuento = carrito.aplicarDescuento(porcentaje);
        vista.mostrarMensaje("Descuento aplicado: " + descuento + " USD.");
    }

    public void calcularEnvio(double costoEnvio) {
        carrito.setCostoEnvio(costoEnvio);
        vista.mostrarMensaje("Costo de envío calculado: " + costoEnvio + " USD.");
    }

    public void verCarrito() {
        List<Producto> productos = carrito.getProductos();
        if (productos.isEmpty()) {
            vista.mostrarMensaje("El carrito está vacío.");
        } else {
            vista.mostrarCarrito(productos, carrito.calcularTotal());
        }
    }

    public void realizarCompra() {
        double totalCompra = carrito.calcularTotal();
        historialCompras.agregarCompra(carrito.getProductos(), totalCompra);
        carrito.vaciarCarrito();
        vista.mostrarMensaje("Compra realizada con éxito. Total pagado: " + totalCompra + " USD.");
    }

    public void verHistorialCompras() {
        vista.mostrarHistorial(historialCompras.getHistorialCompras());
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1":
                    Producto producto = vista.solicitarProducto();
                    agregarProducto(producto);
                    break;
                case "2":
                    listarProductos();
                    break;
                case "3":
                    String nombreEliminar = vista.solicitarNombreProducto();
                    eliminarProducto(nombreEliminar);
                    break;
                case "4":
                    double porcentajeDescuento = vista.solicitarPorcentajeDescuento();
                    aplicarDescuento(porcentajeDescuento);
                    break;
                case "5":
                    double costoEnvio = vista.solicitarCostoEnvio();
                    calcularEnvio(costoEnvio);
                    break;
                case "6":
                    verCarrito();
                    break;
                case "7":
                    realizarCompra();
                    break;
                case "8":
                    verHistorialCompras();
                    break;
                case "9":
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!opcion.equals("9"));
        vista.cerrarScanner();
    }
}
//MODELO
//Carrito
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class CarritoModelo {
    private List<Producto> productos;
    private double costoEnvio;

    public CarritoModelo() {
        productos = new ArrayList<>();
        costoEnvio = 0.0;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public boolean eliminarProducto(String nombreProducto) {
        return productos.removeIf(producto -> producto.getNombre().equalsIgnoreCase(nombreProducto));
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void vaciarCarrito() {
        productos.clear();
    }

    public double aplicarDescuento(double porcentaje) {
        double total = calcularTotal();
        return total * (porcentaje / 100);
    }

    public double calcularTotal() {
        double total = productos.stream().mapToDouble(Producto::getPrecio).sum();
        return total + costoEnvio;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }
}
//Producto
package Modelo;

public class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
//Compra
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class CompraModelo {
    private List<List<Producto>> historialCompras;

    public CompraModelo() {
        historialCompras = new ArrayList<>();
    }

    public void agregarCompra(List<Producto> productos, double totalCompra) {
        historialCompras.add(new ArrayList<>(productos));
    }

    public List<List<Producto>> getHistorialCompras() {
        return historialCompras;
    }
}
//Vista
package Vista;

import java.util.List;
import java.util.Scanner;
import Modelo.Producto;

public class CarritoVista {
    private Scanner scanner;

    public CarritoVista() {
        scanner = new Scanner(System.in);
    }

    public Producto solicitarProducto() {
        System.out.print("Introduce el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce el precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Consumir nueva línea
        return new Producto(nombre, precio);
    }

    public String solicitarNombreProducto() {
        System.out.print("Introduce el nombre del producto a eliminar: ");
        return scanner.nextLine();
    }

    public double solicitarPorcentajeDescuento() {
        System.out.print("Introduce el porcentaje de descuento: ");
        return scanner.nextDouble();
    }

    public double solicitarCostoEnvio() {
        System.out.print("Introduce el costo de envío: ");
        return scanner.nextDouble();
    }

    public void mostrarProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            System.out.println("Productos disponibles:");
            for (Producto producto : productos) {
                System.out.println("- " + producto.getNombre() + " (Precio: " + producto.getPrecio() + ")");
            }
        }
    }

    public void mostrarCarrito(List<Producto> productos, double total) {
        System.out.println("Productos en el carrito:");
        for (Producto producto : productos) {
            System.out.println("- " + producto.getNombre() + " (Precio: " + producto.getPrecio() + ")");
        }
        System.out.println("Total del carrito: " + total + " USD.");
    }

    public void mostrarHistorial(List<List<Producto>> historialCompras) {
        System.out.println("Historial de compras:");
        for (List<Producto> compra : historialCompras) {
            for (Producto producto : compra) {
                System.out.println("- " + producto.getNombre() + " (Precio: " + producto.getPrecio() + ")");
            }
        }
    }

    public void mostrarMenu() {
        System.out.println("\nOpciones:");
        System.out.println("1. Agregar Producto al Carrito");
        System.out.println("2. Listar Productos del Carrito");
        System.out.println("3. Eliminar Producto del Carrito");
        System.out.println("4. Aplicar Descuento");
        System.out.println("5. Calcular Envío");
        System.out.println("6. Ver Carrito");
        System.out.println("7. Realizar Compra");
        System.out.println("8. Ver Historial de Compras");
        System.out.println("9. Salir");
    }

    public String solicitarOpcion() {
        System.out.print("Selecciona una opción: ");
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
//Main
package Principal;

import Controlador.CarritoControlador;
import Modelo.CarritoModelo;
import Modelo.CompraModelo;
import Vista.CarritoVista;

public class Main {
    public static void main(String[] args) {
        CarritoModelo carrito = new CarritoModelo();
        CarritoVista vista = new CarritoVista();
        CompraModelo historialCompras = new CompraModelo();
        CarritoControlador controlador = new CarritoControlador(carrito, vista, historialCompras);
        controlador.iniciar();
    }
}

