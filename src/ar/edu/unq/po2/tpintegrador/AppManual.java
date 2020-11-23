package ar.edu.unq.po2.tpintegrador;

import com.sun.org.apache.xpath.internal.operations.Equals;

public class AppManual implements ModoDeApp {

	private AppUsuario app;

	public AppManual(AppUsuario app) {
		this.app = app;

	}

	@Override
	public void estacionar() {
		if (app.seEncuentraEnZona()) {
			if (this.app.getSaldo() > this.app.sem.getCosto()) {
				// && this.app.getPosition() == Falta la validación del sem
				this.app.sem.registrarEstacionamientoViaApp(new EstacionamientoViaApp(app));
				this.alertaDeInicioDeEstacionamiento();
			} else
				System.out.println("Saldo insuficiente. Estacionamiento no permitido.");
		} else {
			System.out.println("No se encuentra en un una zona de Estacionamiento");
		}
	}

	@Override
	public void finDeEstacionamiento() {
		if (!(this.app.sem.existeEstacionamientoDe(this.app.getPatente()))) {

			this.app.sem.finalizarEstacionamientoViaApp(this.app.getNumero());
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
