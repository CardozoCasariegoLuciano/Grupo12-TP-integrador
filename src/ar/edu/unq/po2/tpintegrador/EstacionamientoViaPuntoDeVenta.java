package ar.edu.unq.po2.tpintegrador;

import java.time.LocalDate;
import java.time.LocalTime;

public class EstacionamientoViaPuntoDeVenta extends RegistroEstacionamiento {
	
	//Variables
	private int cantDeHoras;
	private PuntoDeVenta puntoDeVenta;
	
	
	//Constructor
	public EstacionamientoViaPuntoDeVenta(int cantDeHoras, String unaPatente, PuntoDeVenta puntoDeVenta) {
		
		this.cantDeHoras = cantDeHoras;
		this.puntoDeVenta = puntoDeVenta;			
		
		RegistroDeCompra.numeroDeRegistro ++;
		this.hora = LocalTime.now();
		this.fecha = LocalDate.now();
		
		this.patente = unaPatente;
		this.estaActivo = true;
		this.horaFinal = this.hora.plusHours(this.cantDeHoras);
	}

	//Getters
	public Integer getCantDeHS() {
		
		return this.cantDeHoras;
	}

	public Object getPuntoDeVenta() {
		
		return this.puntoDeVenta;
	}
	
	public LocalTime horaActual() {			
				
		return LocalTime.now();
	}
	

	//Metodos
	@Override
	public boolean comprobarValidez() {		
		
		boolean resultado;
			
		LocalTime horaActual = horaActual();	
		
		resultado = this.estaActivo && this.horaFinal.isAfter(horaActual);
		
				
		return resultado;
	}
}
