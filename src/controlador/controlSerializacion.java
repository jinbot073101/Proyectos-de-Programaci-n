package controlador;

import modelo.Capitan;
import modelo.Jugador;
import modelo.Juez;
import modelo.Serializacion;

public class controlSerializacion {
    
    private Capitan capitanesSerializar;
    private Capitan capitanesDeserializar;
    private Jugador jugadoresSerializar;
    private Jugador jugadoresDeserializar;
    private Juez juezDeserializar;
    private Juez juezSerializar;
    private Serializacion serializacion;
    
    public controlSerializacion(){
        serializacion = new Serializacion();
    }
    
    /*public void serializarCapitanes() {
        capitanesSerializar = new Capitan("Jhon", "Herrera", 38);
        serializar.escribirArchivoSerializado(personaASerializar);
        personaDesSerializada =new Persona();
        personaDesSerializada = (Persona) serializar.leerArchivoSerializado();
        System.out.println("Persona DesSerializada: " + personaDesSerializada.getNombre() + " " + personaDesSerializada.getApellido());
   }
    
    public void serializarJugadores(){
        
    }
    
    public void serializarJuez(){
        
    }*/

    
    
    
}
