package control;

import java.io.IOException;
import modelo.Serializacion;
import modelo.PerroVO;

/**
 * Clase que gestiona la serialización de objetos de tipo PerroVO.
 *
 * esta clase se encarga de serializar los datos de los perros registrados en la
 * base de datos, utilizando un objeto de la clase Serializacion.
 */
public class GestorSerializacion {

    /**
     * Controlador que maneja las operaciones relacionadas con perros
     */
    private final IControlPerro controlPerro;

    /**
     * Perro que se va a serializar
     */
    private PerroVO perroSerializar;
    /**
     * Clase encargada de la serialización de datos
     */
    private final Serializacion serializar;
    ;

    /** Contador para llevar la cuenta de los perros serializados */
    private int cont = 0;

    /**
     * Constructor de GestorSerializacion.
     *
     * @param controlPerro Controlador que se utilizará para acceder a la lista
     * de perros.
     * @throws java.io.IOException Si ocurre un error al escribir el archivo
     * serializado.
     */
    public GestorSerializacion(IControlPerro controlPerro) throws IOException {
        this.serializar = new Serializacion();
        this.controlPerro = controlPerro;
    }

    /**
     * Método que gestiona la serialización de perros.
     *
     * Este método serializa el perro actual (determinado por el contador cont)
     * y lo escribe en un archivo. Si se han serializado todos los perros, no
     * realiza ninguna acción
     */
    public void gestionarSerializacion() {
        if (cont < controlPerro.mostrarPerrosBaseDeDatos().size()) {
            perroSerializar = controlPerro.mostrarPerrosBaseDeDatos().get(cont);
            serializar.escribirArchivoSerializado(perroSerializar);
            cont++;
            gestionarSerializacion();
        }
    }
}
