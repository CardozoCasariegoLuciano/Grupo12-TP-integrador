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
		
		unSem = mock(Sem.class);
		appManual= mock(AppManual.class);
		appAutomatica = mock(AppAutomatica.class);	
		
		
		unConductor = new Conductor("ABC123", unaApp );		
		unaApp = new AppUsuario(12354, unSem, unConductor, appManual);
	}
	
	@Test 
	public void testConstructor() {		
		
		assertTrue(unaApp.getModo().getClass().equals(appManual.getClass()));
		assertEquals(12354, unaApp.getNumero());
		assertEquals(0, unaApp.getSaldo());		
		assertEquals(unConductor, unaApp.getConductor());		
	}
	
	
	@Test 
	public void testCambioDeModo() {
		
		assertTrue(unaApp.getModo().getClass().equals(appManual.getClass()));
		
		unaApp.modoAutomatico();
		
		assertTrue(unaApp.getModo().getClass().equals(AppAutomatica.class));		
	}
	 
	@Test 
	public void testEstacionar01() {
		
		unaApp.estacionar();
		
		verify(unaApp.getModo() , atLeastOnce()).estacionar();
	}
	
	@Test 
	public void testEstacionar02() {
		
		unaApp.setModo(appAutomatica);
		
		unaApp.estacionar();
		
		verify(unaApp.getModo() , atLeastOnce()).estacionar();
	}

	@Test 
	public void testFinalizarEstacionamiento01() {		
		
		unaApp.finDeEstacionamiento();
		
		verify(unaApp.getModo(), atLeastOnce()).finDeEstacionamiento();
	}
	
	@Test 
	public void testFinalizarEstacionamiento02() {		
		
		unaApp.setModo(appAutomatica);
		unaApp.finDeEstacionamiento();
		
		verify(unaApp.getModo(), atLeastOnce()).finDeEstacionamiento();
	}
	

	@Test
	public void testPuedeAumentarSuSaldo() {
		
		assertEquals(0, unaApp.getSaldo());
		
		unaApp.aumentarSaldo(100);
		
		assertEquals(100, unaApp.getSaldo());
	}
	
	@Test
	public void testPuedeDecrementarSuSaldo() {
		
		unaApp.aumentarSaldo(100);
		assertEquals(100, unaApp.getSaldo());
		
		unaApp.decrementarSaldo(25);
		
		assertEquals(75, unaApp.getSaldo());
	}
	
	

}




