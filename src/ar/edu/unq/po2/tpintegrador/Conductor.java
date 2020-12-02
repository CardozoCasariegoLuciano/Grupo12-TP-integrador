package ar.edu.unq.po2.tpintegrador;

public class Conductor {
	private String patente;
	public AppUsuario app;

	public Conductor(String patente, AppUsuario app) {
		this.app = app;
		this.patente = patente;
	}	

	public AppUsuario getApp() {
		
		return this.app;
	}

	public String getPatente() {
		return patente;
	}

	// Metodos para estacionar

	public void estacionarPorPuntoDeVenta(PuntoDeVenta unPuntoDeVenta, String patente, int horas) {
		unPuntoDeVenta.registrarEstacionamiento(patente, horas);
	}

	public void estacionarPorApp() {

		this.app.estacionar();
	}
	
	
	//Delega acciones al celular
	public void finalizarEstacionamientoPorApp() {
		app.finDeEstacionamiento();
	}
	

	public void recargarCelular(int saldoACargar , PuntoDeVenta unPunto) {
		unPunto.registrarCargaCredito(saldoACargar, this.app);
	}

	
	
}
