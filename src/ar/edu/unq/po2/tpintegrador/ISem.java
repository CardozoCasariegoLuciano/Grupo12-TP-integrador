package ar.edu.unq.po2.tpintegrador;

public interface ISem {

  abstract	public boolean existeEstacionamientoDe(String unaPatente);
  abstract  public void registrarEstacionamientoViaApp(EstacionamientoViaApp unEstacionamiento);
  abstract  public void registrarEstacionamientoViaPuntoDeVenta(EstacionamientoViaPuntoDeVenta unEstacionamiento);
  abstract void finalizarEstacionamientoViaApp(int numero);
  public  void cargarCredito(float unMonto, AppUsuario unaAppusuario);
		
	

}
