package ar.edu.unq.po2.tpintegrador;

import java.util.ArrayList;



public class PuntoDeVenta {
	
	//Variables	
	private Zona zona;
	private ArrayList<RegistroViaPuntoFijo> listaDeEstacionamientos;
	private ArrayList<RegistroCargaCelular> listaDeCargasCelular;
	
		
	
	//Constructor
	public PuntoDeVenta(Zona unaZona) {
		
		this.zona = unaZona;
		this.listaDeEstacionamientos = new ArrayList<RegistroViaPuntoFijo>();
		this.listaDeCargasCelular = new ArrayList<RegistroCargaCelular>();
	}
	
	
	// Getters
	public Zona getZona() {		
		return zona;
	}

	public ArrayList<RegistroViaPuntoFijo> getRegistrosDeEstacionamiento() {		
		return this.listaDeEstacionamientos;
	}

	public ArrayList<RegistroCargaCelular> getRegistrosDeCargas(){		
		return this.listaDeCargasCelular;
	}
	

	// Metodos
	
	public void registrarEstacionamiento(String unaPatente, int cantDeHoras) {
		
		listaDeEstacionamientos.add(new RegistroViaPuntoFijo(cantDeHoras,unaPatente, this));		
	}


	public void registrarCargaCredito(float unMonto, Celular unCelu) {
		
		listaDeCargasCelular.add(new RegistroCargaCelular(unMonto, unCelu, this));		
	}


	public void finalizarEstacionamientosDePuntoDeVenta() {
		
		for(RegistroEstacionamiento elem:this.listaDeEstacionamientos) {
			
			elem.finalizarRegistro();
		}
		
	}

	public int getEstacionamientosActivos() {
		
		int contador = 0;
		
		for(RegistroEstacionamiento elem:this.listaDeEstacionamientos) {
			
			if(elem.estaActivo == true) {
				contador++;
			}
		}		
		return contador;
	}
	
	

	

	

}
	