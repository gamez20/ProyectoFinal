package co.edu.uniquindio.tiendaelectronicos.model;

public class Tarjeta {
	
	private String numero;
	private TipoTarjeta tipoTarjeta;
	private String cvv;
	private String fechaVencimiento;
	
	public Tarjeta(String numero, TipoTarjeta tipoTarjeta, String cvv, String fechaVencimiento) {
		super();
		this.numero = numero;
		this.tipoTarjeta = tipoTarjeta;
		this.cvv = cvv;
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public TipoTarjeta getTipoTarjeta() {
		return tipoTarjeta;
	}

	public void setTipoTarjeta(TipoTarjeta tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	

}
