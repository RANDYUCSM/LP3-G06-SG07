public class Coche {
    private String marca;
    private String modelo;
    private int añoFabricacion;
    private double precio;
    private boolean encendido;

    public Coche() {
        this.marca = "Desconocida";
        this.modelo = "Desconocido";
        this.añoFabricacion = 2000;
        this.precio = 0.0;
        this.encendido = false;
    }

    // Constructor con parámetros
    public Coche(String marca, String modelo, int añoFabricacion, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.añoFabricacion = añoFabricacion;
        this.precio = precio;
        this.encendido = false;
    }

    public void encender() {
        if (!encendido) {
            encendido = true;
            System.out.println(marca + " " + modelo + " ha sido encendido.");
        } else {
            System.out.println(marca + " " + modelo + " ya está encendido.");
        }
    }

    public void apagar() {
        if (encendido) {
            encendido = false;
            System.out.println(marca + " " + modelo + " ha sido apagado.");
        } else {
            System.out.println(marca + " " + modelo + " ya está apagado.");
        }
    }

    public void acelerar() {
        if (encendido) {
            System.out.println(marca + " " + modelo + " está acelerando.");
        } else {
            System.out.println("No puedes acelerar " + marca + " " + modelo + " porque está apagado.");
        }
    }

    public void frenar() {
        if (encendido) {
            System.out.println(marca + " " + modelo + " está frenando.");
        } else {
            System.out.println("No puedes frenar " + marca + " " + modelo + " porque está apagado.");
        }
    }

    // Getters y setters para los atributos
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public void setAñoFabricacion(int añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
//
public class EjemploCoche {
    public static void main(String[] args) {

        Coche cocheDeportivo = new Coche("BMW", "X3", 2020, 250000);
        Coche cocheTodoTerreno = new Coche("Jeep", "Wrangler", 2018, 45000);

        cocheDeportivo.encender();
        cocheDeportivo.acelerar();
        cocheDeportivo.frenar();
        cocheDeportivo.apagar();

        System.out.println(); 

        cocheTodoTerreno.encender();
        cocheTodoTerreno.acelerar();
        cocheTodoTerreno.frenar();
        cocheTodoTerreno.apagar();
    }
}

