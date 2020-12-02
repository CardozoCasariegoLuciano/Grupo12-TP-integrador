package ar.edu.unq.po2.tpIntegradorTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpintegrador.AppAutomatica;
import ar.edu.unq.po2.tpintegrador.AppManual;
import ar.edu.unq.po2.tpintegrador.AppUsuario;
import ar.edu.unq.po2.tpintegrador.Conductor;
import ar.edu.unq.po2.tpintegrador.ISem;
import ar.edu.unq.po2.tpintegrador.ModoDeApp;
import ar.edu.unq.po2.tpintegrador.Sem;

class AppUsuarioTest {
	AppUsuario unaApp;
	ModoDeApp modoApp;
	Sem unSem;
	AppManual appManual;
	AppAutomatica appAutomatica;
	Conductor unConductor;
	
	
	
	
	@BeforeEach
	
	public void setUp() {
		modoApp = mock(ModoDeApp.class);
		appManual= mock(AppManual.class);
		appAutomatica = mock(AppAutomatica.class);
		unSem = mock(Sem.class);
		when(unSem.getCosto()).thenReturn(100f);
		unConductor = new Conductor("ABC123", unaApp );
		
		unaApp = new AppUsuario( 12354,unSem,unConductor );
	}
	
	@Test 
	public void testConstructor() {
		assertEquals("asdf565" ,unaApp.getPatente());
		assertEquals(12354, unaApp.getNumero());
		assertEquals(1000, unaApp.getSaldo());
		assertEquals(appManual, unaApp.getModo());
		
		
	}
	@Test 
	public void testCambioDeModo() {
		unaApp.modoAutomatico();
		assertTrue(unaApp.getModo().getClass().equals(AppAutomatica.class));
		
		unaApp.modoManual();
		assertTrue(unaApp.getModo().getClass().equals(AppManual.class));
	}
	 
//	@Test 
//	public void testEstacionar() {
//		
//		unaApp.aumentarSaldo(100);
//		unaApp.estacionar();
//		verify(appManual, atLeastOnce()).estacionar();
//	}
//	
	@Test 
	public void testFinalizarEstacionamiento() {
		unaApp.aumentarSaldo(100);
		unaApp.estacionar();
		verify(appManual, atLeastOnce()).estacionar();
		unaApp.finDeEstacionamiento();
		verify(appManual, atLeastOnce()).finDeEstacionamiento();
	}
	
	@Test
	public void testEstacionarAutomatico() {
		unaApp.modoAutomatico();
		unaApp.walking();
		verify(appAutomatica, atLeastOnce()).estacionar();
		
	}
	
	@Test 
	public void existeEstacionamiento() {
		
		when(unSem.existeEstacionamientoDe(unaApp.getPatente())).thenReturn(true);

	}
	@Test
	public void testPuedeRegistrarUnaCarga() {
		unaApp.setSaldo(100);
		assertEquals(100, unaApp.getSaldo());
	}
	
	public void estacionamientoAutomatico() {
		unaApp.modoAutomatico();
		unaApp.walking();
		unaApp.driving();
		verify(appAutomatica,atLeastOnce()).finDeEstacionamiento();
	
	
	}

}
