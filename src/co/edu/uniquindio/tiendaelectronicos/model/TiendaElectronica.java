package co.edu.uniquindio.tiendaelectronicos.model;

import java.util.ArrayList;

public class TiendaElectronica {

	private ArrayList<Cliente> listClientes ;
	private ArrayList<Producto> listProductos;
	private ArrayList<Sede> listSedes;
	private ArrayList<Ciudad> listCiudades;
	private ArrayList<Administrador> listAdministrador;
	private Administrador administradorNacional;
	
	public TiendaElectronica(Administrador administradorNacional) {
		this.administradorNacional = administradorNacional;
		listClientes = new ArrayList<Cliente>();
		listProductos = new ArrayList<Producto>();
		listSedes = new ArrayList<Sede>();
		listCiudades = new ArrayList<Ciudad>();
		listAdministrador = new ArrayList<Administrador>();
	}
	
	public ArrayList<Cliente> getListClientes() {
		return listClientes;
	}

	public void setListClientes(ArrayList<Cliente> listClientes) {
		this.listClientes = listClientes;
	}

	public ArrayList<Producto> getListProductos() {
		return listProductos;
	}

	public void setListProductos(ArrayList<Producto> listProductos) {
		this.listProductos = listProductos;
	}

	public ArrayList<Sede> getListSedes() {
		return listSedes;
	}

	public void setListSedes(ArrayList<Sede> listSedes) {
		this.listSedes = listSedes;
	}

	public ArrayList<Ciudad> getListCiudades() {
		return listCiudades;
	}

	public void setListCiudades(ArrayList<Ciudad> listCiudades) {
		this.listCiudades = listCiudades;
	}

	public ArrayList<Administrador> getListAdministrador() {
		return listAdministrador;
	}

	public void setListAdministrador(ArrayList<Administrador> listAdministrador) {
		this.listAdministrador = listAdministrador;
	}

	public Administrador getAdministradorNacional() {
		return administradorNacional;
	}

	public void setAdministradorNacional(Administrador administradorNacional) {
		this.administradorNacional = administradorNacional;
	}
	
}
