import java.util.ArrayList;
import java.util.Scanner;

public class ControlReclutado implements ControladorInterface{

    private Scanner input;
    private ArrayList<Persona> baseDatosReclutado;
    private Reclutado reclutado;


    public void ingresarPersona(){

        reclutado = new Reclutado(); 
        Reclutado usuario = (Reclutado)reclutado;
        System.out.println("Ingrese el número de cédula de la persona a registrar: ");
        int cedula = input.nextInt();
        System.out.println("Ingrese un nombre: ");
        String nombre = input.nextLine();

        System.out.println("Ingrese un apellido: ");
        String apellido = input.nextLine();

        System.out.println("Ingrese el código de reclutamiento:");
        int codigoReclutado = input.nextInt();
        usuario.setCedula(cedula);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setCodigoReclutado(codigoReclutado);
        baseDatosReclutado.add(usuario);



    }

    public void consultarPersona() {

    }

    public void CambiarSituacion(){
        
    }


}
