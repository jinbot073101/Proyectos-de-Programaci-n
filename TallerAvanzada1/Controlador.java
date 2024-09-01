import java.util.ArrayList;
import java.util.Scanner;

public class Controlador {

    private Scanner input;
    private ArrayList<Persona> baseDatos;
    private Persona reservista;
    private Persona remiso;
    private Persona aplazado;
    private Persona reclutado;

    public Controlador() {
        input = new Scanner(System.in);
        baseDatos = new ArrayList<Persona>();   
        
    }

    public void ingresarPersona() {
        System.out.println("Ingrese el número de cédula de la persona a registrar: ");
        int cedula = input.nextInt();
        for(Persona val: baseDatos){
            if(cedula == val.getCedula()){
                System.out.println("Ya se a registrado un usuario con este número.");
            }
            else{
                System.out.println("Ingrese un nombre: ");
                String nombre = input.nextLine();
                System.out.println("Ingrese un apellido: ");
                String apellido = input.nextLine();
                System.out.println("Situación militar a declarar: [Reservista/Remiso/Aplazado/Reclutado]");
                String situacion = input.nextLine();

                if(situacion.equalsIgnoreCase("Reservista")){
                    reservista = new Reservista(); 
                    Reservista usuario = (Reservista)reservista;
                    System.out.println("Ingrese el número de la libreta militar:");
                    int numeroLibretaMilitar = input.nextInt();
                    usuario.setCedula(cedula);
                    usuario.setNombre(nombre);
                    usuario.setApellido(apellido);
                    usuario.setNumeroLibretaMilitar(numeroLibretaMilitar);
                    baseDatos.add(usuario);


                } else if(situacion.equalsIgnoreCase("Remiso")){
                    remiso = new Remiso();
                    Remiso usuario = (Remiso)remiso;
                    usuario.setCedula(cedula);
                    usuario.setNombre(nombre);
                    usuario.setApellido(apellido);
                    baseDatos.add(usuario);
                    
                } else if(situacion.equalsIgnoreCase("Aplazado")){
                    aplazado = new Aplazado();

                }
                else if(situacion.equalsIgnoreCase("Reclutado")){
                    reclutado = new Reclutado();

                }
                else{

                }
            }
        }
    }

    public void consultarPersona() {
        if (baseDatos.isEmpty()) {
            System.out.println("NO SE A INGRESADO NINGÚN REGISTRO");
        } else {
            System.out.println("Ingrese el número de cédula de la persona a consultar: ");
            int cedulaIngresada = input.nextInt();
            for (Persona val : baseDatos) {
                if (cedulaIngresada == val.getCedula()) {
                    System.out.println();
                }

            }
        }
    }

    public void CambiarSituacion() {
        System.out.println("Ingrese el número de cédula de la persona: ");
        int cedula = input.nextInt();
        System.out.println("Gracias");

    }


}
