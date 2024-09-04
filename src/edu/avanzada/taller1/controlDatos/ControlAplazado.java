package edu.avanzada.taller1.controlDatos;

import edu.avanzada.taller1.modelo.Aplazado;
import edu.avanzada.taller1.modelo.Persona;
import java.util.ArrayList;
import java.util.Scanner;

/*Esta clase se encarga de gestionar y manejar los datos de una persona aplazada y 
sus diferentes interacciones con el respectivo ArrayList encargado de almacenar los objetos
de esta clase.
 */

public class ControlAplazado implements InterfaceControl {

    private ArrayList<Persona> baseDatosAplazados = new ArrayList<>();
    private final Scanner input;
    private final ControlBaseDatos controlDatos;

    public ControlAplazado(ControlBaseDatos controlDatos) {
        input = new Scanner(System.in);
        this.controlDatos = controlDatos;
        this.baseDatosAplazados = controlDatos.getListaPorEstado("Aplazado");
    }

    // Utiliza el objeto creado en el método crearAplazado para ingresarlo al
    // ArrayList
    @Override
    public void ingresarPersona(int cedula) {
        if (verificarArray(cedula)) {
            System.out.println("Ya se a registrado un usuario con este número de cédula.\n");
        } else {
            Persona aplazado = crearAplazado(cedula);// uso del método
            controlDatos.ingresarUsuario(aplazado, "Aplazado");
        }
    }

    // Crea un objeto aplazado junto con sus respectivos datos
    private Persona crearAplazado(int cedula) {
        Aplazado aplazado = new Aplazado();
        System.out.println("Ingrese un nombre: ");
        String nombre = input.nextLine();
        System.out.println("Ingrese un apellido: ");
        String apellido = input.nextLine();
        System.out.println("Ingrese la fecha de aplazamiento:   Formato DD -- MM --AAAA");
        String fechaAplazado = input.nextLine();
        input.nextLine();

        aplazado.setCedula(cedula);
        aplazado.setNombre(nombre);
        aplazado.setApellido(apellido);
        aplazado.setFechaAplazado(fechaAplazado);
        aplazado.setSituacionMilitar("Aplazado");

        return aplazado;
    }

    // Busca un objeto aplazado dentro del ArrayList y retorna su información al
    // encontralo
    @Override
    public void consultarPersona() {
        if (baseDatosAplazados.isEmpty()) {
            System.out.println("\n<< No se ha registrado ningún usuario aplazado en la base de datos. >>\n");
        } else {
            System.out.println("Número de cédula de la persona a consultar: ");
            int cedula = input.nextInt();
            input.nextLine(); // Consumir la nueva línea
            boolean encontrado = false;
            for (Persona val : baseDatosAplazados) {
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

    // Gestiona y valida el cambio del objeto aplazado a un nuevo tipo de estado
    // militar
    @Override
    public void cambiarSituacion() {
        System.out.println("Digite número de cédula: ");
        int cedula = input.nextInt();
        input.nextLine(); // Consumir la nueva línea
        boolean encontrado = verificarArray(cedula);
        if (encontrado) {
            for (Persona objPersona : baseDatosAplazados) {
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
                        case 2 -> {
                            System.out.println("Cambiando estado....");
                            controlDatos.cambiarUsuario(objPersona, "Remiso");
                            System.out.println("\\t>>Estado cambiado exitosamente.\n");
                        }
                        case 3 -> System.out.println("El usuario ya se encuentra en este estado\n");
                        case 4 -> {
                            System.out.println("\\t>>Cambiando estado....");
                            controlDatos.cambiarUsuario(objPersona, "Reclutado");
                            System.out.println("Estado cambiado exitosamente.\n");
                        }
                        default -> System.out.println("Opción inválida");
                    }
                    break;
                }
            }
        } else {
            System.out.println("\nNo se encontró un usuario con esta cédula.\n");
        }
    }

    @Override
    public ArrayList<Persona> getLista() {
        return baseDatosAplazados;
    }

    // ejecuta el proceso de verificar si una cédula ya ha sido registrada antes en
    // el ArrayList
    private boolean verificarArray(int cedula) {
        boolean encontrado = false;
        for (Persona val : baseDatosAplazados) {
            if (cedula == val.getCedula()) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }
}
