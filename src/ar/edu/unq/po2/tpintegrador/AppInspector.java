package ar.edu.unq.po2.tpintegrador;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AppInspector {
	
	private List<Multa> listaDeMultas;
	
	
	
	public List<Multa> getListaDeMultas() {
		return this.listaDeMultas;
	}


	public void registrarMulta(String patente , LocalDate fecha, LocalTime hora , Inspector inspector) {
	  		
  	   this.listaDeMultas.add(new Multa(patente , fecha, hora , inspector, inspector.getPerteneceA()));
		
	}

}
