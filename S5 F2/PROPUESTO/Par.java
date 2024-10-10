public class Par<F, S> {
    private F primero;
    private S segundo;

    public Par(F primero, S segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public F getPrimero() {
        return primero;
    }

    public void setPrimero(F primero) {
        this.primero = primero;
    }

    public S getSegundo() {
        return segundo;
    }

    public void setSegundo(S segundo) {
        this.segundo = segundo;
    }

    public String toString() {
        return "(Primero: " + primero + ", Segundo: " + segundo + ")";
    }

    public boolean esIgual(Par<F, S> otroPar) {
        return this.primero.equals(otroPar.getPrimero()) && this.segundo.equals(otroPar.getSegundo());
    }
}
2//
public class PruebaPar {
    public static void main(String[] args) {
        Par<Integer, String> par1 = new Par<>(1, "Uno");
        Par<Integer, String> par2 = new Par<>(1, "Uno");
        Par<Integer, String> par3 = new Par<>(2, "Dos");

        System.out.println(par1);  
        System.out.println(par2);  
        System.out.println(par3);  

        System.out.println("par1 es igual a par2 " + par1.esIgual(par2));  
        System.out.println("par1 es igual a par3 " + par1.esIgual(par3));  
    }
}
4//
import java.util.ArrayList;

public class Contenedor<F, S> {
    private ArrayList<Par<F, S>> pares;

    public Contenedor() {
        pares = new ArrayList<>();
    }

    public void agregarPar(F primero, S segundo) {
        Par<F, S> nuevoPar = new Par<>(primero, segundo);
        pares.add(nuevoPar);
    }

    public Par<F, S> obtenerPar(int indice) {
        if (indice >= 0 && indice < pares.size()) {
            return pares.get(indice);
        } else {
            return null; 
        }
    }

    public ArrayList<Par<F, S>> obtenerTodosLosPares() {
        return pares;
    }

    public void mostrarPares() {
        for (Par<F, S> par : pares) {
            System.out.println(par);
        }
    }

    public static void main(String[] args) {
        Contenedor<String, Integer> contenedor = new Contenedor<>();

        contenedor.agregarPar("Uno", 1);
        contenedor.agregarPar("Dos", 2);
        contenedor.agregarPar("Tres", 3);

        contenedor.mostrarPares();

        Par<String, Integer> par = contenedor.obtenerPar(1);
        if (par != null) {
            System.out.println("Par en índice 1: " + par);
        } else {
            System.out.println("Índice no válido");
        }
    }
}
3//
public class Main {

    public static <F, S> void imprimirPar(Par<F, S> par) {
        System.out.println(par);
    }

    public static void main(String[] args) {
        Par<String, Integer> par1 = new Par<>(":3", 100);
        Par<Double, Boolean> par2 = new Par<>(13.9, true);
        Par<Persona, Integer> par3 = new Par<>(new Persona("ANA", 30), 1);

        imprimirPar(par1);  
        imprimirPar(par2);  
        imprimirPar(par3);  
    }
}

class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public String toString() {
        return "Persona{nombre='" + nombre + "', edad=" + edad + "}";
    }
}
