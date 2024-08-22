import java.util.Scanner;

public class Ejer6 { //ConvertidorTiempoASegundos
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Solicitar al usuario que ingrese las horas, minutos y segundos
        System.out.print("Ingrese el número de horas: ");
        int horas = scanner.nextInt();
        System.out.print("Ingrese el número de minutos: ");
        int minutos = scanner.nextInt();
        System.out.print("Ingrese el número de segundos: ");
        int segundos = scanner.nextInt();
        // Convertir todo a segundos
        int totalSegundos = (horas * 3600) + (minutos * 60) + segundos;
        // Mostrar el resultado
        System.out.println("El equivalente en segundos es: " + totalSegundos);
        scanner.close();
    }
}
