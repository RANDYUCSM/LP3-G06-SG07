package Ejer1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Producto {
    private String nombre;
    private double precio;
    private int cantidadStock;
    private String categoria;


    // Constructor
    public Producto(String nombre, double precio, int cantidadStock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.categoria = categoria;
    }


    // Getters y Setters
    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public double getPrecio() {
        return precio;
    }


    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public int getCantidadStock() {
        return cantidadStock;
    }


    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }


    public String getCategoria() {
        return categoria;
    }


    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidadStock=" + cantidadStock +
                ", categoría='" + categoria + '\'' +
                '}';
    }
}


public class GestionProducto extends JFrame {
    private JTextField txtNombre, txtPrecio, txtCantidad, txtCategoria;
    private JLabel lblInfo;
    private Producto producto;


    public GestionProducto() {
        // Inicializar producto con valores predeterminados
        producto = new Producto("ProductoX", 0.0, 0, "CategoríaX");


        // Configuración básica de la ventana
        setTitle("Gestión de Producto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(6, 2, 10, 10));


        // Componentes de la interfaz
        add(new JLabel("Nombre del Producto:"));
        txtNombre = new JTextField();
        add(txtNombre);


        add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        add(txtPrecio);


        add(new JLabel("Cantidad en Stock:"));
        txtCantidad = new JTextField();
        add(txtCantidad);


        add(new JLabel("Categoría:"));
        txtCategoria = new JTextField();
        add(txtCategoria);


        JButton btnActualizar = new JButton("Actualizar Producto");
        add(btnActualizar);


        lblInfo = new JLabel("Producto no actualizado.");
        lblInfo.setForeground(Color.BLUE);
        add(lblInfo);


        // Acción del botón
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Validaciones
                    if (txtNombre.getText().isEmpty() || 
                        txtPrecio.getText().isEmpty() || 
                        txtCantidad.getText().isEmpty() || 
                        txtCategoria.getText().isEmpty()) {
                        throw new Exception("Todos los campos deben estar completos.");
                    }


                    String nombre = txtNombre.getText();
                    double precio;
                    int cantidad;
                    String categoria = txtCategoria.getText();


                    try {
                        precio = Double.parseDouble(txtPrecio.getText());
                        if (precio < 0) throw new NumberFormatException();
                    } catch (NumberFormatException ex) {
                        throw new Exception("El precio debe ser un número válido mayor o igual a 0.");
                    }


                    try {
                        cantidad = Integer.parseInt(txtCantidad.getText());
                        if (cantidad < 0) throw new NumberFormatException();
                    } catch (NumberFormatException ex) {
                        throw new Exception("La cantidad en stock debe ser un número entero mayor o igual a 0.");
                    }


                    // Actualizar el modelo de datos
                    producto.setNombre(nombre);
                    producto.setPrecio(precio);
                    producto.setCantidadStock(cantidad);
                    producto.setCategoria(categoria);


                    // Mostrar la información actualizada
                    lblInfo.setText(producto.toString());
                } catch (Exception ex) {
                    // Mostrar mensaje de error
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        setVisible(true);
    }


    public static void main(String[] args) {
        new GestionProducto();
    }
}
