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
	
	
	public void setHoraInicioEstacionamiento(LocalTime horaInicioEstacionamiento) {
		this.horaInicioEstacionamiento = horaInicioEstacionamiento;
	}


	public void setHoraFinDeEstacionamiento(LocalTime horaFinDeEstacionamiento) {
		this.horaFinDeEstacionamiento = horaFinDeEstacionamiento;
	}
	
	public LocalTime getHoraInicioEstacionamiento() {
		return horaInicioEstacionamiento;
	}

	public LocalTime getHoraFinDeEstacionamiento() {
		return horaFinDeEstacionamiento;
	}

	@Override
	public void estacionar() {
		if (app.seEncuentraEnZona()) {
			if (this.app.getSaldo() > this.app.sem.getCosto()
					&& !(this.app.sem.existeEstacionamientoDe(this.app.getPatente()))) {
				this.app.decrementarSaldo(this.app.sem.getCosto());
				this.app.sem.registrarEstacionamientoViaApp(new EstacionamientoViaApp(app));
				this.setHoraInicioEstacionamiento(LocalTime.now());
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
			this.setHoraFinDeEstacionamiento(LocalTime.now());
			this.alertaDeFinDeEstacionamiento();

		} else {
			System.out.println("No existe estacionamiento de la patente");
		}

	}


	@Override
	public void alertaDeInicioDeEstacionamiento() {
		System.out.println("Inicio de Estacionamiento exitoso \n Hora de Inicio:" + LocalTime.now().getHour() + LocalDate.now());

	}

	@Override
	public void alertaDeFinDeEstacionamiento() {
		System.out.println("Fin de Estacionamiento exitoso\n HoraDeInicio:" + this.getHoraInicioEstacionamiento() + ".\n"
				+ "HoraDeFin:" + this.getHoraFinDeEstacionamiento() + ".\n" + "Cantidad de Horas:" + this.cantidadDeHoras()
				+ "PrecioTotal:" + ".\n" + this.precioTotal());

	}
	
	



	public float precioTotal() {
		return (this.app.sem.getCosto() * this.cantidadDeHoras());
	}

	
	public int cantidadDeHoras() {
		return Math.abs(this.getHoraInicioEstacionamiento().getHour() - this.getHoraFinDeEstacionamiento().getHour());
	}


	



	

	
}
