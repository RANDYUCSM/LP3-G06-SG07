package ejer_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ProductoControlador {
 private Producto modelo;
 private ProductoVista vista;

 public ProductoControlador(Producto modelo, ProductoVista vista) {
     this.modelo = modelo;
     this.vista = vista;

     this.vista.getBTNACTUALIZAR().addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             actualizarProducto();
         }
     });
 }

 private void actualizarProducto() {
     try {
         String nombre = vista.getNOMBRE().getText();
         double precio = Double.parseDouble(vista.getPRECIO().getText());
         int cantidadStock = Integer.parseInt(vista.getCANTIDAD().getText());
         String categoria = vista.getCATEGORIA().getText();

         modelo.setNombre(nombre);
         modelo.setPrecio(precio);
         modelo.setCantidadStock(cantidadStock);
         modelo.setCategoria(categoria);

         vista.getINFOPRODUCTO().setText("Información del producto: " + modelo.toString());
     } catch (NumberFormatException ex) {
         JOptionPane.showMessageDialog(vista, "Precio y cantidad deben ser números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
     }
 }
}