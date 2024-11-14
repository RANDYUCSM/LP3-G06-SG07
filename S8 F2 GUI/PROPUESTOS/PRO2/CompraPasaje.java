package PRO2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompraPasaje extends JFrame {
    private JTextField nombreField;
    private JTextField documentoField;
    private JTextField fechaField;
    private JCheckBox audifonosCheckBox;
    private JCheckBox mantaCheckBox;
    private JCheckBox revistasCheckBox;
    private JRadioButton piso1RadioButton;
    private JRadioButton piso2RadioButton;
    private JComboBox<String> origenComboBox;
    private JComboBox<String> destinoComboBox;
    private JList<String> calidadList;
    private JButton resumenButton;
    private JButton reiniciarButton;

    public CompraPasaje() {
        setTitle("Llerena-Pari");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2, 10, 10));

        add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        add(nombreField);

        add(new JLabel("Documento de Identidad:"));
        documentoField = new JTextField();
        add(documentoField);

        add(new JLabel("Fecha de Viaje (dd/mm/yyyy):"));
        fechaField = new JTextField();
        add(fechaField);

        add(new JLabel("Servicios Opcionales:"));
        JPanel serviciosPanel = new JPanel();
        audifonosCheckBox = new JCheckBox("Audífonos");
        mantaCheckBox = new JCheckBox("Manta");
        revistasCheckBox = new JCheckBox("Revistas");
        serviciosPanel.add(audifonosCheckBox);
        serviciosPanel.add(mantaCheckBox);
        serviciosPanel.add(revistasCheckBox);
        add(serviciosPanel);

        add(new JLabel("Piso del Bus:"));
        JPanel pisoPanel = new JPanel();
        piso1RadioButton = new JRadioButton("1er Piso");
        piso2RadioButton = new JRadioButton("2do Piso");
        ButtonGroup pisoGroup = new ButtonGroup();
        pisoGroup.add(piso1RadioButton);
        pisoGroup.add(piso2RadioButton);
        pisoPanel.add(piso1RadioButton);
        pisoPanel.add(piso2RadioButton);
        add(pisoPanel);

        add(new JLabel("Origen:"));
        origenComboBox = new JComboBox<>(new String[] {"Ciudad A", "Ciudad B", "Ciudad C"});
        add(origenComboBox);

        add(new JLabel("Destino:"));
        destinoComboBox = new JComboBox<>(new String[] {"Ciudad X", "Ciudad Y", "Ciudad Z"});
        add(destinoComboBox);

        add(new JLabel("Calidad del Servicio:"));
        calidadList = new JList<>(new String[] {"Económico", "Standard", "VIP"});
        add(new JScrollPane(calidadList));

        resumenButton = new JButton("Mostrar Resumen");
        add(resumenButton);
        reiniciarButton = new JButton("Reiniciar");
        add(reiniciarButton);

        resumenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarResumen();
            }
        });

        reiniciarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reiniciarCampos();
            }
        });
    }

    private void mostrarResumen() {
        String nombre = nombreField.getText().trim();
        String documento = documentoField.getText().trim();
        String fecha = fechaField.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!documento.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "El Documento de Identidad debe contener solo números.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!fecha.matches("\\d{2}/\\d{2}/\\d{2}")) {
            JOptionPane.showMessageDialog(this, "La fecha debe tener el formato dd/mm/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        StringBuilder servicios = new StringBuilder();
        if (audifonosCheckBox.isSelected()) servicios.append("Audífonos ");
        if (mantaCheckBox.isSelected()) servicios.append("Manta ");
        if (revistasCheckBox.isSelected()) servicios.append("Revistas ");

        String piso = piso1RadioButton.isSelected() ? "1er Piso" : "2do Piso";
        String origen = (String) origenComboBox.getSelectedItem();
        String destino = (String) destinoComboBox.getSelectedItem();
        String calidad = calidadList.getSelectedValue();

        String resumen = String.format("Nombre: %s\nDocumento: %s\nFecha de Viaje: %s\n" +
                "Servicios: %s\nPiso: %s\nOrigen: %s\nDestino: %s\nCalidad del Servicio: %s",
                nombre, documento, fecha, servicios, piso, origen, destino, calidad);

        JOptionPane.showMessageDialog(this, resumen, "Resumen de Compra", JOptionPane.INFORMATION_MESSAGE);
    }

    private void reiniciarCampos() {
        nombreField.setText("");
        documentoField.setText("");
        fechaField.setText("");
        audifonosCheckBox.setSelected(false);
        mantaCheckBox.setSelected(false);
        revistasCheckBox.setSelected(false);
        piso1RadioButton.setSelected(true);
        origenComboBox.setSelectedIndex(0);
        destinoComboBox.setSelectedIndex(0);
        calidadList.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CompraPasaje().setVisible(true);
            }
        });
    }
}
