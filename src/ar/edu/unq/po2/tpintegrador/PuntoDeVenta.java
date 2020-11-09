package ar.edu.unq.po2.tpintegrador;

import java.util.ArrayList;



public class PuntoDeVenta {
	
	//Variables	
	private ZonaDeEstacionamiento zona;
	private ArrayList<RegistroDeCompra> listaDeCompras;		
	
	//Constructor
	public PuntoDeVenta(ZonaDeEstacionamiento unaZona) {
		
		this.zona = unaZona;
		this.listaDeCompras = new ArrayList<RegistroDeCompra>();		
	}
	
	
	// Getters
	public ZonaDeEstacionamiento getZona() {		
		return zona;
	}
	
	public ArrayList<RegistroDeCompra> getRegistrosDeCompra() {		
		return this.listaDeCompras;
	}	
	

	// Metodos
	
	public void registrarEstacionamiento(String unaPatente, int cantDeHoras, ISem unSem) {
		
		unSem.registrarEstacionamientoViaPuntoDeVenta(new RegistroViaPuntoFijo(cantDeHoras,unaPatente, this));	// Ramiro, quiza tenias razon y es mejor que el 
																												//  registroViaPuntoFijo se construya dentro de SEM y no en
																												// puntoDeVenta jajajaja
		
		this.listaDeCompras.add(new RegistroCompraDeHoras(cantDeHoras, unaPatente ,this));
	}


	public void registrarCargaCredito(float unMonto, Celular unCelu) {
		
		this.listaDeCompras.add(new RegistroCargaCelular(unMonto, unCelu, this));		
	}
	

}
	