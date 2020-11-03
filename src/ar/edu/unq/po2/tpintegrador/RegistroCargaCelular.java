package ar.edu.unq.po2.tpintegrador;

import java.time.LocalDate;
import java.time.LocalTime;

public class RegistroCargaCelular extends RegistroDeCompra {

	//Variables
	private float monto;
	private Celular celular;
	private PuntoDeVenta puntoDeVenta;
	
	//Constructor
	public RegistroCargaCelular(float unMonto, Celular unCelu, PuntoDeVenta puntoDeVenta) {
		
		this.monto = unMonto;
		this.celular = unCelu;
		this.puntoDeVenta = puntoDeVenta;
		RegistroDeCompra.numeroDeRegistro ++;
		this.hora = LocalTime.now();
		this.fecha = LocalDate.now();
	}
	

}
