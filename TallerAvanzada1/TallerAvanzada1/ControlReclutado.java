import java.util.*;

public class ControlReclutado implements ControlInterface {

    private Scanner input;
    private ArrayList<Reclutado> baseDatosReclutados; // ArrayList para guardar objetos de tipo reclutado
    private Reclutado reclutado;

    public ControlReclutado() {
        baseDatosReclutados = new ArrayList<Reclutado>();
        reclutado = new Reclutado();
    }

    public void ingresarPersona(int cedula) {
        input = new Scanner(System.in);
        System.out.println("Ingrese un nombre: ");
        String nombre = input.nextLine();

        System.out.println("Ingrese un apellido: ");
        String apellido = input.nextLine();

        System.out.println("Ingrese el código de reclutamiento:");
        int codigoReclutado = input.nextInt();

        reclutado.setCedula(cedula);
        reclutado.setNombre(nombre);
        reclutado.setApellido(apellido);
        reclutado.setCodigoReclutado(codigoReclutado);
        baseDatosReclutados.add(reclutado);

    }

    public boolean verificarArray(int cedula) {
        boolean encontrado = false;
        for (Reclutado val : baseDatosReclutados) {
            if (cedula == val.getCedula()) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    public void consultarPersona() {
        input = new Scanner(System.in);
        if (baseDatosReclutados.isEmpty()) {
            System.out.println("No sea a registrado ningún usuario reclutado en la base de datos.");
        } else {
            System.out.println("Número de cédula de la persona a consultar: ");
            int cedula = input.nextInt();
            for (Reclutado val : baseDatosReclutados) {
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