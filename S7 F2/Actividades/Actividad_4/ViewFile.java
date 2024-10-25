package Actividad_4;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ViewFile extends JFrame {
    private JTextArea areaTexto;

    public ViewFile(String s) {
        super("Mostrando el contenido de un archivo");

        areaTexto = new JTextArea(s, 5, 40);
        areaTexto.setEditable(false);  
        JScrollPane scroll = new JScrollPane(areaTexto);

        add(scroll);
    }
}
