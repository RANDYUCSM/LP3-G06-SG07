package Excepciones;


@SuppressWarnings("serial")
public class SeleccionInvalidaException extends Exception {
    public SeleccionInvalidaException(String mensaje) {
        super(mensaje);
    }
}
