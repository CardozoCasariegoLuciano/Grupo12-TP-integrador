package ar.edu.unq.po2.tpintegrador;

public class AppAutomatica implements ModoDeApp {

	private AppUsuario app;

	public AppAutomatica(AppUsuario app) {
		this.app = app;

	}

	@Override
	public void estacionar() {
		// Esta acción se ejecuta de forma manual

	}

	@Override
	public void finDeEstacionamiento() {
		// Esta acción se ejecuta de forma manual

	}

	@Override
	public void inicioDeEstacionamientoAutomatico() {
		new AppManual(this.app).estacionar();
	}

	@Override
	public void finDeEstacionamientoAutomatico() {
		new AppManual(this.app).finDeEstacionamiento();

	}

	@Override
	public void alertaDeInicioDeEstacionamiento() {
		// TODO Auto-generated method stub

	}

	@Override
	public void alertaDeFinDeEstacionamiento() {
		// TODO Auto-generated method stub

	}

}
