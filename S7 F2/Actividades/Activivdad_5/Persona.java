package Activivdad_5;

public class Persona {
    protected String nombre;
    protected String telefono;
    protected String direccion;

    public Persona(String nombre, String telefono, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String toString() {
        return nombre + "\t" + telefono + "\t" + direccion + "\n";
    }
}
