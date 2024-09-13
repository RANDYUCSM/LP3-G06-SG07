import java.util.List;

public class Habitacion {
    private int numero;
    private String tipo;
    private double precioBase;
    private GestorDisponibilidadHabitacion gestorDisponibilidad;

    public Habitacion(int numero, String tipo, double precioBase, GestorDisponibilidadHabitacion gestorDisponibilidad) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioBase = precioBase;
        this.gestorDisponibilidad = gestorDisponibilidad;
    }

    public double calcularPrecio(Temporada temporada, Promocion promocion) {
        double precioFinal = this.precioBase;
        if (temporada != null) {
            precioFinal += temporada.getIncremento();
        }
        if (promocion != null) {
            precioFinal -= promocion.getDescuento();
        }
        return precioFinal;
    }

    public void generarInformeOcupacion() {
        System.out.println("Informe de ocupación de la habitación " + numero);
    }

    public boolean estaDisponible(RangoFechas rangoFechas) {
        return gestorDisponibilidad.verificarDisponibilidad(this, rangoFechas);
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecioBase() {
        return precioBase;
    }
}
//
import java.util.List;

public class GestorDisponibilidadHabitacion {
    private List<Reserva> listaReservas;

    public GestorDisponibilidadHabitacion(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public boolean verificarDisponibilidad(Habitacion habitacion, RangoFechas rangoFechas) {
        for (Reserva reserva : listaReservas) {
            if (reserva.getHabitacion().getNumero() == habitacion.getNumero() && 
                reserva.getRangoFechas().seSolapaCon(rangoFechas)) {
                return false; 
            }
        }
        return true; // La habitación está disponible
    }

    public void marcarReservada(Habitacion habitacion, RangoFechas rangoFechas) {
        Reserva nuevaReserva = new Reserva(habitacion, rangoFechas);
        listaReservas.add(nuevaReserva);
    }

    public void marcarDisponible(Habitacion habitacion) {
        listaReservas.removeIf(reserva -> reserva.getHabitacion().getNumero() == habitacion.getNumero());
    }
}
//
public class ControladorReservas {
    private List<Habitacion> habitaciones;
    private GestorDisponibilidadHabitacion gestorDisponibilidad;

    public ControladorReservas(List<Habitacion> habitaciones, GestorDisponibilidadHabitacion gestorDisponibilidad) {
        this.habitaciones = habitaciones;
        this.gestorDisponibilidad = gestorDisponibilidad;
    }

    public void crearReserva(int numeroHabitacion, RangoFechas rangoFechas) {
        Habitacion habitacion = buscarHabitacion(numeroHabitacion);
        if (habitacion != null && habitacion.estaDisponible(rangoFechas)) {
            gestorDisponibilidad.marcarReservada(habitacion, rangoFechas);
            System.out.println("Reserva creada para la habitación " + numeroHabitacion);
        } else {
            System.out.println("La habitación " + numeroHabitacion + " no está disponible.");
        }
    }

    private Habitacion buscarHabitacion(int numeroHabitacion) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numeroHabitacion) {
                return habitacion;
            }
        }
        return null;
    }

    public void cancelarReserva(int numeroHabitacion) {
        Habitacion habitacion = buscarHabitacion(numeroHabitacion);
        if (habitacion != null) {
            gestorDisponibilidad.marcarDisponible(habitacion);
            System.out.println("Reserva cancelada para la habitación " + numeroHabitacion);
        } else {
            System.out.println("No se encontró la habitación " + numeroHabitacion);
        }
    }
}
//
public class Reserva {
    private Habitacion habitacion;
    private RangoFechas rangoFechas;

    public Reserva(Habitacion habitacion, RangoFechas rangoFechas) {
        this.habitacion = habitacion;
        this.rangoFechas = rangoFechas;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public RangoFechas getRangoFechas() {
        return rangoFechas;
    }
}
//

