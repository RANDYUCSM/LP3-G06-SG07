package Modelo;

import Excepciones.ApellidoInvalidoException;
import Excepciones.DniInvalidoException;
import Excepciones.FechaInvalidaException;
import Excepciones.IdInvalidoException;
import Excepciones.NombreInvalidoException;
import Excepciones.OrigenDestinoInvalidoException;
import Excepciones.SeleccionInvalidaException;

public class Compra {
    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private String fechaViaje;
    private String origen;
    private String destino;
    private boolean almuerzo;
    private boolean cena;
    private String accesorios;
    private int piso;

    public Compra(int id, String nombre, String apellido, String dni, String fechaViaje, String origen, String destino, boolean almuerzo, boolean cena, String accesorios, int piso)
            throws Exception {
        this.setId(id);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDni(dni);
        this.setFechaViaje(fechaViaje);
        this.setOrigen(origen);
        this.setDestino(destino);
        this.setAccesorios(accesorios);
        this.setPiso(piso);
        this.setAlmuerzo(almuerzo);
        this.setCena(cena);
    }

    public int getId() { return id; }
    public void setId(int id) throws IdInvalidoException {
        if (id <= 0) throw new IdInvalidoException("El ID debe ser positivo.");
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws NombreInvalidoException {
        if (nombre == null || nombre.trim().isEmpty())
            throw new NombreInvalidoException("El nombre no puede estar vacío.");
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) throws ApellidoInvalidoException {
        if (apellido == null || apellido.trim().isEmpty())
            throw new ApellidoInvalidoException("El apellido no puede estar vacío.");
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) throws DniInvalidoException {
        if (!dni.matches("\\d{8}")) throw new DniInvalidoException("El DNI debe tener 8 dígitos.");
        this.dni = dni;
    }

    public String getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(String fechaViaje) throws FechaInvalidaException {
        if (!fechaViaje.matches("\\d{2}-\\d{2}-\\d{2}")) throw new FechaInvalidaException("La fecha debe estar en formato DD-MM-YY.");
        this.fechaViaje = fechaViaje;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) throws OrigenDestinoInvalidoException {
        if (origen != null && origen.equals(destino))
            throw new OrigenDestinoInvalidoException("El origen y destino no pueden ser iguales.");
        this.destino = destino;
    }

    public String getAccesorios() {
        return accesorios;
    }

    public void setAccesorios(String accesorios) {
        this.accesorios = accesorios;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) throws SeleccionInvalidaException {
        if (piso != 1 && piso != 2) throw new SeleccionInvalidaException("El piso debe ser 1 o 2.");
        this.piso = piso;
    }

	public boolean isAlmuerzo() {
		return almuerzo;
	}

	public void setAlmuerzo(boolean almuerzo) {
		this.almuerzo = almuerzo;
	}

	public boolean isCena() {
		return cena;
	}

	public void setCena(boolean cena) {
		this.cena = cena;
	}
}
