package ar.edu.unq.po2.tpintegrador;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class AppAutomatica implements ModoDeApp {

	private AppUsuario app;
	private LocalTime horaInicioEstacionamiento;
	private LocalTime horaFinDeEstacionamiento;

	public AppAutomatica(AppUsuario app) {
		this.app = app;

	}

	
	@Override
	public void estacionar() {
		if (app.seEncuentraEnZona()) {
			if (this.app.getSaldo() > this.app.sem.getCosto() && !(this.app.sem.existeEstacionamientoDe(this.app.getPatente()))) {
				this.app.setSaldo(app.getSaldo() - this.app.sem.getCosto());
				this.app.sem.registrarEstacionamientoViaApp(new EstacionamientoViaApp(app));
				this.horaInicioEstacionamiento = LocalTime.now();
				this.alertaDeInicioDeEstacionamiento();
			} else
				System.out.println("Saldo insuficiente. Estacionamiento no permitido.");
		} else {
			System.out.println("No se encuentra en una zona de Estacionamiento");
		}
	}

	
	@Override
	public void finDeEstacionamiento() {
		if ((this.app.sem.existeEstacionamientoDe(this.app.getPatente()))) {
			this.app.decrementarSaldo( this.app.sem.getCosto());
			this.app.sem.finalizarEstacionamientoViaApp(this.app.getNumero());
			this.horaFinDeEstacionamiento = LocalTime.now();
			this.alertaDeFinDeEstacionamiento();

		} else {
			System.out.println("No existe estacionamiento de la patente");
		}

		// new AppManual(this.app).finDeEstacionamiento();
	}

	

	@Override
	public void alertaDeInicioDeEstacionamiento() {
		System.out.println("Inicio de Estacionamiento exitoso" + LocalTime.now() + LocalDate.now() );

	}

	@Override
	public void alertaDeFinDeEstacionamiento() {
		System.out.println("Fin de Estacionamiento exitoso\n" + "Cantidad de Horas:" + this.cantidadDeHoras() );

	}
	
	public Duration cantidadDeHoras() {
		return Duration.between(this.horaInicioEstacionamiento,this.horaFinDeEstacionamiento).abs();
	}

}
