package co.edu.uniquindio.tiendaelectronicos.model;

public enum TipoTarjeta {

	DEBITO(0),CREDITO(1);

	private int numCategoriaProducto;

	TipoTarjeta(int numCategoriaProducto){
		this.numCategoriaProducto = numCategoriaProducto;
	}

	public int getNumTipoVehiculo() {
		return numCategoriaProducto;
	}

}
