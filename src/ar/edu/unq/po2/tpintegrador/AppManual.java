package ar.edu.unq.po2.tpintegrador;

public class AppManual implements ModoDeApp {

	private AppUsuario app;
	
	public AppManual (AppUsuario app) {
		this.app = app;
		
	}

	@Override
	public void estacionar() {
		this.app.getSem().registrarEstacionamientoViaApp(new EstacionamientoViaApp(app));
		
	}

	@Override
	public void finDeEstacionamiento() {
		if (!(this.app.getSem().existeEstacionamientoDe(this.app.getPatente())))
			
		this.app.getSem().finalizarEstacionamientoViaApp(this.app.getNumero());
		
	}

	@Override
	public void alertaDeInicioDeEstacionamiento() {
		// No se usan de manera manual
		
	}

	@Override
	public void alertaDeFinDeEstacionamiento() {
		// No se usan de manera manual
		
	}


	




}
