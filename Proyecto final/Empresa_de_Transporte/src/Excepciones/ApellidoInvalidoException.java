package Excepciones;

@SuppressWarnings("serial")
public class ApellidoInvalidoException extends Exception {
    public ApellidoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
