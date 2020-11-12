package ar.edu.unq.po2.tpIntegradorTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpintegrador.AppInspector;
import ar.edu.unq.po2.tpintegrador.Inspector;

class AppInspectorTestCase {
	
	AppInspector appInspect;
	
	@BeforeEach
	public void setUp() {
		
		appInspect = new AppInspector();
	}

	@Test
	void unaAppInspectorEsCreadaConUnaListaDeMultasVacia() {
		
		assertEquals(0 , appInspect.getListaDeMultas().size());
	}
	
	@Test
	void unaAppInspectorPuedeRegistrarUnaMulta() {
		
		Inspector unInspector = mock (Inspector.class);
		
		assertEquals(0 , appInspect.getListaDeMultas().size());
		
		appInspect.registrarMulta("altaPatente", LocalDate.now(), LocalTime.now(), unInspector);
		
		assertEquals(1 , appInspect.getListaDeMultas().size());
		
		appInspect.registrarMulta("altaPatente3", LocalDate.now(), LocalTime.now(), unInspector);
		appInspect.registrarMulta("altaPatente1", LocalDate.now(), LocalTime.now(), unInspector);
		
		assertEquals(3 , appInspect.getListaDeMultas().size());
		
	}

}
