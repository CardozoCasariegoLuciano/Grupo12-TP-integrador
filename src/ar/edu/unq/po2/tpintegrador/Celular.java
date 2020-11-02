package ar.edu.unq.po2.tpintegrador;

public class Celular {
 //test
	private String numero;
	private Integer saldo;
	private AppUsuario app;
	
	

	public Integer getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public String getNumero() {
		return numero;
	}
	public void estacionar(String patente) {
		//Envia mensaje a la app dentro del celular y es quien se encargaria de enviar mensaje al sistema
		app.estacionar(patente);
		
	}
	public void finDeEstacionamiento() {
		// TODO Auto-generated method stub
		
	}
	
}

