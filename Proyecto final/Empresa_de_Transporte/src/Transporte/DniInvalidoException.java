package Transporte;

@SuppressWarnings("serial")
class DniInvalidoException extends Exception {
    public DniInvalidoException(String mensaje) {
        super(mensaje);
    }
}

@SuppressWarnings("serial")
class FechaInvalidaException extends Exception {
    public FechaInvalidaException(String mensaje) {
        super(mensaje);
    }
}

@SuppressWarnings("serial")
class SeleccionInvalidaException extends Exception {
    public SeleccionInvalidaException(String mensaje) {
        super(mensaje);
    }
}
