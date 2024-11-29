package Transporte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Transporte.RutaControlador.ComprarPasajeListener;

@SuppressWarnings("unused")
class RutaControlador {
    private RutaVista vista;

    public RutaControlador(RutaVista vista) {
        this.vista = vista;
        this.vista.agregarCompraListener(new ComprarPasajeListener());
    }

    class ComprarPasajeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String nombre = vista.getNombre();
                String apellido = vista.getApellido();
                String dni = vista.getDni();
                String fechaViaje = vista.getFechaViaje();
                String origen = vista.getOrigen();
                String destino = vista.getDestino();
                BaseDatos.registrarCompra(nombre, apellido, dni, fechaViaje, origen, destino);
                vista.mostrarError("Compra registrada con éxito.");
            } catch (SQLException ex) {
                vista.mostrarError("Error al registrar la compra: " + ex.getMessage());
            }
        }
    }
}