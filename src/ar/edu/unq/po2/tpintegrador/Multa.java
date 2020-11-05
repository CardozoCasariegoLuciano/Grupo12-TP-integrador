package ar.edu.unq.po2.tpintegrador;


import java.time.LocalDate;
import java.time.LocalTime;


public class Multa {

    private String patente;
    private LocalDate fecha;
    private LocalTime hora;
    private Inspector inspector;
    private ZonaDeEstacionamiento zona;

	

	public Multa(String patente, LocalDate fecha, LocalTime hora, Inspector inspector, ZonaDeEstacionamiento zona) {
		this.patente = patente;
		this.fecha = fecha;
		this.hora = hora;
		this.inspector = inspector;
		this.zona = zona;
	}

	private String getPatente() {
		return patente;
	}

	private void setPatente(String patente) {
		this.patente = patente;
	}

	private LocalDate getFecha() {
		return fecha;
	}

	private void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	private LocalTime getHora() {
		return hora;
	}

	private void setHora(LocalTime hora) {
		this.hora = hora;
	}

	private Inspector getInspector() {
		return inspector;
	}

	private void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}

	private ZonaDeEstacionamiento getZona() {
		return zona;
	}

	private void setZona(ZonaDeEstacionamiento zona) {
		this.zona = zona;
	}

	
	
}
