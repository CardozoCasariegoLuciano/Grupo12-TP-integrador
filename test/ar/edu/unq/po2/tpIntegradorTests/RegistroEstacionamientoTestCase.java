package ar.edu.unq.po2.tpIntegradorTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpintegrador.PuntoDeVenta;
import ar.edu.unq.po2.tpintegrador.EstacionamientoViaPuntoDeVenta;

class RegistroEstacionamientoTestCase {
	
	PuntoDeVenta unPuntoDeV;
	EstacionamientoViaPuntoDeVenta unRegistro;
	
	EstacionamientoViaPuntoDeVenta unRegistro2;
	
	
	@BeforeEach
	public void setUp() {
		
		unPuntoDeV = mock(PuntoDeVenta.class);
		unRegistro = new EstacionamientoViaPuntoDeVenta(1, "patenteX", unPuntoDeV);
		
	}
	
	@Test
	void unRegistroDeEstacionamientSabeSusDatosDeConstruccion() {
		
		assertEquals("patenteX", unRegistro.getPatente());
		assertEquals(1, unRegistro.getCantDeHS());
		assertEquals(unPuntoDeV, unRegistro.getPuntoDeVenta());
	}

	
	@Test
	void unRegistroDeEstacionamientSabeSiEstaActivo() {
		
		assertTrue(unRegistro.comprobarValidez());
	}
	
	@Test
	void unRegistroDeEstacionamientSabeSiNoEstaActivo() {
		
		when(unRegistro.horaActual()).thenReturn(LocalTime.of(20, 00, 00));
		
		assertFalse(unRegistro.comprobarValidez());
	}
	
	
	
	
	@Test
	void unRegistroDeEstacionamientPuedeFinalizarse() {
		
		assertTrue(unRegistro.comprobarValidez());
		
		unRegistro.finalizarRegistro();
		
		assertFalse(unRegistro.comprobarValidez());
	}	
	
	
	
	
	
	
	
}
