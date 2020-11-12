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
			this.alertaDeInicioDeEstacionamiento();
		} else
			System.out.println("Saldo insuficiente. Estacionamiento no permitido.");
	}

	@Override
	public void finDeEstacionamiento() {
		if (!(this.app.getSem().existeEstacionamientoDe(this.app.getPatente()))) {

			this.app.getSem().finalizarEstacionamientoViaApp(this.app.getNumero());
			this.alertaDeFinDeEstacionamiento();

		} else {
			System.out.println("No existe estacionamiento de la patente");
		}

	}

	@Override
	public void inicioDeEstacionamientoAutomatico() {
		// No se usan de manera manual

	}

	@Override
	public void finDeEstacionamientoAutomatico() {
		// No se usan de manera manual

	}

	@Override
	public void alertaDeInicioDeEstacionamiento() {
		System.out.println("Estacionamiento Exitoso");

	}

	@Override
	public void alertaDeFinDeEstacionamiento() {
		System.out.println("Fin de Estacionamiento Exitoso");

	}

}
