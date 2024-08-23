//Lanza un dado 20000 veces y guarda la frecuencia de cada una de las 6 caras en un arreglo
import java.util.Random;
public class Ejer3 {  //LanzarDado
    public static void main(String[] args) {
        int[] frecuencias = new int[6]; 
        Random dado = new Random();
        for (int i = 0; i < 20000; i++) {
            int resultado = dado.nextInt(6) + 1; 
            frecuencias[resultado - 1]++; 
        }
        // Imprimimos las frecuencias de cada cara
        for (int i = 0; i < frecuencias.length; i++) {
            System.out.println("Cara " + (i + 1) + ": " + frecuencias[i] + " veces");
        }
    }
}
