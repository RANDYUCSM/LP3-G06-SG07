package Excepciones;

@SuppressWarnings("serial")
public class OrigenDestinoInvalidoException extends Exception {
    public OrigenDestinoInvalidoException(String mensaje) {
        super(mensaje);
    }
}