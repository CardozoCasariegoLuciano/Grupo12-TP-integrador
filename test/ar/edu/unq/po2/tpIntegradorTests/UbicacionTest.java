package ar.edu.unq.po2.tpIntegradorTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpintegrador.Ubicacion;

class UbicacionTest {
	
	Ubicacion unaUbicacion;
	double latitud;
	double longitud;
	

	@BeforeEach
	void setup() {
		latitud = (double)12;
		longitud = (double)12;
		unaUbicacion = new Ubicacion(longitud,latitud);
	}
	
	@Test
	void getLongitud() {
		assertEquals((double)12 , unaUbicacion.getLongitud());
	}
	
	@Test
	void getLatitud() {
		assertEquals((double)12 , unaUbicacion.getLatitud());
	}


}
