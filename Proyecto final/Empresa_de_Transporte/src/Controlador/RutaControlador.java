package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Controlador.RutaControlador.ComprarPasajeListener;
import Modelo.BaseDatos;
import Modelo.Compra;
import Vista.RutaVista;

@SuppressWarnings("unused")
public
class RutaControlador {
    private RutaVista vista;

    public RutaControlador(RutaVista vista) {
        this.vista = vista;
        this.vista.agregarCompraListener(new ComprarPasajeListener());
    }

    class ComprarPasajeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Compra compra = new Compra(
                    1, 
                    vista.getNombre(),
                    vista.getApellido(),
                    vista.getDni(),
                    vista.getFechaViaje(),
                    vista.getOrigen(),
                    vista.getDestino(),
                    vista.isAlmuerzo(),
                    vista.isCena(),
                    vista.getAccesorios(),
                    vista.getPiso()
                );
                BaseDatos.registrarCompra(compra.getNombre(), compra.getApellido(), compra.getDni(), compra.getFechaViaje(), compra.getOrigen(), compra.getDestino());
                vista.mostrarError("Compra registrada con éxito.");
            } catch (Exception ex) {
                vista.mostrarError("Error: " + ex.getMessage());
            }
        }
    }
}
