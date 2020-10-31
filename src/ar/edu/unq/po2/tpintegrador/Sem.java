package ar.edu.unq.po2.tpintegrador;

import java.time.LocalDateTime;
import java.util.List;

public class Sem {
   
    private List<Zona> zonas;
    private List<Celular> celularesDeConductores;
    private LocalDateTime inicioFranjaHoraria;
    private LocalDateTime finFranjaHoraria;
    private float costo =  12;
    
    
	public Sem(List<Zona>zonas, List<Celular> celulares, LocalDateTime inicioDeFranja, LocalDateTime finDeFranja, float costo) {
		 this.setZonas(zonas);
	     this.setCelularesDeConductores(celularesDeConductores);
	     this.setInicioFranjaHoraria(inicioDeFranja);
	     this.setFinFranjaHoraria(finDeFranja);
	     this.setCosto(costo);
	}


	public LocalDateTime getInicioFranjaHoraria() {
		return inicioFranjaHoraria;
	}
	
	
	public void setInicioFranjaHoraria(LocalDateTime inicioFranjaHoraria) {
		this.inicioFranjaHoraria = inicioFranjaHoraria;
	}
	
	
	public LocalDateTime getFinFranjaHoraria() {
		return finFranjaHoraria;
	}
	
	
	public void setFinFranjaHoraria(LocalDateTime finFranjaHoraria) {
		this.finFranjaHoraria = finFranjaHoraria;
	}
	
	
	public Float getCosto() {
		return costo;
	}
	
	
	public void setCosto(Float costo) {
		this.costo = costo;
	}


	private List<Zona> getZonas() {
		return zonas;
	}


	private void setZonas(List<Zona> zonas) {
		this.zonas = zonas;
	}


	private List<Celular> getCelularesDeConductores() {
		return celularesDeConductores;
	}


	private void setCelularesDeConductores(List<Celular> celularesDeConductores) {
		this.celularesDeConductores = celularesDeConductores;
	}
    
    
	private void finalizarTodosLosEstacionamientos() {
		for (Zona zona : zonas) {
			zona.finalizarEstacionamientos();
		}
	}
	
	
  

 
    
}
