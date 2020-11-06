package ar.edu.unq.po2.tpintegrador;

import java.util.ArrayList;



public class PuntoDeVenta {
	
	//Variables	
	private ZonaDeEstacionamiento zona;
	private ArrayList<RegistroViaPuntoFijo> listaDeEstacionamientosPorCompraPuntual;
	private ArrayList<RegistroCargaCelular> listaDeCargasCelular;
	
		
	
	//Constructor
	public PuntoDeVenta(ZonaDeEstacionamiento unaZona) {
		
		this.zona = unaZona;
		this.listaDeEstacionamientosPorCompraPuntual = new ArrayList<RegistroViaPuntoFijo>();
		this.listaDeCargasCelular = new ArrayList<RegistroCargaCelular>();
	}
	
	
	// Getters
	public ZonaDeEstacionamiento getZona() {		
		return zona;
	}

	
	
	public ArrayList<RegistroViaPuntoFijo> getRegistrosDeEstacionamientoPorCompraPuntual() {		
		return this.listaDeEstacionamientosPorCompraPuntual;
	}

	
	
	public ArrayList<RegistroCargaCelular> getRegistrosDeCargas(){		
		return this.listaDeCargasCelular;
	}
	

	// Metodos
	
	public void registrarEstacionamiento(String unaPatente, int cantDeHoras) {
		
		listaDeEstacionamientosPorCompraPuntual.add(new RegistroViaPuntoFijo(cantDeHoras,unaPatente, this));		
	}


	public void registrarCargaCredito(float unMonto, Celular unCelu) {
		
		listaDeCargasCelular.add(new RegistroCargaCelular(unMonto, unCelu, this));		
	}


	

	

}
	