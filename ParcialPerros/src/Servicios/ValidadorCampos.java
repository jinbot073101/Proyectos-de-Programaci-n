package Servicios;


public class ValidadorCampos {
    
    public static boolean validarCampo(String campo) {
        boolean incorrecto = false;
        if (campo.isBlank() || campo.matches(".*\\d.*")) {
            incorrecto = true;
        }
        return incorrecto;
    }
    
}
