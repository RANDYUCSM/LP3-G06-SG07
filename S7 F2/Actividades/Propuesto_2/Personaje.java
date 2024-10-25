package Propuesto_2;

public class Personaje {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int alcance;
    private int nivel;

    public Personaje(String nombre, int vida, int ataque, int defensa, int alcance, int nivel) {
        if (vida <= 0 || ataque <= 0 || defensa <= 0 || alcance <= 0 || nivel <= 0) {
            throw new IllegalArgumentException("Todos los atributos deben ser mayores a cero.");
        }
        this.nombre = nombre;
        this.vida = vida * nivel;
        this.ataque = ataque * nivel;
        this.defensa = defensa * nivel;
        this.alcance = alcance;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        if (vida <= 0) {
            throw new IllegalArgumentException("La vida debe ser mayor a cero.");
        }
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        if (ataque <= 0) {
            throw new IllegalArgumentException("El ataque debe ser mayor a cero.");
        }
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        if (defensa <= 0) {
            throw new IllegalArgumentException("La defensa debe ser mayor a cero.");
        }
        this.defensa = defensa;
    }

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        if (alcance <= 0) {
            throw new IllegalArgumentException("El alcance debe ser mayor a cero.");
        }
        this.alcance = alcance;
    }

    public int getNivel() {
        return nivel;
    }

    public void subirNivel() {
        this.nivel++;
        this.vida = this.vida * (this.nivel - 1) / this.nivel;
        this.ataque = this.ataque * (this.nivel - 1) / this.nivel;
        this.defensa = this.defensa * (this.nivel - 1) / this.nivel;
    }

    @Override
    public String toString() {
        return nombre + " " + vida + " " + ataque + " " + defensa + " " + alcance + " " + nivel;
    }
}