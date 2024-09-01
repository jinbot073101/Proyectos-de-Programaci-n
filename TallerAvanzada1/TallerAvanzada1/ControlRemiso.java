import java.util.ArrayList;
import java.util.Scanner;

public class ControlRemiso implements ControlInterface {

    private Scanner input;
    private ArrayList<Remiso> baseDatosRemisos; // ArrayList para guaradrar objetos de tipo remiso
    private Remiso remiso;

    public ControlRemiso() {
        
        baseDatosRemisos = new ArrayList<Remiso>(); // Inicializar el arrayList
        remiso = new Remiso();
    }

    public void ingresarPersona(int cedula) {
        input = new Scanner(System.in);

        System.out.println("Ingrese un nombre: ");
        String nombre = input.nextLine();

        System.out.println("Ingrese un apellido: ");
        String apellido = input.nextLine();

        remiso.setCedula(cedula);
        remiso.setNombre(nombre);
        remiso.setApellido(apellido);
        baseDatosRemisos.add(remiso);

    }

    public boolean verificarArray(int cedula) {
        boolean encontrado = false;
        for (Remiso val : baseDatosRemisos) {
            if (cedula == val.getCedula()) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    public void consultarPersona() {
        input = new Scanner(System.in);
        if (baseDatosRemisos.isEmpty()) {
            System.out.println("No sea a registrado ningún usuario remiso en la base de datos.");
        } else {
            System.out.println("Número de cédula de la persona a consultar: ");
            int cedula = input.nextInt();
            for (Remiso val : baseDatosRemisos) {
                if (cedula == val.getCedula()) {
                    val.getDatos();
                } else {
                    System.out.println("\nNo se a registrado ningún usuario asociado con este número de cédula.");
                }
            }
        }
    }

    public void cambiarSituacion() {
        input = new Scanner(System.in);
    }

}
