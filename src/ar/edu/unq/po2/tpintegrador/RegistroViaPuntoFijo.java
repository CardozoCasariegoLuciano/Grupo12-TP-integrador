package ar.edu.unq.po2.tpintegrador;

import java.time.LocalDate;
import java.time.LocalTime;

public class RegistroViaPuntoFijo extends RegistroEstacionamiento {
	
	private int cantDeHoras;
	private PuntoDeVenta puntoDeVenta;
	

	public RegistroViaPuntoFijo(int cantDeHoras, String unaPatente, PuntoDeVenta puntoDeVenta) {
		
		this.cantDeHoras = cantDeHoras;
		this.puntoDeVenta = puntoDeVenta;			
		
		this.patente = unaPatente;
		this.estaActivo = true;
		this.horaFinal = null;
		
		RegistroDeCompra.numeroDeRegistro ++;
		this.hora = LocalTime.now();
		this.fecha = LocalDate.now();
	}
	

}
