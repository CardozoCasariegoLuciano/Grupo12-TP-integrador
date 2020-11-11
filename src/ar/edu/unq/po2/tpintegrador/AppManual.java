package ar.edu.unq.po2.tpintegrador;

public class AppManual implements ModoDeApp {


	@Override
	
	public void estacionar(String patente, int numeroCelular, ISem sem)  {
		sem.registrarEstacionamientoViaApp(new EstacionamientoViaApp(numeroCelular, patente));
	}
	

	@Override
	public void finEstacionamiento() {
		
		
	}







}
