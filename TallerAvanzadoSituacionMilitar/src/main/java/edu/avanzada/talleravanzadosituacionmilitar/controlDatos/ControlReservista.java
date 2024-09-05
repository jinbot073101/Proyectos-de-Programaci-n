package edu.avanzada.talleravanzadosituacionmilitar.controlDatos;

import edu.avanzada.talleravanzadosituacionmilitar.modelo.Persona;
import edu.avanzada.talleravanzadosituacionmilitar.modelo.Reservista;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta clase se encarga de gestionar y manejar los datos de personas en estado "Reservista".
 * Permite registrar nuevas personas, consultar datos, cambiar su situación militar
 * y gestionar una lista de personas en estado "Reservista".
 */

public class ControlReservista implements InterfaceControl {
    private final ControlBaseDatos controlDatos;
    private ArrayList<Persona> baseDatosReservistas = new ArrayList<>();
    private final Scanner input;
    
    /**
     * Constructor que inicializa el controlador de la base de datos y la lista de personas reservistas.
     * 
     * @param controlDatos instancia del controlador que maneja la base de datos de todas las personas.
     */
    public ControlReservista(ControlBaseDatos controlDatos) {
        input = new Scanner(System.in);
        this.controlDatos = controlDatos;
        this.baseDatosReservistas = controlDatos.getListaPorEstado("Reservista");
    }

    /**
     * Método para ingresar una persona en estado "Reservista".
     * Verifica si la persona ya está registrada antes de crear un nuevo objeto y añadirlo a la lista.
     * 
     * @param cedula el número de cédula de la persona a ingresar.
     */
    @Override
    public void ingresarPersona(int cedula) {
        if (controlDatos.verificarArrays(cedula)) {
            System.out.println("Ya se a registrado un usuario con este número de cédula.\n");
        } else {
            System.out.println("Persona agregada exitosamente...\n");

            Persona reservista = crearReservista(cedula);// uso del método
            controlDatos.ingresarUsuario(reservista, "Reservista");
            mostrarArray();
            
        }
    }

    /**
     * Método que crea un objeto de tipo {@link Reservista} con los datos ingresados por el usuario.
     * 
     * @param cedula el número de cédula de la persona reservista.
     * @return un objeto de tipo {@link Persona} con los datos de la persona reservista.
     */
    public Persona crearReservista(int cedula) {
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

    /**
     * Método para consultar los datos de una persona en estado "Reservista".
     * Solicita la cédula del usuario a consultar y muestra su información si se encuentra en la lista.
     */
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

    /**
     * Método para cambiar la situación militar de una persona en estado "Reservista".
     * Solicita la cédula de la persona y permite cambiar su situación a otro estado militar disponible.
     */
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


   /**
     * Retorna la lista de personas en estado "Reservista".
     * 
     * @return un {@link ArrayList} de personas en estado reservista.
     */
    @Override
    public ArrayList<Persona> getLista() {
        baseDatosReservistas = controlDatos.getListaPorEstado("Reservista");
        return baseDatosReservistas;
    }

    /**
     * Verifica si una persona con la cédula dada ya está registrada en la lista de reservistas.
     * 
     * @param cedula el número de cédula de la persona a verificar.
     * @return true si la persona está registrada, false en caso contrario.
     */

    public boolean verificarArray(int cedula) {
        boolean encontrado = false;
        for (Persona val : baseDatosReservistas) {
            if (cedula == val.getCedula()) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    /**
     * Muestra la lista completa de personas reservistas almacenadas en el ArrayList.
     */
        public void mostrarArray(){
        for (Persona val : baseDatosReservistas) {
           val.getDatos();
        }


    }

}
