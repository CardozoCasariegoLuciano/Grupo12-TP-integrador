package ar.edu.unq.po2.tpintegrador;

import java.time.LocalDate;
import java.time.LocalTime;

public class RegistroCompraDeHoras extends RegistroDeCompra {
	
	//Variables
	private int cantDeHoras;
	private String patente;
	private PuntoDeVenta puntoDeVenta;

	//Constructor
	public RegistroCompraDeHoras(int cantDeHoras, String unaPatente, PuntoDeVenta puntoDeVenta) {
		
		this.patente = unaPatente;
		this.cantDeHoras = cantDeHoras;
		this.puntoDeVenta = puntoDeVenta;
		RegistroDeCompra.numeroDeRegistro ++;
		this.hora = LocalTime.now();
		this.fecha = LocalDate.now();
	}
}
