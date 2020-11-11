package ar.edu.unq.po2.tpintegrador;

public class AppAutomatica implements ModoDeApp {
	private MovementSensor sensor;

	
	@Override
	public void estacionar(String patente, int numeroCelular, ISem sem) {
		//verificar el sensor
		sem.registrarEstacionamientoViaApp(new EstacionamientoViaApp(numeroCelular, patente));
		
	}

	@Override
	public void finEstacionamiento() {
		//sem.finalizoEstacionamiento 
		
		
	}


}
