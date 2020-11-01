package ar.edu.unq.po2.tpintegrador;

public class Conductor {
	private String patente;
	private Celular celularActual;
	public PuntoDeVenta puntoDeVenta;

	public Conductor(String patente, Celular celularDeConductor) {
		this.celularActual = celularDeConductor;
		this.patente = patente;

	}

	public String getPatente() {
		return patente;
	}

	// Metodos para estacionar

	void estacionarPorPuntoDeVenta(String patente, int horas) {
		this.puntoDeVenta.registrarEstacionamiento(patente, horas);
	}

	void estacionarPorApp() {

		celularActual.estacionar(patente);
	}
	
	
	//Delega acciones al celular
	void finalizarEstacionamientoPorApp() {
		celularActual.finDeEstacionamiento();
	}

	void recargarCelular(int nuevoSaldo) {
		celularActual.setSaldo(nuevoSaldo);
	}
}
