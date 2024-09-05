package main.test.com.miempresa.miapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import main.java.com.miempresa.miapp.ServicioEstudiante;
import main.java.com.miempresa.miapp.EstudiantesRegistrados;

public class ServicioEsudianteTest {

    private EstudiantesRegistrados estudiantesRegistradosMock;
    private ServicioEstudiante servicioEstudiante;

    @BeforeEach
    public void setUp() {
        estudiantesRegistradosMock = Mockito.mock(EstudiantesRegistrados.class);
        servicioEstudiante = new ServicioEstudiante(estudiantesRegistradosMock);
    }

//    @Test
//    public void testContarTotalEstudiantes_conEstudiantes() {
//        when(estudiantesRegistradosMock.obtenerEstudiantes()).thenReturn(Arrays.asList("123", "456"));
//        int total = servicioEstudiante.contarTotalEstudiantes();
//        assertEquals(2, total);
//        verify(estudiantesRegistradosMock).obtenerEstudiantes();
//    }

    @Test
    public void testContarTotalEstudiantes_sinEstudiantes() {
        when(estudiantesRegistradosMock.obtenerEstudiantes()).thenReturn(Collections.emptyList());

        int total = servicioEstudiante.contarTotalEstudiantes();

        assertEquals(0, total);
        verify(estudiantesRegistradosMock).obtenerEstudiantes();
    }

//    @Test
//    public void testEsEstudianteRegistrado_conEstudianteExistente() {
//        when(estudiantesRegistradosMock.buscarPorMatricula("123")).thenReturn("123");
//
//        boolean registrado = servicioEstudiante.esEstudianteRegistrado("123");
//
//        assertTrue(registrado);
//        verify(estudiantesRegistradosMock).buscarPorMatricula("123");
//    }

    @Test
    public void testEsEstudianteRegistrado_conEstudianteInexistente() {
        when(estudiantesRegistradosMock.buscarPorMatricula("123")).thenReturn(null);

        boolean registrado = servicioEstudiante.esEstudianteRegistrado("123");

        assertFalse(registrado);
        verify(estudiantesRegistradosMock).buscarPorMatricula("123");
    }


}
