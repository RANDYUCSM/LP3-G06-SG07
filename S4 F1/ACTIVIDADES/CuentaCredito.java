// Excepción para cuando se excede el límite de crédito
class LimiteCreditoExcedidoException extends Exception {
    public LimiteCreditoExcedidoException(String mensaje) {
        super(mensaje);
    }
}
public class CuentaCredito extends CuentaBancaria {
    private double limiteCredito;

    // Constructor de la clase CuentaCredito
    public CuentaCredito(String numeroCuenta, String titular, double saldoInicial, double limiteCredito) {
        super(numeroCuenta, titular, saldoInicial);
        this.limiteCredito = limiteCredito;
    }

    public void retirar(double monto) throws SaldoInsuficienteException, LimiteCreditoExcedidoException {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo.");
        }

        double saldoDisponible = consultarSaldo() + limiteCredito; // Considera saldo + límite de crédito

        if (monto > saldoDisponible) {
            throw new LimiteCreditoExcedidoException("La operación excede el límite de crédito disponible.");
        }

        if (monto > consultarSaldo()) {
            double diferencia = monto - consultarSaldo();
            System.out.println("Usando " + diferencia + " del crédito.");
        }

        super.retirar(monto); 
    }

    public void transferir(CuentaBancaria destino, double monto) throws SaldoInsuficienteException, LimiteCreditoExcedidoException, CuentaNoEncontradaException {
        if (destino == null) {
            throw new CuentaNoEncontradaException("La cuenta destino no fue encontrada.");
        }

        double saldoDisponible = consultarSaldo() + limiteCredito;

        if (monto > saldoDisponible) {
            throw new LimiteCreditoExcedidoException("La transferencia excede el límite de crédito disponible.");
        }

        super.transferir(destino, monto); 
    }

    public void mostrarInfoCredito() {
        System.out.println("Límite de crédito: " + limiteCredito);
    }
}
