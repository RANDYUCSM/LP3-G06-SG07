package Excepciones;


@SuppressWarnings("serial")
public class DniInvalidoException extends Exception {
    public DniInvalidoException(String mensaje) {
        super(mensaje);
    }
}


