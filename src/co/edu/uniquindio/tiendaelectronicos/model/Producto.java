package co.edu.uniquindio.tiendaelectronicos.model;

public class Producto {

	//Variables
	
	private int codigo;
	private String sede;
	private String nombre;
	private double valor;
	private CategoriaProducto categoriaProducto;
	private int stock;
	
	public Producto(int codigo, String sede, String nombre, double valor, CategoriaProducto categoriaProducto, int stock) {
		this.codigo = codigo;
		this.sede = sede;
		this.nombre = nombre;
		this.valor = valor;
		this.categoriaProducto = categoriaProducto;
		this.stock = stock;
	}
		
	public CategoriaProducto getCategoriaProducto() {
		return categoriaProducto;
	}

	public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}
	
	
}
