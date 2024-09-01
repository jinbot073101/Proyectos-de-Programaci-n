import java.util.ArrayList;
import java.util.Scanner;

public class ControlReservista implements ControladorInterface{

    private Scanner input;
    private ArrayList<Persona> baseDatosReservistas;
    private Reservista reservista;
    public void ingresarPersona(){

        reservista = new Reservista(); 
        Reservista usuario = (Reservista)reservista;System.out.println("Ingrese el número de cédula de la persona a registrar: ");
        int cedula = input.nextInt();
        System.out.println("Ingrese un nombre: ");
        String nombre = input.nextLine();

        System.out.println("Ingrese un apellido: ");
        String apellido = input.nextLine();

        System.out.println("Ingrese el número de la libreta militar:");
        int numeroLibretaMilitar = input.nextInt();
        usuario.setCedula(cedula);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setNumeroLibretaMilitar(numeroLibretaMilitar);
        baseDatosReservistas.add(usuario);




    }

    public void verificarArray(){
        System.out.println("Ingrese el número de cédula de la persona a registrar: ");
        int cedula = input.nextInt();
        for(Persona val: baseDatosReservistas){
            if(cedula == val.getCedula()){
                System.out.println("Ya se a registrado un usuario con este número.");
                break;
            }
            else{

            }

        }

    }

    public void consultarPersona() {

    }

    public void CambiarSituacion(){
        
    }


}
