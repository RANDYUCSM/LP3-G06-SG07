import java.util.Scanner;

public class LeerEntrada {
    private Scanner scanner;

    public LeerEntrada() {
        scanner = new Scanner(System.in);
    }

    public char getChar() {
        System.out.print("Ingrese un carácter: ");
        String input = scanner.nextLine();
        return input.length() > 0 ? input.charAt(0) : '\0'; 
    }
}
//
class ExcepcionVocal extends Exception {
    public ExcepcionVocal(char c) {
        super("Excepción de vocal: " + c);
    }
}

class ExcepcionNumero extends Exception {
    public ExcepcionNumero(char c) {
        super("Excepción de número: " + c);
    }
}

class ExcepcionBlanco extends Exception {
    public ExcepcionBlanco() {
        super("Excepción de espacio en blanco");
    }
}

class ExcepcionSalida extends Exception {
    public ExcepcionSalida() {
        super("Excepción de carácter de salida");
    }
}
//
public class ProcesarEntrada {
    private LeerEntrada leerEntrada;

    public ProcesarEntrada() {
        leerEntrada = new LeerEntrada();
    }

    public void procesar() throws ExcepcionVocal, ExcepcionNumero, ExcepcionBlanco, ExcepcionSalida {
        char c = leerEntrada.getChar();
        
        if ("AEIOUaeiou".indexOf(c) != -1) {
            throw new ExcepcionVocal(c);
        }
        if (Character.isDigit(c)) {
            throw new ExcepcionNumero(c);
        }
        if (Character.isWhitespace(c)) {
            throw new ExcepcionBlanco();
        }
        if (c == 'X' || c == 'x') {
            throw new ExcepcionSalida();
        }

        System.out.println("Carácter válido: " + c);
    }

    public static void main(String[] args) {
        ProcesarEntrada procesador = new ProcesarEntrada();
        boolean continuar = true;

        while (continuar) {
            try {
                procesador.procesar();
            } catch (ExcepcionVocal e) {
                System.out.println(e.getMessage());
            } catch (ExcepcionNumero e) {
                System.out.println(e.getMessage());
            } catch (ExcepcionBlanco e) {
                System.out.println(e.getMessage());
            } catch (ExcepcionSalida e) {
                System.out.println(e.getMessage());
                continuar = false; 
            }
        }

        System.out.println("Programa terminado.");
    }
}

