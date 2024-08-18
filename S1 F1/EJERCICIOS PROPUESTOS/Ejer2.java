import java.util.Scanner;


public class Ejer2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10];
        int anterior = Integer.MIN_VALUE; // Inicialización con el valor más bajo posible


        System.out.println("Ingrese 10 números en orden ascendente:");


        for (int i = 0; i < numeros.length; i++) {
            int numero;
            while (true) {
                System.out.print("Número " + (i + 1) + ": ");
                numero = scanner.nextInt();
                
                if (numero > anterior) {
                    numeros[i] = numero;
                    anterior = numero;
                    break;  
                } else {
                    System.out.println("El número debe ser mayor que el anterior (" + anterior + "). Inténtelo de nuevo.");
                }
            }
        }


        System.out.println("\nIngrese numeros en orden ascendente:");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        
        scanner.close();
    }
}
