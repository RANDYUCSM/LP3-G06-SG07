/*Para cumplir con el principio de segregación de interfaces (ISP), debemos evitar que las clases implementen métodos que no necesitan. */
public interface Imprimible {
    void imprimir();
}
//
public interface Escaneable {
    void escanear();
}
//
public class Impresora implements Imprimible {
    public void imprimir() {
        System.out.println("Imprimir documento.");
    }
}
//
public class ImpresoraMultifuncional implements Imprimible, Escaneable {
    public void imprimir() {
        System.out.println("Imprimir documento.");
    }

    public void escanear() {
        System.out.println("Escaneando documento...");
    }
}
//
public class Main {
    public static void main(String[] args) {
        Imprimible impresora = new Impresora();
        Imprimible impresoraMultifuncional = new ImpresoraMultifuncional();
        Escaneable multifuncionalEscaneable = (Escaneable) impresoraMultifuncional;

        impresora.imprimir();
        multifuncionalEscaneable.escanear();
    }
}
