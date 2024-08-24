//Un estacionamiento cobra S/3.00 por la primera hora, luego S/0.50 por cada hora siguiente. El
//cargo máximo por día es de S/12.00. Programe una función para que al ingresar el númerodehoras se imprima el cargo.
import java.util.Scanner;

    public class Ejer5 { //Estacionamiento
        public static double calcularCargo(double horas) {
            double cargo;
            if (horas <= 1) {
                cargo = 3.00;
            } else {
                cargo = 3.00;
                double horasAdicionales = horas - 1; 
                cargo += horasAdicionales * 0.50; // Cargo por horas adicionales
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
    
