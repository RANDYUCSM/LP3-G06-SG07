package EJER_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        CalculadoraDePrecios calculadora = new CalculadoraDePrecios();
        List<Producto> productos = new ArrayList<>();

        while (true) {
            try {
                System.out.println("\nMenú:");
                System.out.println("1. Agregar producto");
                System.out.println("2. Seleccionar estrategia de descuento");
                System.out.println("3. Salir");
                System.out.print("Opción: ");

                int opcion = Integer.parseInt(scanner.nextLine().trim());

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombre = scanner.nextLine().trim();
                        System.out.print("Ingrese el precio del producto: ");
                        double precio = Double.parseDouble(scanner.nextLine().trim());
                        productos.add(new Producto(nombre, precio));
                        System.out.println("Producto agregado exitosamente.");
                        break;

                    case 2:
                        if (productos.isEmpty()) {
                            System.out.println("No hay productos en la lista. Por favor, agregue productos primero.");
                            break;
                        }

                        System.out.println("\nSeleccione una estrategia de descuento:");
                        System.out.println("1. Sin Descuento");
                        System.out.println("2. Descuento Fijo (10%)");
                        System.out.println("3. Descuento Porcentual (30% para 2 productos iguales)");
                        System.out.println("4. Descuento Porcentual Acumulado (50% en el más barato a partir de 3 productos)");
                        System.out.print("Opción: ");

                        int estrategia = Integer.parseInt(scanner.nextLine().trim());

                        switch (estrategia) {
                            case 1:
                                calculadora.setEstrategia(new SinDescuento());
                                break;
                            case 2:
                                calculadora.setEstrategia(new DescuentoFijo());
                                break;
                            case 3:
                                calculadora.setEstrategia(new DescuentoPorcentual());
                                break;
                            case 4:
                                calculadora.setEstrategia(new DescuentoPorcentualAcumulado());
                                break;
                            default:
                                System.out.println("Opción inválida. Volviendo al menú principal.");
                                continue;
                        }

                        double precioFinal = calculadora.calcularPrecioFinal(productos);
                        System.out.printf("El precio final con el descuento aplicado es: $%.2f%n", precioFinal);
                        break;

                    case 3:
                        System.out.println("Saliendo...");
                        return;

                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            }
        }
    }
}
