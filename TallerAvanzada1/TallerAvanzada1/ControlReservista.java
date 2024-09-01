import java.util.ArrayList;
import java.util.Scanner;

public class ControlReservista implements ControlInterface {

    private ArrayList<Reservista> baseDatosReservistas;
    private Scanner input;
    private Reservista reservista;

    public ControlReservista() {
        baseDatosReservistas = new ArrayList<Reservista>();
        reservista = new Reservista();
    }

    public void ingresarPersona(int cedula) {
        input = new Scanner(System.in);

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
        baseDatosReservistas.add(reservista);

    }

    public boolean verificarArray(int cedula) {
        boolean encontrado = false;
        for (Reservista val : baseDatosReservistas) {
            if (cedula == val.getCedula()) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    public void consultarPersona() {
        input = new Scanner(System.in);
        if (baseDatosReservistas.isEmpty()) {
            System.out.println("No sea a registrado ningún usuario reservista en la base de datos.");
        } else {
            System.out.println("Número de cédula de la persona a consultar: ");
            int cedula = input.nextInt();
            for (Reservista val : baseDatosReservistas) {
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