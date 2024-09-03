package edu.avanzada.taller1.controlDatos;

import edu.avanzada.taller1.modelo.Persona;
import edu.avanzada.taller1.modelo.Reservista;
import java.util.*;

public class ControlReservista implements InterfaceControl {

    private ArrayList<Persona> baseDatosReservistas; //ArrayList para guardar objetos tipo reservistas
    private Scanner input;
    private Persona objReservista;

    public ControlReservista() {
        input = new Scanner(System.in);
        baseDatosReservistas = new ArrayList<Persona>();
        objReservista = new Reservista();
    }

    public void ingresarPersona(int cedula) {
        if (verificarArray(cedula)) {
            System.out.println("Ya se a registrado un usuario con este número de cédula.");
        } else {
            Reservista reservista = (Reservista) objReservista;
            verificarArray(cedula);
            System.out.println("Ingrese un nombre: ");
            String nombre = input.nextLine();

            System.out.println("Ingrese un apellido: ");
            String apellido = input.nextLine();

            System.out.println("Ingrese el número de la libreta militar:");
            int numeroLibretaMilitar = input.nextInt();

            // Ingresar datos de la persona y añadir al arrayList
            reservista.setCedula(cedula);
            reservista.setNombre(nombre);
            reservista.setApellido(apellido);
            reservista.setNumeroLibretaMilitar(numeroLibretaMilitar);
            if(reservista.getSituacion().equals("Reservista")){
                baseDatosReservistas.add(reservista);
            } else {
                baseDatosReservistas.remove(reservista);
            }
        }
    }

    public void consultarPersona() {
        if (baseDatosReservistas.isEmpty()) {
            System.out.println("\n<< No sea a registrado ningún usuario reservista en la base de datos. >>");
        } else {
            System.out.println("Número de cédula de la persona a consultar: ");
            int cedula = input.nextInt();
            for (Persona val : baseDatosReservistas) {
                if (cedula == val.getCedula()) {
                    System.out.println("");
                    val.getDatos();
                } else {
                    System.out.println("\n[ No se a registrado ningún usuario asociado con este número de cédula en esta base de datos. ]");
                }
            }
        }
    }
    
    public void cambiarSituacion() {
         

    }

    private boolean verificarArray(int cedula) {
        boolean encontrado = false;
        for (Persona val : baseDatosReservistas) {
            if (cedula == val.getCedula()) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }
    
    public ArrayList<Persona> getLista(){
        return this.baseDatosReservistas;
    }
    
     


}
