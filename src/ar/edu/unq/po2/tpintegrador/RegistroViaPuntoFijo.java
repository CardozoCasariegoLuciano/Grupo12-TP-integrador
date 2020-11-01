package ar.edu.unq.po2.tpintegrador;

import java.util.Calendar;
import java.util.Date;

public class RegistroViaPuntoFijo extends RegistroEstacionamientos {
	
	private int cantDeHoras;
	private PuntoDeVenta puntoDeVenta;
	

	public RegistroViaPuntoFijo(int cantDeHoras, String unaPatente, PuntoDeVenta puntoDeVenta) {
		
		this.cantDeHoras = cantDeHoras;
		this.puntoDeVenta = puntoDeVenta;			
		
		this.patente = unaPatente;
		this.estaActivo = true;
		this.horaFinal = null;
		
		RegistroDeCompra.numeroDeRegistro ++;
		this.hora = Calendar.getInstance();
		this.fecha = new Date();
	}

}
