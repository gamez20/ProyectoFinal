package co.edu.uniquindio.tiendaelectronicos.model;

import java.util.ArrayList;

public class Venta {

	private Cliente cliente;
	private Sede sede;
	private String sedeNombre;
	private String nombreProducto;
	private TipoTarjeta tipoTarjeta;
	private ArrayList<DetalleVenta> listDetalleVenta = new ArrayList<DetalleVenta>();
	private double total;
	
	public Venta(Cliente cliente, Sede sede) {
		this.cliente = cliente;
		this.sede = sede;
		this.sedeNombre = this.sede.getNombre();
		this.tipoTarjeta = cliente.getTarjeta().getTipoTarjeta();
	}
	
	public void setDetalleVenta(DetalleVenta detalleVenta){
		this.listDetalleVenta.add(detalleVenta);
		setTotal();
	}

	
	
	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public TipoTarjeta getTipoTarjeta() {
		return tipoTarjeta;
	}

	public void setTipoTarjeta(TipoTarjeta tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}

	public String getSedeNombre() {
		return sedeNombre;
	}

	public void setSedeNombre(String sedeNombre) {
		this.sedeNombre = sedeNombre;
	}

	public void setTotal(double total) {
		this.total = total;
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

	public double getTotal() {
		return total;
	}

	public void setTotal() {
		double total = 0;
		
		for (int i = 0; i < listDetalleVenta.size(); i++) {
			total += listDetalleVenta.get(i).getValor();
		}
		
		this.total = total;
	}
	
	
		
}
