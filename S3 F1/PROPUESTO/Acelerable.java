/*En este caso, tanto Coche como Bicicleta cumplen con el contrato de la interfaz Acelerable, ya que ambas implementan el método acelerar(). 
Sin embargo, la diferencia en la descripción del comportamiento (usando el motor vs. pedaleando) puede ser vista como una violación del LSP */
public interface Acelerable {
    void acelerar();
}

public class Coche implements Acelerable {
    public void acelerar() {
        System.out.println("El coche está acelerando usando el motor.");
    }
}

public class Bicicleta implements Acelerable {
    public void acelerar() {
        System.out.println("La bicicleta está acelerando pedaleando.");
    }
}

public class Main {
    public static void main(String[] args) {
        Acelerable coche = new Coche();
        Acelerable bicicleta = new Bicicleta();

        coche.acelerar();
        bicicleta.acelerar();
    }
}
