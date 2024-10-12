import java.util.ArrayList;
import java.util.List;

// Interfaz del observador
interface Observador {
    void actualizar(String mensaje);
}

// Sujeto
class Sujeto {
    private List<Observador> observadores = new ArrayList<>();
    private String estado;

    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    public void eliminarObservador(Observador o) {
        observadores.remove(o);
    }

    public void setEstado(String estado) {
        this.estado = estado;
        notificarObservadores();
    }

    public void notificarObservadores() {
        for (Observador o : observadores) {
            o.actualizar(estado);
        }
    }
}

// Observador concreto
class Usuario implements Observador {
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println(nombre + " recibió la notificación: " + mensaje);
    }
}

// Uso del patrón Observer
public class ObserverDemo {
    public static void main(String[] args) {
        Sujeto sujeto = new Sujeto();
        Usuario usuario1 = new Usuario("Usuario 1");
        Usuario usuario2 = new Usuario("Usuario 2");

        sujeto.agregarObservador(usuario1);
        sujeto.agregarObservador(usuario2);

        sujeto.setEstado("Nueva actualización disponible.");
    }
}
