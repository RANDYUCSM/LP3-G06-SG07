public interface CanalNotificacion {
    void enviarNotificacion(String mensaje);
}


public class EnviadorCorreo implements CanalNotificacion {
    @Override
    public void enviarNotificacion(String mensaje) {
        // Aquí iría la lógica para enviar un correo electrónico
        System.out.println("Enviando correo: " + mensaje);
    }
}




public class EnviadorSMS implements CanalNotificacion {
    @Override
    public void enviarNotificacion(String mensaje) {
        // Aquí se simula el envío de un SMS
        System.out.println("Enviando SMS: " + mensaje);
    }
}
public class NotificadorSlack implements CanalNotificacion {
    @Override
    public void enviarNotificacion(String mensaje) {
        
        System.out.println("Enviando notificación a Slack: " + mensaje);
    }
}


public class NotificadorReserva {
    private CanalNotificacion canal;


    // Inyección de dependencias mediante el constructor
    public NotificadorReserva(CanalNotificacion canal) {
        this.canal = canal;
    }


    // Método para enviar la notificación usando el canal recibido
    public void notificar(String mensaje) {
        canal.enviarNotificacion(mensaje);
    }
}


public class ControladorReserva {
    public void procesarReserva() {
       
        CanalNotificacion canalCorreo = new EnviadorCorreo();
        NotificadorReserva notificador = new NotificadorReserva(canalCorreo);


        
        notificador.notificar("Reserva confirmada");
    }


    public static void main(String[] args) {
        ControladorReserva controlador = new ControladorReserva();
        controlador.procesarReserva();
    }
}
