package ar.edu.unq.po2.tpintegrador;

import java.time.LocalTime;

public class EstacionamientoViaApp extends Estacionamiento {
	private int numeroDeCelular;
	private String patente;
	private Integer saldo;
	private Sem sem;
	

	public EstacionamientoViaApp(AppUsuario app) {
		this.numeroDeCelular = app.getNumero();
		this.patente = app.getPatente();
		this.horaInicio = LocalTime.now();
		this.estaActivo = true;
		this.saldo = app.getSaldo();

		
	}

	@Override
	public boolean comprobarValidez() {
		
		return this.estaActivo && this.saldo >= sem.getCosto();
	}

}
