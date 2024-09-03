package edu.avanzada.taller1.controlDatos;

import edu.avanzada.taller1.modelo.Persona;
import edu.avanzada.taller1.modelo.Remiso;
import java.util.*;

public class ControlRemiso implements InterfaceControl {

    private Scanner input;
    private ArrayList<Persona> baseDatosRemisos; // ArrayList para guaradrar objetos de tipo remiso
    private Persona objRemiso;

    public ControlRemiso() {
        input = new Scanner(System.in);
        baseDatosRemisos = new ArrayList<Persona>(); // Inicializar el arrayList
        objRemiso = new Remiso();
    }

    public void ingresarPersona(int cedula) {
        if (verificarArray(cedula)) {
            System.out.println("Ya se a registrado un usuario con este número de cédula.");
        } else {
            Remiso remiso = (Remiso) objRemiso;
            System.out.println("Ingrese un nombre: ");
            String nombre = input.nextLine();

            System.out.println("Ingrese un apellido: ");
            String apellido = input.nextLine();

            remiso.setCedula(cedula);
            remiso.setNombre(nombre);
            remiso.setApellido(apellido);
            if (remiso.getSituacion().equals("Remiso")) {
                baseDatosRemisos.add(remiso);
            } else {
                baseDatosRemisos.remove(remiso);
            }
        }
    }

    public void consultarPersona() {
        if (baseDatosRemisos.isEmpty()) {
            System.out.println("\n<< No sea a registrado ningún usuario remiso en la base de datos. >>");
        } else {
            System.out.println("Número de cédula de la persona a consultar: ");
            int cedula = input.nextInt();
            for (Persona val : baseDatosRemisos) {
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
        for (Persona val : baseDatosRemisos) {
            if (cedula == val.getCedula()) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }
    
    
    public ArrayList<Persona> getLista(){
        return this.baseDatosRemisos;
    }

}
