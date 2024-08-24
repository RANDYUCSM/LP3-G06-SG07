//Programe una función menor que tenga 3 números decimales y devuelva el menor de los 3.
public class Ejer4 {

    public static double menor(double num1, double num2, double num3) {
        double menor = num1;
        if (num2 < menor) menor = num2;
        if (num3 < menor) menor = num3;
        return menor;
    }

    public static void main(String[] args) {
        double numero1 = 5.7;
        double numero2 = 3.4;
        double numero3 = 8.2;
        System.out.println("El menor número es: " + menor(numero1, numero2, numero3));
    }
}
