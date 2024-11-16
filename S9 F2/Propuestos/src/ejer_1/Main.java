package ejer_1;

public class Main {
	 public static void main(String[] args) {
	     Producto modelo = new Producto("", 0.0, 0, "");
	     ProductoVista vista = new ProductoVista();

	     new ProductoControlador(modelo, vista);
	 }
	}