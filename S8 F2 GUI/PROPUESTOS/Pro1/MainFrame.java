package Pro1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class MainFrame extends JFrame {

    private JPanel panelBotones;
    private JButton[] botones;

    public MainFrame() {
        setTitle("Llerena- Pari");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 200);
        
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 5)); 
        
        botones = new JButton[5];
        for (int i = 0; i < botones.length; i++) {
            botones[i] = new JButton("Boton " + (i + 1));
            int buttonNumber = i + 1;
            botones[i].addActionListener(e -> {
                System.out.println("Botón " + buttonNumber + " presionado");
                botones[buttonNumber - 1].setBackground(java.awt.Color.YELLOW); 
            });
            panelBotones.add(botones[i]);
        }
        
        getContentPane().add(panelBotones, BorderLayout.SOUTH); 
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }
}
