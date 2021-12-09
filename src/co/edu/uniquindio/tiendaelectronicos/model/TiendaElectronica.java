package co.edu.uniquindio.tiendaelectronicos.model;


import co.edu.uniquindio.tiendaelectronicos.test.TestData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TiendaElectronica {

	private ObservableList<Cliente> listClientes ;
	private ObservableList<Producto> listProductos;
	private ObservableList<Sede> listSedes;
	private ObservableList<Ciudad> listCiudades;
	private ObservableList<Administrador> listAdministrador;
	private Administrador administradorNacional;
	private int idProducto = 1;
	
	
	
	public TiendaElectronica(Administrador administradorNacional) {
		//data
		this.administradorNacional = administradorNacional;
		listClientes = FXCollections.observableArrayList();
		listProductos = FXCollections.observableArrayList();
		listSedes = FXCollections.observableArrayList();
		listCiudades = FXCollections.observableArrayList();
		listAdministrador = FXCollections.observableArrayList();
		
	
		Cliente cliente;
		cliente=new Cliente("1233","santiago","skdflsk","200/15/10","gamez.guerr@sdkf","Armenia","sdlkfj");
		listClientes.add(cliente);
		
		cliente=new Cliente("222","maria","ss","200/15/10","gamez.guerr@sdkf","Armenia","sdlkfj");
		listClientes.add(cliente);
	}
	
	public ObservableList<Cliente> getListClientes() {
		return listClientes;
	}

	public void setListClientes(ObservableList<Cliente> listClientes) {
		this.listClientes = listClientes;
	}

	public ObservableList<Producto> getListProductos() {
		return listProductos;
	}

	public void setListProductos(ObservableList<Producto> listProductos) {
		this.listProductos = listProductos;
	}

	public ObservableList<Sede> getListSedes() {
		return listSedes;
	}

	public void setListSedes(ObservableList<Sede> listSedes) {
		this.listSedes = listSedes;
	}

	public ObservableList<Ciudad> getListCiudades() {
		return listCiudades;
	}

	public void setListCiudades(ObservableList<Ciudad> listCiudades) {
		this.listCiudades = listCiudades;
	}

	public ObservableList<Administrador> getListAdministrador() {
		return listAdministrador;
	}

	public void setListAdministrador(ObservableList<Administrador> listAdministrador) {
		this.listAdministrador = listAdministrador;
	}

	public Administrador getAdministradorNacional() {
		return administradorNacional;
	}

	public void setAdministradorNacional(Administrador administradorNacional) {
		this.administradorNacional = administradorNacional;
	}

	public boolean validFieldsCliente(int documento, String nombre, String direccion, String correo, String fechaNac,
			String departamento, String ciudad) {
		
		boolean valid = true;
		
		if (documento == 0 || nombre.equalsIgnoreCase("") || direccion.equalsIgnoreCase("")|| correo.equalsIgnoreCase("") || fechaNac.equalsIgnoreCase("") || departamento.equalsIgnoreCase("") || ciudad.equalsIgnoreCase("")) {
			valid = false;
		}
		
		return valid;
	}

	public Cliente crearCliente(String documento, String nombre, String direccion, String correo, String fechaNac,
			String departamento, String ciudad) {
		
		Cliente cliente= null;
		
		//validar si el cliente exite con ese documento 
		cliente = obtenerCliente(documento);
		
		if(cliente == null ){
			 cliente = new Cliente(documento,nombre,direccion,correo,fechaNac,departamento,ciudad);
			 getListClientes().add(cliente);
		}
		
		return cliente;
		
	}

	private Cliente obtenerCliente(String documento) {
		
		for (Cliente cliente : listClientes) {
			if(cliente.getId().equals(documento)){
				return cliente;
			}
		}
		
		return null;
	}


	public boolean actualizarCliente(String documento, String nombre, String direccion, String correo, String fechaNac,
			String departamento, String ciudad) {
		Cliente cliente = null;
		
		cliente=obtenerCliente(documento);
		
		if (cliente!=null){
			
			cliente.setId(documento);
			cliente.setNombre(nombre);
			cliente.setDireccion(direccion);
			cliente.setCorreo(correo);
			cliente.setFechaNacimiento(fechaNac);
			cliente.setDepartamento(departamento);
			cliente.setCiudad(ciudad);
			return true;
			
		}
		
		return false;
	}
	
	public boolean eliminarCliente(String documento){
		
		Cliente cliente = null;
		
		cliente = obtenerCliente(documento);
		
		if(cliente !=null){
			getListClientes().remove(cliente);
			return true;
		}
		return false;
	}

	public Producto crearProducto(String nombre, double precio, int stock, String sede, CategoriaProducto categoria) {
		
		Producto producto = new Producto(idProducto,sede,nombre,precio,categoria,stock);
		listProductos.add(producto);
		this.idProducto += 1;
		return producto;
	}

	public Producto actualizarProducto(int idProducto, int codigo, String nombre, double precio, int stock,
			String sede, CategoriaProducto categoria) {
		
		for (Producto producto : listProductos) {
			if(producto.getCodigo() == idProducto){
				
				producto.setCodigo(codigo);
				producto.setNombre(nombre);
				producto.setValor(precio);
				producto.setStock(stock);
				producto.setCategoriaProducto(categoria);
				producto.setSede(sede);
				
				return producto;
				
			}
		}
		
		return null;
	}

	public boolean eliminarProducto(int codigo) {
		
		for (int i = 0; i < listProductos.size(); i++) {
			if (listProductos.get(i).getCodigo() == codigo) {
				listProductos.remove(i);
				return true;
			}
		}

		return false;
	}
	
}
