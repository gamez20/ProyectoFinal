package co.edu.uniquindio.tiendaelectronicos.model;

import java.util.ArrayList;

public class Sede {

	private String nombre;
	private int id;
	private Administrador administrador;
	private ArrayList<Producto> listProductos;
	
	public Sede(String nombre, int id, Administrador administrador) {
		this.nombre = nombre;
		this.id = id;
		this.administrador = administrador;
		this.listProductos = new ArrayList<Producto>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public ArrayList<Producto> getListProductos() {
		return listProductos;
	}

	public void setListProductos(ArrayList<Producto> listProductos) {
		this.listProductos = listProductos;
	}
	
	
}
