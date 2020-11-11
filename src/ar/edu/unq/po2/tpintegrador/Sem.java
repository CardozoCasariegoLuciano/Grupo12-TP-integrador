package ar.edu.unq.po2.tpintegrador;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sem implements ISem {

	private List<ZonaDeEstacionamiento> zonas;
	private List<AppUsuario> appDeUsuarios;
	private LocalDateTime inicioFranjaHoraria;
	private LocalDateTime finFranjaHoraria;
	private float costo;
	private List<Subscriptor> sistemasSubscriptos;
	private List<Estacionamiento> estacionamientos;


	public Sem(LocalDateTime inicioDeFranja,LocalDateTime finDeFranja, float costo) {
		
		this.zonas = new ArrayList<ZonaDeEstacionamiento>();		
		this.appDeUsuarios = new ArrayList<AppUsuario>();		
		
		this.setInicioFranjaHoraria(inicioDeFranja);
		this.setFinFranjaHoraria(finDeFranja);
		
		this.setCosto(costo);
		
		this.sistemasSubscriptos = new ArrayList<Subscriptor>();
		this.estacionamientos = new ArrayList<Estacionamiento>();
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

	private List<AppUsuario> getAppDeConductores() {
		return appDeUsuarios;
	}

	private void agregarAppUsuario(AppUsuario appUsuario) {
		this.appDeUsuarios.add(appUsuario);
	}

	private void finalizarTodosLosEstacionamientos() {

		for (Estacionamiento elem : this.estacionamientos) {
			elem.finalizarRegistro();
		}

	}

	public int getEstacionamientosActivos() {

		int contador = 0;

		for (Estacionamiento elem : this.estacionamientos) {

			if (elem.estaActivo == true) {

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

	public boolean existeEstacionamientoDe(String unaPatente) {

		for (Estacionamiento estacionamiento : this.estacionamientos) {
			if (estacionamiento.perteneceAPatente(unaPatente)) {
				return true;

			}

		}
		return false;

	}
}
