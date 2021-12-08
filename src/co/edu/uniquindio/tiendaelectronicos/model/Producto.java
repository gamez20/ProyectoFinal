package co.edu.uniquindio.tiendaelectronicos.model;

public class Producto {

	//Variables
	
	private int codigo;
	private Sede sede;
	private String nombre;
	private double valor;
	
	
	public Producto(int codigo, Sede sede, String nombre, double valor) {
		this.codigo = codigo;
		this.sede = sede;
		this.nombre = nombre;
		this.valor = valor;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Sede getSede() {
		return sede;
	}
	public void setSede(Sede sede) {
		this.sede = sede;
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
	
	
}
