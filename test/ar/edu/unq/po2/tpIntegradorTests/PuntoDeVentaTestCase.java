package ar.edu.unq.po2.tpIntegradorTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpintegrador.Celular;
import ar.edu.unq.po2.tpintegrador.PuntoDeVenta;
import ar.edu.unq.po2.tpintegrador.Zona;

class PuntoDeVentaTestCase {

	PuntoDeVenta unPuntoDeVenta;
	Zona unaZona;
	
	@BeforeEach
	public void setUp() {
		
		unaZona = mock(Zona.class);
		
		unPuntoDeVenta = new  PuntoDeVenta(unaZona);
	}
	
	
	@Test
	void unPuntoDeVentaEsCreadoConUnaZona() {
				
		assertEquals(unaZona , unPuntoDeVenta.getZona());
	}
	
	@Test
	void unPuntoDeVentaTieneUnaListaDeRegistrosDeVentas() {
				
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
	void unPuntoDeVentaPuedeRegistrarUnEstacionamiento() {
		
				
		assertEquals(0 , unPuntoDeVenta.getRegistrosDeCompra().size());		
		unPuntoDeVenta.registrarEstacionamiento("patente", 18);		
		assertEquals(1 , unPuntoDeVenta.getRegistrosDeCompra().size());
	}	
	

}
