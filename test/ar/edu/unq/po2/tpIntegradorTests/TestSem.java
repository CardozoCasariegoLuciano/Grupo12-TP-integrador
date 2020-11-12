package ar.edu.unq.po2.tpIntegradorTests;

import static org.mockito.Mockito.*;

import java.time.LocalTime;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpintegrador.AppUsuario;
import ar.edu.unq.po2.tpintegrador.EstacionamientoViaApp;
import ar.edu.unq.po2.tpintegrador.EstacionamientoViaPuntoDeVenta;
import ar.edu.unq.po2.tpintegrador.Inspector;
import ar.edu.unq.po2.tpintegrador.PuntoDeVenta;
import ar.edu.unq.po2.tpintegrador.RegistroCargaCelular;
import ar.edu.unq.po2.tpintegrador.Sem;
import ar.edu.unq.po2.tpintegrador.Ubicacion;
import ar.edu.unq.po2.tpintegrador.ZonaDeEstacionamiento;

class TestSem {

	LocalTime franjaInicial = LocalTime.now();
	LocalTime franjaFin = LocalTime.now().plusHours(8);
	Sem unSem;
	EstacionamientoViaApp estacionamientoPorApp;
	EstacionamientoViaPuntoDeVenta estacionamientoPorPuntoDeVenta;
	EstacionamientoViaPuntoDeVenta otroEstacionamiento;
	AppUsuario appDeUsuario;
	PuntoDeVenta unPuntoDeV;
	Inspector unInspector;
	ZonaDeEstacionamiento unaZona;
	PuntoDeVenta unPuntoDeVenta;
	AppUsuario unaAppDeUsuario;
	Ubicacion unaUbicacion;
	
	@BeforeEach
	public void setup() {
		
		unSem = new Sem(franjaInicial, franjaFin, 12);
		estacionamientoPorApp = mock(EstacionamientoViaApp.class);
		estacionamientoPorPuntoDeVenta = mock(EstacionamientoViaPuntoDeVenta.class);
		appDeUsuario = mock(AppUsuario.class);
		unPuntoDeV = mock(PuntoDeVenta.class);
		otroEstacionamiento = new EstacionamientoViaPuntoDeVenta(1, "altaPatente", unPuntoDeV);
		unInspector = mock(Inspector.class);
		unaZona = new ZonaDeEstacionamiento(unInspector , unaUbicacion);
		unPuntoDeVenta = new PuntoDeVenta(unaZona , unSem);
		unaAppDeUsuario = mock(AppUsuario.class);
		unaUbicacion = mock(Ubicacion.class);
		
	}
	
	@Test
	void testSeCreaUnSemConCosto12() {
		assertEquals(12 , unSem.getCosto());	
	}
	
	@Test
	void testRegistrarEstacionamientoPorApp() {
		unSem.registrarEstacionamientoViaApp(estacionamientoPorApp);
		
		assertTrue(unSem.getEstacionamientosViaApp().contains(estacionamientoPorApp));
		
	}

	@Test
	void testRegistrarEstacionamientoPorPuntoDeVenta() {
		unSem.registrarEstacionamientoViaPuntoDeVenta(estacionamientoPorPuntoDeVenta);
		
		assertTrue(unSem.getEstacionamientosViaPuntoDeVenta().contains(estacionamientoPorPuntoDeVenta));
		
	}
	
	
	@Test
	void testAgregarAppDeUsuarioALista() {
		unSem.agregarAppUsuario(appDeUsuario);
		
		assertTrue(unSem.getAppDeConductores().contains(appDeUsuario));
		
	}
	
	@Test 
	void testFinalizarEstacionamientosViaApp() {
		unSem.registrarEstacionamientoViaApp(estacionamientoPorApp);;
		unSem.finalizarEstacionamientosViaApp();
		
		assertTrue(!estacionamientoPorApp.estacionamientoEstaAcitvo());
		
	}
	
	
	@Test
	void testFinalizarEstacionamientosViaPuntoDeVenta() {
		unSem.registrarEstacionamientoViaApp(estacionamientoPorApp);;
		unSem.finalizarEstacionamientosViaApp();
		
		assertTrue(!estacionamientoPorPuntoDeVenta.estacionamientoEstaAcitvo());
	}
	
	
	@Test
	void registrarYFinalizarEstacionamientosPorAppYPorPuntoDeVenta() {
		unSem.registrarEstacionamientoViaApp(estacionamientoPorApp);;
		unSem.registrarEstacionamientoViaPuntoDeVenta(estacionamientoPorPuntoDeVenta);;
		unSem.finalizarTodosLosEstacionamientos();
		
		assertTrue(!estacionamientoPorApp.estacionamientoEstaAcitvo());
		assertTrue(!estacionamientoPorPuntoDeVenta.estacionamientoEstaAcitvo());
		
	}
	
	
	@Test
	void verificarQueExisteEstacionamientoParaPatente() {
		unSem.registrarEstacionamientoViaPuntoDeVenta(otroEstacionamiento);
		
		assertTrue(unSem.existeEstacionamientoDe(otroEstacionamiento.getPatente()));
	}
	
	
	@Test
	void verificarQueNoExisteEstacionamientoParaPatente() {
		
		assertTrue(!unSem.existeEstacionamientoDe(otroEstacionamiento.getPatente()));
	}

	@Test 
	void registrarTodasLasComprasDeLasZonasDelSem() {
		
		unaZona.abrirPuntoDeVenta(unPuntoDeVenta);
		unPuntoDeVenta.registrarCargaCredito(12, unaAppDeUsuario);
		
		assertEquals(1 , unSem.registrarTodasLasCompras().size()); 
	}
	

	
}	
