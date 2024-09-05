package edu.avanzada.taller1.controlDatos;

import edu.avanzada.taller1.modelo.Aplazado;
import edu.avanzada.taller1.modelo.Persona;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta clase se encarga de gestionar los datos de personas en estado "Aplazado"
 * y sus interacciones con un ArrayList que almacena dichos objetos. 
 * Proporciona métodos para ingresar, consultar, cambiar el estado de una persona 
 * y generar reportes sobre las personas en estado aplazado.
 */

public class ControlAplazado implements InterfaceControl {

    private ArrayList<Persona> baseDatosAplazados = new ArrayList<>();
    private final Scanner input;
    private final ControlBaseDatos controlDatos;

     /**
     * Constructor que inicializa el controlador de la base de datos y la lista de personas en estado aplazado.
     * 
     * @param controlDatos instancia del controlador que maneja la base de datos de todas las personas.
     */

    public ControlAplazado(ControlBaseDatos controlDatos) {
        input = new Scanner(System.in);
        this.controlDatos = controlDatos;
        this.baseDatosAplazados = controlDatos.getListaPorEstado("Aplazado");
    }

     /**
     * Método para ingresar una persona en estado aplazado.
     * Verifica si la persona ya está registrada antes de crear un nuevo objeto y añadirlo al ArrayList.
     * 
     * @param cedula el número de cédula de la persona a ingresar.
     */
    @Override
    public void ingresarPersona(int cedula) {
        if (controlDatos.verificarArrays(cedula)) {
            System.out.println("Ya se a registrado un usuario con este número de cédula.\n");
        } else {
            Persona aplazado = crearAplazado(cedula);// uso del método
            controlDatos.ingresarUsuario(aplazado, "Aplazado");
            mostrarArray();
        }
    }

    /**
     * Método que crea un objeto de tipo {@link Aplazado} con los datos ingresados por el usuario.
     * 
     * @param cedula el número de cédula de la persona aplazada.
     * @return un objeto de tipo {@link Persona} con los datos de la persona aplazada.
     */
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

    /**
     * Método para consultar los datos de una persona en estado aplazado.
     * Solicita la cédula del usuario a consultar y muestra su información si se encuentra en el ArrayList.
     */
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

     /**
     * Método para cambiar el estado militar de una persona.
     * Solicita la cédula de la persona y permite cambiar su situación a uno de los otros estados disponibles.
     */
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


    /**
     * Retorna la lista de personas en estado aplazado.
     * 
     * @return un {@link ArrayList} de personas en estado aplazado.
     */
    @Override
    public ArrayList<Persona> getLista() {
        baseDatosAplazados = controlDatos.getListaPorEstado("Aplazado");
        return baseDatosAplazados;
    }

    /**
     * Verifica si una persona con la cédula dada ya está registrada en la lista de personas aplazadas.
     * 
     * @param cedula el número de cédula de la persona a verificar.
     * @return true si la persona está registrada, false en caso contrario.
     */    
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

    /**
     * Muestra la lista completa de personas aplazadas almacenadas en el ArrayList.
     */
    public void mostrarArray(){
        for (Persona val : baseDatosAplazados) {

           val.getDatos();
        }


    }
    
}
