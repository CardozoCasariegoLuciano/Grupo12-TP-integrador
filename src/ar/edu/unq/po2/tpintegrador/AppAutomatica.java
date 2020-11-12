package ar.edu.unq.po2.tpintegrador;

public class AppAutomatica implements ModoDeApp {
	
	private AppUsuario app;
	
	public AppAutomatica (AppUsuario app) {
		this.app = app;
		
	}

	@Override
	public void estacionar() {
		// Esta acción no se ejecuta de forma manual
		
	}

	@Override
	public void finDeEstacionamiento() {
		// Esta acción no se ejecuta de forma manual
		
	}

	@Override
	public void alertaDeInicioDeEstacionamiento() {
		new AppManual(this.app).estacionar();
	}

	@Override
	public void alertaDeFinDeEstacionamiento() {
		new AppManual(this.app).finDeEstacionamiento();
		
	}




}
