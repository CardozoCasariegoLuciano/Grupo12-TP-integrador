package ar.edu.unq.po2.tpintegrador;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sem implements ISem {

	private List<ZonaDeEstacionamiento> zonas;
	private List<AppUsuario> appDeUsuarios;
	private LocalTime inicioFranjaHoraria;
	private LocalTime finFranjaHoraria;
	private float costo;
	private List<Subscriptor> sistemasSubscriptos;
	private List<Estacionamiento> estacionamientos;
	


	public Sem(LocalTime inicioDeFranja,LocalTime finDeFranja, float costo) {
		
		this.zonas = new ArrayList<ZonaDeEstacionamiento>();		
		this.appDeUsuarios = new ArrayList<AppUsuario>();		
		
		this.setInicioFranjaHoraria(inicioDeFranja);
		this.setFinFranjaHoraria(finDeFranja);
		
		this.setCosto(costo);
		
		this.sistemasSubscriptos = new ArrayList<Subscriptor>();
		this.estacionamientos = new ArrayList<Estacionamiento>();
	}

	public void suscribirSistema(Subscriptor sistemaSubscriptor) {
		this.sistemasSubscriptos.add(sistemaSubscriptor);
	}

	public void desSubscribirSistema(Subscriptor sistema) {
		this.sistemasSubscriptos.remove(sistema);
	}
	
	public void registrarEstacionamientoViaPuntoDeVenta(EstacionamientoViaPuntoDeVenta unEstacionamiento) {
		this.estacionamientos.add(unEstacionamiento);
	}

	public void registrarEstacionamientoViaApp(EstacionamientoViaApp unEstacionamiento) {
		this.estacionamientos.add(unEstacionamiento);
	}
	
	 
	

	public List<Estacionamiento> getEstacionamientos() {
		return this.estacionamientos;
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

	public List<ZonaDeEstacionamiento> getZonas() {
		return zonas;
	}



	public List<AppUsuario> getAppDeConductores() {
		return appDeUsuarios;
	}
	
	

	public List<Subscriptor> getSistemasSubscriptos() {
		return sistemasSubscriptos;
	}

	public void agregarAppUsuario(AppUsuario appUsuario) {
		this.appDeUsuarios.add(appUsuario);
	}

	public void finalizarTodosLosEstacionamientos() {
     this.estacionamientos.stream().
                                    forEach(estacionamiento -> estacionamiento.finalizarRegistro());
		
	}
	
	
	
	
	public List<RegistroDeCompra> registrarTodasLasCompras() {
		List<RegistroDeCompra> todasLasCompras = new ArrayList<RegistroDeCompra>();

        this.getZonas().stream().
                              forEach(zona -> todasLasCompras.addAll(zona.registrarComprasDePuntosDeVenta()));
        
        return todasLasCompras;
	}


	
	public void agregarZonaDeEstacionamientoASem(ZonaDeEstacionamiento zona) {
		this.zonas.add(zona);
	}


	public boolean existeEstacionamientoDe(String unaPatente) {

		for (Estacionamiento estacionamiento : this.estacionamientos) {
			if (estacionamiento.perteneceAPatente(unaPatente)) {
				return true;

			}

		}
		return false;

	}
	
	
	public List<Float> conocerSaldoDeTodasLasAppsDeUsuario(){
		List<Float> saldos = new ArrayList<Float>();
		
		this.getAppDeConductores().stream().
		                                    forEach(app -> saldos.add(app.getSaldo()));
		
		return saldos;
	}

    public  Float conocerSaldoDeApp(AppUsuario unaAppusuario) { 	
       int  indice = this.getAppDeConductores().indexOf(unaAppusuario);
       return this.getAppDeConductores().get(indice).getSaldo(); 
      	 
              }
      	
           
	
   
	
    public  void cargarCredito(int unMonto, AppUsuario unaAppusuario) {
      int  indice = this.getAppDeConductores().indexOf(unaAppusuario);
      this.getAppDeConductores().get(indice).aumentarSaldo(unMonto);
    
    	
         }
	

     
	@Override
	public void finalizarEstacionamientoViaApp(int numeroDeTelefono) {
		
				
	}
	
	
	

 	
}
