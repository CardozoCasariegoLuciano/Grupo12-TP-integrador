package ar.edu.unq.po2.tpintegrador;

import java.util.ArrayList;
import java.util.List;

public class Zona {
    
	private Inspector inspector;
	private List<PuntoDeVenta>puntosDeVenta;
	private List<RegistroViaApp> estacinamientosViaApp;
	
	/*Constructor*/
	public Zona(Inspector inspector, List<PuntoDeVenta> puntosDeVenta , List<RegistroViaApp>estacionamientosDeApp) {
		this.inspector = inspector;
		this.puntosDeVenta = puntosDeVenta;
		this.setEstacinamientosViaApp(estacionamientosDeApp);
	}

	private Inspector getInspector() {
		return inspector;
	}

	private void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}

	private List<PuntoDeVenta> getPuntosDeVenta() {
		return puntosDeVenta;
	}

	private void setPuntosDeVenta(List<PuntoDeVenta> puntosDeVenta) {
		this.puntosDeVenta = puntosDeVenta;
	}

	
	
	
	private List<RegistroViaApp> getEstacinamientosViaApp() {
		return estacinamientosViaApp;
	}

	private void setEstacinamientosViaApp(List<RegistroViaApp> estacinamientosViaApp) {
		this.estacinamientosViaApp = estacinamientosViaApp;
	}

	public void finalizarEstacionamientos() {
		for(PuntoDeVenta puntoDeVenta : puntosDeVenta) {
			puntoDeVenta.finalizarEstacionamientosDePuntoDeVenta();
			
		}
		
	}

	
	public List<RegistroDeCompra> registrarComprasDePuntosDeVenta() {
		List<RegistroDeCompra> compras = new ArrayList<RegistroDeCompra>();
			
		for (PuntoDeVenta puntoDeVenta : puntosDeVenta) {
			compras.addAll(puntoDeVenta.getRegistrosDeCargas());
		}
		
		return compras;
	}

	
	public List<RegistroEstacionamiento> getEstacionamientosDePuntosDeVenta(){
	  List<RegistroEstacionamiento>	estacionamientos = new ArrayList<RegistroEstacionamiento>();
	  
	  for (PuntoDeVenta puntoDeVenta : this.puntosDeVenta) {
		  estacionamientos.addAll(puntoDeVenta.getRegistrosDeEstacionamiento());
	  }
		
	  return estacionamientos;	
	}
	
	
	
	
	public boolean estaEstacionadoEnZona(String patente) {
		ArrayList<RegistroEstacionamiento>	estacionamientos = new ArrayList<RegistroEstacionamiento>();
		estacionamientos.addAll(this.getEstacinamientosViaApp());
		
		for (RegistroEstacionamiento registro : this.getEstacionamientosDePuntosDeVenta()) {
			if(registro.perteneceAPatente(patente)) {
				return true;
			}
		   	
		}
		return false;
	}



}
