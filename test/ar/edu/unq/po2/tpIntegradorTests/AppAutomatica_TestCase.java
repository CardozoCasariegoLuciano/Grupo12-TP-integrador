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

class AppAutomatica_TestCase {

	AppAutomatica appAuto;
	AppUsuario appUsuario;
	
	@BeforeEach
	public void setUp() {
		
		appUsuario = mock (AppUsuario.class);
		
		appAuto = new AppAutomatica(appUsuario);
	}
	
	@Test
	void laAppSabeTirarAlertaInicioEstacionamiento() {
		
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
	
        appAuto.alertaDeInicioDeEstacionamiento();
		
		assertEquals("Inicio de Estacionamiento exitoso \n Hora de Inicio:" + LocalTime.now().getHour() + LocalDate.now(), outContent.toString().replaceAll("\r\n" , ""));		
	}
	
}





















