//Solo son los cambios y aumentos
public interface ServicioHabitacion {
    void solicitarLimpieza();
    void solicitarComida();
    void solicitarLavanderia();
}
//
public interface ServicioLimpieza {
    void solicitarLimpieza();
}
//
public interface ServicioComida {
    void solicitarComida();
}
//
public interface ServicioLavanderia {
    void solicitarLavanderia();
}
//
public class HabitacionLujo implements ServicioLimpieza, ServicioComida, ServicioLavanderia {
    private int numero;

    public HabitacionLujo(int numero) {
        this.numero = numero;
    }

    public void solicitarLimpieza() {
        System.out.println("Limpieza solicitada para la habitación de lujo " + numero);
    }

    public void solicitarComida() {
        System.out.println("Comida solicitada para la habitación de lujo " + numero);
    }

    public void solicitarLavanderia() {
        System.out.println("Lavandería solicitada para la habitación de lujo " + numero);
    }
}
//
public class HabitacionEstandar implements ServicioLimpieza {
    private int numero;

    public HabitacionEstandar(int numero) {
        this.numero = numero;
    }

    public void solicitarLimpieza() {
        System.out.println("Limpieza solicitada para la habitación estándar " + numero);
    }
}
//
//Modificacion
public class ControladorReservas {
    private List<Object> habitaciones; // Lista genérica que puede contener distintos tipos de habitaciones

    public ControladorReservas(List<Object> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public void solicitarServicioLimpieza(int numeroHabitacion) {
        Object habitacion = buscarHabitacion(numeroHabitacion);
        if (habitacion instanceof ServicioLimpieza) {
            ((ServicioLimpieza) habitacion).solicitarLimpieza();
        } else {
            System.out.println("El servicio de limpieza no está disponible para la habitación " + numeroHabitacion);
        }
    }

    public void solicitarServicioComida(int numeroHabitacion) {
        Object habitacion = buscarHabitacion(numeroHabitacion);
        if (habitacion instanceof ServicioComida) {
            ((ServicioComida) habitacion).solicitarComida();
        } else {
            System.out.println("El servicio de comida no está disponible para la habitación " + numeroHabitacion);
        }
    }

    public void solicitarServicioLavanderia(int numeroHabitacion) {
        Object habitacion = buscarHabitacion(numeroHabitacion);
        if (habitacion instanceof ServicioLavanderia) {
            ((ServicioLavanderia) habitacion).solicitarLavanderia();
        } else {
            System.out.println("El servicio de lavandería no está disponible para la habitación " + numeroHabitacion);
        }
    }

    private Object buscarHabitacion(int numeroHabitacion) {
        for (Object habitacion : habitaciones) {
            if (habitacion instanceof HabitacionEstandar && ((HabitacionEstandar) habitacion).getNumero() == numeroHabitacion) {
                return habitacion;
            } else if (habitacion instanceof HabitacionLujo && ((HabitacionLujo) habitacion).getNumero() == numeroHabitacion) {
                return habitacion;
            }
        }
        return null;
    }
}