package ar.edu.unq.po2.tpintegrador;

import java.time.LocalTime;


public class EstacionamientoViaPuntoDeVenta extends Estacionamiento {

	// Variables


	private int cantDeHoras;
	private PuntoDeVenta puntoDeVenta;
	private Boolean estaActivo;

	// Constructor
	public EstacionamientoViaPuntoDeVenta(int cantDeHoras, String unaPatente, PuntoDeVenta puntoDeVenta) {

		LocalTime actual = LocalTime.now();
		
		this.cantDeHoras = cantDeHoras;
		this.puntoDeVenta = puntoDeVenta;
		this.patente = unaPatente;
		this.estaActivo = true;
		this.horaInicio = actual;
		this.horaFinal = actual.plusHours(this.cantDeHoras);
	}

	// Getters
	public Integer getCantDeHS() {

		return this.cantDeHoras;
	}

	public Object getPuntoDeVenta() {

		return this.puntoDeVenta;
	}

	
	// Metodos
	
	public LocalTime horaActual() {

		return LocalTime.now();
	}

	
	public Boolean estacionamientoEstaAcitvo() {
		return this.estaActivo;
		
	}
	
	public void finalizarRegistro() {
		
		this.estaActivo = false;
	}

	
	
	@Override
	public boolean comprobarValidez() {

		boolean resultado;

		LocalTime horaActual = horaActual();

		resultado = (this.estacionamientoEstaAcitvo() && this.horaFinal.isAfter(horaActual));
		
		return resultado;
	}
	
	
}
