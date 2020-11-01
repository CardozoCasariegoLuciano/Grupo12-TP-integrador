package ar.edu.unq.po2.tpintegrador;

public class Inspector {
   
	private Zona perteneceA;
	private AppInspector dispositivoMovil;
	
	
	public Inspector(Zona perteneceA, AppInspector dispositivoMovil) {
		this.setPerteneceA(perteneceA);
		this.setDispositivoMovil(dispositivoMovil);
	}


	private Zona getPerteneceA() {
		return perteneceA;
	}


	private void setPerteneceA(Zona perteneceA) {
		this.perteneceA = perteneceA;
	}


	private AppInspector getDispositivoMovil() {
		return dispositivoMovil;
	}


	private void setDispositivoMovil(AppInspector dispositivoMovil) {
		this.dispositivoMovil = dispositivoMovil;
	}
	
	
	
	
	
}
