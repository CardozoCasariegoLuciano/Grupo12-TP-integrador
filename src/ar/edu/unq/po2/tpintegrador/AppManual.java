package ar.edu.unq.po2.tpintegrador;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.Temporal;

public class AppManual implements ModoDeApp {

	private AppUsuario app;
	private LocalTime horaInicioEstacionamiento;
	private LocalTime horaFinDeEstacionamiento;
	
	
	public AppManual(AppUsuario app) {
		this.app = app;

	}


	@Override
	public void estacionar() {
		if (app.seEncuentraEnZona()) {
			if (this.app.getSaldo() > this.app.sem.getCosto()&& !(this.app.sem.existeEstacionamientoDe(this.app.getPatente()))) {
				this.app.decrementarSaldo( this.app.sem.getCosto());
				this.app.sem.registrarEstacionamientoViaApp(new EstacionamientoViaApp(app));
				this.horaInicioEstacionamiento = LocalTime.now();
				this.alertaDeInicioDeEstacionamiento();
			} else
				System.out.println("Saldo insuficiente.\n Estacionamiento no permitido.");
		} else {
			System.out.println("No se encuentra en una zona de Estacionamiento");
		}
	}

	@Override
	public void finDeEstacionamiento() {
		if ((this.app.sem.existeEstacionamientoDe(this.app.getPatente()))) {
			this.app.sem.finalizarEstacionamientoViaApp(this.app.getNumero());
			this.alertaDeFinDeEstacionamiento();

		} else {
			System.out.println("No existe estacionamiento de la patente");
		}

	}
	
	
	public AppUsuario getApp() {
		return this.app;
	}
	
	@Override
	public void alertaDeInicioDeEstacionamiento() {
		System.out.println("Inicio de Estacionamiento exitoso \n Hora de Inicio:" + LocalTime.now() + LocalDate.now() );

	}

	@Override
	public void alertaDeFinDeEstacionamiento() {
		System.out.println("Fin de Estacionamiento exitoso\n Cantidad de Horas:" + this.cantidadDeHoras() );

	}
	
	public Duration cantidadDeHoras() {
		return Duration.between(this.horaInicioEstacionamiento,this.horaFinDeEstacionamiento).abs();
	}
}
