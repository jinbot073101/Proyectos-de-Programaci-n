package edu.avanzada.taller1.controlEjecucion;

import edu.avanzada.taller1.controlDatos.ControlAplazado;
import edu.avanzada.taller1.controlDatos.ControlBaseDatos;
import edu.avanzada.taller1.controlDatos.ControlReclutado;
import edu.avanzada.taller1.controlDatos.ControlRemiso;
import edu.avanzada.taller1.controlDatos.ControlReservista;
import edu.avanzada.taller1.controlDatos.Reporte;
import java.util.Scanner;

/*Esta clase se encarga de la ejecución principal del programa con sus
respectivas instancias que permitan la conexión entre las clases necesarias*/

public class Fachada {

    private Scanner input;
    private final ControlPersonas redireccion;
    private final Reporte reporte;

    public Fachada() {
        ControlBaseDatos baseDatos = new ControlBaseDatos();// Crear una instancia de ControlBaseDatos
        // Crear instancias de los controladores con ControlBaseDatos
        ControlAplazado controlAplazado = new ControlAplazado(baseDatos);
        ControlReclutado controlReclutado = new ControlReclutado(baseDatos);
        ControlRemiso controlRemiso = new ControlRemiso(baseDatos);
        ControlReservista controlReservista = new ControlReservista(baseDatos);
        // Crear instancia de Reporte con los controladores
        this.reporte = new Reporte(controlAplazado, controlReclutado, controlRemiso, controlReservista);
        // Inicializar ControlPersonas
        this.redireccion = ControlPersonasFactory.createControlPersonas();
        iniciarPrograma();
    }

    // Inicia la ejecución central del programa
    public final void iniciarPrograma() {
        int ControlSalida;
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
            int opcion = input.nextInt();

            /* Redirecciona el flujo del programa a la función correspondiente según la
               opción de entrada*/
            switch (opcion) {
                case 1 -> {
                    redireccion.ingresarPersona();
                    break;
                }
                case 2 -> {
                    redireccion.consultarPersona();
                    break;
                }
                case 3 -> {
                    redireccion.cambiarSituacion();
                    break;
                }
                case 4 -> {
                    reporte.generarReporte();
                    break;
                }
                default -> {
                    System.out.println("ARGUMENTO INVÁLIDO.");
                }
            }

            if (opcion > 4 || opcion <= 0) {
                ControlSalida = 1;
            } else {
                System.out.println("Deseas realizar otra accón? \t\n 1) si \n 2) no");
                ControlSalida = input.nextInt();

            }

        } while (ControlSalida != 2);

    }

}
