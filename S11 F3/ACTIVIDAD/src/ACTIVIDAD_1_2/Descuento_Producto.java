package ACTIVIDAD_1_2;

import java.util.Scanner;

public class Descuento_Producto {
	 public static void main(String[] args) {
	     Scanner scanner = new Scanner(System.in);
	     System.out.print("Ingrese el nombre del producto: ");
	     String nombre = scanner.nextLine();
	     System.out.print("Ingrese el precio del producto: ");
	     double precio = scanner.nextDouble();

	     Producto producto = new Producto(nombre, precio);
	     System.out.print("Ingrese el tipo de descuento (1 para fijo y 2 para % ): ");
	     int tipoDescuento = scanner.nextInt();
	     if (tipoDescuento == 1) {
	         System.out.print("Ingrese el monto del descuento fijo: ");
	         double descuentoFijo = scanner.nextDouble();
	         producto.setEstrategia(new DescuentoFijo(descuentoFijo));
	     } else if (tipoDescuento == 2) {

	         System.out.print("Ingrese el porcentaje de descuento: ");
	         double porcentajeDescuento = scanner.nextDouble();
	         producto.setEstrategia(new DescuentoPorcentual(porcentajeDescuento));
	     } else {
	         System.out.println("Tipo de descuento no válido.");
	         scanner.close();
	         return; 
	     }
	     producto.mostrarPrecio();
	     scanner.close();
	 }
	}