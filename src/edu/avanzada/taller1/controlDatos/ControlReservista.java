package edu.avanzada.taller1.controlDatos;

import edu.avanzada.taller1.modelo.Persona;
import edu.avanzada.taller1.modelo.Reservista;
import java.util.ArrayList;
import java.util.Scanner;

/*Esta clase se encarga de gestionar y manejar los datos de una persona reservista y 
sus diferentes interacciones con el respectivo ArrayList encargado de almacenar los
objetos de esta clase.
 */

public class ControlReservista implements InterfaceControl {
    private final ControlBaseDatos controlDatos;
    private ArrayList<Persona> baseDatosReservistas = new ArrayList<>();
    private final Scanner input;

    public ControlReservista(ControlBaseDatos controlDatos) {
        input = new Scanner(System.in);
        this.controlDatos = controlDatos;
        this.baseDatosReservistas = controlDatos.getListaPorEstado("Reservista");
    }

    // Utiliza el objeto creado en el método crearReclutado para ingresarlo al
    // ArrayList
    @Override
    public void ingresarPersona(int cedula) {
        if (controlDatos.verificarArrays(cedula)) {
            System.out.println("Ya se a registrado un usuario con este número de cédula.\n");
        } else {
            Persona reservista = crearReservista(cedula);// uso del método
            controlDatos.ingresarUsuario(reservista, "Reservista");
        }
    }

    // Crea un objeto reclutado junto con sus respectivos datos
    private Persona crearReservista(int cedula) {
        Reservista reservista = new Reservista();
        System.out.println("Ingrese un nombre: ");
        String nombre = input.nextLine();
        System.out.println("Ingrese un apellido: ");
        String apellido = input.nextLine();

        System.out.println("Ingrese el número de la libreta militar:");
        int numeroLibretaMilitar = input.nextInt();
        input.nextLine();
        reservista.setCedula(cedula);
        reservista.setNombre(nombre);
        reservista.setApellido(apellido);
        reservista.setNumeroLibretaMilitar(numeroLibretaMilitar);
        reservista.setSituacionMilitar("Reservista");

        return reservista;
    }

    // Busca un objeto reclutado dentro del ArrayList y retorna su información al
    // encontralo
    @Override
    public void consultarPersona() {
        if (baseDatosReservistas.isEmpty()) {
            System.out.println("\n<< No se ha registrado ningún usuario reservista en la base de datos >>\n");
        } else {
            System.out.println("Número de cédula de la persona a consultar: ");
            int cedula = input.nextInt();
            input.nextLine(); // Consumir la nueva línea
            boolean encontrado = false;
            for (Persona val : baseDatosReservistas) {
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

    // Gestiona y valida el cambio del objeto reclutado a un nuevo tipo de estado
    // militar
    @Override
    public void cambiarSituacion() {
        System.out.println("Digite número de cédula: ");
        int cedula = input.nextInt();
        input.nextLine(); // Consumir la nueva línea
        boolean encontrado = verificarArray(cedula);
        if (encontrado) {
            for (Persona objPersona : baseDatosReservistas) {
                if (cedula == objPersona.getCedula()) {
                    System.out.println("Digite el nuevo estado militar: ");
                    System.out.println("[1) Reservista | 2) Remiso | 3) Aplazado | 4) Reclutado]");
                    int opcion = input.nextInt();
                    input.nextLine(); // Consumir la nueva línea
                    switch (opcion) {
                        case 1 -> System.out.println("El usuario ya se encuentra en este estado\n");
                        case 2 -> System.out.println("No se puede efectuar este cambio\n");
                        case 3 -> System.out.println("No se puede efectuar este cambio\n");
                        case 4 -> {
                            System.out.println("Cambiando estado....");
                            controlDatos.cambiarUsuario(objPersona, "Reclutado");
                            System.out.println("\t>>Estado cambiado exitosamente.\n");
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
        return baseDatosReservistas;
    }

    // ejecuta el proceso de verificar si una cédula ya ha sido registrada antes en
    // el ArrayList
    private boolean verificarArray(int cedula) {
        boolean encontrado = false;
        for (Persona val : baseDatosReservistas) {
            if (cedula == val.getCedula()) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

}
