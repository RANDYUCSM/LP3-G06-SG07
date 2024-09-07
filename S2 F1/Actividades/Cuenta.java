public class Cuenta {
    protected double saldo;


    public Cuenta() {
        saldo = 0.0;
    }


    public void depositar(double monto) {
        saldo += monto;
    }


    public void retirar(double monto) {
        saldo -= monto;
    }


    public double getSaldo() {
        return saldo;
    }


    public void consultar() {
        // Este método será sobreescrito en las subclases
    }
}
//
public class CuentaAhorro extends Cuenta {
    private double tasaInteres;
    private double minSaldo;


    public CuentaAhorro(double tasaInteres) {
        this.tasaInteres = tasaInteres;
        this.minSaldo = saldo; 
    }


    @Override
    public void retirar(double monto) {
        super.retirar(monto);
        if (saldo < minSaldo) {
            minSaldo = saldo;
        }
    }


    @Override
    public void consultar() {
        // Calcula los intereses basados en el saldo mínimo mensual
        double interes = minSaldo * tasaInteres / 100;
        depositar(interes);
        minSaldo = saldo;  // Reinicia el saldo mínimo después de acumular intereses
    }
}
//
public class CuentaCorriente extends Cuenta {
    private int retiros;
    private static final int LIBRE_RETIROS = 3;
    private static final double TARIFA_TRANSACCION = 3.0;


    public CuentaCorriente() {
        retiros = 0;
    }


    @Override
    public void retirar(double monto) {
        super.retirar(monto);
        retiros++;
        if (retiros > LIBRE_RETIROS) {
            super.retirar(TARIFA_TRANSACCION); 
        }
    }


    @Override
    public void consultar() {
        // Resetea el contador de retiros
        retiros = 0;
    }
}
//
import java.util.Scanner;
public class AppBanco {
    public static void main(String[] args) {
        // Crear 5 cuentas de ahorro y 5 cuentas corrientes
        Cuenta[] cuentas = new Cuenta[10];
        for (int i = 0; i < 5; i++) {
            cuentas[i] = new CuentaAhorro(5.0);  // Tasa de interés del 5% para las cuentas de ahorro
        }
        for (int i = 5; i < 10; i++) {
            cuentas[i] = new CuentaCorriente();  // Cuentas corrientes
        }


        Scanner in = new Scanner(System.in);
        boolean done = false;


        while (!done) {
            System.out.print("D)epositar R)etirar C)onsultar S)alir: ");
            String op = in.next();


            if (op.equalsIgnoreCase("S")) {
                done = true;  // Salir del programa
            } else if (op.equalsIgnoreCase("D") || op.equalsIgnoreCase("R")) {
                // Solicitar número de cuenta y monto
                System.out.print("Ingrese el número de cuenta (0-9): ");
                int num = in.nextInt();
                System.out.print("Ingrese el monto: ");
                double monto = in.nextDouble();


                if (op.equalsIgnoreCase("D")) {
                    cuentas[num].depositar(monto);
                } else if (op.equalsIgnoreCase("R")) {
                    cuentas[num].retirar(monto);
                }
                System.out.println("Saldo actual: S/." + cuentas[num].getSaldo());
            } else if (op.equalsIgnoreCase("C")) {
                // Consultar todas las cuentas
                for (int i = 0; i < cuentas.length; i++) {
                    cuentas[i].consultar();
                    System.out.println("Cuenta " + i + " - Saldo: S/." + cuentas[i].getSaldo());
                }
            }
        }


        in.close();
    }
}
