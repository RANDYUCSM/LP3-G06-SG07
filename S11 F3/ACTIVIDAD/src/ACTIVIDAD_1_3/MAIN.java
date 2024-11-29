package ACTIVIDAD_1_3;

import java.util.Scanner;

public class MAIN {
	
	 public static void main(String[] args) {
	     Scanner scanner = new Scanner(System.in);
	     Televisor televisor = new Televisor();
	     ControlRemoto control = new ControlRemoto();

	     boolean salir = false;

	     while (!salir) {
	         System.out.println("\nSeleccione una opción:");
	         System.out.println("1. Encender el televisor");
	         System.out.println("2. Apagar el televisor");
	         System.out.println("3. Subir volumen");
	         System.out.println("4. Bajar volumen");
	         System.out.println("5. Cambiar canal");
	         System.out.println("6. Salir");
	         System.out.print("Opción: ");

	         int opcion = scanner.nextInt();

	         switch (opcion) {
	             case 1:
	                 control.establecerComando(new EncenderComando(televisor));
	                 control.presionarBoton();
	                 break;
	             case 2:
	                 control.establecerComando(new ApagarComando(televisor));
	                 control.presionarBoton();
	                 break;
	             case 3:
	                 control.establecerComando(new SubirVolumenComando(televisor));
	                 control.presionarBoton();
	                 break;
	             case 4:
	                 control.establecerComando(new BajarVolumenComando(televisor));
	                 control.presionarBoton();
	                 break;
	             case 5:
	                 System.out.print("Ingrese el canal deseado: ");
	                 int canal = scanner.nextInt();
	                 control.establecerComando(new CambiarCanalComando(televisor, canal));
	                 control.presionarBoton();
	                 break;
	             case 6:
	                 salir = true;
	                 System.out.println("A ");
	                 break;
	             default:
	                 System.out.println("Opción no válida. Intente nuevamente.");
	                 break;
	         }
	     }

	     scanner.close();
	 }
	}


