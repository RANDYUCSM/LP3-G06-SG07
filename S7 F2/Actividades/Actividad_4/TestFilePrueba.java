package Actividad_4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;

public class TestFilePrueba {
    public static void main(String[] args) {
        FileInputStream file = null;
        byte[] b = new byte[1024];

        try {
            file = new FileInputStream("src/archivos/TestFile.java");
            
            int bytesRead = file.read(b);
           
            String s = new String(b, 0, bytesRead);
        
            ViewFile view = new ViewFile(s);
            view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            view.setSize(400, 150);
            view.setVisible(true);

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        } finally {
            try {
                if (file != null) {
                    file.close(); 
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo: " + e.getMessage());
            }
        }
    }
}
