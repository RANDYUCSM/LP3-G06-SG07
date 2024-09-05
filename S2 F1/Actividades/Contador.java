public class Contador {
    static int acumulador = 0;
    private int valor;
    public static final int VALOR_INICIAL = 5;
    private static int nContadores = 0;
    private static int ultimoContador;

    public static int getAcumulador() {
        return acumulador;
    }
    public static int getNContadores() {
        return nContadores;
    }

    public static int getUltimoContador() {
        return ultimoContador;
    }
    public Contador(int valor) {
        this.valor = valor;
        Contador.acumulador += valor;
        nContadores++;
        ultimoContador = valor;
    }
    public Contador() {
        this(Contador.VALOR_INICIAL);
    }
    public void inc() {
        this.valor++;
        Contador.acumulador++;
    }
    public int getValor() {
        return this.valor;
    }
}
//
public class ContadorTest {
    public static void main(String[] args) {
        Contador c1, c2, c3;

        System.out.println(Contador.getAcumulador());

        c1 = new Contador(3);
        c2 = new Contador(10);
        c3 = new Contador();

        c1.inc();
        c2.inc();

        System.out.println(c1.getValor());
        System.out.println(c2.getValor());
        System.out.println(c3.getValor());

        System.out.println("Acumulador total: " + Contador.getAcumulador());
        System.out.println("Contadores creados: " + Contador.getNContadores());
        System.out.println("Último contador creado con valor inicial: " + Contador.getUltimoContador());
    }
}
