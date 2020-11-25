package ar.edu.unq.po2.tpintegrador;

import java.time.LocalDate;
import java.time.LocalTime;

public class Inspector {
   
	//Variables
	private ZonaDeEstacionamiento perteneceA;
	private AppInspector dispositivoMovil;
	
	//Constructor
	public Inspector(ZonaDeEstacionamiento perteneceA, AppInspector dispositivoMovil) {
		this.perteneceA = perteneceA;
		this.dispositivoMovil = dispositivoMovil;
	}

	// Getters
	public ZonaDeEstacionamiento getPerteneceA() {
		return perteneceA;
	}
	

	public AppInspector getDispositivoMovil() {
		return dispositivoMovil;
	}
	
	
	//Metodos
	
	public boolean verificarEstacionamiento(String patente, ISem unSem) {
		return unSem.existeEstacionamientoDe(patente);
	}
	
	public LocalTime horaActual() {

		return LocalTime.now();
	}
	
	public LocalDate fechaActual() {

		return LocalDate.now();
	}
	
	public void multar(String patente) {
		this.dispositivoMovil.registrarMulta(patente ,fechaActual(), horaActual(), this);
	}
	
	
	
}
