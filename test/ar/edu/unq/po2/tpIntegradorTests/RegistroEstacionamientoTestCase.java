package ar.edu.unq.po2.tpIntegradorTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpintegrador.PuntoDeVenta;
import ar.edu.unq.po2.tpintegrador.EstacionamientoViaPuntoDeVenta;

class RegistroEstacionamientoTestCase {
	
	PuntoDeVenta unPuntoDeV;
	
	EstacionamientoViaPuntoDeVenta unEstacionamientoPuntoDeVenta;
	
	
	
	@BeforeEach
	public void setUp() {
		
		unPuntoDeV = mock(PuntoDeVenta.class);
		unEstacionamientoPuntoDeVenta = new EstacionamientoViaPuntoDeVenta(1, "altaPatente", unPuntoDeV);
	  
		
	}
	
	@Test
	void unRegistroDeEstacionamientSabeSusDatosDeConstruccion() {
		
		assertEquals("altaPatente", unEstacionamientoPuntoDeVenta.getPatente());
		assertEquals(1, unEstacionamientoPuntoDeVenta.getCantDeHS());
		assertEquals(unPuntoDeV, unEstacionamientoPuntoDeVenta.getPuntoDeVenta());
		assertTrue(unEstacionamientoPuntoDeVenta.estacionamientoEstaAcitvo());
		assertEquals(unEstacionamientoPuntoDeVenta.getHoraInicio().plusHours(1) , unEstacionamientoPuntoDeVenta.getHoraFinal());
				
	}

	
	
	@Test
	void unRegistroDeEstacionamientSabeSiEstaActivo() {
		
		assertTrue(unEstacionamientoPuntoDeVenta.comprobarValidez());
	}		
	
	
	
	@Test
	void unRegistroDeEstacionamientPuedeFinalizarse() {
		
		assertTrue(unEstacionamientoPuntoDeVenta.comprobarValidez());
		
		unEstacionamientoPuntoDeVenta.finalizarRegistro();		
		
		assertFalse(unEstacionamientoPuntoDeVenta.estacionamientoEstaAcitvo());
		
	}	
	
	
	
	
	
	
	
	
}
