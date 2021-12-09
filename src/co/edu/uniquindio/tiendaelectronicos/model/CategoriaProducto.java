package co.edu.uniquindio.tiendaelectronicos.model;

public enum CategoriaProducto {


	HOGAR(0),EMPRESARIALES(1),ENTRETENIMIENTO(2);

	private int numCategoriaProducto;

	CategoriaProducto(int numCategoriaProducto){
		this.numCategoriaProducto = numCategoriaProducto;
	}

	public int getNumTipoVehiculo() {
		return numCategoriaProducto;
	}

}
