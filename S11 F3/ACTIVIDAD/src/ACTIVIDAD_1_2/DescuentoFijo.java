package ACTIVIDAD_1_2;

interface EstrategiaPromocion {
 double aplicarPromocion(double precio);
}

class DescuentoFijo implements EstrategiaPromocion {
 private double descuento;
 
 public DescuentoFijo(double descuento) {
     this.descuento = descuento;
 }

 public double aplicarPromocion(double precio) {
     return precio - descuento;
 }
}

class DescuentoPorcentual implements EstrategiaPromocion {
 private double porcentaje;

 public DescuentoPorcentual(double porcentaje) {
     this.porcentaje = porcentaje;
 }

 public double aplicarPromocion(double precio) {
     return precio * (1 - porcentaje / 100);
 }
}

class Producto {
 private String nombre;
 private double precio;
 private EstrategiaPromocion estrategia;

 public Producto(String nombre, double precio) {
     this.nombre = nombre;
     this.precio = precio;
 }

 public void setEstrategia(EstrategiaPromocion estrategia) {
     this.estrategia = estrategia;
 }

 public double obtenerPrecioFinal() {
     return estrategia != null ? estrategia.aplicarPromocion(precio) : precio;
 }

 public void mostrarPrecio() {
     System.out.println(nombre + " - Precio final: $" + obtenerPrecioFinal());
 }
}
