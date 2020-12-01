package ar.edu.unq.po2.tpintegrador;

import java.util.ArrayList;

public class PuntoDeVenta {

	// Variables
	private ZonaDeEstacionamiento zona;
	private ArrayList<RegistroDeCompra> listaDeCompras;
	private ISem elSem;

	// Constructor
	public PuntoDeVenta(ZonaDeEstacionamiento unaZona, ISem unSem) {

		this.zona = unaZona;
		this.listaDeCompras = new ArrayList<RegistroDeCompra>();
		this.elSem = unSem;
	}

	// Getters
	public ZonaDeEstacionamiento getZona() {
		return zona;
	}

	public ArrayList<RegistroDeCompra> getRegistrosDeCompra() {
		return this.listaDeCompras;
	}

	// Metodos

	public void registrarEstacionamiento(String unaPatente, int cantDeHoras) {

		elSem.registrarEstacionamientoViaPuntoDeVenta(
				new EstacionamientoViaPuntoDeVenta(cantDeHoras, unaPatente, this));

		this.listaDeCompras.add(new RegistroCompraDeHoras(cantDeHoras, unaPatente, this));
	}

	public void registrarCargaCredito(int unMonto, AppUsuario unaAppusuairo) {

		this.listaDeCompras.add(new RegistroCargaCelular(unMonto, unaAppusuairo, this));
		elSem.cargarCredito(unMonto, unaAppusuairo);
	}

	
}
