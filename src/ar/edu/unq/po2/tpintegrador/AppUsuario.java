package ar.edu.unq.po2.tpintegrador;

////Falta validación de zona y retorno de fin de estacionamiento 

public class AppUsuario implements MovementSensor, Gps {

	private ModoDeApp modoDeApp;
	private int numero;
	private int saldo;
	private String patente;
	protected ISem sem;
	protected Sem semClase;

	public AppUsuario(ModoDeApp modoDeApp, int numero, int saldo, String patente, ISem semInterfaz, Sem semClase) {
		this.modoDeApp = modoDeApp;
		this.numero = numero;
		this.saldo = saldo;
		this.patente = patente;
		this.sem = sem;
		this.semClase = semClase;
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

//	void alertaDeInicioDeEstacionamiento() {
//	
//	}
//
//	void alertaDeFinDeEstacionamiento() {
//		
//	}

	public Integer getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public String getPatente() {
		return patente;
	}

	/// METODOS DE ESTACIONAMIENTO MANUAL

	void estacionar() {

		modoDeApp.estacionar();
	}

	void finDeEstacionamiento() {
		modoDeApp.finDeEstacionamiento();
	}

	/// METODOS ESTACIONAMIENTO AUTOMATICO

	private void inicioDeEstacionamientoAutomatico() {
		modoDeApp.inicioDeEstacionamientoAutomatico();

	}

	private void finDeEstacionamientoAutomatico() {
		modoDeApp.finDeEstacionamientoAutomatico();

	}

	/// MovementSensor/////////
	@Override
	public void driving() {
		if (sem.existeEstacionamientoDe(this.getPatente()) && this.modoDeApp == modoDeApp) {// Falta definir sem y gps
			this.finDeEstacionamientoAutomatico();
		}
	}

	@Override
	public void walking() {
		if (!(sem.existeEstacionamientoDe(this.getPatente()))) {// Falta definir sem y gps
			this.inicioDeEstacionamientoAutomatico();
		}
	}

	/////////////////

	/// GPS///////////////////////
	@Override
	public void cambiarPosicion() {
		// No sabemos como se define

	}

	@Override
	public void getPosition() {
		// No sabemos como se define

	}
	/////////////////////////////
}
