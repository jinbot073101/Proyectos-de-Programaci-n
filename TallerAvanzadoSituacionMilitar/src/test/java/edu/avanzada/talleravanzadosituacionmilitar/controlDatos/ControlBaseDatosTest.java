package edu.avanzada.talleravanzadosituacionmilitar.controlDatos;

import edu.avanzada.talleravanzadosituacionmilitar.modelo.Persona;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class ControlBaseDatosTest {

    private ControlBaseDatos controlBaseDatos;

    @BeforeEach
    public void setUp() {
        controlBaseDatos = new ControlBaseDatos(); // Inicializa la clase que contiene los ArrayList
    }

    @Test
    public void testGetListaPorEstadoReservista() {
        ArrayList<Persona> listaReservistas = controlBaseDatos.getListaPorEstado("Reservista");
        assertNotNull(listaReservistas, "La lista de reservistas no debería ser null");
        assertEquals(0, listaReservistas.size(), "La lista de reservistas debería estar vacía inicialmente");
    }

    @Test
    public void testGetListaPorEstadoRemiso() {
        ArrayList<Persona> listaRemisos = controlBaseDatos.getListaPorEstado("Remiso");
        assertNotNull(listaRemisos, "La lista de remisos no debería ser null");
        assertEquals(0, listaRemisos.size(), "La lista de remisos debería estar vacía inicialmente");
    }

    @Test
    public void testGetListaPorEstadoAplazado() {
        ArrayList<Persona> listaAplazados = controlBaseDatos.getListaPorEstado("Aplazado");
        assertNotNull(listaAplazados, "La lista de aplazados no debería ser null");
        assertEquals(0, listaAplazados.size(), "La lista de aplazados debería estar vacía inicialmente");
    }

    @Test
    public void testGetListaPorEstadoReclutado() {
        ArrayList<Persona> listaReclutados = controlBaseDatos.getListaPorEstado("Reclutado");
        assertNotNull(listaReclutados, "La lista de reclutados no debería ser null");
        assertEquals(0, listaReclutados.size(), "La lista de reclutados debería estar vacía inicialmente");
    }

    @Test
    public void testGetListaPorEstadoInvalido() {
        // Verifica que se lanza una excepción cuando se pasa un estado no válido
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controlBaseDatos.getListaPorEstado("Invalido");
        });

        String expectedMessage = "Estado no reconocido";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage), "El mensaje de la excepción debería ser 'Estado no reconocido'");
    }
}
