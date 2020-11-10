package ar.edu.unq.po2.tpintegrador;

public class Conductor {
	private String patente;
	public PuntoDeVenta puntoDeVenta;
	public AppUsuario app;

	public Conductor(String patente, AppUsuario app) {
		this.app = app;
		this.patente = patente;
		

	}

	public String getPatente() {
		return patente;
	}

	// Metodos para estacionar

	void estacionarPorPuntoDeVenta(String patente, int horas, Sem sem) {
		this.puntoDeVenta.registrarEstacionamiento(patente, horas, sem);
	}

	void estacionarPorApp() {

		app.estacionar(patente);
	}
	
	
	//Delega acciones al celular
	void finalizarEstacionamientoPorApp() {
		app.finDeEstacionamiento();
	}

	void recargarCelular(int nuevoSaldo) {
		app.setSaldo(nuevoSaldo);
	}
}
