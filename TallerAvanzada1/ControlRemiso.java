import java.util.ArrayList;
import java.util.Scanner;

public class ControlRemiso implements ControladorInterface{
    private Scanner input;
    private ArrayList<Persona> baseDatosRemisos;
    private Persona remiso;

    public ControlRemiso() {
        
        input = new Scanner(System.in);
        baseDatosRemisos = new ArrayList<Persona>();   
        
    }

    public void ingresarPersona(){

        System.out.println("Ingrese el número de cédula de la persona a registrar: ");
        int cedula = input.nextInt();
        for(Persona val: baseDatosRemisos){
            if(cedula == val.getCedula()){
                System.out.println("Ya se a registrado un usuario con este número.");
            }
            else{
                System.out.println("Ingrese un nombre: ");
                String nombre = input.nextLine();
                System.out.println("Ingrese un apellido: ");
                String apellido = input.nextLine();
               

                remiso = new Remiso();
                Remiso usuario = (Remiso)remiso;
                usuario.setCedula(cedula);
                usuario.setNombre(nombre);
                usuario.setApellido(apellido);
                baseDatosRemisos.add(usuario);

            }
        }              
    }

    public void verificarArray(){
        System.out.println("Ingrese el número de cédula de la persona a registrar: ");
        int cedula = input.nextInt();
        for(Persona val: baseDatosRemisos){
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




    
