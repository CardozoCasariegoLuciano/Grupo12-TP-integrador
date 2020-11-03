package ar.edu.unq.po2.tpIntegradorTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpintegrador.PuntoDeVenta;
import ar.edu.unq.po2.tpintegrador.RegistroViaPuntoFijo;

class RegistroEstacionamientoTestCase {
	
	PuntoDeVenta unPuntoDeV;
	RegistroViaPuntoFijo unRegistro;
	
	RegistroViaPuntoFijo unRegistro2;
	
	
	@BeforeEach
	public void setUp() {
		
		unPuntoDeV = mock(PuntoDeVenta.class);
		unRegistro = new RegistroViaPuntoFijo(1, "altaPatente", unPuntoDeV);
		
	}
	
	@Test
	void unRegistroDeEstacionamientSabeSusDatosDeConstruccion() {
		
		assertEquals("altaPatente", unRegistro.getPatente());
		assertEquals(1, unRegistro.getCantDeHS());
		assertEquals(unPuntoDeV, unRegistro.getPuntoDeVenta());
	}

	
	@Test
	void unRegistroDeEstacionamientSabeSiEstaActivo() {
		
		assertTrue(unRegistro.comprobarValidez());
	}
	
	@Test
	void unRegistroDeEstacionamientSabeSiNoEstaActivo() {
		
		//Como testeo esto?
		//Quiero que comprobarValidez retorne Falso por agotamiento del tiempo comprado
		
		//assertFalse(unRegistro.comprobarValidez());
	}
	
	
	
	
	@Test
	void unRegistroDeEstacionamientPuedeFinalizarse() {
		
		assertTrue(unRegistro.comprobarValidez());
		
		unRegistro.finalizarRegistro();
		
		assertFalse(unRegistro.comprobarValidez());
	}	
	
	
	
	
	
	
	
}
