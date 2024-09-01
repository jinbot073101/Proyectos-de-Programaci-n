import java.util.Scanner;

public class Fachada {

    //Variables de instancia 
    private Scanner input;
    private Controlador control;
    private Reporte reporte; 

    // Constructor para iniciar el programa
    public Fachada() {
        control = new Controlador();
        reporte = new Reporte();
        iniciarPrograma(); 
    }

    public final void iniciarPrograma() { // Inicia hilo de ejecución
        input = new Scanner(System.in);
        System.out.println("\n-------SISTEMA DE GESTIÓN DE SITUACIÓN MILITAR-------");
        System.out.println(
                "\n\t1.Ingresar nuevo usuario.\n\t2.Consultar usuario existente.\n\t3.Cambiar situación militar de un usuario.\n\t4.Generar reporte de ingresados.\n");
        System.out.println("-----------------------------------------------------");
        System.out.println("Ingresar opción:");
        int seleccion = input.nextInt();

        // Llama a la función correspondiente según la opción seleccionada
        switch (seleccion) {
            case 1 -> {
                control.ingresarPersona(); 
                break;
            }
            case 2 -> {
                control.consultarPersona();
                break;
            }
            case 3 -> {
                control.cambiarSituacion();
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

    }



}
