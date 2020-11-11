package ar.edu.unq.po2.tpintegrador;

public class AppUsuario {
	private ModoDeApp modoDeApp;
	private int numero;
	private int saldo;
	private String patente;
	private ISem sem;

	void setModo(ModoDeApp setModo) {
		this.modoDeApp = setModo;
	}

	void alertaDeInicioDeEstacionamiento() {
		
	}

	void alertaDeFinDeEstacionamiento() {
		modoDeApp.finEstacionamiento();
	}

	void estacionar(String patente, int numeroCelular, ISem sem) {
		// Deja que el modo de app actual se encargue
		modoDeApp.estacionar(patente, numeroCelular, sem);
	}

	void finDeEstacionamiento() {
		modoDeApp.finEstacionamiento();
	}

	public Integer getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}

}
