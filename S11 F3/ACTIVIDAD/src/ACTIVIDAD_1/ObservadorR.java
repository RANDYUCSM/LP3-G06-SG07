package ACTIVIDAD_1;

import java.util.Scanner;

public class ObservadorR {
    public static void main(String[] args) {
        Scanner escáner = new Scanner(System.in);
        CanalDeNoticias canal = new CanalDeNoticias();

        System.out.print("Ingrese el número de suscriptores: ");
        int numeroDeSuscriptores = escáner.nextInt();
        escáner.nextLine();
        for (int i = 0; i < numeroDeSuscriptores; i++) {
            System.out.print("Ingrese el nombre del suscriptor " + (i + 1) + ": ");
            String nombreUsuario = escáner.nextLine();
            Usuario usuario = new Usuario(nombreUsuario);
            canal.suscribir(usuario);
        }

        System.out.print("Ingrese el mensaje para notificar a los suscriptores: ");
        String mensajeNotificacion = escáner.nextLine();
        canal.notificarSuscriptores(mensajeNotificacion);

        System.out.print("¿Desea desuscribir a algún usuario? (sí/no): ");
        String respuesta = escáner.nextLine();

        if (respuesta.equalsIgnoreCase("sí")) {
            System.out.print("Ingrese el nombre del usuario a desuscribir: ");
            String nombreUsuarioDesuscribir = escáner.nextLine();

            for (Observador observador : canal.suscriptores) {
                if (observador instanceof Usuario && ((Usuario) observador).nombre.equals(nombreUsuarioDesuscribir)) {
                    canal.desuscribir(observador);
                    System.out.println(nombreUsuarioDesuscribir + " ha sido desuscrito.");
                    break;
                }
            }
        }

        escáner.close();
    }
}