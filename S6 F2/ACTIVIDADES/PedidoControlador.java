//CONTROLADOR
package Controlador;

import java.util.List;
import Modelo.Pedido;
import Modelo.PedidoModelo;
import Vista.PedidoVista;

public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;

    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarPedido(String nombrePlato, String tipoPlato) {
        if (!nombrePlato.trim().isEmpty() && !tipoPlato.trim().isEmpty()) {
            modelo.agregarPedido(new Pedido(nombrePlato, tipoPlato));
            vista.mostrarMensaje("Pedido agregado: " + nombrePlato + " (" + tipoPlato + ")");
        } else {
            vista.mostrarMensaje("El nombre y tipo del plato no pueden estar vacíos.");
        }
    }

    public void eliminarPedido(String nombrePlato) {
        if (modelo.eliminarPedido(nombrePlato)) {
            vista.mostrarMensaje("Pedido eliminado: " + nombrePlato);
        } else {
            vista.mostrarMensaje("Pedido no encontrado.");
        }
    }

    public void actualizarPedido(String nombreActual, String nuevoNombre) {
        if (modelo.actualizarPedido(nombreActual, nuevoNombre)) {
            vista.mostrarMensaje("Pedido actualizado: " + nombreActual + " a " + nuevoNombre);
        } else {
            vista.mostrarMensaje("Pedido no encontrado.");
        }
    }

    public void buscarPedido(String criterio) {
        List<Pedido> resultados = modelo.buscarPedido(criterio);
        if (resultados.isEmpty()) {
            vista.mostrarMensaje("No se encontraron pedidos.");
        } else {
            vista.mostrarPedidos(resultados);
        }
    }

    public void contarPedidos() {
        int total = modelo.contarPedidos();
        vista.mostrarMensaje("Total de pedidos: " + total);
        vista.mostrarConteoPorTipo(modelo.contarPedidosPorTipo());
    }

    public void mostrarPedidos() {
        List<Pedido> pedidos = modelo.getPedidos();
        vista.mostrarPedidos(pedidos);
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1":
                    String nombrePlato = vista.solicitarNombrePlato();
                    String tipoPlato = vista.solicitarTipoPlato();
                    agregarPedido(nombrePlato, tipoPlato);
                    break;
                case "2":
                    mostrarPedidos();
                    break;
                case "3":
                    String nombreEliminar = vista.solicitarNombrePlato();
                    eliminarPedido(nombreEliminar);
                    break;
                case "4":
                    String nombreActual = vista.solicitarNombrePlato();
                    String nuevoNombre = vista.solicitarNuevoNombrePlato();
                    actualizarPedido(nombreActual, nuevoNombre);
                    break;
                case "5":
                    String criterio = vista.solicitarCriterioBusqueda();
                    buscarPedido(criterio);
                    break;
                case "6":
                    contarPedidos();
                    break;
                case "7":
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!opcion.equals("7"));

        vista.cerrarScanner();
    }
}
//MODELO Pedido
package Modelo;

public class Pedido {
    private String nombrePlato;
    private String tipoPlato;

    public Pedido(String nombrePlato, String tipoPlato) {
        this.nombrePlato = nombrePlato;
        this.tipoPlato = tipoPlato;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getTipoPlato() {
        return tipoPlato;
    }

    public void setTipoPlato(String tipoPlato) {
        this.tipoPlato = tipoPlato;
    }
}
//MODELO PedidoModelo
package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PedidoModelo {
    private List<Pedido> pedidos;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public boolean eliminarPedido(String nombrePlato) {
        return pedidos.removeIf(pedido -> pedido.getNombrePlato().equalsIgnoreCase(nombrePlato));
    }

    public boolean actualizarPedido(String nombreActual, String nuevoNombre) {
        for (Pedido pedido : pedidos) {
            if (pedido.getNombrePlato().equalsIgnoreCase(nombreActual)) {
                pedido.setNombrePlato(nuevoNombre);
                return true;
            }
        }
        return false;
    }

    public List<Pedido> buscarPedido(String criterio) {
        List<Pedido> resultados = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getNombrePlato().equalsIgnoreCase(criterio) || pedido.getTipoPlato().equalsIgnoreCase(criterio)) {
                resultados.add(pedido);
            }
        }
        return resultados;
    }

    public int contarPedidos() {
        return pedidos.size();
    }

    public Map<String, Integer> contarPedidosPorTipo() {
        Map<String, Integer> conteoPorTipo = new HashMap<>();
        for (Pedido pedido : pedidos) {
            conteoPorTipo.put(pedido.getTipoPlato(), conteoPorTipo.getOrDefault(pedido.getTipoPlato(), 0) + 1);
        }
        return conteoPorTipo;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
//Vista
package Vista;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import Modelo.Pedido;

public class PedidoVista {
    private Scanner scanner;

    public PedidoVista() {
        scanner = new Scanner(System.in);
    }

    public String solicitarNombrePlato() {
        System.out.print("Introduce el nombre del plato: ");
        return scanner.nextLine().trim();
    }

    public String solicitarTipoPlato() {
        System.out.print("Introduce el tipo del plato: ");
        return scanner.nextLine().trim();
    }

    public String solicitarNuevoNombrePlato() {
        System.out.print("Introduce el nuevo nombre del plato: ");
        return scanner.nextLine().trim();
    }

    public String solicitarCriterioBusqueda() {
        System.out.print("Introduce el nombre o tipo del plato para buscar: ");
        return scanner.nextLine().trim();
    }

    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos en la lista.");
        } else {
            System.out.println("Lista de Pedidos:");
            for (Pedido pedido : pedidos) {
                System.out.println("- " + pedido.getNombrePlato() + " (" + pedido.getTipoPlato() + ")");
            }
        }
    }

    public void mostrarMenu() {
        System.out.println("\nOpciones:");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos");
        System.out.println("3. Eliminar Pedido");
        System.out.println("4. Actualizar Pedido");
        System.out.println("5. Buscar Pedido");
        System.out.println("6. Contar Pedidos");
        System.out.println("7. Salir");
    }

    public String solicitarOpcion() {
        System.out.print("Selecciona una opción: ");
        return scanner.nextLine().trim();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarConteoPorTipo(Map<String, Integer> conteoPorTipo) {
        System.out.println("Conteo de pedidos por tipo:");
        for (String tipo : conteoPorTipo.keySet()) {
            System.out.println(tipo + ": " + conteoPorTipo.get(tipo));
        }
    }

    public void cerrarScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
//Main
package Principal;

import Controlador.PedidoControlador;
import Modelo.PedidoModelo;
import Vista.PedidoVista;

public class Main {
    public static void main(String[] args) {
        PedidoModelo modelo = new PedidoModelo();
        PedidoVista vista = new PedidoVista();
        PedidoControlador controlador = new PedidoControlador(modelo, vista);
        controlador.iniciar();
    }
}

