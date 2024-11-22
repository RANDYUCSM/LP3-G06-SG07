package Actividad1;

import javax.swing.*;
import java.awt.*;
@SuppressWarnings("serial")
public class AppGraficos extends JPanel {
 
 @Override
 protected void paintComponent(Graphics g) {
 super.paintComponent(g);

 g.setColor(Color.RED);

 g.drawLine(10, 10, 100, 100);

 g.setColor(Color.RED);
 g.drawRect(50, 50, 100, 50);

 g.setColor(Color.GREEN);
 g.drawOval(150, 50, 100, 50);

 g.setColor(Color.ORANGE);
 g.fillOval(200, 150, 50, 50);

 g.setColor(Color.BLACK);
 g.drawString("Ejemplo de Gráficos en Swing", 10, 200);
 }
 public static void main(String[] args) {
 JFrame frame = new JFrame("Ejemplo de Gráficos");
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.setSize(400, 300);

 AppGraficos panel = new AppGraficos();
 frame.add(panel);

 frame.setVisible(true);
 }
}
