package ar.edu.unq.po2.tpIntegradorTests;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpintegrador.AppUsuario;
import ar.edu.unq.po2.tpintegrador.Conductor;
import ar.edu.unq.po2.tpintegrador.PuntoDeVenta;
import ar.edu.unq.po2.tpintegrador.ZonaDeEstacionamiento;

class ConductorTest {

	PuntoDeVenta unPunto;
	Conductor unConductor;
	AppUsuario unaApp;
	
	ZonaDeEstacionamiento unaZona;
	
	@BeforeEach
	public void setUp() {		
		
		unaApp = mock(AppUsuario.class);
		
		unConductor = new Conductor("patente", unaApp);
	}

	@Test
	void unConductorConoceSuPatenteYaSuApp() {
		
		assertEquals("patente" , unConductor.getPatente());
		assertEquals(unaApp , unConductor.getApp());
	}
	
	@Test
	void unConductorPuedeCargarCreditoASuApp() {
		
		unPunto = mock (PuntoDeVenta.class);				
		unConductor.recargarCelular(100, unPunto);				
		verify(unPunto, atLeastOnce()).registrarCargaCredito(100, unConductor.getApp());
	}
	
	@Test
	void unConductorPuedeEstacionarPorPuntoFijo() {
		
		unPunto = mock (PuntoDeVenta.class);		
		unConductor.estacionarPorPuntoDeVenta(unPunto, unConductor.getPatente(), 2);			
		verify(unPunto, atLeastOnce()).registrarEstacionamiento(unConductor.getPatente(), 2);
	}
	
	@Test
	void unConductorPuedeEstacionarUsandoLaApp() {		
		
		unConductor.estacionarPorApp();				
		verify(unConductor.getApp(), atLeastOnce()).estacionar();
	}
	
	@Test
	void unConductorPuedeFinalizarEstacionarUsandoLaApp() {		
		
		unConductor.finalizarEstacionamientoPorApp();				
		verify(unConductor.getApp(), atLeastOnce()).finDeEstacionamiento();
	}
} 