package co.edu.uniquindio.tiendaelectronicos.model;

/**
 * 
 * @author Gamez
 *
 */

public class Persona {
	
	// Variables de Persona
	
	private int id;
	private  String nombre;
	private String direccion;
	private String fechaNacimiento;
	private String correo;
	
	
	/**
	 * Constructor 1 
	 * @param id
	 * @param nombre
	 * @param direccion
	 * @param fechaNacimiento
	 * @param correo
	 */
	public Persona (int id, String nombre,String direccion,String fechaNacimiento,String correo){
		
		this.id = id;
		this.nombre = nombre;
		this.direccion=direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.correo = correo;
	}

	//Getter Setter

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
}
