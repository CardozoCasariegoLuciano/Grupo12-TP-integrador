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

	public String getPatente() {
		return patente;
	}
	

	public LocalDate getFecha() {
		return fecha;
	}


	public LocalTime getHora() {
		return hora;
	}
	

	public Inspector getInspector() {
		return inspector;
	}
	

	public ZonaDeEstacionamiento getZona() {
		return zona;
	}

	
	
}
