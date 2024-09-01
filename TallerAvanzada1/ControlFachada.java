import java.util.Scanner;

public class ControlFachada {

    private Scanner input;
    private Controlador controlador;
    private Controlador2 controlador2;
    private Reporte reporte;
    


    public ControlFachada() {
        controlador = new Controlador();
        reporte = new Reporte();
        iniciarPrograma(); 
    }

    public final void iniciarPrograma() {
        
        input = new Scanner(System.in);
        System.out.println("\n-------SISTEMA DE GESTIÓN DE SITUACIÓN MILITAR-------");
        System.out.println(
                "\n\t1.Ingresar nuevo usuario.\n\t2.Consultar usuario existente.\n\t3.Cambiar estado.\n\t4.Generar reporte de ingresados.\n");
        System.out.println("-----------------------------------------------------");
        System.out.println("OP:");
        int seleccion = input.nextInt();
        switch (seleccion) {
            case 1 -> {
                controlador2.ingresarPersona();
                break;
            }
            case 2 -> {
                controlador.consultarPersona();
                break;
            }
            case 3 -> {
                controlador.CambiarSituacion();
                break;
            }
            case 4 -> {
                reporte.generarReporte(); 
                break;
            }
            default -> {
                System.out.println("Opción no encontrada.");
            }
        }

    }



}
