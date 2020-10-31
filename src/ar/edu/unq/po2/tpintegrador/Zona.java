package ar.edu.unq.po2.tpintegrador;

import java.util.ArrayList;
import java.util.List;

public class Zona {

	private List<PuntoDeVenta>puntosDeVenta;
	
	public void finalizarEstacionamientos() {
		// TODO Auto-generated method stub
		
	}

	public List<RegistroDeCompra> registrarComprasDePuntosDeVenta() {
		List<RegistroDeCompra> compras = new ArrayList<RegistroDeCompra>();
			
		for (PuntoDeVenta puntoDeVenta : puntosDeVenta) {
			compras.addAll(puntoDeVenta.registrarCompras());
		}
		
		return compras;
	}



}
