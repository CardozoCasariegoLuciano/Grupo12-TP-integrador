package ar.edu.unq.po2.tpintegrador;

////Falta validación de zona y retorno de fin de estacionamiento 

public class AppUsuario implements MovementSensor, Gps {

	private ModoDeApp modoDeApp;
	private int numero;
	private int saldo;
	private String patente;
	protected Sem sem;

	public AppUsuario(ModoDeApp modoDeApp, int numero, int saldo, String patente, Sem semClase) {
		this.modoDeApp = modoDeApp;
		this.numero = numero;
		this.saldo = saldo;
		this.patente = patente;
		this.sem = semClase;
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

	public void estacionar() {

		modoDeApp.estacionar();
	}

	public void finDeEstacionamiento() {
		modoDeApp.finDeEstacionamiento();
	}

	/// METODOS ESTACIONAMIENTO AUTOMATICO

	private void inicioDeEstacionamientoAutomatico() {
		modoDeApp.inicioDeEstacionamientoAutomatico();
		modoDeApp.alertaDeInicioDeEstacionamiento();

	}

	private void finDeEstacionamientoAutomatico() {
		modoDeApp.finDeEstacionamientoAutomatico();
		modoDeApp.alertaDeFinDeEstacionamiento();

	}

	/// MovementSensor/////////
	@Override
	public void driving() {
			this.finDeEstacionamientoAutomatico();
		
	}

	@Override
	public void walking() {
			this.inicioDeEstacionamientoAutomatico();
		
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



	public Object getModo() {
		
		return this.modoDeApp;
	}



	public boolean seEncuentraEnZona() {
		// TODO Auto-generated method stub
		
		return false;
	}
	
	public void aumentarSaldo(int unSaldo) {
		saldo = saldo + unSaldo;
	}
}
