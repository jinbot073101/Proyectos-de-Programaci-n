package edu.avanzada.taller1.controlDatos;

import edu.avanzada.taller1.modelo.Persona;
import edu.avanzada.taller1.modelo.Aplazado;
import java.util.*;

public class ControlAplazado implements InterfaceControl {

    private ArrayList<Persona> baseDatosAplazados; // ArrayList para guaradar objeots de tipo aplazados
    private Scanner input;
    private Persona objAplazado;

    // Constructor
    public ControlAplazado() {
        input = new Scanner(System.in);
        baseDatosAplazados = new ArrayList<Persona>();
        objAplazado = new Aplazado();
    }

    public void ingresarPersona(int cedula) {
        if (verificarArray(cedula)) {
            System.out.println("Ya se a registrado un usuario con este número de cédula.");
        } else {
            Aplazado aplazado = (Aplazado) objAplazado;
            System.out.println("Ingrese un nombre: ");
            String nombre = input.nextLine();
            System.out.println("Ingrese un apellido: ");
            String apellido = input.nextLine();
            System.out.println("Ingrese la fecha de aplazamiento:   Formato DD -- MM --AAAA");
            String fechaAplazado = input.nextLine();

            aplazado.setCedula(cedula);
            aplazado.setNombre(nombre);
            aplazado.setApellido(apellido);
            aplazado.setFechaAplazado(fechaAplazado);
            if(aplazado.getSituacion().equals("Aplazado")){
                baseDatosAplazados.add(aplazado);
            } else {
                baseDatosAplazados.remove(aplazado);
            }
        }
    }

    public void consultarPersona() {
        if (baseDatosAplazados.isEmpty()) {
            System.out.println("\n<< No sea a registrado ningún usuario aplazado en la base de datos. >>");
        } else {
            System.out.println("Número de cédula de la persona a consultar: ");
            int cedula = input.nextInt();
            for (Persona val : baseDatosAplazados) {
                if (cedula == val.getCedula()) {
                    val.getDatos();
                } else {
                    System.out.println("\nNo se a registrado ningún usuario asociado con este número de cédula en esta base de datos.");
                }
            }
        }
    }
    
     public void cambiarSituacion() {

    }
    

    private boolean verificarArray(int cedula) {
        boolean encontrado = false;
        for (Persona val : baseDatosAplazados) {
            if (cedula == val.getCedula()) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }
 
    public ArrayList<Persona> getLista(){
        return this.baseDatosAplazados;
    }

}
