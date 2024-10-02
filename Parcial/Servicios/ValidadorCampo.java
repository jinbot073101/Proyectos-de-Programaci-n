package Servicios;

public class ValidadorCampo {

    public static boolean validarCampo(String campo) {
        boolean incorrecto = false;
        if (campo.isBlank() || campo.matches(".*\\d.*")) {
            incorrecto = true;
        }
        return incorrecto;
    }
}
