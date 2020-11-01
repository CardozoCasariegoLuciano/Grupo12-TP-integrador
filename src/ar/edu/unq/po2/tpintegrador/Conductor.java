package ar.edu.unq.po2.tpintegrador;

public class Conductor {
	private String patente;
	private Celular celularDeConductor;
	
	
	public Conductor(String patente, Celular celularDeConductor) {
		this.celularDeConductor = celularDeConductor;
		this.patente = patente;
		
	}
	
	
	public String getPatente() {
		return patente;
	}


	void estacionarPorApp() {
		
		celularDeConductor.estacionar(patente);
	}
	
	void finalizarEstacionamientoPorApp() {
		celularDeConductor.finDeEstacionamiento();
	}
	
}
