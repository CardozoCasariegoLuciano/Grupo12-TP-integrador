package ar.edu.unq.po2.tpIntegradorTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpintegrador.AppUsuario;
import ar.edu.unq.po2.tpintegrador.Conductor;
import ar.edu.unq.po2.tpintegrador.EstacionamientoViaApp;
import ar.edu.unq.po2.tpintegrador.Sem;

class TestEstacionamientoViaApp {

	
	    LocalTime franjaInicial = LocalTime.now();
	    LocalTime franjaFin = LocalTime.now().plusHours(8);
		EstacionamientoViaApp unEstacionamiento;
		AppUsuario unaApp;
		Conductor unConductor;
		Sem unSem;
		
		
		

       @BeforeEach
	   void setup() {
    	    unSem = new Sem(franjaInicial, franjaFin, 12);
			unConductor = mock(Conductor.class);
			unaApp = new AppUsuario(123 , unSem , unConductor);
			unaApp.aumentarSaldo(13);
			unEstacionamiento = new EstacionamientoViaApp(unaApp);
			unEstacionamiento.setSem(unSem);
			
		}
		
       
       @Test
		void pedirNumeroDeCelular() {
			
			assertEquals(123 , unEstacionamiento.getNumeroDeCelular());
		}
       
       
       @Test
       void comprovarValidez() {
    	   
    	  
    	   assertTrue(unEstacionamiento.comprobarValidez());
       }
}
