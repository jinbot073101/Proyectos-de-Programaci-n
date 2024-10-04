package modelo;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase PersistenciaAleatoria permite la serialización de objetos en un
 * archivo de acceso aleatorio, lo que posibilita escribir en posiciones
 * específicas del archivo sin sobrescribir los datos existentes.
 */
public class PersistenciaAleatoria {

    /**
     * Archivo de acceso aleatorio donde se almacenarán los objetos
     * serializados.
     */
    private RandomAccessFile archivoAleatorio;

    /**
     * Constructor de la clase PersistenciaAleatoria.
     *
     * Este constructor abre el archivo de acceso aleatorio en modo
     * lectura/escritura.
     *
     * @throws IOException Si ocurre un error al abrir el archivo de acceso
     * aleatorio.
     */
    public PersistenciaAleatoria() throws IOException {
        try {
            // Abrimos el archivo en modo lectura/escritura
            archivoAleatorio = new RandomAccessFile("src/data/perrosRegistrados.dat", "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PersistenciaAleatoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Escribe un objeto PerroVO en una posición específica del archivo de
     * acceso aleatorio.
     *
     * Este método mueve el puntero del archivo a una posición basada en el
     * parámetro de posición, serializa el objeto en bytes y lo escribe en el
     * archivo.
     *
     * @param perro El objeto PerroVO que será serializado y almacenado en el
     * archivo.
     * @param posicion La posición en el archivo donde se escribirá el objeto.
     * @throws IOException Si ocurre un error al escribir en el archivo.
     */
    public void escribirArchivoAleatorio(PerroVO perro, int posicion) throws IOException {
        // Mover el puntero a la posición correcta
        archivoAleatorio.seek(posicion * 1024); // Estimamos que cada objeto ocupará 1KB como ejemplo

        // Serializamos el objeto en un array de bytes
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(perro);
        oos.flush();
        byte[] bytes = bos.toByteArray();

        // Escribimos el array de bytes en el archivo
        archivoAleatorio.write(bytes);
    }

    /**
     * Cierra el archivo de acceso aleatorio cuando ya no se necesita.
     *
     * Es importante llamar a este método para liberar los recursos asociados
     * con el archivo.
     *
     * @throws IOException Si ocurre un error al cerrar el archivo.
     */
    public void cerrarArchivo() throws IOException {
        if (archivoAleatorio != null) {
            archivoAleatorio.close();
        }
    }
}
