package ar.edu.unq.po2.tpintegrador;

public class AppUsuario implements MovementSensor {

	private ModoDeApp modoDeApp;
	private int numero;
	private int saldo;
	private String patente;
	private ISem sem;

	
	

	public AppUsuario(ModoDeApp modoDeApp, int numero, int saldo, String patente, ISem sem) {
		this.modoDeApp = modoDeApp;
		this.numero = numero;
		this.saldo = saldo;
		this.patente = patente;
		this.sem = sem;
	}
	
	public ISem getSem() {
		return sem;
	}


	private void setModo(ModoDeApp setModo) {
		this.modoDeApp = setModo;
	}

	public void modoManual() {
		this.setModo(new AppManual(this));
	}

	public void modoAutomatico() {
		this.setModo(new AppAutomatica(this));
	}

	void alertaDeInicioDeEstacionamiento() {
		modoDeApp.estacionar();
	}

	void alertaDeFinDeEstacionamiento() {
		modoDeApp.finDeEstacionamiento();
	}

	void estacionar() {
		// Deja que el modo de app actual se encargue
		modoDeApp.estacionar();
	}

	void finDeEstacionamiento() {
		modoDeApp.finDeEstacionamiento();
	}

	public Integer getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}

	@Override
	public void driving() {
		if (!(sem.existeEstacionamientoDe(this.getPatente()))) {// Falta definir sem y gps
			this.alertaDeFinDeEstacionamiento();
		}
	}

	@Override
	public void walking() {
		if (sem.existeEstacionamientoDe(this.getPatente())) {// Falta definir sem y gps
			this.alertaDeInicioDeEstacionamiento();
		}
	}

	public int getNumero() {
		return numero;
	}

	public String getPatente() {
		return patente;
	}

}
