/*Para cumplir con el principio de abierto/cerrado (OCP), debemos hacer que el código sea abierto para la extensión, pero cerrado para la modificación. Esto significa que
no debemos modificar las clases existentes para añadir nuevas funcionalidades.*/
public interface Dibujable {
    void dibujar();
}
//
public class Circulo implements Dibujable {
    public void dibujar() {
        System.out.println("Dibujando un círculo");
    }
}
//
public class Rectangulo implements Dibujable {
    public void dibujar() {
        System.out.println("Dibujando un rectángulo");
    }
}
//
public class Triangulo implements Dibujable {
    public void dibujar() {
        System.out.println("Dibujando un triángulo");
    }
}
//
public class Main {
    public static void main(String[] args) {
        Dibujable circulo = new Circulo();
        Dibujable rectangulo = new Rectangulo();
        Dibujable triangulo = new Triangulo();

        circulo.dibujar();
        rectangulo.dibujar();
        triangulo.dibujar();
    }
}
////////
public interface Acelerable {
    void acelerar();
}

public class Coche implements Acelerable {
    public void acelerar() {
        System.out.println("El coche está acelerando");
    }
}

public class Bicicleta implements Acelerable {
    public void acelerar() {
        System.out.println("La bicicleta está acelerando");
    }
}
public class Moto implements Acelerable {
    public void acelerar() {
        System.out.println("La moto está acelerando");
    }
}

public class Main {
    public static void main(String[] args) {
        Acelerable coche = new Coche();
        Acelerable bicicleta = new Bicicleta();
        Acelerable moto = new Moto();

        coche.acelerar();
        bicicleta.acelerar();
        moto.acelerar();
    }
}
