package Control;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    private final Properties propiedades = new Properties();

    public void cargarProperties(String filePath) {
        try (InputStream entrada = new FileInputStream(filePath)) {
            propiedades.load(entrada);
            //AQUI SE SACAN LOS DATOS DE LOS PERROS (HAY QUE GUARDARLOS PARA ENVIARLOS A LA BASE DE DATOS DESDE EL CONTROLADOR GENERAL)
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
