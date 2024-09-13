public interface PoliticaCancelacion {
    boolean puedeCancelar(Reserva reserva);
}
//
import java.time.LocalDateTime;

public class PoliticaCancelacionFlexible implements PoliticaCancelacion {
    public boolean puedeCancelar(Reserva reserva) {
        LocalDateTime ahora = LocalDateTime.now();
        return reserva.getFechaCheckIn().minusHours(24).isAfter(ahora);
    }
}
//
import java.time.LocalDateTime;

public class PoliticaCancelacionModerada implements PoliticaCancelacion {
    public boolean puedeCancelar(Reserva reserva) {
        LocalDateTime ahora = LocalDateTime.now();
        return reserva.getFechaCheckIn().minusHours(72).isAfter(ahora);
    }
}
//
public class PoliticaCancelacionEstricta implements PoliticaCancelacion {
    public boolean puedeCancelar(Reserva reserva) {
        return false; 
    }
}
//
import java.time.LocalDateTime;

public class Reserva {
    private Habitacion habitacion;
    private LocalDateTime fechaCheckIn;
    private PoliticaCancelacion politicaCancelacion;

    public Reserva(Habitacion habitacion, LocalDateTime fechaCheckIn, PoliticaCancelacion politicaCancelacion) {
        this.habitacion = habitacion;
        this.fechaCheckIn = fechaCheckIn;
        this.politicaCancelacion = politicaCancelacion;
    }

    public boolean cancelar() {
        if (politicaCancelacion.puedeCancelar(this)) {
            System.out.println("Reserva cancelada exitosamente.");
            return true;
        } else {
            System.out.println("No se puede cancelar la reserva según la política seleccionada.");
            return false;
        }
    }

    public LocalDateTime getFechaCheckIn() {
        return fechaCheckIn;
    }
}
//
import java.time.LocalDateTime;
import java.util.List;

public class ControladorReservas {
    private List<Reserva> reservas;

    public ControladorReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void crearReserva(Habitacion habitacion, LocalDateTime fechaCheckIn, String tipoPolitica) {
        PoliticaCancelacion politicaCancelacion = seleccionarPolitica(tipoPolitica);
        Reserva nuevaReserva = new Reserva(habitacion, fechaCheckIn, politicaCancelacion);
        reservas.add(nuevaReserva);
        System.out.println("Reserva creada para la habitación " + habitacion.getNumero());
    }

    public void cancelarReserva(Reserva reserva) {
        if (reserva.cancelar()) {
            reservas.remove(reserva);
        }
    }

    private PoliticaCancelacion seleccionarPolitica(String tipoPolitica) {
        switch (tipoPolitica) {
            case "flexible":
                return new PoliticaCancelacionFlexible();
            case "moderada":
                return new PoliticaCancelacionModerada();
            case "estricta":
                return new PoliticaCancelacionEstricta();
            default:
                throw new IllegalArgumentException("Tipo de política no reconocido.");
        }
    }
}
//
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Reserva> reservas = new ArrayList<>();
        ControladorReservas controlador = new ControladorReservas(reservas);

        Habitacion habitacion1 = new Habitacion(101, "Lujo", 200, null);
        controlador.crearReserva(habitacion1, LocalDateTime.of(2024, 9, 20, 15, 0), "flexible");

        Habitacion habitacion2 = new Habitacion(102, "Estándar", 100, null);
        controlador.crearReserva(habitacion2, LocalDateTime.of(2024, 9, 22, 15, 0), "estricta");

        Reserva reserva = reservas.get(0);
        controlador.cancelarReserva(reserva);
    }
}


