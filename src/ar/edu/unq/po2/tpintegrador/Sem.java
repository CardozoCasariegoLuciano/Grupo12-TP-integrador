package ar.edu.unq.po2.tpintegrador;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sem implements ISem {

	private List<ZonaDeEstacionamiento> zonas;
	private List<AppUsuario> appDeUsuarios;
	private LocalTime inicioFranjaHoraria;
	private LocalTime finFranjaHoraria;
	private float costo;
	private List<Subscriptor> sistemasSubscriptos;
	private List<EstacionamientoViaApp> estacionamientosViaApp;
	private List<EstacionamientoViaPuntoDeVenta> estacionamientosViaPuntoDeVenta;


	public Sem(LocalTime inicioDeFranja,LocalTime finDeFranja, float costo) {
		
		this.zonas = new ArrayList<ZonaDeEstacionamiento>();		
		this.appDeUsuarios = new ArrayList<AppUsuario>();		
		
		this.setInicioFranjaHoraria(inicioDeFranja);
		this.setFinFranjaHoraria(finDeFranja);
		
		this.setCosto(costo);
		
		this.sistemasSubscriptos = new ArrayList<Subscriptor>();
		this.estacionamientosViaApp = new ArrayList<EstacionamientoViaApp>();
		this.estacionamientosViaPuntoDeVenta = new ArrayList<EstacionamientoViaPuntoDeVenta>();
	}

	private void suscribirSistema(Subscriptor sistemaSubscriptor) {
		this.sistemasSubscriptos.add(sistemaSubscriptor);
	}

	private void desSubscribirSistema(Subscriptor sistema) {
		this.sistemasSubscriptos.remove(sistema);
	}
	
	public void registrarEstacionamientoViaPuntoDeVenta(EstacionamientoViaPuntoDeVenta unEstacionamiento) {
		this.estacionamientosViaPuntoDeVenta.add(unEstacionamiento);
	}

	public void registrarEstacionamientoViaApp(EstacionamientoViaApp unEstacionamiento) {
		this.estacionamientosViaApp.add(unEstacionamiento);
	}

	public LocalTime getInicioFranjaHoraria() {
		return inicioFranjaHoraria;
	}

	public void setInicioFranjaHoraria(LocalTime inicioFranjaHoraria) {
		this.inicioFranjaHoraria = inicioFranjaHoraria;
	}

	public LocalTime getFinFranjaHoraria() {
		return finFranjaHoraria;
	}

	public void setFinFranjaHoraria(LocalTime finFranjaHoraria) {
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
      List<Estacionamiento>estacionamientos = new ArrayList<Estacionamiento>();
      estacionamientos.addAll(this.estacionamientosViaApp);
      estacionamientos.addAll(this.estacionamientosViaPuntoDeVenta);
    
		for (Estacionamiento elem : estacionamientos) {
			elem.finalizarRegistro();
		}

	}

	public List<RegistroDeCompra> registrarTodasLasCompras() {
		List<RegistroDeCompra> todasLasCompras = new ArrayList<RegistroDeCompra>();

		for (ZonaDeEstacionamiento zona : zonas) {
			todasLasCompras.addAll(zona.registrarComprasDePuntosDeVenta());
		}

		return todasLasCompras;
	}




	public boolean existeEstacionamientoDe(String unaPatente) {
	  List<Estacionamiento>estacionamientos = new ArrayList<Estacionamiento>();
	  estacionamientos.addAll(this.estacionamientosViaApp);
	  estacionamientos.addAll(this.estacionamientosViaPuntoDeVenta);
	  
		for (Estacionamiento estacionamiento : estacionamientos) {
			if (estacionamiento.perteneceAPatente(unaPatente)) {
				return true;

			}

		}
		return false;

	}

	@Override
	public void finalizarEstacionamientoViaApp(int numero) {
		
		
	}
	
	
}
