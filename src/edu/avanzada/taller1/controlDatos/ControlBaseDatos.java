package edu.avanzada.taller1.controlDatos;
import edu.avanzada.taller1.modelo.Persona;
import java.util.ArrayList;

/*Esta clase se encarga de gestionar los métodos de la creación de los ArraysList usados
para almacenar las instancias de las distintas personas. Asímismo, de la modificación de
dichos ArraysList y los metodos que permiten interactuar y modificar estos mismos
 */
public class ControlBaseDatos {

    private final ArrayList<Persona> listaReservistas = new ArrayList<>();
    private final ArrayList<Persona> listaRemisos = new ArrayList<>();
    private final ArrayList<Persona> listaAplazados = new ArrayList<>();
    private final ArrayList<Persona> listaReclutados = new ArrayList<>();

    /*retorna el ArrayList de cada control dependiendo del estado que se le pase
     * como parámetro. Asi, puede acceder a cada ArrayList indivual para sus
     * diferentes
     * implementaciones y modificaciones en el método cambiarUsuario
     */
    public ArrayList<Persona> getListaPorEstado(String estado) {
        return switch (estado) {
            case "Reservista" -> listaReservistas;
            case "Remiso" -> listaRemisos;
            case "Aplazado" -> listaAplazados;
            case "Reclutado" -> listaReclutados;
            default -> throw new IllegalArgumentException("Estado no reconocido");

             
        };
    }

    // Ingresa un objeto persona a un ArrayList específico usando el método
    // getListaPorEstado
    public void ingresarUsuario(Persona persona, String estado) {
        getListaPorEstado(estado).add(persona);
    }

    // Elimina un objeto persona a un ArrayList específico usando el método
    // getListaPorEstado
    public void eliminarUsuario(Persona persona, String estado) {
        getListaPorEstado(estado).remove(persona);
    }

    /*
     * Valida el ArrayList en el que se encuentra un objeto persona, lo elimina y
     * lo agrega a un nuevo ArrayList una vez cambiado su situación militar
     */
    public void cambiarUsuario(Persona persona, String nuevoEstado) {
        String estadoAnterior = persona.getSituacionMilitar();
        eliminarUsuario(persona, estadoAnterior);
        persona.setSituacionMilitar(nuevoEstado);
        ingresarUsuario(persona, nuevoEstado);
    }

    public boolean verificarArrays(int cedula){
        
        for (Persona p : listaAplazados) {
            if(p.getCedula() == cedula){
                return true;
            
            } 

        }
        for (Persona p : listaReclutados) {
            if(p.getCedula() == cedula){
                return true;
            
            } 
            
        }
        for (Persona p : listaRemisos) {
            if(p.getCedula() == cedula){
                return true;
            
            } 
            
        }
        for (Persona p : listaReservistas) {
            if(p.getCedula() == cedula){
                return true;
            
            } 
            
        }
        return false;
    }

    public void MostrarArrays(){
        
        for (Persona p : listaAplazados) {
            p.getDatos(); 

        }
        for (Persona p : listaReclutados) {
            p.getDatos();
            
        }
        for (Persona p : listaRemisos) {
            p.getDatos();
            
        }
        for (Persona p : listaReservistas) {
            p.getDatos();
            
        }
        
    }
}
