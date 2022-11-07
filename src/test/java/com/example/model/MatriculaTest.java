package com.example.model;

import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class MatriculaTest {

    @Test
    public void null_vector_Throws_Exception() throws Exception {
        Matricula matricula = new Matricula(null);
        assertThrows(Exception.class, () -> matricula.getImporte());
    }

    @Test
    public void getImporteTest() throws Exception {
        Asignatura asignatura = mock(Asignatura.class);
        Asignatura asignatura2 = mock(Asignatura.class);
        Vector<Asignatura> vector = new Vector<>();
        vector.add(asignatura);
        vector.add(asignatura2);
        Matricula matricula = new Matricula(vector); //mock vector?
        when(asignatura.getImporte()).thenReturn(20.0);
        when(asignatura2.getImporte()).thenReturn(30.0);
        assertEquals(50.0, matricula.getImporte());
    }

    @Test
    public void getImporteIterationsTest() throws Exception {
        Asignatura asignatura = mock(Asignatura.class);
        Asignatura asignatura2 = mock(Asignatura.class);
        Vector<Asignatura> vector = new Vector<>();
        vector.add(asignatura);
        vector.add(asignatura2);
        Matricula matricula = new Matricula(vector); //mock vector?
        matricula.getImporte();
        verify(asignatura, times(1)).getImporte();
        verify(asignatura2, times(1)).getImporte();
        verifyNoMoreInteractions(asignatura);
        verifyNoMoreInteractions(asignatura2);
    }


}
