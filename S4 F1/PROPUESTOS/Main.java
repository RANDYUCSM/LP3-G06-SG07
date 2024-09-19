public class Numero {
    private double valor;

    // Constructor
    public Numero(double valor) {
        setValor(valor);  
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("El valor no puede ser negativo: " + valor);
        }
        this.valor = valor;
    }
}
//
public class Main {
    public static void main(String[] args) {
        try {
            Numero numeroPositivo = new Numero(10.5);
            System.out.println("Valor inicial (positivo): " + numeroPositivo.getValor());

            numeroPositivo.setValor(-5.2);
            System.out.println("Nuevo valor: " + numeroPositivo.getValor());

        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        System.out.println("Programa finalizado.");
    }
}
