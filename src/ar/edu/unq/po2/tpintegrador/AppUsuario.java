package ar.edu.unq.po2.tpintegrador;

public class AppUsuario {
	private ModoDeApp modoDeApp;

	void alertaDeInicioDeEstacionamiento() {
		
	}

	void alertaDeFinDeEstacionamiento() {

	}

	void estacionar(String patente) {
		//Deja que el modo de app actual se encargue 
		modoDeApp.estacionar(patente);
	}

	void finDeEstacionamiento() {

	}

}
