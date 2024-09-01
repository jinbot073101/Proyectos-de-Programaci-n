import java.util.ArrayList;
import java.util.Scanner;

public class ControlAplazado implements ControlInterface {

    private ArrayList<Aplazado> baseDatosAplazados; // ArrayLiat para guaradar objeots de tipo aplazados
    private Scanner input;
    private Aplazado aplazado;

    // Constructor
    public ControlAplazado() {
        baseDatosAplazados = new ArrayList<Aplazado>();
        aplazado = new Aplazado();
    }

    public void ingresarPersona(int cedula) {
        input = new Scanner(System.in);
        System.out.println("Ingrese un nombre: ");
        String nombre = input.nextLine();
        System.out.println("Ingrese un apellido: ");
        String apellido = input.nextLine();
        System.out.println("Ingrese la fecha de aplazamiento:   Formato DD -- MM -- AAAA");
        String fechaAplazado = input.nextLine();

        aplazado.setCedula(cedula);
        aplazado.setNombre(nombre);
        aplazado.setApellido(apellido);
        aplazado.setFechaAplazado(fechaAplazado);
        baseDatosAplazados.add(aplazado);

    }

    public boolean verificarArray(int cedula) {
        boolean encontrado = false;
        for (Aplazado val : baseDatosAplazados) {
            if (cedula == val.getCedula()) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    public void consultarPersona() {
        input = new Scanner(System.in);
        if (baseDatosAplazados.isEmpty()) {
            System.out.println("No sea a registrado ningún usuario aplazado en la base de datos.");
        } else {
            System.out.println("Número de cédula de la persona a consultar: ");
            int cedula = input.nextInt();
            for (Aplazado val : baseDatosAplazados) {
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