package co.edu.uniquindio.tiendaelectronicos.model;

/**
 * 
 * @author Gamez
 *
 */
public class Cliente extends Persona{

	// variables
	private String ciudad;
	private String departamento;
	private Tarjeta tarjeta;

	/**
	 * Constructor
	 * @param ciudad
	 * @param departamento
	 */
	public Cliente(String id,String nombre,String direccion,String fechaNacimiento,String correo,String ciudad,String departamento){
		super( id,nombre, direccion, fechaNacimiento,correo);
		this.ciudad=ciudad;
		this.departamento = departamento;
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

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}	
	
	
}
