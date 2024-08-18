import java.util.Scanner;

public class NumerosPerfectosConFunciones_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int n = scanner.nextInt();
        imprimirNumerosPerfectos(n);
    }

    public static boolean esPerfecto(int num) {
        int sumaDivisores = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sumaDivisores += i;
            }
        }
        return sumaDivisores == num;
    }

    public static void imprimirNumerosPerfectos(int n) {
        System.out.println("Números perfectos menores que " + n + ":");
        boolean encontrado = false; 
        for (int num = 1; num < n; num++) {
            if (esPerfecto(num)) {
                System.out.println(num);
                encontrado = true;
            }
        }
    }
}
