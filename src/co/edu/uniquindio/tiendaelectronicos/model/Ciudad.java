package co.edu.uniquindio.tiendaelectronicos.model;

public class Ciudad {

	private String nombre;
	private int id;
	
	public Ciudad(String nombre, int id) {
		this.nombre = nombre;
		this.id = id;
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
	
}
