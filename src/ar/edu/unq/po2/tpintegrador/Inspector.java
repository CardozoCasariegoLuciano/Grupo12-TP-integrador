package ar.edu.unq.po2.tpintegrador;

import java.time.LocalDate;
import java.time.LocalTime;

public class Inspector {
   
	private ZonaDeEstacionamiento perteneceA;
	private AppInspector dispositivoMovil;
	
	
	public Inspector(ZonaDeEstacionamiento perteneceA, AppInspector dispositivoMovil) {
		this.setPerteneceA(perteneceA);
		this.setDispositivoMovil(dispositivoMovil);
	}


	public ZonaDeEstacionamiento getPerteneceA() {
		return perteneceA;
	}


	private void setPerteneceA(ZonaDeEstacionamiento perteneceA) {
		this.perteneceA = perteneceA;
	}


	private AppInspector getDispositivoMovil() {
		return dispositivoMovil;
	}


	private void setDispositivoMovil(AppInspector dispositivoMovil) {
		this.dispositivoMovil = dispositivoMovil;
	}
	
	
	private boolean verificarEstacionamiento(String patente, ISem unSem) {
		return unSem.existeEstacionamientoDe(patente);
	}
	
	
	private void multar(String patente) {
		this.dispositivoMovil.registrarMulta(patente , LocalDate.now() , LocalTime.now() , this);
	}
	
	
}
