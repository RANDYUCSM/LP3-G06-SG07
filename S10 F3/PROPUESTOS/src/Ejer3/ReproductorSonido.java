package Ejer3;

import javax.swing.*;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class ReproductorSonido extends JFrame {


    public ReproductorSonido() {
        setTitle("Reproductor de Efectos de Sonido");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new GridLayout(1, 3, 10, 10));


        // Crear botones para los efectos de sonido
        JButton btnAplausos = new JButton("Aplausos");
        JButton btnCampana = new JButton("Campana");
        JButton btnExplosion = new JButton("Explosión");


        btnAplausos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reproducirSonido("aplausos.wav");
            }
        });


        btnCampana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reproducirSonido("campana.wav");
            }
        });


        btnExplosion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reproducirSonido("explosion.wav");
            }
        });


        add(btnAplausos);
        add(btnCampana);
        add(btnExplosion);


        setVisible(true);
    }


    private void reproducirSonido(String archivo) {
        try {
            File file = new File(archivo);
            if (!file.exists()) {
                throw new IOException("Archivo no encontrado: " + archivo);
            }


            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException ex) {
            JOptionPane.showMessageDialog(this, "Formato de archivo no soportado.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (LineUnavailableException ex) {
            JOptionPane.showMessageDialog(this, "Dispositivo de audio no disponible.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args) {
        new ReproductorSonido();
    }
}

