package ar.edu.unq.po2.tpintegrador;

import java.time.LocalDate;
import java.time.LocalTime;

public class RegistroViaPuntoFijo extends RegistroEstacionamiento {
	
	//Variables
	private int cantDeHoras;
	private PuntoDeVenta puntoDeVenta;
	
	
	//Constructor
	public RegistroViaPuntoFijo(int cantDeHoras, String unaPatente, PuntoDeVenta puntoDeVenta) {
		
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

	//Metodos
	@Override
	public boolean comprobarValidez() {		
		
		boolean resultado;
			
		LocalTime horaActual = LocalTime.now();	
		
		resultado = this.estaActivo && this.horaFinal.isAfter(horaActual);
		
				
		return resultado;
	}
}
