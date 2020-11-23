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
		if (app.seEncuentraEnZona()) {
			if (this.app.getSaldo() > this.app.sem.getCosto()
					&& !(this.app.sem.existeEstacionamientoDe(this.app.getPatente()))) {
				// && this.app.getPosition() == Falta la validación del sem
				this.app.sem.registrarEstacionamientoViaApp(new EstacionamientoViaApp(app));
				this.alertaDeInicioDeEstacionamiento();
			} else
				System.out.println("Saldo insuficiente. Estacionamiento no permitido.");
		} else {
			System.out.println("No existe estacionamiento de la patente");
		}
	}

	// new AppManual(this.app).estacionar();

	@Override
	public void finDeEstacionamientoAutomatico() {
		if ((this.app.sem.existeEstacionamientoDe(this.app.getPatente()))) {

			this.app.sem.finalizarEstacionamientoViaApp(this.app.getNumero());
			this.alertaDeFinDeEstacionamiento();

		} else {
			System.out.println("No existe estacionamiento de la patente");
		}

		// new AppManual(this.app).finDeEstacionamiento();
	}

	@Override
	public void alertaDeInicioDeEstacionamiento() {
		System.out.println("Inicio de Estacionamiento exitoso");

	}

	@Override
	public void alertaDeFinDeEstacionamiento() {
		System.out.println("Fin de Estacionamiento exitoso");

	}

}
