public class Habitacion {
    protected int numero;
    protected String tipo;
    protected double precio;

    public Habitacion(int numero, String tipo, double precio) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
    }

    public double calcularPrecio() {
        return this.precio;
    }

    public String getTipo() {
        return tipo;
    }
}
//
public class HabitacionEstandar extends Habitacion {
    public HabitacionEstandar(int numero, double precio) {
        super(numero, "Estandar", precio);
    }

    public double calcularPrecio() {
        return super.calcularPrecio();
    }
}
//
public class HabitacionLujo extends Habitacion {
    private double tarifaExtra;

    public HabitacionLujo(int numero, double precio, double tarifaExtra) {
        super(numero, "Lujo", precio);
        this.tarifaExtra = tarifaExtra;
    }

    public double calcularPrecio() {
        return super.calcularPrecio() + tarifaExtra;
    }
}
//
import java.util.List;

public class ControladorHabitaciones {
    private List<Habitacion> habitaciones;

    public ControladorHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public void mostrarPreciosHabitaciones() {
        for (Habitacion habitacion : habitaciones) {
            try {
                System.out.println("Precio de la habitación " + habitacion.getTipo() + ": " + habitacion.calcularPrecio());
            } catch (UnsupportedOperationException e) {
                System.out.println("No se puede calcular el precio para la habitación: " + habitacion.getTipo());
            }
        }
    }
}
//
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Habitacion> habitaciones = new ArrayList<>();
        habitaciones.add(new HabitacionEstandar(101, 100.0));
        habitaciones.add(new HabitacionLujo(102, 200.0, 50.0));
        habitaciones.add(new HabitacionGratis(103));

        ControladorHabitaciones controlador = new ControladorHabitaciones(habitaciones);
        controlador.mostrarPreciosHabitaciones();
    }
}
