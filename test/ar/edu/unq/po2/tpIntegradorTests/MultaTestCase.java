package ar.edu.unq.po2.tpIntegradorTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpintegrador.Inspector;
import ar.edu.unq.po2.tpintegrador.Multa;
import ar.edu.unq.po2.tpintegrador.ZonaDeEstacionamiento;

class MultaTestCase {
	
	Multa unaMulta;
	
	Inspector unInspector;
	ZonaDeEstacionamiento unaZona;
	
	@BeforeEach
	public void setUp() {
		
		unInspector = mock(Inspector.class);
		unaZona = mock(ZonaDeEstacionamiento.class);
		
		unaMulta = new Multa("Patente" ,LocalDate.of(2020, 10, 17) , LocalTime.of(20, 24, 15), unInspector , unaZona );
	}

	@Test
	void unaMultaSabeSusDatosDeConstruccion() {
		
		assertEquals("Patente", unaMulta.getPatente());
		assertEquals(LocalDate.of(2020, 10, 17), unaMulta.getFecha());
		assertEquals(LocalTime.of(20, 24, 15), unaMulta.getHora());
		assertEquals(unInspector, unaMulta.getInspector());
		assertEquals(unaZona, unaMulta.getZona());
	}

}




















