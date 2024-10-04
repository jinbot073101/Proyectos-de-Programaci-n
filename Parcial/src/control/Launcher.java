package control;

import java.io.IOException;

/**
 * Clase principal para lanzar la aplicación.
 *
 * Esta clase contiene el método main, que es el punto de entrada de la
 * aplicación. Se encarga de inicializar el sistema creando una instancia de
 * ControlGeneral.
 */
public class Launcher {

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args Argumentos de línea de comandos (no se utilizan en esta
     * implementación).
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        new ControlGeneral();
    }
}
