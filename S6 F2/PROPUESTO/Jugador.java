public class Jugador {
    private String nombre;
    private int salud;
    private int nivel;
    private Inventario inventario;
    private Objeto objetoEquipado;


    public Jugador(String nombre, int salud, int nivel) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.inventario = new Inventario();
    }


    public void atacar(Enemigo enemigo) {
        if (objetoEquipado != null) {
            int danio = objetoEquipado.getDanio();
            enemigo.recibirDanio(danio);
            System.out.println(nombre + " atacó a " + enemigo.getNombre() + " con " + objetoEquipado.getNombre() + " e infligió " + danio + " de daño.");
        } else {
            System.out.println(nombre + " no tiene un objeto equipado.");
        }
    }


    public void recibirDanio(int danio) {
        salud -= danio;
        System.out.println(nombre + " recibió " + danio + " de daño.");
    }


    public void usarObjeto(Objeto objeto) {
        System.out.println(nombre + " usó " + objeto.getNombre());
    }


    public String getNombre() {
        return nombre;
    }


    public int getSalud() {
        return salud;
    }


    public int getNivel() {
        return nivel;
    }


    public Inventario getInventario() {
        return inventario;
    }


    public void equiparObjeto(Objeto objeto) {
        this.objetoEquipado = objeto;
    }
}


public class Enemigo {
    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;


    public Enemigo(String nombre, int salud, int nivel, String tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.tipo = tipo;
    }


    public void atacar(Jugador jugador) {
        int danio = (int) (Math.random() * 10) + 1;
        jugador.recibirDanio(danio);
        System.out.println(nombre + " atacó a " + jugador.getNombre() + " e infligió " + danio + " de daño.");
    }


    public void recibirDanio(int danio) {
        salud -= danio;
        System.out.println(nombre + " recibió " + danio + " de daño.");
    }


    public String getNombre() {
        return nombre;
    }


    public int getSalud() {
        return salud;
    }


    public String getTipo() {
        return tipo;
    }
}


public class VistaCombate {
    public void mostrarEstadoJugador(Jugador jugador) {
        System.out.println("Jugador: " + jugador.getNombre() + " | Salud: " + jugador.getSalud() + " | Nivel: " + jugador.getNivel());
    }


    public void mostrarEstadoEnemigo(Enemigo enemigo) {
        System.out.println("Enemigo: " + enemigo.getNombre() + " | Salud: " + enemigo.getSalud() + " | Tipo: " + enemigo.getTipo());
    }


    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}


public class ControladorCombate {
    private Jugador jugador;
    private Enemigo enemigo;
    private VistaCombate vista;


    public ControladorCombate(Jugador jugador, Enemigo enemigo, VistaCombate vista) {
        this.jugador = jugador;
        this.enemigo = enemigo;
        this.vista = vista;
    }


    public void iniciarCombate() {
        while (jugador.getSalud() > 0 && enemigo.getSalud() > 0) {
            jugador.atacar(enemigo);
            if (enemigo.getSalud() > 0) {
                enemigo.atacar(jugador);
            }
            vista.mostrarEstadoJugador(jugador);
            vista.mostrarEstadoEnemigo(enemigo);
        }


        if (jugador.getSalud() <= 0) {
            vista.mostrarMensaje("El jugador ha sido derrotado.");
        } else {
            vista.mostrarMensaje("El enemigo ha sido derrotado.");
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Jugador jugador = new Jugador("Héroe", 100, 1);
        Enemigo enemigo = new Enemigo("Goblin", 50, 1, "Terrestre");
        VistaCombate vista = new VistaCombate();


        ControladorCombate controlador = new ControladorCombate(jugador, enemigo, vista);
        controlador.iniciarCombate();
    }
}
