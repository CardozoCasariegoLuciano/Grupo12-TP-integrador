package ar.edu.unq.po2.tpintegrador;

import java.time.LocalTime;

public class EstacionamientoViaApp extends Estacionamiento {
	private int numeroDeCelular;
	
	private String patente;
	private Integer saldo;
	private Sem sem;
	private Boolean estaActivo;

	public EstacionamientoViaApp(AppUsuario app) {
		this.numeroDeCelular = app.getNumero();
		this.patente = app.getPatente();
		this.horaInicio = LocalTime.now();
		this.estaActivo = true;
		this.saldo = app.getSaldo();

		
	}
	
	public int getNumeroDeCelular() {
		return numeroDeCelular;
	}


	@Override
	public boolean comprobarValidez() {
		
		return this.estaActivo && this.saldo >= sem.getCosto();
	}
	
	public Boolean estacionamientoEstaAcitvo() {
		return this.estaActivo;
		
	}

}
