package Activivdad_5;

public class ArrayPersona {
    private Persona[] arreglo;
    private final int max = 128;
    private int tamano;

    public ArrayPersona() {
        this.arreglo = new Persona[max];
        this.tamano = 0;
    }

    public void printArray(String nombre) {
        boolean encontrado = false;
        for (int i = 0; i < tamano; i++) {
            if (arreglo[i].getNombre().equals(nombre)) {
                System.out.print(arreglo[i]);  
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ninguna persona con el nombre: " + nombre);
        }
    }

    public void addArray(Persona persona) {
        if (tamano < max) {
            arreglo[tamano++] = persona;
        } else {
            System.out.println("Error: no se puede agregar más personas, el arreglo está lleno.");
        }
    }
}
