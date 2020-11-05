package ar.edu.unq.po2.tpIntegradorTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpintegrador.Celular;
import ar.edu.unq.po2.tpintegrador.PuntoDeVenta;
import ar.edu.unq.po2.tpintegrador.ZonaDeEstacionamiento;

class PuntoDeVentaTestCase {

	PuntoDeVenta unPuntoDeVenta;
	ZonaDeEstacionamiento unaZona;
	
	@BeforeEach
	public void setUp() {		
		
		unaZona = mock(ZonaDeEstacionamiento.class);
		unPuntoDeVenta = new  PuntoDeVenta(unaZona);
	}
	
	
	@Test
	void unPuntoDeVentaEsCreadoConUnaZonaYConListasDeEstacionamientosPorPuntoVentaYComprasVacios() {
					
		assertEquals(unaZona , unPuntoDeVenta.getZona());
		assertEquals(0 , unPuntoDeVenta.getRegistrosDeCargas().size());
		assertEquals(0 , unPuntoDeVenta.getRegistrosDeEstacionamientoPorCompraPuntual().size());
	}	
	
	
	@Test
	void unPuntoDeVentaPuedeRegistrarUnaCargaDeCelular() {
		
		Celular unCelu = mock(Celular.class);
		
		assertEquals(0 , unPuntoDeVenta.getRegistrosDeCargas().size());		
		unPuntoDeVenta.registrarCargaCredito(500,unCelu);		
		assertEquals(1 , unPuntoDeVenta.getRegistrosDeCargas().size());
	}
	
	
	@Test
	void unPuntoDeVentaPuedeRegistrarUnEstacionamiento() {		
				
		assertEquals(0 , unPuntoDeVenta.getRegistrosDeEstacionamientoPorCompraPuntual().size());		
		unPuntoDeVenta.registrarEstacionamiento("patente", 18);		
		assertEquals(1 , unPuntoDeVenta.getRegistrosDeEstacionamientoPorCompraPuntual().size());
	}	
	
	
	@Test
	void unPuntoDeVentaPuedeFinalizarTodosLosestacionamientos() {		
				
		unPuntoDeVenta.registrarEstacionamiento("patente1", 18);
		unPuntoDeVenta.registrarEstacionamiento("patente2", 20);
		
		assertEquals(2, unPuntoDeVenta.getEstacionamientosActivos());
		
		unPuntoDeVenta.finalizarEstacionamientosDePuntoDeVenta();
		
		assertEquals(0, unPuntoDeVenta.getEstacionamientosActivos());
		
	}	

}
