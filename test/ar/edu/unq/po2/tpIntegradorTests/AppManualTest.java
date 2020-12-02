package ar.edu.unq.po2.tpIntegradorTests;

import static org.mockito.Mockito.*;
import ar.edu.unq.po2.tpintegrador.AppManual;
import ar.edu.unq.po2.tpintegrador.AppUsuario;
import ar.edu.unq.po2.tpintegrador.Conductor;
import ar.edu.unq.po2.tpintegrador.EstacionamientoViaApp;
import ar.edu.unq.po2.tpintegrador.Sem;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppManualTest {
	
	AppManual unaAppManual;
	AppManual otraAppManual;
	AppUsuario unaApp;
	AppUsuario otraApp;
	Conductor unConductor;
	LocalTime franjaInicial = LocalTime.now();
	LocalTime franjaFin = LocalTime.now().plusHours(8);
	EstacionamientoViaApp unEstacionamiento;
	Sem unSem;
	
	
	@BeforeEach
	void setup() {
		unConductor = mock(Conductor.class);
		unSem = new Sem(franjaInicial , franjaFin , 12);
		unaApp = new AppUsuario(11111 , unSem , unConductor , unaAppManual);
		otraApp = new AppUsuario(11111 , unSem , unConductor ,otraAppManual);
		unaApp.aumentarSaldo(13);
		otraAppManual = new AppManual(otraApp);
		otraApp.aumentarSaldo(2);
		unEstacionamiento = new EstacionamientoViaApp(unaApp);
		
		unaAppManual = new AppManual(unaApp);
		otraAppManual = new AppManual(otraApp);
	}
	
	
	@Test
	void testEstacionar() {
		
		unaAppManual.estacionar();
		
		assertTrue(unSem.existeEstacionamientoDe(unaAppManual.getApp().getPatente()));
	}
	
	@Test
	void testEstacionarSinSaldoSuficiente() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
	
        otraAppManual.estacionar();
		
		assertEquals("Saldo insuficiente.\n Estacionamiento no permitido.", outContent.toString().replaceAll("\r\n" , ""));		
	}
	


}
