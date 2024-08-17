package S1 F1.Actividades;

public class Actividad_4 {
    
public class MenorNumero {

    public static double menor(double num1, double num2, double num3) {
        return Math.min(num1, Math.min(num2, num3));
    }

    public static void main(String[] args) {
        double numero1 = 5.7;
        double numero2 = 3.4;
        double numero3 = 8.2;
        System.out.println("El menor número es: " + menor(numero1, numero2, numero3));
    }
}

