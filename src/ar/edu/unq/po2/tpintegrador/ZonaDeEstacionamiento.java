package ar.edu.unq.po2.tpintegrador;

import java.util.ArrayList;
import java.util.List;

public class ZonaDeEstacionamiento {
    
	private Inspector inspector;
	private List<PuntoDeVenta>puntosDeVenta;
	

	
	/*Constructor*/
	public ZonaDeEstacionamiento(Inspector inspector, List<PuntoDeVenta> puntosDeVenta , List<RegistroViaApp>estacionamientosDeApp) {
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

	
	
	

	
	public List<RegistroDeCompra> registrarComprasDePuntosDeVenta() {
		List<RegistroDeCompra> compras = new ArrayList<RegistroDeCompra>();
			
		for (PuntoDeVenta puntoDeVenta : puntosDeVenta) {
			compras.addAll(puntoDeVenta.getRegistrosDeCompra());
		}
		
		return compras;
	}

	



}
