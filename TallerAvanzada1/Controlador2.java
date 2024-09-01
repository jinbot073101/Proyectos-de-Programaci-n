import java.util.Scanner;

public class Controlador2 {

    private Scanner input;
    private ControlRemiso controlRemiso;
    private ControlReclutado controlReclutado;
    private ControlReservista controlReservista;
    private ControlAplazado controlAplazado;
    
    public void ingresarPersona() {

        System.out.println("Situación militar a declarar: 1) Reservista / 2) Remiso/ 3) Aplazado/ 4) Reclutado]");
        int opcion = input.nextInt();

        switch (opcion) {
            case 1:

            controlReservista =  new ControlReservista();
            controlReservista.ingresarPersona();

                break;

            case 2:

            controlRemiso = new ControlRemiso();
            controlRemiso.ingresarPersona();
            
                break;
                
            case 3:

            controlAplazado = new ControlAplazado();
            controlAplazado.ingresarPersona();
            
                break;
                
            case 4:
            
            controlReclutado = new ControlReclutado();
            controlReclutado.ingresarPersona();
                break;
        
            default:
            System.out.println("Opcion invalida");
                break;
        }

    }

}
