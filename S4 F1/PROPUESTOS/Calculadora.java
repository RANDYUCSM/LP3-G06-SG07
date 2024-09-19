// Excepción personalizada para la división por cero
class DivisionPorCeroException extends Exception {
    public DivisionPorCeroException() {
        super("Error: No se puede dividir por cero.");
    }
}
//
public class Calculadora {

    public double sumar(double a, double b) {
        return a + b;
    }

    public double restar(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }
    public double dividir(double a, double b) throws DivisionPorCeroException {
        if (b == 0) {
            throw new DivisionPorCeroException();
        }
        return a / b;
    }
}
//
public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        double resultado = 0;
        
        try {
            resultado = calculadora.sumar(5, 3);
            System.out.println("Resultado de la suma: " + resultado);

            resultado = calculadora.restar(10, 4);
            System.out.println("Resultado de la resta: " + resultado);

            resultado = calculadora.multiplicar(6, 7);
            System.out.println("Resultado de la multiplicación: " + resultado);

            resultado = calculadora.dividir(20, 0);  // Intento de división por 0
            System.out.println("Resultado de la división: " + resultado);
        
        } catch (DivisionPorCeroException e) {
            System.out.println(e.getMessage());
        
        } catch (IllegalArgumentException e) {
            System.out.println("Error de argumento inválido: " + e.getMessage());
        
        } catch (ArithmeticException e) {
            System.out.println("Error aritmético: " + e.getMessage());
        }

        System.out.println("Programa finalizado.");
    }
}

