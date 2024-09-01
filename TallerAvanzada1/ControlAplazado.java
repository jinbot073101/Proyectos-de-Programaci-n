import java.util.ArrayList;
import java.util.Scanner;

public class ControlAplazado implements ControladorInterface {

    private ArrayList<Persona> baseDatosAplazados;
    private Scanner input;
    private Persona aplazado;

    public ControlAplazado() {
        
        input = new Scanner(System.in);
        baseDatosAplazados = new ArrayList<Persona>();   
        
    }
    public void ingresarPersona(){

        System.out.println("Ingrese el número de cédula de la persona a registrar: ");
        int cedula = input.nextInt();
        for(Persona val: baseDatosAplazados){
            if(cedula == val.getCedula()){
                System.out.println("Ya se a registrado un usuario con este número.");
            }
            else{
                System.out.println("Ingrese un nombre: ");
                String nombre = input.nextLine();
                System.out.println("Ingrese un apellido: ");
                String apellido = input.nextLine();
               

                aplazado = new Aplazado();
                Remiso usuario = (Remiso)aplazado;
                usuario.setCedula(cedula);
                usuario.setNombre(nombre);
                usuario.setApellido(apellido);
                baseDatosAplazados.add(usuario);

            }
        }      



    }

    public void verificarArray(){
        System.out.println("Ingrese el número de cédula de la persona a registrar: ");
        int cedula = input.nextInt();
        for(Persona val: baseDatosAplazados){
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
