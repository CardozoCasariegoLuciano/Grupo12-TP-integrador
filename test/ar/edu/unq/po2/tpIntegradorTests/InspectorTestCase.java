package ar.edu.unq.po2.tpIntegradorTests;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpintegrador.AppInspector;
import ar.edu.unq.po2.tpintegrador.Inspector;
import ar.edu.unq.po2.tpintegrador.Sem;
import ar.edu.unq.po2.tpintegrador.ZonaDeEstacionamiento;

class InspectorTestCase {
	
	
	Inspector unInspec;
	
	AppInspector appInspector;
	ZonaDeEstacionamiento unaZona;
	
	@BeforeEach
	public void setUp() {
		
		unaZona = mock (ZonaDeEstacionamiento.class);
		appInspector = new AppInspector();
		
		unInspec = new Inspector(unaZona, appInspector);
	}

	@Test
	void unInspectorSabeCualEsSuZonaYSuApp() {
		
		assertEquals(appInspector, unInspec.getDispositivoMovil());
		assertEquals(unaZona, unInspec.getPerteneceA());
	}
	
	@Test
	void unInspectorPuedeMultar() {
		
		assertEquals(0, unInspec.getDispositivoMovil().getListaDeMultas().size());
		unInspec.multar("unaPatente");		
		assertEquals(1, unInspec.getDispositivoMovil().getListaDeMultas().size());
		
		}
	
	@Test
	void unInspectorPuedeverificarUnEstacionamiento() {
		
		Sem unSem = mock(Sem.class);
		
		unInspec.verificarEstacionamiento("patente", unSem);  //Esto verifica que este en el estacionamiento, pero no si esta activo o no
		
		verify(unSem).existeEstacionamientoDe("patente");
	}
	
	
}























