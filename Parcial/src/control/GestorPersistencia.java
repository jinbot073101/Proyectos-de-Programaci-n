package control;

import java.io.IOException;
import modelo.PerroVO;
import modelo.PersistenciaAleatoria;

/**
 * La clase GestorPersistencia se encarga de gestionar la serialización de
 * objetos de tipo PerroVO utilizando la clase PersistenciaAleatoria, que
 * escribe los objetos en un archivo de acceso aleatorio.
 */
public class GestorPersistencia {

    /**
     * Controlador que permite acceder y gestionar la lista de perros.
     */
    private final IControlPerro controlPerro;

    /**
     * El objeto PerroVO que será serializado.
     */
    private PerroVO perroPersistir;

    /**
     * Instancia de PersistenciaAleatoria utilizada para realizar la escritura
     * de los objetos en el archivo.
     */
    private final PersistenciaAleatoria serializar;

    /**
     * Contador que lleva la cuenta de cuántos perros han sido serializados.
     */
    private int cont = 0;

    /**
     * Constructor de la clase GestorPersistencia.
     *
     * Inicializa el gestor con el controlador de perros y la clase de
     * persistencia para escribir en un archivo de acceso aleatorio.
     *
     * @param controlPerro El controlador que proporciona acceso a la lista de
     * perros.
     * @throws IOException Si ocurre un error al crear la instancia de
     * PersistenciaAleatoria.
     */
    public GestorPersistencia(IControlPerro controlPerro) throws IOException {
        this.serializar = new PersistenciaAleatoria();
        this.controlPerro = controlPerro;
    }

    /**
     * Método que gestiona la serialización de los perros.
     *
     * Este método serializa los objetos PerroVO obtenidos desde el controlador
     * y los escribe en el archivo de acceso aleatorio. La serialización se
     * realiza de manera recursiva hasta que todos los perros hayan sido
     * guardados.
     *
     * @throws IOException Si ocurre un error durante la escritura en el
     * archivo.
     */
    public void gestionarPersistencia() throws IOException {
        if (cont < controlPerro.mostrarPerrosBaseDeDatos().size()) {
            perroPersistir = controlPerro.mostrarPerrosBaseDeDatos().get(cont);
            serializar.escribirArchivoAleatorio(perroPersistir, cont);
            cont++;
            gestionarPersistencia(); // Para serializar todos los perros en la base de datos
        }
    }
}
