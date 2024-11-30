package Excepciones;

@SuppressWarnings("serial")
public class FechaInvalidaException extends Exception {
    public FechaInvalidaException(String mensaje) {
        super(mensaje);
    }
}