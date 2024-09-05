package edu.avanzada.talleravanzadosituacionmilitar.controlEjecucion;

import edu.avanzada.talleravanzadosituacionmilitar.controlDatos.InterfaceControl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.mockito.Mockito.*;

public class ControlPersonasTest {

    private ControlPersonas controlPersonas;
    private InterfaceControl controlRemiso;
    private InterfaceControl controlReclutado;
    private InterfaceControl controlReservista;
    private InterfaceControl controlAplazado;

    @BeforeEach
    public void setUp() {
        controlRemiso = Mockito.mock(InterfaceControl.class);
        controlReclutado = Mockito.mock(InterfaceControl.class);
        controlReservista = Mockito.mock(InterfaceControl.class);
        controlAplazado = Mockito.mock(InterfaceControl.class);
        controlPersonas = new ControlPersonas(controlRemiso, controlReclutado, controlReservista, controlAplazado);
    }

    @Test
    public void testIngresarPersonaRemiso() {
        String input = "REMISO\n12345678\n"; // Simula la entrada del usuario
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        controlPersonas.ingresarPersona();

        verify(controlRemiso).ingresarPersona(12345678);
    }

    @Test
    public void testConsultarPersonaReservista() {
        String input = "RESERVISTA\n"; // Simula la entrada del usuario
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        controlPersonas.consultarPersona();

        verify(controlReservista).consultarPersona();
    }

    @Test
    public void testCambiarSituacionAplazado() {
        String input = "APLAZADO\n"; // Simula la entrada del usuario
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        controlPersonas.cambiarSituacion();

        verify(controlAplazado).cambiarSituacion();
    }

    @Test
    public void testIngresarPersonaInvalida() {
        String input = "INVALIDO\n"; // Simula una entrada inválida
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        controlPersonas.ingresarPersona();

        // Verifica que no se llame a ningún método de ingreso
        verify(controlRemiso, never()).ingresarPersona(anyInt());
        verify(controlReclutado, never()).ingresarPersona(anyInt());
        verify(controlReservista, never()).ingresarPersona(anyInt());
        verify(controlAplazado, never()).ingresarPersona(anyInt());
    }
}

