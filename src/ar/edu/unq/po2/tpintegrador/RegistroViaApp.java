package ar.edu.unq.po2.tpintegrador;

import java.time.LocalDate;
import java.time.LocalTime;

public class RegistroViaApp extends RegistroEstacionamiento{
	private int cantDeHoras;
	
public RegistroViaApp(int cantDeHoras, String unaPatente) {
		
		this.cantDeHoras = cantDeHoras;
		
		
		RegistroDeCompra.numeroDeRegistro ++;
		this.hora = LocalTime.now();
		this.fecha = LocalDate.now();
		
		this.patente = unaPatente;
		this.estaActivo = true;
		this.horaFinal = this.hora.plusHours(this.cantDeHoras);
	}
	@Override
	public boolean comprobarValidez() {
		// TODO Auto-generated method stub
		return false;
	}
  
}
