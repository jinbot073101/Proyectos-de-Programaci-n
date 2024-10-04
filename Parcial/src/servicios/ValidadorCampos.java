package servicios;

/**
 * Clase responsable de validar los campos de entrada relacionados con los
 * perros.
 */
public class ValidadorCampos {
    /**
     * Valida los campos de entrada para asegurarse de que no estén vacíos y que
     * no contengan dígitos.
     *
     * @param raza La raza del perro.
     * @param paisOrigen El país de origen del perro.
     * @param pelo El tipo de pelo del perro.
     * @param color El color del perro.
     * @param espalda La descripción de la espalda del perro.
     * @param lomo La descripción del lomo del perro.
     * @param cola La descripción de la cola del perro.
     * @param pecho La descripción del pecho del perro.
     * @param descripcion Descripción adicional del perro.
     * @return true si alguno de los campos es incorrecto (vacío o contiene
     * dígitos), false en caso contrario.
     */
    public static boolean validarCampos(String raza, String paisOrigen, String pelo, String color,
            String espalda, String lomo, String cola, String pecho, String descripcion) {
        boolean incorrecto = false;
        if (raza.isBlank() || raza.matches(".*\\d.*")
                || paisOrigen.isBlank() || paisOrigen.matches(".*\\d.*")
                || pelo.isBlank() || pelo.matches(".*\\d.*")
                || color.isBlank() || color.matches(".*\\d.*")
                || espalda.isBlank() || espalda.matches(".*\\d.*")
                || lomo.isBlank() || lomo.matches(".*\\d.*")
                || cola.isBlank() || cola.matches(".*\\d.*")
                || pecho.isBlank() || pecho.matches(".*\\d.*")
                || descripcion.isBlank() || descripcion.matches(".*\\d.*")) {
            incorrecto = true; // Marca como incorrecto si hay algún campo inválido
        }
        return incorrecto; // Retorna el estado de validez
    }
}
