package modelo;

import java.io.IOException;
import java.io.RandomAccessFile;

public class PersistenciaDatos {

    private final String nombreArchivo = "equipo_ganador.dat";
    private final int tamreg = 128; // Tamaño aproximado para un registro, depende de los atributos

    // Método para guardar un equipo ganador
    public void guardarEquipo(Equipo equipo) throws IOException {
        try (RandomAccessFile archivo = new RandomAccessFile(nombreArchivo, "rw")) {
            archivo.seek(archivo.length()); // Ir al final del archivo para agregar un nuevo equipo
            // Guardar los datos del equipo
            archivo.writeInt(equipo.getIdEquipo()); // Guardar ID del equipo
            escribirString(archivo, equipo.getNombreEquipo(), 50); // Guardar el nombre (con longitud fija)
            archivo.writeInt(equipo.getPuntaje()); // Guardar el puntaje
        }
    }
    // Método auxiliar para escribir una cadena con longitud fija en el archivo
    private void escribirString(RandomAccessFile archivo, String str, int longitud) throws IOException {
        StringBuffer buffer = new StringBuffer(str);
        buffer.setLength(longitud);
        archivo.writeChars(buffer.toString());
    }
}
