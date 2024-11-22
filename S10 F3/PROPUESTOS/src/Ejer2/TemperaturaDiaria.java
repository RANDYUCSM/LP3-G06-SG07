package Ejer2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class TemperaturaDiaria extends JFrame {
    private JTextField[] tempFields = new JTextField[7];
    private JPanel chartPanel;

    public TemperaturaDiaria() {
        setTitle("Registro de Temperaturas Semanales");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel rightPanel = new JPanel(new GridLayout(7, 2, 5, 5));
        String[] days = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        for (int i = 0; i < 7; i++) {
            JLabel dayLabel = new JLabel(days[i], SwingConstants.RIGHT);
            tempFields[i] = new JTextField();
            rightPanel.add(dayLabel);
            rightPanel.add(tempFields[i]);
        }
        add(rightPanel, BorderLayout.WEST); 

        JButton showChartButton = new JButton("Mostrar Gráfico");
        showChartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateChart();
            }
        });
        add(showChartButton, BorderLayout.SOUTH);

        chartPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawChart(g);
            }
        };
        chartPanel.setPreferredSize(new Dimension(600, 300)); // Establece el tamaño preferido del panel
        chartPanel.setVisible(false);
        add(chartPanel, BorderLayout.CENTER);
    }

    private void updateChart() {
        try {
            double[] temperatures = new double[7];
            for (int i = 0; i < 7; i++) {
                temperatures[i] = Double.parseDouble(tempFields[i].getText());
                if (temperatures[i] < -50 || temperatures[i] > 50) {
                    throw new NumberFormatException("Temperatura fuera de rango");
                }
            }

            chartPanel.setVisible(true);
            chartPanel.repaint();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores válidos para las temperaturas (entre -50 y 50 grados).", "Error de entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void drawChart(Graphics g) {
        String[] days = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        int chartWidth = 600;
        int chartHeight = 250; // Ajustado para que se vea bien con el offset
        int xOffset = 50;
        int yOffset = 250;

        g.drawLine(xOffset, yOffset, xOffset + chartWidth, yOffset); 
        g.drawLine(xOffset, yOffset, xOffset, yOffset - chartHeight); 

        g.drawString("-50°C", xOffset - 40, yOffset + 5);
        g.drawString("50°C", xOffset - 40, yOffset - chartHeight + 10);

        for (int i = 0; i < 7; i++) {
            double temp = Double.parseDouble(tempFields[i].getText());
            int barHeight = (int) ((temp + 50) / 100 * chartHeight); // Ajuste para que el rango sea de 0 a chartHeight
            int barWidth = 50;
            int x = xOffset + i * (barWidth + 10);
            int y = yOffset - barHeight;

            g.setColor(Color.BLUE);
            g.fillRect(x, y, barWidth, barHeight);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, barWidth, barHeight);

            g.drawString(days[i], x + 10, yOffset + 15);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TemperaturaDiaria frame = new TemperaturaDiaria();
            frame.setVisible(true);
        });
    }
}