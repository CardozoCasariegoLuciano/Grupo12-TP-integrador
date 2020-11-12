package ar.edu.unq.po2.tpIntegradorTests;

import static org.mockito.Mockito.*;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpintegrador.Sem;

class TestSem {

	LocalTime franjaInicial = LocalTime.now();
	LocalTime franjaFin = LocalTime.now().plusHours(8);
	Sem unSem;
	
	
	@BeforeEach
	public void setup() {
		unSem = new Sem(franjaInicial, franjaFin, 12);
		
	}
	
	@Test
	void testSeCreaUnSemConCosto12() {
		assertEquals(12 , unSem.getCosto());	
	}

}
