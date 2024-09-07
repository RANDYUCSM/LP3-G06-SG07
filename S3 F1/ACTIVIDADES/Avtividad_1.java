// Habitacion.java
public class Habitacion {
    private int id;
    private String tipo;
    private double precio;
    private boolean disponible;

}

// Cliente.java
public class Cliente {
    private int id;
    private String nombre;
    private String datosContacto;

}

// Personal.java
public class Personal {
    private int id;
    private String nombre;
    private String cargo;

}

// Reserva.java
public class Reserva {
    private int id;
    private Habitacion habitacion;
    private Cliente cliente;
    private Date fechaInicio;
    private Date fechaFin;

}
