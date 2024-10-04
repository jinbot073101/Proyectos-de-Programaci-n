package modelo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Serializacion {

    //Canal de salida para escribir en el archivo de serializacion
    private FileOutputStream fileOut;
    private ObjectOutputStream salida;

    //Metodo Cosntructor que prepara los canales para leer / escribir 
    //en el archivo de serializacion
    public Serializacion() throws IOException {
        try {
            //Para escribir
            fileOut = new FileOutputStream("src//data//datosPerros.bin");
            salida = new ObjectOutputStream(fileOut);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Serializacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Serializacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void escribirArchivoSerializado(PerroVO perro) {
        if (salida != null) {
            try {
                salida.writeObject(perro);
            } catch (IOException ex) {
                Logger.getLogger(Serializacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
