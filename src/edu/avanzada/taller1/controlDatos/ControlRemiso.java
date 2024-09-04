package edu.avanzada.taller1.controlDatos;

import edu.avanzada.taller1.modelo.Persona;
import edu.avanzada.taller1.modelo.Remiso;
import java.util.ArrayList;
import java.util.Scanner;

/*Esta clase se encarga de gestionar y manejar los datos de una persona remiso y 
sus diferentes interacciones con el respectivo ArrayList encargado de almacenar los
objetos de esta clase.
 */

public class ControlRemiso implements InterfaceControl {

    private final Scanner input;
    private ArrayList<Persona> baseDatosRemisos = new ArrayList<>();
    private ControlBaseDatos controlDatos;

    public ControlRemiso(ControlBaseDatos controlDatos) {
        input = new Scanner(System.in);
        this.controlDatos = controlDatos;
        this.baseDatosRemisos = controlDatos.getListaPorEstado("Remiso");
    }

    // Utiliza el objeto creado en el método crearRemiso para ingresarlo al
    // ArrayList
    @Override
    public void ingresarPersona(int cedula) {
        controlDatos = new ControlBaseDatos();
        if (verificarArray(cedula)) {
            System.out.println("Ya se a registrado un usuario con este número de cédula.\n");
        } else {
            Persona remiso = crearRemiso(cedula);// uso del método
            controlDatos.ingresarUsuario(remiso, "Remiso");
        }
    }

    // Crea un objeto remiso junto con sus respectivos datos
    private Persona crearRemiso(int cedula) {
        Remiso remiso = new Remiso();
        System.out.println("Ingrese un nombre: ");
        String nombre = input.nextLine();
        System.out.println("Ingrese un apellido: ");
        String apellido = input.nextLine();

        remiso.setCedula(cedula);
        remiso.setNombre(nombre);
        remiso.setApellido(apellido);
        remiso.setSituacionMilitar("Remiso");

        return remiso;
    }

    // Busca un objeto remiso dentro del ArrayList y retorna su información al
    // encontralo
    @Override
    public void consultarPersona() {
        if (baseDatosRemisos.isEmpty()) {
            System.out.println("\n<< No se ha registrado ningún usuario remiso en la base de datos. >>\n");
        } else {
            System.out.println("Número de cédula de la persona a consultar: ");
            int cedula = input.nextInt();
            input.nextLine(); // Consumir la nueva línea
            boolean encontrado = false;
            for (Persona val : baseDatosRemisos) {
                if (cedula == val.getCedula()) {
                    val.getDatos();
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println(
                        "\n[ No se ha registrado ningún usuario asociado con este número de cédula en esta base de datos ]\n");
            }
        }
    }

    // Gestiona y valida el cambio del objeto remiso a un nuevo tipo de estado
    // militar
    @Override
    public void cambiarSituacion() {
        System.out.println("Digite número de cédula: ");
        int cedula = input.nextInt();
        input.nextLine(); // Consumir la nueva línea
        boolean encontrado = verificarArray(cedula);
        if (encontrado) {
            for (Persona objPersona : baseDatosRemisos) {
                if (cedula == objPersona.getCedula()) {
                    System.out.println("Digite el nuevo estado militar: ");
                    System.out.println("[1) Reservista | 2) Remiso | 3) Aplazado | 4) Reclutado]");
                    int opcion = input.nextInt();
                    input.nextLine(); // Consumir la nueva línea
                    switch (opcion) {
                        case 1 -> System.out.println("No se puede efectuar este cambio\n");
                        case 2 -> System.out.println("El usuario ya se encuentra en este estado\n");
                        case 3 -> {
                            System.out.println("Cambiando estado....");
                            controlDatos.cambiarUsuario(objPersona, "Aplazado");
                            System.out.println("\\t>>Estado cambiado exitosamente.\n");
                        }
                        case 4 -> {
                            System.out.println("Cambiando estado....");
                            controlDatos.cambiarUsuario(objPersona, "Reclutado");
                            System.out.println("\\t>>Estado cambiado exitosamente.\n");
                        }
                        default -> System.out.println("Opción inválida");
                    }
                    break;
                }
            }
        } else {
            System.out.println("No se encontró un usuario con esta cédula.\n");
        }
    }

    @Override
    public ArrayList<Persona> getLista() {
        return baseDatosRemisos;
    }

    // ejecuta el proceso de verificar si una cédula ya ha sido registrada antes en
    // el ArrayList
    private boolean verificarArray(int cedula) {
        boolean encontrado = false;
        for (Persona val : baseDatosRemisos) {
            if (cedula == val.getCedula()) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

}
