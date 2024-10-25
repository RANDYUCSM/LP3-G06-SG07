package Actividad_3;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Binarios2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileOutputStream fos = null;
        DataOutputStream salida = null;
        double[][] matriz;
        int filas, columnas, i, j;

        do {
            System.out.print("Número de filas: ");
            filas = sc.nextInt();
        } while (filas <= 0);

        do {
            System.out.print("Número de columnas: ");
            columnas = sc.nextInt();
        } while (columnas <= 0);

        matriz = new double[filas][columnas];

        for (i = 0; i < filas; i++) {
            for (j = 0; j < columnas; j++) {
                System.out.print("matriz[" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextDouble();
            }
        }

        try {
            fos = new FileOutputStream("matriz.dat");
            salida = new DataOutputStream(fos);

            salida.writeInt(filas);
            salida.writeInt(columnas);

            for (i = 0; i < filas; i++) {
                for (j = 0; j < columnas; j++) {
                    salida.writeDouble(matriz[i][j]);
                }
            }

            System.out.println("Matriz guardada exitosamente en el archivo 'matriz.dat'.");

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        } finally {
            try {
                if (salida != null) {
                    salida.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo: " + e.getMessage());
            }
        }

        sc.close();
    }
}
