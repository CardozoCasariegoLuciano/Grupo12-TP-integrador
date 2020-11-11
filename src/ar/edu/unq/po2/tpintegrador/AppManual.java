package ar.edu.unq.po2.tpintegrador;

public class AppManual implements ModoDeApp {

	private AppUsuario app;
	
	public AppManual (AppUsuario app) {
		this.app = app;
		
	}

	@Override
	public void estacionar() {
		
		
	}

	@Override
	public void finDeEstacionamiento() {
		// TODO Auto-generated method stub
		
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
