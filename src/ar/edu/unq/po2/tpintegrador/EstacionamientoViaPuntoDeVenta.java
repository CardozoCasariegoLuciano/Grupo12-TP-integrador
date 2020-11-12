package ar.edu.unq.po2.tpintegrador;

import java.time.LocalTime;


public class EstacionamientoViaPuntoDeVenta extends Estacionamiento {

	// Variables


	private int cantDeHoras;
	private PuntoDeVenta puntoDeVenta;
	private Boolean estaActivo;

	// Constructor
	public EstacionamientoViaPuntoDeVenta(int cantDeHoras, String unaPatente, PuntoDeVenta puntoDeVenta) {

		this.cantDeHoras = cantDeHoras;
		this.puntoDeVenta = puntoDeVenta;
		this.patente = unaPatente;
		this.estaActivo = true;
		this.horaFinal = LocalTime.now().plusHours(this.cantDeHoras);
	}

	// Getters
	public Integer getCantDeHS() {

		return this.cantDeHoras;
	}

	public Object getPuntoDeVenta() {

		return this.puntoDeVenta;
	}

	public LocalTime horaActual() {

		return LocalTime.now();
	}

	
	public Boolean estacionamientoEstaAcitvo() {
		return this.estaActivo;
		
	}

	
	// Metodos
	@Override
	public boolean comprobarValidez() {

		boolean resultado;

		LocalTime horaActual = horaActual();

		resultado = (this.estaActivo && this.horaFinal.isAfter(horaActual));

		return resultado;
	}
}
