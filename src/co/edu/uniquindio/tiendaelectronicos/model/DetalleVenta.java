package co.edu.uniquindio.tiendaelectronicos.model;

public class DetalleVenta {

	private Producto producto;

	public DetalleVenta(Producto producto) {
		super();
		this.producto = producto;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public double getValor() {
		return producto.getValor();
	}
	
}
