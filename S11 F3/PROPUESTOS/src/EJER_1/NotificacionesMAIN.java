package EJER_1;

import java.util.Scanner;

public class NotificacionesMAIN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Notificacion sistema = new Notificacion();

        while (true) {
            try {
                System.out.println("\nMenú:");
                System.out.println("1. Suscribir usuario");
                System.out.println("2. Desuscribir usuario");
                System.out.println("3. Enviar notificación");
                System.out.println("4. Salir");
                System.out.print("Elige una opción: ");
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Introduce el nombre del usuario para suscribir: ");
                        String nombre = scanner.nextLine();
                        Usuario nuevoUsuario = new Usuario(nombre);
                        sistema.suscribir(nuevoUsuario);
                        break;

                    case 2:
                        System.out.print("Introduce el nombre del usuario para desuscribir: ");
                        String nombreDes = scanner.nextLine();
                        Observer usuarioADesuscribir = sistema.usuarios.stream()
                                .filter(u -> ((Usuario) u).getNombre().equals(nombreDes))
                                .findFirst()
                                .orElse(null);
                        if (usuarioADesuscribir != null) {
                            sistema.desuscribir(usuarioADesuscribir);
                        } else {
                            System.out.println("Usuario no encontrado.");
                        }
                        break;

                    case 3:
                        System.out.print("Introduce el mensaje de notificación: ");
                        String mensaje = scanner.nextLine();
                        sistema.notificar(mensaje);
                        break;

                    case 4:
                        System.out.println("Saliendo del sistema...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (Exception e) { 
                System.err.println("Error inesperado: " + e.getMessage());
            }
        }
    }
}

