package ar.edu.unq.po2.tpintegrador;

import java.util.ArrayList;
import java.util.List;

public class ZonaDeEstacionamiento {
    
	//Variables
	private Inspector inspector;
	private List<PuntoDeVenta>puntosDeVenta;
	private Ubicacion unaUbicacion;

	
	/*Constructor*/
	public ZonaDeEstacionamiento(Inspector inspector, Ubicacion unaUbicacion) {
		this.inspector = inspector;
		this.puntosDeVenta = new ArrayList<PuntoDeVenta>();
		this.unaUbicacion = unaUbicacion; 
	}
	
	
	//Getters
	
	public Ubicacion getUbicacion() {
		
		return this.unaUbicacion;
	}
	
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
