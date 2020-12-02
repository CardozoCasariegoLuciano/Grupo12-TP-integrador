package ar.edu.unq.po2.tpIntegradorTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpintegrador.AppAutomatica;
import ar.edu.unq.po2.tpintegrador.AppManual;
import ar.edu.unq.po2.tpintegrador.AppUsuario;
import ar.edu.unq.po2.tpintegrador.Conductor;
import ar.edu.unq.po2.tpintegrador.EstacionamientoViaApp;
import ar.edu.unq.po2.tpintegrador.ISem;
import ar.edu.unq.po2.tpintegrador.ModoDeApp;
import ar.edu.unq.po2.tpintegrador.Sem;

class AppUsuarioTest {
	
	Sem unSem;	
	AppUsuario unaApp;
	ModoDeApp modoApp;
	AppManual appManual;
	AppAutomatica appAutomatica;
	Conductor unConductor;	
	EstacionamientoViaApp estacionamiento;
	
	@BeforeEach
	
	public void setUp() {
		
		unConductor = mock(Conductor.class);
		modoApp = mock(ModoDeApp.class);
		appManual= mock(AppManual.class);
		appAutomatica = mock(AppAutomatica.class);
		unSem = mock(Sem.class);
		when(unSem.getCosto()).thenReturn(100f);
		unConductor = new Conductor("ABC123", unaApp );
		unaApp = new AppUsuario(12354, unSem, unConductor, appManual);
	}
	
	@Test 
	public void testConstructor() {		
		
		assertTrue(unaApp.getModo().getClass().equals(AppManual.class));
		assertEquals(12354, unaApp.getNumero());
		assertEquals(0, unaApp.getSaldo());		
		assertEquals(unConductor, unaApp.getConductor());		
	}
	
	
	@Test 
	public void testCambioDeModo() {
		
		assertTrue(unaApp.getModo().getClass().equals(AppManual.class));
		
		unaApp.modoAutomatico();
		
		assertTrue(unaApp.getModo().getClass().equals(AppAutomatica.class));	
		
	}
	 
	@Test 
	public void testEstacionar() {
		unaApp.aumentarSaldo(200);
		unaApp.estacionar();
		verify(unaApp.getModo() , atLeastOnce()).estacionar();
	}

	@Test 
	public void testFinalizarEstacionamiento() {
		when(unSem.existeEstacionamientoDe(unaApp.getPatente())).thenReturn(true);
		unaApp.finDeEstacionamiento();
		verify(unaApp.getModo(), atLeastOnce()).alertaDeFinDeEstacionamiento();
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
