package ar.edu.unq.po2.tpintegrador;

public class EstacionamientoViaApp extends Estacionamiento {
	private int numeroDeCelular;
	private String patente;

	public EstacionamientoViaApp(int numeroDeCelular, String patente) {
		this.numeroDeCelular = numeroDeCelular;
		this.patente = patente;
	}

	@Override
	public boolean comprobarValidez() {
		// TODO Auto-generated method stub
		return false;
	}

}
