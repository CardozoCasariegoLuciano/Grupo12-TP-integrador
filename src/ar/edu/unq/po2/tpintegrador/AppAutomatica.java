package ar.edu.unq.po2.tpintegrador;

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
			if (this.app.getSaldo() > this.app.sem.getCosto()
					&& !(this.app.sem.existeEstacionamientoDe(this.app.getPatente()))) {
				this.app.decrementarSaldo(this.app.sem.getCosto());
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
			this.app.sem.finalizarEstacionamientoViaApp(this.app.getNumero());
			this.horaFinDeEstacionamiento = LocalTime.now();
			this.alertaDeFinDeEstacionamiento();

		} else {
			System.out.println("No existe estacionamiento de la patente");
		}

	}

	@Override
	public void alertaDeInicioDeEstacionamiento() {
		System.out.println("Inicio de Estacionamiento exitoso \n Hora de Inicio:" + LocalTime.now() + LocalDate.now());

	}

	@Override
	public void alertaDeFinDeEstacionamiento() {
		System.out.println("Fin de Estacionamiento exitoso\n HoraDeInicio:" + this.horaInicioEstacionamiento + ".\n"
				+ "HoraDeFin:" + this.horaFinDeEstacionamiento + ".\n" + "Cantidad de Horas:" + this.cantidadDeHoras()
				+ "PrecioTotal:" + ".\n" + this.precioTotal());

	}

	public float precioTotal() {
		return (this.app.sem.getCosto() * this.cantidadDeHoras());
	}

	public int cantidadDeHoras() {
		return Math.abs(this.horaInicioEstacionamiento.getHour() - this.horaFinDeEstacionamiento.getHour());
	}

}
