package ar.edu.unq.po2.tpintegrador;

import java.util.Calendar;

public abstract class RegistroEstacionamientos extends RegistroDeCompra{
	
	//Variables
	protected String patente;
	protected boolean estaActivo;	
	protected Calendar horaFinal;
	
	
	
	//Getters
	public String getPatente() {
		
		return this.patente;
	}
	
	//Metodos
	public void finalizarRegistro() {
		
		this.estaActivo = false;
	}


}

