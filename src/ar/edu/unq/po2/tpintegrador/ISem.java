package ar.edu.unq.po2.tpintegrador;

public interface ISem {

  abstract	public boolean existeEstacionamientoDe(String unaPatente);
  abstract  public void registrarEstacionamientoViaApp(RegistroViaApp unEstacionamiento);
  abstract  public void registrarEstacionamientoViaPuntoDeVenta(RegistroViaPuntoFijo unEstacionamiento);
		
	

}
