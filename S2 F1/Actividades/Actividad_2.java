public class Contador{
    static int acumulador =0;
    private int valor;
    
    public static int acumulador(){
        return acumulador;
    }
    public Contador(int valor){
        this.valor = valor;
        acumulador +=valor;
    }
    public void inc(){
        valor++;
        acumulador++;
    }
    public int getValor(){
        return this.valor;
    }
}
public ContadorTest{
    public static void main (String[] args){
        Contador c1,c2;

        System.out.println(Contador.acumulador());
        c1=new Contador(3);
        c2=new Contador(10);
        c1.inc();
        c2.inc();
        System.out.println(c1.getValor());
        System.out.println(c2.getValor());
        System.out.println(Contador.acumulador);
    }
}
