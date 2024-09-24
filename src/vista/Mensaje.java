package vista;

import javax.swing.JOptionPane;

public class Mensaje {

    /*Mensajes del menú ->
    
    Mensaje para informar ingreso del juez*/
    public void informeIngresoCapitan() {
        JOptionPane.showMessageDialog(null, "Registre inicialmente un capitán para liderar el equipo.", "Registro", JOptionPane.INFORMATION_MESSAGE);
    }

    //Mensaje para informar ingreso del juez
    public void noJuecesRegistrado() {
        JOptionPane.showMessageDialog(null, "Debe Registrar un juez para que valide y supervise el juego.", "Registro", JOptionPane.INFORMATION_MESSAGE);
    }

    /*Mensajes de información ->
    
    
    
    Mensaje para ingreso de opciones inválidas*/
    public void valorInvalido() {
        JOptionPane.showMessageDialog(null, "El valor ingresado no es correcto.", "Error", JOptionPane.INFORMATION_MESSAGE);
    }

    //Mensaje de error al registrar
    public void datosIncompletos() {
        JOptionPane.showMessageDialog(null, "Debe completar todos los datos del participante.", "Error", JOptionPane.INFORMATION_MESSAGE);
    }

    //Mensaje de error al tener datos incompletos
    public void manejarError() {
        JOptionPane.showMessageDialog(null, "Se ha presentado el error al registrar los datos.", "Registro completado", JOptionPane.INFORMATION_MESSAGE);
    }
    
    //Mensaje para informar que la cantidad de jugadores ingresados es incorrecta
    public void cantidadDeJugadoresIncorrecta(){
        JOptionPane.showMessageDialog(null,"La cantidad de jugadores ingresados no es válida.","Error",JOptionPane.INFORMATION_MESSAGE);
    }

    /*Mensajes para ResgistrarCapitan ->
    
    
    
    Mensaje de RegistroCapitan*/
    public void ingresoCapitan() {
        JOptionPane.showMessageDialog(null, "Se ha registrado el capitan del equipo.", "Registro completado", JOptionPane.INFORMATION_MESSAGE);
    }

    //Mensaje para confirmar la cantidad de jugadores
    public String preguntarCantidadDeJugadores() {
        return JOptionPane.showInputDialog("Cuantos jugadores desea registrar en este equipo?");
    }

    //Mensaje de confirmación para los equipos registrados
    public void equiposRegistrados() {
        JOptionPane.showMessageDialog(null, "Equipo registrado.", "Registro completado", JOptionPane.INFORMATION_MESSAGE);
    }

    /*Mensajes para RegistroJugador ->
    
    
    
    Mensajes para RegistroJugador*/
    public void ingresoJugador(int numeroJugador) {
        JOptionPane.showMessageDialog(null, "Se ha registrado el jugador " + (numeroJugador + 1) + " correctamente.", "Registro completado", JOptionPane.INFORMATION_MESSAGE);
    }

    //Mensaje para informar el ingreso de todos los jugadores
    public void jugadoresIngresados() {
        JOptionPane.showMessageDialog(null, "Todos los jugadores fueron registrados.", "Registro completado", JOptionPane.INFORMATION_MESSAGE);
    }

    //Mensaje para consultar el nombre del equipo
    public String preguntarNombreDelEquipo() {
        return JOptionPane.showInputDialog("Cuál es el nombre del equipo? ");
    }

    /*Mensajes para ReporteJuez ->
    
    
    
    Mensajes para RegistroJuez*/
    public void ingresoJuez() {
        JOptionPane.showMessageDialog(null, "Se ha registrado el juez correctamente", "Registro completado", JOptionPane.INFORMATION_MESSAGE);
    }

    /*Mensajes de Validacion ->
    
    
    
    Mensaje para completar la validación*/
    public void validacionCompleta() {
        JOptionPane.showMessageDialog(null, "Validación completa.", "Validacion", JOptionPane.INFORMATION_MESSAGE);
    }

    //Mensaje para informar la eliminación de un equipo
    public void equipoEliminado(String equipoFaltante) {
        JOptionPane.showMessageDialog(null, "El equipo " + equipoFaltante + " fue descalificado.", "Validación", JOptionPane.INFORMATION_MESSAGE);
    }

    //Mensaje para comenzar las validaciones del juego
    public void requisitos() {
        JOptionPane.showMessageDialog(null, "Se van a validar los datos y la participación de los equipos.", "Validacion", JOptionPane.INFORMATION_MESSAGE);
    }

    //Mensaje de error al no cumplir requesitos
    public void noCumpleRequisito() {
        JOptionPane.showMessageDialog(null, "No se cumplen los requisitos para iniciar el juego.\nSe deben de registrar mínimo dos equipos.",
                "Error", JOptionPane.INFORMATION_MESSAGE);
    }

    //Mensaje de error al no cumplir requesitos
    public void errorAlDescalificarEquipo() {
        JOptionPane.showMessageDialog(null, "Cantidad insuficientes de equipos", "Error", JOptionPane.INFORMATION_MESSAGE);
    }
    
    //Mensaje al repetir la validación
    public void validacionIncompleta(){
        JOptionPane.showMessageDialog(null, "Se debe validar nuevamente la participación de los equipos.", "Error", JOptionPane.INFORMATION_MESSAGE);
    }
     
    /*Mensajes para la lógica y la gestión del juego ->
    
    
    
    Mensaje para confirmar el sorteo de los turnos*/
    public void realizacionDelSorteo(String equipo1, String equipo2) {
        JOptionPane.showMessageDialog(null, """
                                            El juez realizo el sorteo por los turnos. Los equipos fueron seleccionados en el siguiente orden:
                                            Equipo 1: """ + equipo1 + "\nEquipo 2: " + equipo2, "Validacion", JOptionPane.INFORMATION_MESSAGE);

    }
}
