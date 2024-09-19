// Excepción para cuando no hay transacciones en la cuenta
class HistorialVacioException extends Exception {
    public HistorialVacioException(String mensaje) {
        super(mensaje);
    }
}
//
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReporteTransacciones {

    public static void generarReporte(CuentaBancaria cuenta, String nombreArchivo) throws IOException, HistorialVacioException {
        if (cuenta.consultarSaldo() == 0) {
            throw new HistorialVacioException("No hay transacciones en esta cuenta para generar el reporte.");
        }

        try (FileWriter escritor = new FileWriter(nombreArchivo)) {
            escritor.write("Reporte de Transacciones\n");
            escritor.write("Número de Cuenta: " + cuenta.getNumeroCuenta() + "\n");
            escritor.write("Titular: " + cuenta.getTitular() + "\n");
            escritor.write("Saldo: " + cuenta.consultarSaldo() + "\n");
            System.out.println("Reporte generado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
            throw e;  
        }
    }

    public static void leerReporte(String nombreArchivo) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
            System.out.println("Leyendo reporte de transacciones:");
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no fue encontrado: " + e.getMessage());
            throw e;  
        }
    }
}
public class TestReporteTransacciones {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria("12345", "Ana López", 1000);

        CuentaBancaria cuentaVacia = new CuentaBancaria("67890", "Carlos Díaz", 0);

        try {
            System.out.println("\nGenerando reporte para Ana...");
            ReporteTransacciones.generarReporte(cuenta1, "reporte_ana.txt");
        } catch (IOException | HistorialVacioException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("\nIntentando generar reporte para Carlos...");
            ReporteTransacciones.generarReporte(cuentaVacia, "reporte_carlos.txt");
        } catch (IOException | HistorialVacioException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            System.out.println("\nLeyendo reporte de Ana...");
            ReporteTransacciones.leerReporte("reporte_ana.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            System.out.println("\nIntentando leer reporte inexistente...");
            ReporteTransacciones.leerReporte("reporte_inexistente.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
