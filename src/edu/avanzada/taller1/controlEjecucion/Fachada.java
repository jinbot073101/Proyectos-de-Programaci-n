package edu.avanzada.taller1.controlEjecucion;

import edu.avanzada.taller1.controlDatos.ControlAplazado;
import edu.avanzada.taller1.controlDatos.ControlBaseDatos;
import edu.avanzada.taller1.controlDatos.ControlReclutado;
import edu.avanzada.taller1.controlDatos.ControlRemiso;
import edu.avanzada.taller1.controlDatos.ControlReservista;
import edu.avanzada.taller1.controlDatos.Reporte;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * La clase <code>Fachada</code> actúa como el punto de entrada del sistema de gestión de situación militar.
 * Proporciona una interfaz para interactuar con el sistema mediante la gestión de usuarios y generación de reportes.
 */

public class Fachada {

    private Scanner input;
    private final ControlPersonas redireccion;
    private final Reporte reporte;



      /**
     * Constructor de la clase <code>Fachada</code>.
     * Inicializa los controles de los diferentes estados militares y el reporte.
     */
    public Fachada() {
        ControlBaseDatos baseDatos = new ControlBaseDatos();
        ControlAplazado controlAplazado = new ControlAplazado(baseDatos);
        ControlReclutado controlReclutado = new ControlReclutado(baseDatos);
        ControlRemiso controlRemiso = new ControlRemiso(baseDatos);
        ControlReservista controlReservista = new ControlReservista(baseDatos);

        this.reporte = new Reporte(controlAplazado, controlReclutado, controlRemiso, controlReservista);
        this.redireccion = ControlPersonasFactory.createControlPersonas();

        iniciarPrograma();
    }

    /**
     * Inicia el programa, mostrando un menú de opciones y gestionando la entrada del usuario.
     * El programa continúa ejecutándose hasta que el usuario decide salir.
     */
    public final void iniciarPrograma() {
        int ControlSalida = 2; // Inicializar ControlSalida
        do {
            input = new Scanner(System.in);
            System.out.println("===========================================================");
            System.out.println("          SISTEMA DE GESTIÓN DE SITUACIÓN MILITAR          ");
            System.out.println("===========================================================");
            System.out.println("Opción 1: Ingresar nuevo usuario");
            System.out.println("Opción 2: Consultar usuario existente");
            System.out.println("Opción 3: Cambiar estado");
            System.out.println("Opción 4: Generar reporte");
            System.out.print("\nSeleccione una opción: ");

            int opcion = 0;
            try {
                opcion = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                input.next(); // Limpiar el buffer
                continue; // Volver a mostrar el menú
            }

            switch (opcion) {
                case 1 -> redireccion.ingresarPersona();
                case 2 -> redireccion.consultarPersona();
                case 3 -> redireccion.cambiarSituacion();
                case 4 -> reporte.generarReporte();
                default -> System.out.println("ARGUMENTO INVÁLIDO.");
            }

            if (opcion > 4 || opcion <= 0) {
                ControlSalida = 1;
            } else {
                System.out.println("¿Deseas realizar otra acción? \n1) Sí \n2) No");
                ControlSalida = input.nextInt();
            }

        } while (ControlSalida != 2);

    }
}
