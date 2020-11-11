package ar.edu.unq.po2.tpintegrador;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sem implements ISem {
<<<<<<< HEAD
=======
   
    private List<ZonaDeEstacionamiento> zonas;
    private List<Celular> celularesDeConductores;
    private LocalDateTime inicioFranjaHoraria;
    private LocalDateTime finFranjaHoraria;
    private float costo =  12;
    private List<Subscriptor> sistemasSubscriptos;
    private List<RegistroEstacionamiento> estacionamientos;
    
    
>>>>>>> branch 'main' of https://github.com/CardozoCasariegoLuciano/Grupo12-TP-integrador.git

	private List<ZonaDeEstacionamiento> zonas;
	private List<AppUsuario> celularesDeConductores;
	private LocalDateTime inicioFranjaHoraria;
	private LocalDateTime finFranjaHoraria;
	private float costo = 12;
	private List<Subscriptor> sistemasSubscriptos;
	private List<Estacionamiento> estacionamientos;

	public Sem(List<ZonaDeEstacionamiento> zonas, List<AppUsuario> celulares, LocalDateTime inicioDeFranja,
			LocalDateTime finDeFranja, float costo, List<Subscriptor> subscriptores) {
		this.setZonas(zonas);
		this.setCelularesDeConductores(celulares);
		this.setInicioFranjaHoraria(inicioDeFranja);
		this.setFinFranjaHoraria(finDeFranja);
		this.setCosto(costo);
		this.setSistemasSubscriptos(subscriptores);
	}

	private void setSistemasSubscriptos(List<Subscriptor> sistemasSubscriptos) {
		this.sistemasSubscriptos = sistemasSubscriptos;
	}

	public void registrarEstacionamientoViaPuntoDeVenta(EstacionamientoViaPuntoDeVenta unEstacionamiento) {
		this.estacionamientos.add(unEstacionamiento);
	}

	public void registrarEstacionamientoViaApp(EstacionamientoViaApp unEstacionamiento) {
		this.estacionamientos.add(unEstacionamiento);
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

	private List<ZonaDeEstacionamiento> getZonas() {
		return zonas;
	}

	private void setZonas(List<ZonaDeEstacionamiento> zonas) {
		this.zonas = zonas;
	}

	private List<AppUsuario> getCelularesDeConductores() {
		return celularesDeConductores;
	}

	private void setCelularesDeConductores(List<AppUsuario> celularesDeConductores) {
		this.celularesDeConductores = celularesDeConductores;
	}

	private void finalizarTodosLosEstacionamientos() {
<<<<<<< HEAD
		for (Estacionamiento elem : this.estacionamientos) {

=======
	for(RegistroEstacionamiento elem:this.estacionamientos) {
			
>>>>>>> branch 'main' of https://github.com/CardozoCasariegoLuciano/Grupo12-TP-integrador.git
			elem.finalizarRegistro();
		}

	}

	public int getEstacionamientosActivos() {

		int contador = 0;
<<<<<<< HEAD

		for (Estacionamiento elem : this.estacionamientos) {

			if (elem.estaActivo == true) {
=======
		
		for(RegistroEstacionamiento elem:this.estacionamientos) {
			
			if(elem.estaActivo == true) {
>>>>>>> branch 'main' of https://github.com/CardozoCasariegoLuciano/Grupo12-TP-integrador.git
				contador++;
			}
		}

		return contador;

	}

	public List<RegistroDeCompra> registrarTodasLasCompras() {
		List<RegistroDeCompra> todasLasCompras = new ArrayList<RegistroDeCompra>();

		for (ZonaDeEstacionamiento zona : zonas) {
			todasLasCompras.addAll(zona.registrarComprasDePuntosDeVenta());
		}

		return todasLasCompras;
	}

	private void subscribirSistema(Subscriptor sistema) {
		this.sistemasSubscriptos.add(sistema);

	}

	private void desSubscribirSistema(Subscriptor sistema) {
		this.sistemasSubscriptos.remove(sistema);
	}

<<<<<<< HEAD
	public boolean existeEstacionamientoDe(String unaPatente) {

		for (Estacionamiento estacionamiento : this.estacionamientos) {
			if (estacionamiento.perteneceAPatente(unaPatente)) {
				return true;
			}

=======
public boolean existeEstacionamientoDe(String unaPatente) {
	
	for (RegistroEstacionamiento estacionamiento :this.estacionamientos) {
		if(estacionamiento.perteneceAPatente(unaPatente)) {
			return true;
>>>>>>> branch 'main' of https://github.com/CardozoCasariegoLuciano/Grupo12-TP-integrador.git
		}

		return false;
	}

}
