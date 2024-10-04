package pen;


// Excepción personalizada InvalidSubscriptException
class InvalidSubscriptException extends Exception {
    public InvalidSubscriptException(String mensaje) {
        super(mensaje);
    }
}


public class PruebaMetodoGenerico {
    // Método genérico imprimirArreglo original
    public static <E> void imprimirArreglo(E[] arregloEntrada) {
        // muestra los elementos del arreglo
        for (E elemento : arregloEntrada) {
            System.out.printf("%s ", elemento);
        }
        System.out.println();
    }


    // Método sobrecargado que recibe índices para imprimir una parte del arreglo
    public static <E> int imprimirArreglo(E[] arregloEntrada, int subindiceInferior, int subindiceSuperior) throws InvalidSubscriptException {
        // Validar índices
        if (subindiceInferior < 0 || subindiceSuperior >= arregloEntrada.length || subindiceInferior >= subindiceSuperior) {
            throw new InvalidSubscriptException("Índices inválidos: subindiceInferior = " + subindiceInferior + ", subindiceSuperior = " + subindiceSuperior);
        }


        // Imprimir la parte del arreglo en el rango indicado
        for (int i = subindiceInferior; i <= subindiceSuperior; i++) {
            System.out.printf("%s ", arregloEntrada[i]);
        }
        System.out.println();


        // Devolver la cantidad de elementos impresos
        return (subindiceSuperior - subindiceInferior + 1);
    }


    public static void main(String[] args) {
        Integer[] arregloInteger = {1, 2, 3, 4, 5, 6};
        Double[] arregloDouble = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        Character[] arregloCharacter = {'H', 'O', 'L', 'A'};


        System.out.println("El arreglo arregloInteger contiene:");
        imprimirArreglo(arregloInteger); 


        System.out.println("\nEl arreglo arregloDouble contiene:");
        imprimirArreglo(arregloDouble); 


        System.out.println("\nEl arreglo arregloCharacter contiene:");
        imprimirArreglo(arregloCharacter); 


        try {
            System.out.println("\nImprimiendo parte del arregloInteger (índices 1 a 4):");
            int cantidadImpresos = imprimirArreglo(arregloInteger, 1, 4);
            System.out.println("Cantidad de elementos impresos: " + cantidadImpresos);
        } catch (InvalidSubscriptException e) {
            System.out.println(e.getMessage());
        }


        try {
            System.out.println("\nIntentando imprimir parte del arregloInteger con índices inválidos (índices 4 a 1):");
            imprimirArreglo(arregloInteger, 4, 1);
        } catch (InvalidSubscriptException e) {
            System.out.println(e.getMessage());
        }
    }
}

