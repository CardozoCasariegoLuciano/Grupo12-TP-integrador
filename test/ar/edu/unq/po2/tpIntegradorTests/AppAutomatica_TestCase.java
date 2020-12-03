package ar.edu.unq.po2.tpIntegradorTests;

import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpintegrador.AppAutomatica;
import ar.edu.unq.po2.tpintegrador.AppUsuario;
import ar.edu.unq.po2.tpintegrador.Conductor;
import ar.edu.unq.po2.tpintegrador.ModoDeApp;
import ar.edu.unq.po2.tpintegrador.Sem;

class AppAutomatica_TestCase {

	AppAutomatica appAuto;
	AppAutomatica appAutoMock;
	AppUsuario appUsuario;
	Sem sem;
	ModoDeApp unModo;
	Conductor unConductor;

	@BeforeEach
	public void setUp() {	
			
		unModo = mock(ModoDeApp.class);
		sem = mock (Sem.class);
		unConductor = mock (Conductor.class);
		
		appAutoMock = mock(AppAutomatica.class);
		
		appUsuario = new AppUsuario( 101, sem, unConductor, unModo);
		appAuto = new AppAutomatica(appUsuario);
		
	}
	
	@Test
	void laAppSabeTirarAlertaInicioEstacionamiento() {
		
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
	
        appAuto.alertaDeInicioDeEstacionamiento();
		
		assertEquals("Inicio de Estacionamiento exitoso \n Hora de Inicio:" + LocalTime.now().getHour() + LocalDate.now(), outContent.toString().replaceAll("\r\n" , ""));		
	}
	
	
	@Test
	void testAlertaDeFinDeEstacionamiento() {

      appAutoMock.alertaDeFinDeEstacionamiento();
	
	  verify(appAutoMock, atLeastOnce()).alertaDeFinDeEstacionamiento();	

	}
	
	@Test
	void testAlertaDeInicioDeEstacionamiento() {

      appAutoMock.alertaDeInicioDeEstacionamiento();
	
	  verify(appAutoMock, atLeastOnce()).alertaDeInicioDeEstacionamiento();	

	}
	
	@Test
	void testCantidadDeHoras() {
		
		appAuto.setHoraInicioEstacionamiento(LocalTime.of(10, 30, 15));
		appAuto.setHoraFinDeEstacionamiento(LocalTime.of(12, 30, 15));
		
		assertEquals(2, appAuto.cantidadDeHoras() );
		
	}
	
	
	/*
	@Test
	void testPrecioTotal() {
		
		appAuto.setHoraInicioEstacionamiento(LocalTime.of(10, 30, 15));
		appAuto.setHoraFinDeEstacionamiento(LocalTime.of(12, 30, 15));
		
		assertEquals(2, appAuto.cantidadDeHoras() );
		
	}*/
	

	

	

}



















