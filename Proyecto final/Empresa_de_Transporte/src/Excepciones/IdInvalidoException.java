package Excepciones;

@SuppressWarnings("serial")
public class IdInvalidoException extends Exception {
    public IdInvalidoException(String mensaje) {
        super(mensaje);
    }
}