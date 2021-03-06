package ar.edu.unq.po2.tpintegrador;

import java.util.ArrayList;
import java.util.List;

public class ZonaDeEstacionamiento {
    
	//Variables
	private Inspector inspector;
	private List<PuntoDeVenta>puntosDeVenta;
	

	
	/*Constructor*/
	public ZonaDeEstacionamiento(Inspector inspector) {
		this.inspector = inspector;
		this.puntosDeVenta = new ArrayList<PuntoDeVenta>();		
	}
	
	
	//Getters	
	
	
	public Inspector getInspector() {
		return inspector;
	}
	
	public List<PuntoDeVenta> getPuntosDeVenta() {
		return puntosDeVenta;
	}	
	
	
	//Metodos
	
	public ArrayList<RegistroDeCompra> registrarComprasDePuntosDeVenta() {
		ArrayList<RegistroDeCompra> compras = new ArrayList<RegistroDeCompra>();
			
		for (PuntoDeVenta puntoDeVenta : puntosDeVenta) {
			compras.addAll(puntoDeVenta.getRegistrosDeCompra());
			
			
		}
		
		return compras;
	}

	

	public void abrirPuntoDeVenta(PuntoDeVenta unPV) {
		this.puntosDeVenta.add(unPV);
		
	}

	



}
