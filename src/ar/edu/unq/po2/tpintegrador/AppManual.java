package ar.edu.unq.po2.tpintegrador;

public class AppManual implements ModoDeApp {

	private AppUsuario app;

	public AppManual(AppUsuario app) {
		this.app = app;

	}

	@Override
	public void estacionar() {
		if (this.app.getSaldo() > this.app.semClase.getCosto()) {
			this.app.getSem().registrarEstacionamientoViaApp(new EstacionamientoViaApp(app));
			System.out.println("Estacionamiento Exitoso");
		} else
			System.out.println("Saldo insuficiente. Estacionamiento no permitido.");
	}

	@Override
	public void finDeEstacionamiento() {
		if (!(this.app.getSem().existeEstacionamientoDe(this.app.getPatente()))) {

			this.app.getSem().finalizarEstacionamientoViaApp(this.app.getNumero());
			System.out.println("Fin de Estacionamiento Exitoso");
		} else {
			System.out.println("No existe estacionamiento de la patente");
		}

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
