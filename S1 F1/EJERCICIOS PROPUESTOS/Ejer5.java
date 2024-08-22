public class Ejer5 { //Estacionamiento
    public static void main(String[] args) {
        int numerohoras = 10; 
        double cargo = calcularCargo(numerohoras);
        System.out.println("El cargo por " + numerohoras + " horas es:" + cargo);
    }
    public static double calcularCargo(int horas) {
        double cargo = 0.0;
        int horasRestantes = horas;
        if (horasRestantes > 0) {
            cargo = 3.00;
            horasRestantes--;
        }
        while (horasRestantes > 0 && cargo < 12.00) {
            cargo += 0.50;
            horasRestantes--;
        }
        if (cargo > 12.00) {
            cargo = 12.00;
        }
        return cargo;
    }
}
