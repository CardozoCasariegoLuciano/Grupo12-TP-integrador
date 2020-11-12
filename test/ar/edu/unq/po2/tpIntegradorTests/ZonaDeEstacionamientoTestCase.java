package ar.edu.unq.po2.tpIntegradorTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpintegrador.Inspector;
import ar.edu.unq.po2.tpintegrador.PuntoDeVenta;
import ar.edu.unq.po2.tpintegrador.Ubicacion;
import ar.edu.unq.po2.tpintegrador.ZonaDeEstacionamiento;

class ZonaDeEstacionamientoTestCase {

	ZonaDeEstacionamiento unaZona;
	Ubicacion unaUbicacion;
	
	Inspector unInspector;
	
	@BeforeEach
	public void setUp() {
		
		unInspector = mock(Inspector.class);
		unaUbicacion = mock(Ubicacion.class);
		
		unaZona = new ZonaDeEstacionamiento(unInspector, unaUbicacion);
		
	}
	@Test
	void unaZonaEsCreadaConSuInspectorYConSuListaVaciaDePuntosDeVentas() {
		
		assertEquals(unInspector, unaZona.getInspector());
		assertEquals(0, unaZona.getPuntosDeVenta().size());
		assertEquals(unaUbicacion, unaZona.getUbicacion());
	}
	
	@Test
	void unaZonaPuedeAbrirUnPuntoDeVenta() {
		
		PuntoDeVenta unPV = mock(PuntoDeVenta.class);
		
		assertEquals(0, unaZona.getPuntosDeVenta().size());
		
		unaZona.abrirPuntoDeVenta(unPV);
		
		assertEquals(1, unaZona.getPuntosDeVenta().size());
	}
	
	
	@Test
	void unaZonaPuedeObtenerTodosLosRegistrosDeCompra() {
				
		PuntoDeVenta puntoDeVenta = mock(PuntoDeVenta.class);		
		unaZona.abrirPuntoDeVenta(puntoDeVenta);
		
		unaZona.registrarComprasDePuntosDeVenta();
		
		verify(puntoDeVenta, atLeastOnce()).getRegistrosDeCompra();
	}

}


























