package ar.edu.unq.po2.tpintegrador;

import java.time.LocalTime;

public abstract class Estacionamiento {

	// Variables
	protected String patente;
	protected boolean estaActivo;
	protected LocalTime horaFinal;
	protected LocalTime horaInicio;

	// Getters
	public String getPatente() {
		return this.patente;
	}
	
	public LocalTime getHoraInicio() {
		
		return this.horaInicio;
	}

	public LocalTime getHoraFinal() {
		return horaFinal;
	}

	// Metodos



	public boolean perteneceAPatente(String patente) {
		return this.patente == patente;					// este metodo se podria borrar (lo usa el Sem en existeEstacionamientoDe)
	}

	public abstract boolean comprobarValidez();

}
