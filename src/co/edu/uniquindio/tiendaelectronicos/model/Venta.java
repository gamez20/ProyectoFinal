package co.edu.uniquindio.tiendaelectronicos.model;

import java.util.ArrayList;

public class Venta {

	private Cliente cliente;
	private Sede sede;
	private ArrayList<DetalleVenta> listDetalleVenta = new ArrayList<DetalleVenta>();
	
	public Venta(Cliente cliente, Sede sede, DetalleVenta detalleVenta) {
		this.cliente = cliente;
		this.sede = sede;
		this.listDetalleVenta.add(detalleVenta);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public ArrayList<DetalleVenta> getListDetalleVenta() {
		return listDetalleVenta;
	}

	public void setListDetalleVenta(ArrayList<DetalleVenta> listDetalleVenta) {
		this.listDetalleVenta = listDetalleVenta;
	}
		
}
