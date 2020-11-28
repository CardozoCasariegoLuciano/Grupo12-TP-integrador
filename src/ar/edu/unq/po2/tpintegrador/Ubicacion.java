package ar.edu.unq.po2.tpintegrador;

public class Ubicacion {
	private double longitud;
	private double latitud;
	
	public Ubicacion(double longitud, double latitud) {
		this.longitud = longitud;  // Este, Oeste
		this.latitud = latitud;    // Norte, Sur
	}
	
	public double getLongitud() {
		return longitud;
	}

	public double getLatitud() {
		return latitud;
	}
	public double distanciaAlOrigen() {
		return Math.sqrt(this.longitud * this.longitud + this.latitud * this.latitud);
	}
}



