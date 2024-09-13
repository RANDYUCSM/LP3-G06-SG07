/*Para cumplir con el principio de responsabilidad única (SRP), podemos refactorizar la clase Empleado para que solo se encargue de almacenar la información del empleado, 
mientras que la lógica del cálculo del pago mensual la movemos a una clase separada llamada CalculadoraPago.*/
public class Empleado {
    private String nombre;
    private double salario;
    private String departamento;

    public Empleado(String nombre, double salario, String departamento) {
        this.nombre = nombre;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
//
public class CalculadoraPago {
    public double calcularPagoMensual(Empleado empleado) {
        return empleado.getSalario() / 8;
    }
}
//
public class Main {
    public static void main(String[] args) {
        Empleado empleado = new Empleado("JUANCITO", 7000, "Ingeniero");
        CalculadoraPago calculadora = new CalculadoraPago();
        double pagoMensual = calculadora.calcularPagoMensual(empleado);
        System.out.println("El pago mensual de " + empleado.getNombre() + " es: " + pagoMensual);
    }
}


