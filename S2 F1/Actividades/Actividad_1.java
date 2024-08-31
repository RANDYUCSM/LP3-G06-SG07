public class Coche {
    public String Marca;
    public int AñoDeFabricacion;
    public double Precio;

    public Coche() {
        Marca = "TOYOTA";
        AñoDeFabricacion = 2012;
        Precio = 10000.0;
    }

    public Coche(String marca, int anioFabricacion, double precio) {
        Marca = marca;
        AñoDeFabricacion = anioFabricacion;
        Precio = precio;
    }

    public Coche(String marca, String modelo, int anioFabricacion, double precio) {
        Marca = marca + " " + modelo;
        AñoDeFabricacion = anioFabricacion;    //Parámetros
        Precio = precio;
    }

    // Métodos
    public boolean aplicarDescuento(double descuento) {
        if (AñoDeFabricacion < 2010) {
            Precio -= descuento;
            return true; 
        } else {
            return false; 
        }
    }

    public static void main(String[] args) {
        Coche coche = new Coche("Toyota", "Corolla", 2012, 10000.0);
        boolean descuentoAplicado = coche.aplicarDescuento(1000.0);

        if (descuentoAplicado) {
            System.out.println("Descuento se aplico: " + coche.Precio);
        } else {
            System.out.println("No se aplicó el descuento:" + coche.Precio);
        }
    }
}
