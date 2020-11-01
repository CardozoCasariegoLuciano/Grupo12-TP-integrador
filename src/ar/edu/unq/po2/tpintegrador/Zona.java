package ar.edu.unq.po2.tpintegrador;

import java.util.ArrayList;
import java.util.List;

public class Zona {
    
	private Inspector inspector;
	private List<PuntoDeVenta>puntosDeVenta;
	
	
	
	public Zona(Inspector inspector, List<PuntoDeVenta> puntosDeVenta) {
		this.inspector = inspector;
		this.puntosDeVenta = puntosDeVenta;
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

	
	
	
	public void finalizarEstacionamientos() {
		for(PuntoDeVenta puntoDeVenta : puntosDeVenta) {
			puntoDeVenta.finalizarEstacionamientosDePuntoDeVenta();
			
		}
		
	}

	
	public List<RegistroDeCompra> registrarComprasDePuntosDeVenta() {
		List<RegistroDeCompra> compras = new ArrayList<RegistroDeCompra>();
			
		for (PuntoDeVenta puntoDeVenta : puntosDeVenta) {
			compras.addAll(puntoDeVenta.registrarCompras());
		}
		
		return compras;
	}

	public boolean estaEstacionadoEnZona(String patente) {
		
		
	}



}
