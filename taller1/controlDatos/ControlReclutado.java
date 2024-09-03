package edu.avanzada.taller1.controlDatos;

import edu.avanzada.taller1.modelo.Persona;
import edu.avanzada.taller1.modelo.Reclutado;
import java.util.*;

public class ControlReclutado implements InterfaceControl {

    private Scanner input;
    private ArrayList<Persona> baseDatosReclutados; // ArrayList para guardar objetos de tipo reclutado
    private Persona objReclutado;

    public ControlReclutado() {
        input = new Scanner(System.in);
        baseDatosReclutados = new ArrayList<Persona>();
        objReclutado = new Reclutado();
    }

    public void ingresarPersona(int cedula) {
        if (verificarArray(cedula)) {
            System.out.println("Ya se a registrado un usuario con este número.");
        } else {
            Reclutado reclutado = (Reclutado) objReclutado;
            System.out.println("Ingrese un nombre: ");
            String nombre = input.nextLine();

            System.out.println("Ingrese un apellido: ");
            String apellido = input.nextLine();

            System.out.println("Ingrese el código de reclutamiento:");
            long codigoReclutado = input.nextLong();

            reclutado.setCedula(cedula);
            reclutado.setNombre(nombre);
            reclutado.setApellido(apellido);
            reclutado.setCodigoReclutado(codigoReclutado);
            if (reclutado.getSituacion().equals("Reclutado")) {
                baseDatosReclutados.add(reclutado);
            } else {
                baseDatosReclutados.remove(reclutado);
            }
        }
    }

    public void consultarPersona() {
        input = new Scanner(System.in);
        if (baseDatosReclutados.isEmpty()) {
            System.out.println("\n<< No sea a registrado ningún usuario reclutado en la base de datos. >>");
        } else {
            System.out.println("Número de cédula de la persona a consultar: ");
            int cedula = input.nextInt();
            for (Persona val : baseDatosReclutados) {
                if (cedula == val.getCedula()) {
                    val.getDatos();
                } else {
                    System.out.println("\nNo se a registrado ningún usuario asociado con este número de cédula en esta base de datos.");
                }
            }
        }
    }
    
    public void cambiarSituacion() {
        input = new Scanner(System.in);

    }

    private boolean verificarArray(int cedula) {
        boolean encontrado = false;
        for (Persona val : baseDatosReclutados) {
            if (cedula == val.getCedula()) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }
    
    public ArrayList<Persona> getLista(){
        return this.baseDatosReclutados;
    }

    

}
