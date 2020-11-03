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
	
	//Metodos
	public void finalizarRegistro() {
		
		this.estaActivo = false;
	}
	


}

