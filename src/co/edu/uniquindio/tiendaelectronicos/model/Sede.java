package co.edu.uniquindio.tiendaelectronicos.model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Sede {

	private String nombre;
	private int id;
	private Administrador administrador;
	private ObservableList<Producto> listProductos;
	private ObservableList<Venta> listCompras;
	
	public Sede(String nombre, int id, Administrador administrador) {
		this.nombre = nombre;
		this.id = id;
		this.administrador = administrador;
		this.listProductos = FXCollections.observableArrayList();
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

	public ObservableList<Producto> getListProductos() {
		return listProductos;
	}

	public void setListProductos(ObservableList<Producto> listProductos) {
		this.listProductos = listProductos;
	}

	public ObservableList<Venta> getListCompras() {
		return listCompras;
	}
	
	public void setListCompras(ObservableList<Venta> listCompras) {
		this.listCompras = listCompras;
	}
	
}
