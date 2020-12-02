package ar.edu.unq.po2.tpintegrador;

////Falta validaci�n de zona y retorno de fin de estacionamiento 

public class AppUsuario implements MovementSensor, Gps {

	//Variables
	private ModoDeApp modoDeApp;
	private int numero;
	private float saldo;
	protected Sem sem;
	private Conductor conductor;

	//Construtor
	public AppUsuario(int numero, Sem semClase, Conductor conductor, ModoDeApp unModo) {
		
		this.modoDeApp = unModo;
		this.numero = numero;
		this.saldo = 0;
		this.sem = semClase;
		this.conductor = conductor;	
	}


	
	public Conductor getConductor() {
		
		return this.conductor;
	}

	public float getSaldo() {
		
		return saldo;
	}
	
	public int getNumero() {
		return numero;
	}

	public String getPatente() {
		return this.conductor.getPatente();
	
	}	
	
	public ModoDeApp getModo() {

		return this.modoDeApp;
	}

	//Setters	
	
	
	public void setModo(ModoDeApp unModo) {
		
		this.modoDeApp = unModo;
	}
	
	//Metodos
	
	
	public void modoManual() {
		
		this.modoDeApp = new AppManual(this);
	}

	public void modoAutomatico() {
		
		this.modoDeApp = new AppAutomatica(this);
	}
	
	public void aumentarSaldo(float unSaldo) {
		
		saldo = saldo + unSaldo;
	}
	
	public void decrementarSaldo(float saldoADecrementar) {
		
		saldo = saldo - saldoADecrementar;
	}

	/// METODOS DE ESTACIONAMIENTO

	public void estacionar() {
		modoDeApp.estacionar();
	}

	public void finDeEstacionamiento() {
		modoDeApp.finDeEstacionamiento();
	}



 
	/// MovementSensor/////////
	@Override
	public void driving() {
		modoDeApp.finDeEstacionamiento();
		//this.finDeEstacionamientoAutomatico();
	}

	@Override
	public void walking() {
		modoDeApp.estacionar();
		//this.inicioDeEstacionamientoAutomatico();
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

	

	public boolean seEncuentraEnZona() {
		// TODO Auto-generated method stub

		return true;
	}
	
}
