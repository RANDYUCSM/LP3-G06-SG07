package Actividad1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de Binding de Datos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);

        Persona persona = new Persona("John Doe", 30, "Masculino");

        JTextField nombreField = new JTextField("", 15);
        JTextField edadField = new JTextField("", 15);
        JTextField sexoField = new JTextField("", 15);
        JButton button = new JButton("Actualizar Modelo");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String sexo = sexoField.getText();
                
                if (nombre.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese un nombre válido.");
                    return; 
                }
                
                if (sexo.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese un sexo válido.");
                    return; 
                }

                persona.setNombre(nombre);
                try {
                    int edad = Integer.parseInt(edadField.getText());
                    if (edad < 0) {
                        throw new NumberFormatException(); 
                    }
                    persona.setEdad(edad);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese un número válido para la edad.");
                    return; 
                }
                persona.setSexo(sexo);

                System.out.println("Modelo actualizado:");
                System.out.println("Nombre: " + persona.getNombre());
                System.out.println("Edad: " + persona.getEdad());
                System.out.println("Sexo: " + persona.getSexo());
            }
        });

        frame.setLayout(new java.awt.FlowLayout());
        frame.add(new JLabel("Nombre:"));
        frame.add(nombreField);
        frame.add(new JLabel("Edad:"));
        frame.add(edadField);
        frame.add(new JLabel("Sexo:"));
        frame.add(sexoField);
        frame.add(button);

        frame.setVisible(true);
    }
}

class Persona {
    private String nombre;
    private int edad;
    private String sexo;

    public Persona(String nombre, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}