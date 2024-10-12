// Clase Singleton
class Configuracion {
    private static Configuracion instancia;
    private String configuracion;

    private Configuracion() {
        // Constructor privado para evitar instanciación externa
        configuracion = "Configuración por defecto";
    }

    public static Configuracion obtenerInstancia() {
        if (instancia == null) {
            instancia = new Configuracion();
        }
        return instancia;
    }

    public String obtenerConfiguracion() {
        return configuracion;
    }

    public void establecerConfiguracion(String configuracion) {
        this.configuracion = configuracion;
    }
}

// Uso del patrón Singleton
public class SingletonDemo {
    public static void main(String[] args) {
        Configuracion configuracion = Configuracion.obtenerInstancia();
        System.out.println(configuracion.obtenerConfiguracion());

        configuracion.establecerConfiguracion("Nueva configuración");
        System.out.println(Configuracion.obtenerInstancia().obtenerConfiguracion());
    }
}
