package edu.avanzada.talleravanzadosituacionmilitar.controlDatos;

import edu.avanzada.talleravanzadosituacionmilitar.modelo.Aplazado;
import edu.avanzada.talleravanzadosituacionmilitar.modelo.Persona;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.AfterAll;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import static org.mockito.Mockito.*;

public class ControlAplazadoTest {

    private ControlAplazado controlAplazado;
    private ControlBaseDatos mockControlBaseDatos;
    private Persona persona1;
    private Persona persona2;

    @BeforeAll
    public static void setUpClass() {
        // Configuración global si es necesaria
    }

    @AfterAll
    public static void tearDownClass() {
        // Limpieza global si es necesaria
    }

    @BeforeEach
    public void setUp() {
        // Crear un mock de ControlBaseDatos
        mockControlBaseDatos = Mockito.mock(ControlBaseDatos.class);
        // Crear dos instancias de Persona con diferentes cédulas
        persona1 = new Aplazado();
        persona1.setCedula(123456);
        persona2 = new Aplazado();
        persona2.setCedula(654321);

        // Configurar el mock para devolver una lista con personas cuando se llame a getListaPorEstado
        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(persona1);
        listaPersonas.add(persona2);
        when(mockControlBaseDatos.getListaPorEstado("Aplazado")).thenReturn((ArrayList<Persona>) listaPersonas);

        // Instanciar ControlAplazado usando el mock
        controlAplazado = new ControlAplazado(mockControlBaseDatos);
    }
    
    @AfterEach
    public void tearDown() {
        // Limpiar el estado después de cada prueba si es necesario
        // En este caso, no es necesario limpiar ya que estamos usando una nueva instancia de ControlBaseDatos
    }

    @Test
    public void testVerificarArrayConCedulaExistente() {
        // Probar que el método devuelve true cuando la cédula está en la lista
        assertTrue(controlAplazado.verificarArray(123456), "La cédula debería estar en la base de datos.");
    }

    @Test
    public void testVerificarArrayConCedulaNoExistente() {
        // Probar que el método devuelve false cuando la cédula no está en la lista
        assertFalse(controlAplazado.verificarArray(111111), "La cédula no debería estar en la base de datos.");
    }
}
