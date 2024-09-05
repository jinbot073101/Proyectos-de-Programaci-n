package edu.avanzada.talleravanzadosituacionmilitar.controlDatos;

import edu.avanzada.talleravanzadosituacionmilitar.modelo.Persona;
import edu.avanzada.talleravanzadosituacionmilitar.modelo.Reclutado;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta clase se encarga de gestionar y manejar los datos de personas Reclutado.
 * Permite registrar nuevas personas, consultar datos, cambiar su situación militar
 * y gestionar una lista de personas en estado "Reclutado".
 */

public class ControlReclutado implements InterfaceControl {

    private final Scanner input;
    private ArrayList<Persona> baseDatosReclutados = new ArrayList<>();
    private final ControlBaseDatos controlDatos;

    /**
     * Constructor que inicializa el controlador de la base de datos y la lista de personas Reclutado.
     * 
     * @param controlDatos instancia del controlador que maneja la base de datos de todas las personas.
     */

    public ControlReclutado(ControlBaseDatos controlDatos) {
        input = new Scanner(System.in);
        this.controlDatos = controlDatos;
        this.baseDatosReclutados = controlDatos.getListaPorEstado("Reclutado"); // Inicialización de la lista específica
    }

    /**
     * Método para ingresar una persona en estado "Reclutado".
     * Verifica si la persona ya está registrada antes de crear un nuevo objeto y añadirlo a la lista.
     * 
     * @param cedula el número de cédula de la persona a ingresar.
     */
    @Override
    public void ingresarPersona(int cedula) {
        if (controlDatos.verificarArrays(cedula)) {
            System.out.println("Ya se a registrado un usuario con este número de cédula.\n");

        } else {
            Persona reclutado = crearReclutado(cedula);// uso del método
            controlDatos.ingresarUsuario(reclutado, "Reclutado");
            mostrarArray();        
        }
    }
    
    /**
     * Método que crea un objeto de tipo {@link Reclutado} con los datos ingresados por el usuario.
     * 
     * @param cedula el número de cédula de la persona reclutada.
     * @return un objeto de tipo {@link Persona} con los datos de la persona reclutada.
     */
    
     public Persona crearReclutado(int cedula) {
        Reclutado reclutado = new Reclutado();
        System.out.println("Ingrese un nombre: ");
        String nombre = input.nextLine();
        reclutado.setNombre(nombre);
        
        System.out.println("Ingrese un apellido: ");
        String apellido = input.nextLine();
        reclutado.setApellido(apellido);
        
        System.out.println("Ingrese el código de reclutamiento:");
        while (!input.hasNextLong()) {
            System.out.println("Código inválido. Por favor, ingrese un número válido:");
            input.next(); // Consume el input inválido
        }
        long codigoReclutado = input.nextLong();
        reclutado.setCodigoReclutado(codigoReclutado);
        reclutado.setCedula(cedula);
        
        // Consumir el salto de línea restante después de nextLong()
        input.nextLine();
        return reclutado;
    }

    /**
     * Método para consultar los datos de una persona en estado "Reclutado".
     * Solicita la cédula del usuario a consultar y muestra su información si se encuentra en la lista.
     */
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

    /**
     * Método para cambiar la situación militar de una persona en estado "Reclutado".
     * Solicita la cédula de la persona y permite cambiar su situación a otro estado militar disponible.
     */
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

    /**
     * Retorna la lista de personas en estado "Reclutado".
     * 
     * @return un {@link ArrayList} de personas en estado reclutado.
     */
    @Override
    public ArrayList<Persona> getLista() {
        baseDatosReclutados = controlDatos.getListaPorEstado("Reclutado"); 
        return baseDatosReclutados;
    }

   /**
     * Verifica si una persona con la cédula dada ya está registrada en la lista de reclutados.
     * 
     * @param cedula el número de cédula de la persona a verificar.
     * @return true si la persona está registrada, false en caso contrario.
     */
    public boolean verificarArray(int cedula) {
        boolean encontrado = false;
        for (Persona val : baseDatosReclutados) {
            if (cedula == val.getCedula()) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    /**
     * Muestra la lista completa de personas reclutadas almacenadas en el ArrayList.
     */
    public void mostrarArray(){
        
        for (Persona val : baseDatosReclutados) {
           val.getDatos();
        }


    }

}
