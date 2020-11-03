package ar.edu.unq.po2.tpintegrador;

import java.time.LocalTime;

public abstract class RegistroEstacionamiento extends RegistroDeCompra{
	
	//Variables
	protected String patente;
	protected boolean estaActivo;	
	protected LocalTime horaFinal;
	
	
	
	//Getters
	public String getPatente() {		
		return this.patente;
	}
	
	public LocalTime getHoraFinal() {
		return horaFinal;
	}
	
	//Metodos
	public void finalizarRegistro() {
		
		this.estaActivo = false;
		
	}

	public  boolean perteneceAPatente(String patente) {
		return this.patente == patente ;
	}
	
	public abstract boolean comprobarValidez();

}

