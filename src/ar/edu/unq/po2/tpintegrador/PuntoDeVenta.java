package ar.edu.unq.po2.tpintegrador;

import java.util.ArrayList;
import java.util.Calendar;

public class PuntoDeVenta {
	
	//Variables
	Calendar hora; 
	
	private Zona zona;
	private ArrayList<RegistroDeCompra> listaDeRegistros;
	
	
	//Constructor
	public PuntoDeVenta(Zona unaZona) {
		
		this.zona = unaZona;
		this.listaDeRegistros = new ArrayList<RegistroDeCompra>();
	}
	
	
	// Getters
	public Zona getZona() {
		return zona;
	}


	public ArrayList<RegistroDeCompra> getRegistrosDeCompra() {
		
		return listaDeRegistros;
	}

	// Metodos
	
	public void registrarEstacionamiento(String unaPatente, int cantDeHoras) {
		
		listaDeRegistros.add(new RegistroViaPuntoFijo(cantDeHoras,unaPatente, this));		
	}


	public void registrarCargaCredito(float unMonto, Celular unCelu) {
		
		listaDeRegistros.add(new RegistroCargaCelular(unMonto, unCelu, this));		
	}


	public void finalizarEstacionamientosDePuntoDeVenta() {
		// TODO Auto-generated method stub
		
	}

}
	