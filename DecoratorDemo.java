// Componente base
interface Notificador {
    void enviar(String mensaje);
}

// Componente concreto
class NotificadorBasico implements Notificador {
    public void enviar(String mensaje) {
        System.out.println("Enviando mensaje: " + mensaje);
    }
}

// Decorador base
abstract class NotificadorDecorador implements Notificador {
    protected Notificador decorador;

    public NotificadorDecorador(Notificador decorador) {
        this.decorador = decorador;
    }

    public void enviar(String mensaje) {
        decorador.enviar(mensaje);
    }
}

// Decorador concreto que envía SMS
class SMSDecorator extends NotificadorDecorador {
    public SMSDecorator(Notificador decorador) {
        super(decorador);
    }

    @Override
    public void enviar(String mensaje) {
        super.enviar(mensaje);
        System.out.println("Enviando mensaje por SMS: " + mensaje);
    }
}

// Decorador concreto que envía Email
class EmailDecorator extends NotificadorDecorador {
    public EmailDecorator(Notificador decorador) {
        super(decorador);
    }

    @Override
    public void enviar(String mensaje) {
        super.enviar(mensaje);
        System.out.println("Enviando mensaje por Email: " + mensaje);
    }
}

// Uso del patrón Decorator
public class DecoratorDemo {
    public static void main(String[] args) {
        Notificador notificador = new NotificadorBasico();
        Notificador notificadorSMS = new SMSDecorator(notificador);
        Notificador notificadorEmail = new EmailDecorator(notificadorSMS);

        notificadorEmail.enviar("Hola, este es tu mensaje.");
    }
}
