package ar.edu.unq.po2.tpintegrador;

import java.time.LocalDate;
import java.time.LocalTime;

public class RegistroCargaCelular extends RegistroDeCompra {

	//Variables
	private float monto;
	private AppUsuario appUsuario;
	private PuntoDeVenta puntoDeVenta;	
	
	//Constructor
	public RegistroCargaCelular(float unMonto, AppUsuario unaAppUsuario, PuntoDeVenta puntoDeVenta) {
		
		this.monto = unMonto;
		this.appUsuario = unaAppUsuario;
		this.puntoDeVenta = puntoDeVenta;
		RegistroDeCompra.numeroDeRegistro ++;
		this.hora = LocalTime.now();
		this.fecha = LocalDate.now();
	}	
	

}


