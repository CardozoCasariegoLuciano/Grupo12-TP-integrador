package ar.edu.unq.po2.tpintegrador;

import java.time.LocalTime;

public class EstacionamientoViaApp extends Estacionamiento {
	private int numeroDeCelular;
	
	private String patente;
	private float saldo;
	private Sem sem;
	private Boolean estaActivo;

	public EstacionamientoViaApp(AppUsuario app ) {
		this.numeroDeCelular = app.getNumero();
		this.patente = app.getPatente();
		this.horaInicio = LocalTime.now();
		this.estaActivo = true;
		this.saldo = app.getSaldo();
		

		
	}
	
	public void setSem(Sem unSem) {
		this.sem = unSem;
	}
	
	public int getNumeroDeCelular() {
		return numeroDeCelular;
	}


	@Override
	public boolean comprobarValidez() {
		
		return this.saldo >= sem.getCosto();
	}

	public boolean estacionamientoEstaAcitvo() {
		
		return this.estaActivo;
	}
	


}
