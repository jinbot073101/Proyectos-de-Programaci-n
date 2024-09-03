package edu.avanzada.taller1.controlEjecucion;

import edu.avanzada.taller1.controlDatos.Reporte;
import java.util.Scanner;

public class Fachada {

//Variables de instancia 
    private Scanner input;
    private ControlPersonas redireccion;
    private Reporte reporte;

// Constructor para iniciar el programa
    public Fachada(){
        this.redireccion = ControlPersonasFactory.createControlPersonas();
        this.reporte = new Reporte();
        iniciarPrograma();
    }
    // Inicia hilo de ejecución
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

// Llama a la función correspondiente según la opción seleccionada
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
