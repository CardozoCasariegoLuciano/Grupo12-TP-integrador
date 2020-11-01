package ar.edu.unq.po2.tpintegrador;

import java.util.Calendar;
import java.util.Date;

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
		this.hora = Calendar.getInstance();
		this.fecha = new Date();
	}

}
