package EJER_1;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String mensaje);
}

class Usuario implements Observer {
    private String nombre;

    public Usuario(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del usuario no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public void update(String mensaje) {
        System.out.println("Hola " + nombre + ", tienes una nueva notificación: " + mensaje);
    }

    public String getNombre() {
        return nombre;
    }
}

interface Sujeto {
    void suscribir(Observer observer) throws IllegalArgumentException;
    void desuscribir(Observer observer) throws IllegalArgumentException;
    void notificar(String mensaje) throws IllegalStateException;
}

class Notificacion implements Sujeto {
    List<Observer> usuarios;

    public Notificacion() {
        this.usuarios = new ArrayList<>();
    }

    public void suscribir(Observer observer) {
        if (observer == null) {
            throw new IllegalArgumentException("El observador no puede ser nulo.");
        }
        if (usuarios.contains(observer)) {
            throw new IllegalArgumentException("El usuario ya está suscrito.");
        }
        usuarios.add(observer);
        System.out.println("Usuario " + ((Usuario) observer).getNombre() + " suscrito exitosamente.");
    }

    public void desuscribir(Observer observer) {
        if (observer == null) {
            throw new IllegalArgumentException("El observador no puede ser nulo.");
        }
        if (!usuarios.contains(observer)) {
            throw new IllegalArgumentException("El usuario no está suscrito.");
        }
        usuarios.remove(observer);
        System.out.println("Usuario " + ((Usuario) observer).getNombre() + " desuscrito exitosamente.");
    }

    public void notificar(String mensaje) {
        if (usuarios.isEmpty()) {
            throw new IllegalStateException("No hay usuarios suscritos para recibir notificaciones.");
        }
        for (Observer usuario : usuarios) {
            usuario.update(mensaje);
        }
    }
}

