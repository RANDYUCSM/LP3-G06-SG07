package ACTIVIDAD_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("unused")
interface Observador {
    void actualizar(String mensaje);
}

class Usuario implements Observador {
    String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println(nombre + " recibió la notificación: " + mensaje);
    }
}

class CanalDeNoticias {
    List<Observador> suscriptores = new ArrayList<>();

    public void suscribir(Observador observador) {
        suscriptores.add(observador);
    }

    public void desuscribir(Observador observador) {
        suscriptores.remove(observador);
    }

    public void notificarSuscriptores(String mensaje) {
        for (Observador observador : suscriptores) {
            observador.actualizar(mensaje);
        }
    }
}

