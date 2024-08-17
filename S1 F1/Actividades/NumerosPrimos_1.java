//RANDY
import java.util.Scanner;

public class NumerosPrimos_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int n = scanner.nextInt();
        imprimirNumerosPrimos(n);
    }
    public static boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        int raizEntera = raizCuadradaEntera(num);
        // Iteramos desde 2 hasta la raíz cuadrada del número
        for (int i = 2; i <= raizEntera; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int raizCuadradaEntera(int num) {
        int i = 1;
        while (i * i <= num) {
            i++;
        }
        return i - 1;
    }

    // Función para imprimir todos los números primos desde 2 hasta n
    public static void imprimirNumerosPrimos(int n) {
        System.out.println("Números primos entre 1 y " + n + ":");
        for (int num = 2; num <= n; num++) {
            if (esPrimo(num)) {
                System.out.print(num + " ");
                System.out.println();
            }
        }
    }
}

//