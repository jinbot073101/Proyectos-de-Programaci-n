package edu.avanzada.taller1.controlEjecucion;

import edu.avanzada.taller1.controlDatos.InterfaceControl;
import edu.avanzada.taller1.modelo.Persona;
import java.util.Scanner;

/*Esta clase se encarga de manejar los distintos controladores de los objetos
persona y redireccionar según cada caso*/

public class ControlPersonas {

    private Scanner input;
    private final InterfaceControl controlRemiso;
    private final InterfaceControl controlReclutado;
    private final InterfaceControl controlReservista;
    private final InterfaceControl controlAplazado;

    /**
     * Constructor para inicializar los controladores de las diferentes situaciones militares.
     *
     * @param controlRemiso el controlador para personas con estado Remiso
     * @param controlReclutado el controlador para personas con estado Reclutado
     * @param controlReservista el controlador para personas con estado Reservista
     * @param controlAplazado el controlador para personas con estado Aplazado
     */

    public ControlPersonas(InterfaceControl controlRemiso, InterfaceControl controlReclutado,
            InterfaceControl controlReservista, InterfaceControl controlAplazado) {
                
        this.controlRemiso = controlRemiso;
        this.controlReclutado = controlReclutado;
        this.controlReservista = controlReservista;
        this.controlAplazado = controlAplazado;
    }

    /**
     * Método que permite ingresar una persona al sistema según su situación militar.
     * Solicita al usuario que seleccione la situación militar y luego pide la cédula de la persona.
     * Dependiendo de la selección, se llama al controlador correspondiente para ingresar la persona.
     */

    public void ingresarPersona() {

        int cedula;
        input = new Scanner(System.in);
        /*
         * Preguntar al usuario por la situación militar con el objetivo de saber
         * que objeto concreto se va a crear
         */
        System.out
                .println("\n > Situación militar a declarar: [1) Reservista | 2) Remiso | 3) Aplazado | 4) Reclutado]");
        String opcion = input.nextLine();
        // En cada caso, se pide la cédula como primer requisito para poder ingresar un
        // usuario
        if (opcion.equalsIgnoreCase("RESERVISTA")) {
            System.out.println("\nIngrese el número de cédula de la persona a registrar: ");
            cedula = input.nextInt();
            controlReservista.ingresarPersona(cedula);

        } else if (opcion.equalsIgnoreCase("REMISO")) {
            System.out.println("\nIngrese el número de cédula de la persona a registrar: ");
            cedula = input.nextInt();
            controlRemiso.ingresarPersona(cedula);

        } else if (opcion.equalsIgnoreCase("APLAZADO")) {
            System.out.println("\nIngrese el número de cédula de la persona a registrar: ");
            cedula = input.nextInt();
            controlAplazado.ingresarPersona(cedula);

        } else if (opcion.equalsIgnoreCase("RECLUTADO")) {
            System.out.println("\nIngrese el número de cédula de la persona a registrar: ");
            cedula = input.nextInt();
            controlReclutado.ingresarPersona(cedula);
        } else {
            System.out.println("NO SE RECONOCE ESTA OPCIÓN");
        }
    }



    /**
     * Método que permite consultar una persona en el sistema según su situación militar.
     * Solicita al usuario que ingrese la situación militar para filtrar la búsqueda.
     * Luego llama al controlador correspondiente para realizar la consulta.
     */
    public void consultarPersona() {
        input = new Scanner(System.in);
        // Preguntar al usuario por la situación militar para filtrar la consulta
        System.out.println("\n > Ingrese la situación militar de la persona a consultar para filtrar la busqueda:");
        System.out.println(" [Reservista | Remiso | Aplazado | Reclutado]");
        String opcion = input.nextLine();
        // Redirigir al metodo consultarPersona de cada controlador
        if (opcion.equalsIgnoreCase("RESERVISTA")) {
            System.out.println("\n<< Buscando por estado: Reservista >>\n");
            controlReservista.consultarPersona();
        } else if (opcion.equalsIgnoreCase("REMISO")) {
            System.out.println("\n<< Buscando por estado: Remiso >>\n");
            controlRemiso.consultarPersona();
        } else if (opcion.equalsIgnoreCase("APLAZADO")) {
            System.out.println("\n<< Buscando por estado: Aplazado >>\n");
            controlAplazado.consultarPersona();
        } else if (opcion.equalsIgnoreCase("RECLUTADO")) {
            System.out.println("\n<< Buscando por estado: Reclutado >>\n");
            controlReclutado.consultarPersona();
        } else {
            System.out.println("NO SE RECONOCE ESTA OPCIÓN");
        }
    }

    /**
     * Método que permite cambiar la situación militar de una persona en el sistema.
     * Solicita al usuario la situación militar de la persona y luego llama al controlador correspondiente
     * para modificar la situación de la persona.
     */
    public void cambiarSituacion() {
        input = new Scanner(System.in);
        System.out.println(
                "\n > Ingrese la situación militar de la persona a consultar para buscar en la base de datos:");
        System.out.println(" [Reservista | Remiso | Aplazado | Reclutado]");
        String opcion = input.nextLine();

        // Redirigir al metodo consultarPersona de cada controlador
        if (opcion.equalsIgnoreCase("RESERVISTA")) {
            System.out.println("\n<< Buscando por estado: Reservista >>\n");
            controlReservista.cambiarSituacion();
        } else if (opcion.equalsIgnoreCase("REMISO")) {
            System.out.println("\n<< Buscando por estado: Remiso >>\n");
            controlRemiso.cambiarSituacion();
        } else if (opcion.equalsIgnoreCase("APLAZADO")) {
            System.out.println("\n<< Buscando por estado: Aplazado >>\n");
            controlAplazado.cambiarSituacion();
        } else if (opcion.equalsIgnoreCase("RECLUTADO")) {
            System.out.println("\n<< Buscando por estado: Reclutado >>\n");
            controlReclutado.cambiarSituacion();
        } else {
            System.out.println("NO SE RECONOCE ESTA OPCIÓN");
        }
    }

    public void mostrarArray(){

        controlReservista.mostrarArray();


        for (Persona p : controlReservista.getLista()) {
            p.getDatos();
            
        }

        for (Persona p : controlRemiso.getLista()) {
            p.getDatos();
            
        }
        for (Persona p : controlReclutado.getLista()) {
            p.getDatos();
            
        }
        for (Persona p : controlAplazado.getLista()) {
            p.getDatos();
            
        }

    }

    
}
