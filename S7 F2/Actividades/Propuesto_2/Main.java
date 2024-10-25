package Propuesto_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor("personajes.txt");
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Agregar personaje");
            System.out.println("2. Mostrar personajes");
            System.out.println("3. Modificar personaje");
            System.out.println("4. Eliminar personaje");
            System.out.println("5. Filtrar personajes por atributo");
            System.out.println("6. Mostrar estadísticas");
            System.out.println("7. Cargar personajes aleatorios");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        agregarPersonaje(gestor, scanner);
                        break;
                    case 2:
                        gestor.mostrarPersonajes();
                        break;
                    case 3:
                        modificarPersonaje(gestor, scanner);
                        break;
                    case 4:
                        eliminarPersonaje(gestor, scanner);
                        break;
                    case 5:
                        filtrarPorAtributo(gestor, scanner);
                        break;
                    case 6:
                        gestor.mostrarEstadisticas();
                        break;
                    case 7:
                        gestor.cargarPersonajesAleatorios();
                        System.out.println("Personajes aleatorios cargados.");
                        gestor.mostrarPersonajes();
                        break;
                    case 8:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.nextLine(); // Limpiar el buffer en caso de error
                opcion = 0; 
            }
        } while (opcion != 8);
    }

    public static void agregarPersonaje(Gestor gestor, Scanner scanner) {
        System.out.println("\nAGREGAR PERSONAJE ");
        System.out.print("Ingrese el nombre del personaje: ");
        String nombre = scanner.nextLine();

        int vida = ingresarEnteroPositivo(scanner, "vida");
        int ataque = ingresarEnteroPositivo(scanner, "ataque");
        int defensa = ingresarEnteroPositivo(scanner, "defensa");
        int alcance = ingresarEnteroPositivo(scanner, "alcance");
        int nivel = ingresarEnteroPositivo(scanner, "nivel");

        gestor.agregarPersonaje(nombre, vida, ataque, defensa, alcance, nivel);
    }

    public static void modificarPersonaje(Gestor gestor, Scanner scanner) {
        System.out.println("\nMODIFICAR PERSONAJE ");
        System.out.print("Ingrese el nombre del personaje a modificar: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el atributo a modificar (vida, ataque, defensa, alcance): ");
        String atributo = scanner.nextLine().toLowerCase();

        if (!atributo.equals("vida") && !atributo.equals("ataque") && !atributo.equals("defensa") && !atributo.equals("alcance")) {
            System.out.println("Atributo no válido. Intente de nuevo.");
            return;
        }

        int nuevoValor = ingresarEnteroPositivo(scanner, atributo);

        gestor.actualizarAtributoIndividual(nombre, atributo, nuevoValor);
    }

    public static void eliminarPersonaje(Gestor gestor, Scanner scanner) {
        System.out.println("\nELIMINAR PERSONAJE ");
        System.out.print("Ingrese el nombre del personaje a eliminar: ");
        String nombre = scanner.nextLine();
        gestor.eliminarPersonaje(nombre);
    }

    public static void filtrarPorAtributo(Gestor gestor, Scanner scanner) {
        System.out.println("\nFILTRAR PERSONAJES ");
        System.out.print("Ingrese el atributo por el cual filtrar (vida, ataque, defensa, alcance): ");
        String atributo = scanner.nextLine();
        gestor.filtrarPorAtributo(atributo);
    }

    public static int ingresarEnteroPositivo(Scanner scanner, String atributo) {
        int valor;
        while (true) {
            try {
                System.out.print("Ingrese el valor de " + atributo + " (mayor que cero): ");
                valor = scanner.nextInt();
                if (valor <= 0) {
                    System.out.println("El valor debe ser mayor que cero.");
                } else {
                    return valor;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número entero válido.");
                scanner.nextLine(); 
            }
        }
    }
}

