package ACTIVIDAD_1_3;

interface Comando {
 void ejecutar();
}

class Televisor {
 private int volumen = 10;
 @SuppressWarnings("unused")
private int canal = 1;

 public void encender() {
     System.out.println("El televisor está encendido.");
 }

 public void apagar() {
     System.out.println("El televisor está apagado.");
 }

 public void subirVolumen() {
     volumen++;
     System.out.println("Volumen subido a: " + volumen);
 }

 public void bajarVolumen() {
     volumen--;
     System.out.println("Volumen bajado a: " + volumen);
 }

 public void cambiarCanal(int canal) {
     this.canal = canal;
     System.out.println("Canal cambiado a: " + canal);
 }
}

class EncenderComando implements Comando {
 private Televisor tv;

 public EncenderComando(Televisor tv) {
     this.tv = tv;
 }

 public void ejecutar() {
     tv.encender();
 }
}

class ApagarComando implements Comando {
 private Televisor tv;

 public ApagarComando(Televisor tv) {
     this.tv = tv;
 }

 public void ejecutar() {
     tv.apagar();
 }
}

class SubirVolumenComando implements Comando {
 private Televisor tv;

 public SubirVolumenComando(Televisor tv) {
     this.tv = tv;
 }

 public void ejecutar() {
     tv.subirVolumen();
 }
}

class BajarVolumenComando implements Comando {
 private Televisor tv;

 public BajarVolumenComando(Televisor tv) {
     this.tv = tv;
 }

 public void ejecutar() {
     tv.bajarVolumen();
 }
}

class CambiarCanalComando implements Comando {
 private Televisor tv;
 private int canal;

 public CambiarCanalComando(Televisor tv, int canal) {
     this.tv = tv;
     this.canal = canal;
 }

 public void ejecutar() {
     tv.cambiarCanal(canal);
 }
}

class ControlRemoto {
 private Comando comando;

 public void establecerComando(Comando comando) {
     this.comando = comando;
 }

 public void presionarBoton() {
     if (comando != null) {
         comando.ejecutar();
     } else {
         System.out.println("No se ha configurado ningún comando.");
     }
 }
}

