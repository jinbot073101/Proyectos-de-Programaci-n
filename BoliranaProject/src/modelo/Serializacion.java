package modelo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author PC
 */
public class Serializacion {

    //Canales para permitir la entrada y la salida de los datos serializados
    //(para permitir la lectura y la escritura)
    private FileInputStream fileIn;
    private ObjectInputStream entrada;
    private FileOutputStream fileOut;
    private ObjectOutputStream salida;

    public Serializacion() {
        try {
            //para la salida(escritura de los datos(serializacion))
            fileOut = new FileOutputStream("participantes.bin");
            salida = new ObjectOutputStream(fileOut);
            //para la entrada(lectura de los datos(deserialización))
            fileIn = new FileInputStream("participantes.bin");
            entrada = new ObjectInputStream(fileIn);
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

    //Metodo para verificar que al serializar (escribir) los objetos....
    public void cerrarArchivoSerializado() {
        if (salida != null) {
            try {
                salida.close();
            } catch (IOException ex) {
            }
        }
    }

    //Metodo para verificar que al deserializar (leer) los objetos....
    public void cerrarArchivoDeserializado() {
        if (entrada != null) {
            try {
                entrada.close();
            } catch (IOException ex) {
            }
        }
    }

    //Método que serializa (escribe los capitanes en participantes.bin)
    public void serializarCapitanes(Capitan capitan) {
        if (salida != null) {
            try {
                salida.writeObject(capitan);
            } catch (IOException ex) {
            }
        }
    }
    
    //Método que serializa (escribe los jugadores en participantes.bin)
    public void serializarJugadores(Jugador jugador) {
        if (salida != null) {
            try {
                salida.writeObject(jugador);
            } catch (IOException ex) {
            }
        }
    }
    
    //Método que serializa (escribe los jueces en participantes.bin)
    public void serializarJueces(Juez juez) {
        if (salida != null) {
            try {
                salida.writeObject(juez);
            } catch (IOException ex) {
            }
        }
    }

    //Método que deserializa (lee los capitanes desde participantes.bin)
    public Capitan deserializarCapitanes() {
        Capitan capitan = null;
        if (entrada != null) {
            try {
                capitan = (Capitan) entrada.readObject();
            } catch (EOFException eof) {
                //fin del archivo
            } catch (IOException io) {
                //fin del archivo
            } catch (ClassNotFoundException cnfe) {
                //fin del archivo
            }
        }
        return capitan;
    }
    
    //Método que deserializa (lee los jugadores desde participantes.bin)
    public Jugador deserializarJugadores() {
        Jugador jugador = null;
        if (entrada != null) {
            try {
                jugador = (Jugador) entrada.readObject();
            } catch (EOFException eof) {
                //fin del archivo
            } catch (IOException io) {
                //fin del archivo
            } catch (ClassNotFoundException cnfe) {
                //fin del archivo
            }
        }
        return jugador;
    }
    
    //Método que deserializa (lee los jueces desde participantes.bin)
    public Juez deserializarJueces() {
        Juez juez = null;
        if (entrada != null) {
            try {
                juez = (Juez) entrada.readObject();
            } catch (EOFException eof) {
                //fin del archivo
            } catch (IOException io) {
                //fin del archivo
            } catch (ClassNotFoundException cnfe) {
                //fin del archivo
            }
        }
        return juez;
    }
}
