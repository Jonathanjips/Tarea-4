// Subsistema 1: Proyector
class Proyector {
    public void encender() {
        System.out.println("Proyector encendido.");
    }

    public void apagar() {
        System.out.println("Proyector apagado.");
    }
}

// Subsistema 2: Sonido
class SistemaSonido {
    public void encender() {
        System.out.println("Sonido encendido.");
    }

    public void apagar() {
        System.out.println("Sonido apagado.");
    }
}

// Subsistema 3: Luces
class Luces {
    public void atenuar() {
        System.out.println("Luces atenuadas.");
    }

    public void encender() {
        System.out.println("Luces encendidas.");
    }
}

// Fachada
class CineFacade {
    private Proyector proyector;
    private SistemaSonido sonido;
    private Luces luces;

    public CineFacade(Proyector proyector, SistemaSonido sonido, Luces luces) {
        this.proyector = proyector;
        this.sonido = sonido;
        this.luces = luces;
    }

    public void iniciarCine() {
        luces.atenuar();
        proyector.encender();
        sonido.encender();
        System.out.println("La película está por comenzar.");
    }

    public void detenerCine() {
        proyector.apagar();
        sonido.apagar();
        luces.encender();
        System.out.println("La película ha terminado.");
    }
}

// Uso del patrón Facade
public class FacadeDemo {
    public static void main(String[] args) {
        Proyector proyector = new Proyector();
        SistemaSonido sonido = new SistemaSonido();
        Luces luces = new Luces();

        CineFacade cineFacade = new CineFacade(proyector, sonido, luces);
        cineFacade.iniciarCine();
        cineFacade.detenerCine();
    }
}
