package Ejer4;

import javax.sound.sampled.*; 
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Audio {
    private static Clip clip;
    private static boolean isPaused = false;
    private static long clipPosition = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Reproducción de Audio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JButton playButton = new JButton("Reproducir");
        playButton.addActionListener(e -> playAudio("acoustic-guitar-loop-f-91bpm-132687.wav"));

        JButton pauseButton = new JButton("Pausar");
        pauseButton.addActionListener(e -> pauseAudio());

        JButton resumeButton = new JButton("Reanudar");
        resumeButton.addActionListener(e -> resumeAudio());

        JPanel panel = new JPanel();
        panel.add(playButton);
        panel.add(pauseButton);
        panel.add(resumeButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void playAudio(String filePath) {
        try {
            File audioFile = new File(filePath);
            if (!audioFile.exists()) {
                JOptionPane.showMessageDialog(null, "Archivo de audio no encontrado: " + filePath);
                return;
            }

            if (clip != null && clip.isRunning()) {
                clip.stop();
                clip.close();
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            isPaused = false;

            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            JOptionPane.showMessageDialog(null, "Error al reproducir el archivo de audio: " + e.getMessage());
        }
    }

    public static void pauseAudio() {
        if (clip != null && clip.isRunning()) {
            clipPosition = clip.getMicrosecondPosition();
            clip.stop();
            isPaused = true;
        }
    }

    public static void resumeAudio() {
        if (clip != null && isPaused) {
            clip.setMicrosecondPosition(clipPosition);
            clip.start();
            isPaused = false;
        }
    }
}
