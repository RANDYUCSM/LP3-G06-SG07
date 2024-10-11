import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Pedido {
    private String nombrePlato;
    private String estado; // "Pendiente", "Completo" o "Eliminado"


    public Pedido(String nombrePlato) {
        this.nombrePlato = nombrePlato;
        this.estado = "Pendiente"; // Estado inicial
    }


    public String getNombrePlato() {
        return nombrePlato;
    }


    public String getEstado() {
        return estado;
    }


    public void marcarCompleto() {
        this.estado = "Completo";
    }


    public void eliminar() {
        this.estado = "Eliminado";
    }
}


public class PedidoModelo {
    private List<Pedido> pedidos;


    public PedidoModelo() {
        pedidos = new ArrayList<>();
    }


    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }


    public List<Pedido> getPedidos() {
        return pedidos;
    }


    public List<Pedido> getPedidosPorEstado(String estado) {
        List<Pedido> pedidosFiltrados = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getEstado().equalsIgnoreCase(estado)) {
                pedidosFiltrados.add(pedido);
            }
        }
        return pedidosFiltrados;
    }


    public int contarPedidosPendientes() {
        int contador = 0;
        for (Pedido pedido : pedidos) {
            if (pedido.getEstado().equals("Pendiente")) {
                contador++;
            }
        }
        return contador;
    }


    public List<Pedido> getHistorial() {
        List<Pedido> historial = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (!pedido.getEstado().equals("Pendiente")) {
                historial.add(pedido);
            }
        }
        return historial;
    }
}


public class PedidoVista {
    private Scanner scanner;


    public PedidoVista() {
        scanner = new Scanner(System.in);
    }


    public String solicitarNombrePlato() {
        System.out.print("Introduce el nombre del plato: ");
        return scanner.nextLine();
    }


    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos en la lista.");
        } else {
            System.out.println("Lista de Pedidos:");
            for (Pedido pedido : pedidos) {
                System.out.println("- " + pedido.getNombrePlato() + " (" + pedido.getEstado() + ")");
            }
        }
    }


    public void mostrarMenu() {
        System.out.println("\nOpciones:");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos");
        System.out.println("3. Marcar Pedido como Completo");
        System.out.println("4. Mostrar Pedidos Pendientes");
        System.out.println("5. Mostrar Pedidos Completos");
        System.out.println("6. Contar Pedidos Pendientes");
        System.out.println("7. Ver Historial de Pedidos");
        System.out.println("8. Salir");
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


public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;


    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }


    public void agregarPedido(String nombrePlato) {
        if (!nombrePlato.isEmpty()) {
            modelo.agregarPedido(new Pedido(nombrePlato));
            vista.mostrarMensaje("Pedido agregado: " + nombrePlato);
        } else {
            vista.mostrarMensaje("El nombre del plato no puede estar vacío.");
        }
    }


    public void mostrarPedidos() {
        List<Pedido> pedidos = modelo.getPedidos();
        vista.mostrarPedidos(pedidos);
    }


    public void marcarPedidoCompleto(String nombrePlato) {
        for (Pedido pedido : modelo.getPedidos()) {
            if (pedido.getNombrePlato().equalsIgnoreCase(nombrePlato)) {
                pedido.marcarCompleto();
                vista.mostrarMensaje("Pedido marcado como completo: " + nombrePlato);
                return;
            }
        }
        vista.mostrarMensaje("Pedido no encontrado: " + nombrePlato);
    }


    public void mostrarPedidosPorEstado(String estado) {
        List<Pedido> pedidos = modelo.getPedidosPorEstado(estado);
        vista.mostrarPedidos(pedidos);
    }


    public void contarPedidosPendientes() {
        int cantidad = modelo.contarPedidosPendientes();
        vista.mostrarMensaje("Pedidos pendientes: " + cantidad);
    }


    public void mostrarHistorial() {
        List<Pedido> historial = modelo.getHistorial();
        vista.mostrarPedidos(historial);
    }


    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1":
                    String nombrePlato = vista.solicitarNombrePlato();
                    agregarPedido(nombrePlato);
                    break;
                case "2":
                    mostrarPedidos();
                    break;
                case "3":
                    String pedidoCompleto = vista.solicitarNombrePlato();
                    marcarPedidoCompleto(pedidoCompleto);
                    break;
                case "4":
                    mostrarPedidosPorEstado("Pendiente");
                    break;
                case "5":
                    mostrarPedidosPorEstado("Completo");
                    break;
                case "6":
                    contarPedidosPendientes();
                    break;
                case "7":
                    mostrarHistorial();
                    break;
                case "8":
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!opcion.equals("8"));
        vista.cerrarScanner();
    }
}


public class Main {
    public static void main(String[] args) {
        PedidoModelo modelo = new PedidoModelo();
        PedidoVista vista = new PedidoVista();
        PedidoControlador controlador = new PedidoControlador(modelo, vista);
        controlador.iniciar();
    }
}

