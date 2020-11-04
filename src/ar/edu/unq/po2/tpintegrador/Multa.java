package ar.edu.unq.po2.tpintegrador;


import java.time.LocalTime;
import java.util.Date;

public class Multa {

    private String patente;
    private Date fecha;
    private LocalTime hora;
    private Inspector inspector;
    private Zona zona;

	

	public Multa(String patente, Date fecha, LocalTime hora, Inspector inspector, Zona zona) {
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

	private Date getFecha() {
		return fecha;
	}

	private void setFecha(Date fecha) {
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

	private Zona getZona() {
		return zona;
	}

	private void setZona(Zona zona) {
		this.zona = zona;
	}

	
	
}
