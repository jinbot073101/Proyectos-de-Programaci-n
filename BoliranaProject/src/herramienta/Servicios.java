package herramienta;

public class Servicios {
    /**
     *
     * @param nombre
     * @param edad
     * @param cedula
     * @return
     */
    public static boolean verificarCamposVacios(String nombre, String edad, String cedula) {
        boolean esVacio = false;
        if (nombre.isBlank() || edad.isBlank() || cedula.isBlank()) {
            esVacio = true;
        }
        return esVacio;
    }
    /**
     *
     * @param nombre
     * @param edad
     * @param cedula
     * @return
     */
    public static boolean verificarCamposEnCero(String nombre, String edad, String cedula) {
        boolean enCero = false;
        if (nombre.equals('0') || edad.equals('0') || cedula.equals('0')) {
            enCero = true;
        }
        return enCero;
    }
}
