package edu.avanzada.taller1.controlDatos;

import edu.avanzada.taller1.modelo.Persona;
import edu.avanzada.taller1.modelo.Reclutado;
import java.util.ArrayList;
import java.util.Scanner;

/*Esta clase se encarga de gestionar y manejar los datos de una persona reclutada y 
sus diferentes interacciones con el respectivo ArrayList encargado de almacenar estos
objetos.
 */

public class ControlReclutado implements InterfaceControl {

    private final Scanner input;
    private ArrayList<Persona> baseDatosReclutados = new ArrayList<>();
    private final ControlBaseDatos controlDatos;

    public ControlReclutado(ControlBaseDatos controlDatos) {
        input = new Scanner(System.in);
        this.controlDatos = controlDatos;
        this.baseDatosReclutados = controlDatos.getListaPorEstado("Reclutado");
    }

    // Utiliza el objeto creado en el método crearReclutado para ingresarlo al
    // ArrayList
    @Override
    public void ingresarPersona(int cedula) {
        if (controlDatos.verificarArrays(cedula)) {
            System.out.println("Ya se a registrado un usuario con este número de cédula.\n");
        } else {
            Persona reclutado = crearReclutado(cedula);// uso del método
            controlDatos.ingresarUsuario(reclutado, "Reclutado");
        }
    }

    // Crea un objeto reclutado junto con sus respectivos datos
    private Persona crearReclutado(int cedula) {
        Reclutado reclutado = new Reclutado();
        System.out.println("Ingrese un nombre: ");
        String nombre = input.nextLine();
        System.out.println("Ingrese un apellido: ");
        String apellido = input.nextLine();
        System.out.println("Ingrese el código de reclutamiento:");
        long codigoReclutado = input.nextLong();

        reclutado.setCedula(cedula);
        reclutado.setNombre(nombre);
        reclutado.setApellido(apellido);
        reclutado.setCodigoReclutado(codigoReclutado);
        reclutado.setSituacionMilitar("Reclutado");

        return reclutado;
    }

    // Busca un objeto reclutado dentro del ArrayList y retorna su información al
    // encontralo
    @Override
    public void consultarPersona() {
        if (baseDatosReclutados.isEmpty()) {
            System.out.println("\n<< No se ha registrado ningún usuario reclutado en la base de datos. >>\n");
        } else {
            System.out.println("Número de cédula de la persona a consultar: ");
            int cedula = input.nextInt();
            input.nextLine(); // Consumir la nueva línea
            boolean encontrado = false;
            for (Persona val : baseDatosReclutados) {
                if (cedula == val.getCedula()) {
                    val.getDatos();
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println(
                        "\n[ No se ha registrado ningún usuario asociado con este número de cédula en esta base de datos. ]\n");
            }
        }
    }

    // Gestiona y valida el cambio del objeto reclutado a un nuevo tipo de estado
    // militar
    @Override
    public void cambiarSituacion() {
        System.out.println("Digite número de cédula: ");
        int cedula = input.nextInt();
        input.nextLine(); // Consumir la nueva línea
        boolean encontrado = verificarArray(cedula);
        if (encontrado) {
            for (Persona objPersona : baseDatosReclutados) {
                if (cedula == objPersona.getCedula()) {
                    System.out.println("Digite el nuevo estado militar: ");
                    System.out.println("[1) Reservista | 2) Remiso | 3) Aplazado | 4) Reclutado]");
                    int opcion = input.nextInt();
                    input.nextLine(); // Consumir la nueva línea
                    switch (opcion) {
                        case 1 -> {
                            System.out.println("Cambiando estado....");
                            controlDatos.cambiarUsuario(objPersona, "Reservista");
                            System.out.println("\\t>>Estado cambiado exitosamente.\n");
                        }
                        case 2 -> System.out.println("No se puede efectuar este cambio\n");
                        case 3 -> {
                            System.out.println("Cambiando estado....");
                            controlDatos.cambiarUsuario(objPersona, "Aplazado");
                            System.out.println("\\t>>Estado cambiado exitosamente.\n");
                        }
                        case 4 -> System.out.println("El usuario ya se encuentra en este estado\n");
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
        return baseDatosReclutados;
    }

    // ejecuta el proceso de verificar si una cédula ya ha sido registrada antes en
    // el ArrayList
    private boolean verificarArray(int cedula) {
        boolean encontrado = false;
        for (Persona val : baseDatosReclutados) {
            if (cedula == val.getCedula()) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

}
