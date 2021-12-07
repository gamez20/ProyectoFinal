package co.edu.uniquindio.tiendaelectronicos.model;

public class Administrador  extends Persona{
	
	private String estudios;
	
	public Administrador(int id, String nombre,String direccion,String fechaNacimiento,String correo,String estudios){
		super(id,nombre,direccion,fechaNacimiento,correo);
		this.estudios=estudios;
		
	}
	
	// Setter Getter
	
	public String getEstudios() {
		return estudios;
	}

	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}

	@Override
	public String toString() {
		return "estudios=" + estudios + ", getEstudios()=" + getEstudios() + super.toString() + "]";
	}
	

}
