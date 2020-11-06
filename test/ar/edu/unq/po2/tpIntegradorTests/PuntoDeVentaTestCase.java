package ar.edu.unq.po2.tpIntegradorTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpintegrador.Celular;
import ar.edu.unq.po2.tpintegrador.PuntoDeVenta;
import ar.edu.unq.po2.tpintegrador.Sem;
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
	void unPuntoDeVentaEsCreadoConUnaZonaYConListaDeComprasVacia() {
					
		assertEquals(unaZona , unPuntoDeVenta.getZona());
		assertEquals(0 , unPuntoDeVenta.getRegistrosDeCompra().size());
		
	}	
	
	
	@Test
	void unPuntoDeVentaPuedeRegistrarUnaCargaDeCelular() {
		
		Celular unCelu = mock(Celular.class);
		
		assertEquals(0 , unPuntoDeVenta.getRegistrosDeCompra().size());		
		unPuntoDeVenta.registrarCargaCredito(500,unCelu);		
		assertEquals(1 , unPuntoDeVenta.getRegistrosDeCompra().size());
	}
	
	
	@Test
	void cuandoSeRegistraUnEstacionamientoElPVregistraLaCompraDeHoras() {	
		
		Sem unSem = mock(Sem.class);	
			
		unPuntoDeVenta.registrarEstacionamiento("patente", 1, unSem);		
		assertEquals(1 , unPuntoDeVenta.getRegistrosDeCompra().size());
		
		
	}	

}
