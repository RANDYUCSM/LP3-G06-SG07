package ejer_1;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class ProductoVista extends JFrame {
    private JTextField Nombre;
    private JTextField Precio;
    private JTextField Cantidad;
    private JTextField Categoria;
    private JButton btnActualizar;
    private JLabel InfoProducto;

    public ProductoVista() {
        setTitle("Gestión de Producto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(6, 2, 10, 10));

        add(new JLabel("Nombre:"));
        Nombre = new JTextField();
        add(Nombre);

        add(new JLabel("Precio:"));
        Precio = new JTextField();
        add(Precio);

        add(new JLabel("Cantidad en stock:"));
        Cantidad = new JTextField();
        add(Cantidad);

        add(new JLabel("Categoría:"));
        Categoria = new JTextField();
        add(Categoria);
        btnActualizar = new JButton("Actualizar Producto");
        add(btnActualizar);

        InfoProducto = new JLabel("Información del producto: ");
        add(InfoProducto);

        setVisible(true);
    }

    public JTextField getNOMBRE() {
        return Nombre;
    }

    public JTextField getPRECIO() {
        return Precio;
    }

    public JTextField getCANTIDAD() {
        return Cantidad;
    }

    public JTextField getCATEGORIA() {
        return Categoria;
    }

    public JButton getBTNACTUALIZAR() {
        return btnActualizar;
    }

    public JLabel getINFOPRODUCTO() {
        return InfoProducto;
    }
}