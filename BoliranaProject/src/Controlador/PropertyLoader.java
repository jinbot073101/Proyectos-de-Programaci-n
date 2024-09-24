package Controlador;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
    private final Properties propiedades = new Properties();
    private final int[] valoresCargados = new int[12];
    private int puntajeMaximo;

    public void cargarProperties(String filePath) {
        try (InputStream entrada = new FileInputStream(filePath)) {
            propiedades.load(entrada);
            puntajeMaximo = Integer.parseInt(propiedades.getProperty("puntajeMaximo"));
            valoresCargados[0] = Integer.parseInt(propiedades.getProperty("hueco1"));
            valoresCargados[1] = Integer.parseInt(propiedades.getProperty("hueco2"));
            valoresCargados[2] = Integer.parseInt(propiedades.getProperty("hueco3"));
            valoresCargados[3] = Integer.parseInt(propiedades.getProperty("hueco4"));
            valoresCargados[4] = Integer.parseInt(propiedades.getProperty("hueco5"));
            valoresCargados[5] = Integer.parseInt(propiedades.getProperty("hueco6"));
            valoresCargados[6] = Integer.parseInt(propiedades.getProperty("hueco7"));
            valoresCargados[7] = Integer.parseInt(propiedades.getProperty("hueco8"));
            valoresCargados[8] = Integer.parseInt(propiedades.getProperty("hueco9"));
            valoresCargados[9] = Integer.parseInt(propiedades.getProperty("hueco10"));
            valoresCargados[10] = Integer.parseInt(propiedades.getProperty("hueco11"));
            valoresCargados[11] = Integer.parseInt(propiedades.getProperty("hueco12"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public int[] devolverValoresCargados() {
        return valoresCargados;
    }

    public int devolverPuntajeMaximo() {
        return puntajeMaximo;
    }
}
