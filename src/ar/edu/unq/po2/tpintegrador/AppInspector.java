package ar.edu.unq.po2.tpintegrador;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AppInspector {
	
	//Variables
	private List<Multa> listaDeMultas;
	
	
	//Constructor
	public AppInspector() {
		this.listaDeMultas = new ArrayList<Multa>();
	}

	//Getter
	public List<Multa> getListaDeMultas() {
		return this.listaDeMultas;
	}

	//Metodos
	public void registrarMulta(String patente , LocalDate fecha, LocalTime hora , Inspector inspector) {  
	  		
  	   this.listaDeMultas.add(new Multa(patente , fecha, hora , inspector, inspector.getPerteneceA()));		
	}

}
