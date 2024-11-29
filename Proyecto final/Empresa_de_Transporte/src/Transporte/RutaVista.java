package Transporte;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.*;

@SuppressWarnings("serial")
class RutaVista extends JFrame {
    private JTextField txtNombre, txtApellido, txtDni, txtFechaViaje;
    private JComboBox<String> cbOrigen, cbDestino;
    private JCheckBox chkAlmuerzo, chkCena, chkAlmohada, chkOrejeras, chkBufanda, chkManta;
    private JSpinner spPiso;
    private JButton btnComprar;

    public RutaVista() {
        setTitle("Compra de Pasajes");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelCompra = new JPanel(new GridLayout(9, 2, 5, 5));
        panelCompra.setBorder(BorderFactory.createTitledBorder("Datos del Pasaje"));

        panelCompra.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelCompra.add(txtNombre);

        panelCompra.add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        panelCompra.add(txtApellido);

        panelCompra.add(new JLabel("DNI:"));
        txtDni = new JTextField();
        panelCompra.add(txtDni);

        panelCompra.add(new JLabel("Fecha de Viaje (YYYY-MM-DD):"));
        txtFechaViaje = new JTextField();
        panelCompra.add(txtFechaViaje);

        panelCompra.add(new JLabel("Origen:"));
        cbOrigen = new JComboBox<>(new String[]{"Arequipa", "Lima", "Puno", "Cuzco", "Ica", "Ancash"});
        panelCompra.add(cbOrigen);

        panelCompra.add(new JLabel("Destino:"));
        cbDestino = new JComboBox<>(new String[]{"Arequipa", "Lima", "Puno", "Cuzco", "Ica", "Ancash"});
        panelCompra.add(cbDestino);

        panelCompra.add(new JLabel("Piso (1 o 2):"));
        spPiso = new JSpinner(new SpinnerNumberModel(1, 1, 2, 1));
        panelCompra.add(spPiso);

        panelCompra.add(new JLabel("Servicios Opcionales:"));
        JPanel serviciosPanel = new JPanel(new GridLayout(2, 2));
        chkAlmuerzo = new JCheckBox("Almuerzo");
        chkCena = new JCheckBox("Cena");
        serviciosPanel.add(chkAlmuerzo);
        serviciosPanel.add(chkCena);
        panelCompra.add(serviciosPanel);

        panelCompra.add(new JLabel("Accesorios:"));
        JPanel accesoriosPanel = new JPanel(new GridLayout(2, 2));
        chkAlmohada = new JCheckBox("Almohada");
        chkOrejeras = new JCheckBox("Orejeras");
        chkBufanda = new JCheckBox("Bufanda");
        chkManta = new JCheckBox("Manta");
        accesoriosPanel.add(chkAlmohada);
        accesoriosPanel.add(chkOrejeras);
        accesoriosPanel.add(chkBufanda);
        accesoriosPanel.add(chkManta);
        panelCompra.add(accesoriosPanel);

        btnComprar = new JButton("Comprar Pasaje");
        panelCompra.add(btnComprar);

        add(panelCompra, BorderLayout.CENTER);
    }

    public String getNombre() { return txtNombre.getText(); }
    public String getApellido() { return txtApellido.getText(); }
    public String getDni() { return txtDni.getText(); }
    public String getFechaViaje() { return txtFechaViaje.getText(); }
    public String getOrigen() { return (String) cbOrigen.getSelectedItem(); }
    public String getDestino() { return (String) cbDestino.getSelectedItem(); }
    public int getPiso() { return (int) spPiso.getValue(); }
    public boolean isAlmuerzo() { return chkAlmuerzo.isSelected(); }
    public boolean isCena() { return chkCena.isSelected(); }
    public String getAccesorios() {
        StringBuilder accesorios = new StringBuilder();
        if (chkAlmohada.isSelected()) accesorios.append("Almohada ");
        if (chkOrejeras.isSelected()) accesorios.append("Orejeras ");
        if (chkBufanda.isSelected()) accesorios.append("Bufanda ");
        if (chkManta.isSelected()) accesorios.append("Manta ");
        return accesorios.toString().trim();
    }

    public void agregarCompraListener(ActionListener listener) {
        btnComprar.addActionListener(listener);
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
