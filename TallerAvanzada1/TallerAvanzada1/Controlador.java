import java.util.Scanner;

public class Controlador {

    // Variables de instancia y declaración de objetos

    private Scanner input;
    private ControlRemiso controlRemiso;
    private ControlReclutado controlReclutado;
    private ControlReservista controlReservista;
    private ControlAplazado controlAplazado;

    public Controlador(){
        controlReservista = new ControlReservista();
        controlRemiso = new ControlRemiso();
        controlAplazado = new ControlAplazado();
        controlReclutado = new ControlReclutado();
    }

    public void ingresarPersona() {
        int cedula;
        input = new Scanner(System.in);
        // Preguntar al usuario por la situación militar
        System.out.println("Situación militar a declarar: [1) Reservista / 2) Remiso/ 3) Aplazado/ 4) Reclutado]");
        int opcion = input.nextInt();

        // Dependiendo de el input del usuario se redirige a los controladores individuales
        //En cada caso, se pide la cédula para evaluar que el usuario no se haya registrado antes
        switch (opcion) {
            case 1:
                System.out.println("Ingrese el número de cédula de la persona a registrar: ");
                cedula = input.nextInt();
                if (controlReservista.verificarArray(cedula)) {
                    System.out.println("Ya se a registrado un usuario con este número de cédula.");
                } else {
                    controlReservista.ingresarPersona(cedula);
                }
                break;

            case 2:
                System.out.println("Ingrese el número de cédula de la persona a registrar: ");
                cedula = input.nextInt();
                if (controlRemiso.verificarArray(cedula)) {
                    System.out.println("Ya se a registrado un usuario con este número de cédula.");
                } else {
                    controlRemiso.ingresarPersona(cedula);
                }
                break;

            case 3:
                System.out.println("Ingrese el número de cédula de la persona a registrar: ");
                cedula = input.nextInt();
                if (controlAplazado.verificarArray(cedula)) {
                    System.out.println("Ya se a registrado un usuario con este número de cédula.");
                } else {
                    controlAplazado.ingresarPersona(cedula);
                }
                break;

            case 4:
                System.out.println("Ingrese el número de cédula de la persona a registrar: ");
                cedula = input.nextInt();
                if (controlReclutado.verificarArray(cedula)) {
                    System.out.println("Ya se a registrado un usuario con este número.");
                } else {
                    controlReclutado.ingresarPersona(cedula);
                }
                break;

            default:
                System.out.println("NO SE RECONOCE ESTA OPCIÓN");
                break;
        }
    }

    public void consultarPersona() {
        input = new Scanner(System.in);
        // Preguntar al usuario por la situación militar para filtrar la consulta
        System.out.println("Ingrese la situación militar de la persona a consultar para filtrar la busqueda:");
        String opcion = input.nextLine();
        // Redirigir al metodo consultarPersona de cada controlador
        if (opcion.equalsIgnoreCase("RESERVISTA")) {
            controlReservista.consultarPersona();
        } else if (opcion.equalsIgnoreCase("REMISO")) {
            controlRemiso.consultarPersona();
        } else if (opcion.equalsIgnoreCase("APLAZADO")) {
            controlAplazado.consultarPersona();
        } else if (opcion.equalsIgnoreCase("RECLUTADO")) {
            controlReclutado.consultarPersona();
        } else {
            System.out.println("NO SE RECONOCE ESTA OPCIÓN");
        }

    }

    public void cambiarSituacion() {
        input = new Scanner(System.in);
        System.out.println("Situación militar: ");


    }

}
