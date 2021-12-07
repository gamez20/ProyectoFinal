package co.edu.uniquindio.tiendaelectronicos.model;

/**
 * 
 * @author Gamez
 *
 */
public class Cliente extends Persona{

	// variable
	private String nombre;
	private String direccion;
	private String fechaNacimiento;
	private String correo;
	private String ciudad;
	private String departamento;

	/**
	 * Constructor
	 * @param id
	 * @param nombre
	 * @param direccion
	 * @param fechaNacimiento
	 * @param correo
	 * @param ciudad
	 * @param departamento
	 */
	public Cliente(int id,String nombre,String direccion,String fechaNacimiento,String correo,String ciudad,String departamento){
		super( id,nombre, direccion, fechaNacimiento,correo);
		this.ciudad=ciudad;
		this.departamento = departamento;
	}


	//Seeder Getter
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
	
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}	
	
}
