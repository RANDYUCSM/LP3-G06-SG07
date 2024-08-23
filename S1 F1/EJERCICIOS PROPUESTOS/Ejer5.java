import java.util.Scanner;

    public class Ejer5 { //Estacionamiento
        public static double calcularCargo(double horas) {
            double cargo;
            if (horas <= 1) {
                cargo = 3.00;
            } else {
                cargo = 3.00;
                double horasAdicionales = horas - 1; // Cargo por horas adicionales
                cargo += horasAdicionales * 0.50;
            }
            if (cargo > 12.00) {
                cargo = 12.00;
            }
            
            return cargo;
        }
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el número de horas: ");
            double horas = scanner.nextDouble();
            double cargo = calcularCargo(horas);
            System.out.println("El cargo por el estacionamiento es: S/ " + cargo);
            scanner.close();
        }
    }
    
