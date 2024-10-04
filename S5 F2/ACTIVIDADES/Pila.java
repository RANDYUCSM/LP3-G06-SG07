import java.util.EmptyStackException;


public class Pila<E> {
    private final int tamanio;
    private int superior;
    private E[] elementos;




    public Pila() {
        this(10);
    }


    @SuppressWarnings("unchecked")
    public Pila(int s) {
        if (s <= 0) {
            throw new IllegalArgumentException("El tamaño debe ser un número entero positivo");
        }
        tamanio = s;
        superior = -1;
        elementos = (E[]) new Object[tamanio];
    }


    public void push(E valorAMeter) {
        if (superior == tamanio - 1) {
            throw new IllegalStateException("La pila está llena");
        }
        elementos[++superior] = valorAMeter;
    }


    public E pop() {
        if (superior == -1) {
            throw new EmptyStackException();
        }
        return elementos[superior--];
    }


    public boolean contains(E elemento) {
        for (int i = superior; i >= 0; i--) {
            if (elementos[i] != null && elementos[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }


    public boolean isEmpty() {
        return superior == -1;
    }
}
