package co.edu.uniquindio.tiendaelectronicos.controller;

import java.util.Optional;

import co.edu.uniquindio.tiendaelectronicos.Aplicacion;
import co.edu.uniquindio.tiendaelectronicos.model.Cliente;
import co.edu.uniquindio.tiendaelectronicos.model.TiendaElectronica;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;


public class TiendaElectronicaController {
	
	private Aplicacion aplicacion;
	private ObservableList<Cliente> listClientes;
	private Cliente cliente;

	// Client
    @FXML
    private TableView<Cliente> tableClientelistacliente;

    @FXML
    private TableColumn<Cliente, String> columNombre;

    @FXML
    private TextField inputClienteFechaNac;

    @FXML
    private TableColumn<Cliente, String> columDireccion;

    @FXML
    private TextField inputClienteNombre;

    @FXML
    private Button btnClienteActualizar;

    @FXML
    private TextField inputClienteCiudad;

    @FXML
    private TableColumn<Cliente, String> columCorreo;

    @FXML
    private Button btnClienteEliminar;

    @FXML
    private TableColumn<Cliente, String> columFechaNac;

    @FXML
    private TextField inputClienteEmail;

    @FXML
    private TextField inputClienteDireccion;

    @FXML
    private TextField inputClienteDocumento;

    @FXML
    private TextField inputClienteDepartamento;

    @FXML
    private TableColumn<Cliente, String> columCiudad;

    @FXML
    private Button btnClienteCrear;
    
    // Producto
    
    @FXML
    private TextField inputProductoNombre;
    
    @FXML
    private TableView<?> tableProductolistaProducto;
        
    @FXML
    private TextField inputProductoPrecio;
        
    @FXML
    private TextField inputProductoStock;
    
    @FXML
    private Button btnProductoCrear;
    
    @FXML
    private Button btnProductoEliminar;
    
    @FXML
    private Button btnProductoActualizar;
    
    @FXML
    private ComboBox<?> selectProductoCategoria;
    
    @FXML
    private ComboBox<?> selectProductoSede;
    
    @FXML
    private TableColumn<?, ?> columProductoStock;

    @FXML
    private TableColumn<?, ?> columProductoCategoria;
    
    @FXML
    private TableColumn<?, ?> columProductoSede;

    @FXML
    private TableColumn<?, ?> columProductoNombre;
    
    @FXML
    private TableColumn<?, ?> columProductoPrecio;
    

    @FXML
    void initialize() {
    	columNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	columDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
    	columCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
    	columFechaNac.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
    	columCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
    	
    	tableClientelistacliente.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) -> {
    		
//    		inputClienteDocumento.setDisable(true);
    		cliente = newSelection;
    		showInfoClient(cliente);
    		
    	});
    }
       
    private void showInfoClient(Cliente cliente) {
		
    	inputClienteDocumento.setText(String.valueOf(cliente.getId()));
    	inputClienteNombre.setText(cliente.getNombre());
    	inputClienteDireccion.setText(cliente.getDireccion());
    	inputClienteEmail.setText(cliente.getCorreo());
    	inputClienteFechaNac.setText(cliente.getFechaNacimiento());
    	inputClienteDepartamento.setText(cliente.getDepartamento());
    	inputClienteCiudad.setText(cliente.getCiudad());
	}

	@FXML
    void eventClienteCrear(ActionEvent event) {
    	
    	
    	//captura datos
		String documento = inputClienteDocumento.getText();
    	String nombre = inputClienteNombre.getText();
    	String direccion  = inputClienteDireccion.getText();
    	String correo = inputClienteEmail.getText();
    	String fechaNac = inputClienteFechaNac.getText();
    	String departamento = inputClienteDepartamento.getText();
    	String ciudad = inputClienteCiudad.getText();
    	

    	//Validacampos
    	
	    	if (datosValidos(documento,nombre,direccion,correo,fechaNac,departamento,ciudad)==true) {

	    		//registrar
	    		Cliente cliente = null;
	    		
	    		cliente= aplicacion.crearCliente(documento,nombre,direccion,correo,fechaNac,departamento,ciudad);
	    		
	    		if(cliente.getNombre().equalsIgnoreCase(inputClienteNombre.getText()) ){
	    			clearCamposClientes();
	    			notificacion("Notificación cliente", "Cliente registrado",
	    					"Cliente OK", AlertType.INFORMATION);
	    		}else{
	    			notificacion("Notificación cliente", "Cliente no registrado",
	    					"Cliente con docmento"+documento+ " ya esta registrado", AlertType.INFORMATION);
	    			inputClienteDocumento.clear();
	    			inputClienteNombre.clear();
	    		}

			}else {
				
    			notificacion("Notificación cliente", "Cliente no registrado",
    					"El cliente no se ha logrado registrar", AlertType.ERROR);
				
				
			}


    }

    private boolean datosValidos(String documento, String nombre, String direccion, String correo, String fechaNac,
			String departamento, String ciudad) {

    	String mensaje = "";
    
    
    	if(documento == null || documento.equals(""))
			mensaje += "El documento es invalido \n";
    	if(nombre == null || nombre.equals(""))
			mensaje += "El nombre es invalido \n";
		if(direccion == null || direccion.equals(""))
			mensaje += "La direccion es invalida \n";
		if(correo == null || correo.equals(""))
			mensaje += "El correo es invalido \n";
		if(fechaNac == null || fechaNac.equals(""))
			mensaje += "El fechaNacimiento es invalido \n";
		if(departamento == null || departamento.equals(""))
			mensaje += "El departamento es invalido \n";
		if(ciudad == null || ciudad.equals(""))
			mensaje += "El ciudad es invalido \n";
		if(mensaje.equals("")){
			return true;
		}else{
			notificacion("Información cliente", "Datos invalidos", mensaje, AlertType.WARNING);
			return false;
		}
	}

	private void clearCamposClientes() {
    	
    	inputClienteDocumento.clear();
    	inputClienteNombre.clear();
    	inputClienteDireccion.clear();
    	inputClienteEmail.clear();
    	inputClienteFechaNac.clear();
    	inputClienteDepartamento.clear();
    	inputClienteCiudad.clear();
	}

	@FXML
    void eventClienteActualizar(ActionEvent event) {
    	
		//capturar datos
		String documento = inputClienteDocumento.getText();
    	String nombre = inputClienteNombre.getText();
    	String direccion  = inputClienteDireccion.getText();
    	String correo = inputClienteEmail.getText();
    	String fechaNac = inputClienteFechaNac.getText();
    	String departamento = inputClienteDepartamento.getText();
    	String ciudad = inputClienteCiudad.getText();
		
		boolean clienteActualizado = false;
		if(cliente !=null ){
			
			if(datosValidos(documento, nombre, direccion, correo, fechaNac, departamento, ciudad)){
				
				clienteActualizado = aplicacion.actualizarCliente(cliente.getId(), nombre, direccion, correo, fechaNac, departamento, ciudad);
				
				if(clienteActualizado == true){
					tableClientelistacliente.refresh();
        			notificacion("Notificación cliente", "Cliente actualizado", "El cliente se ha actualizado con éxtio", AlertType.INFORMATION);
				}
				else{
					notificacion("Notificación cliente", "Cliente no actualizado", "El cliente no se puede actualizar", AlertType.ERROR);
				}
			}else{
				notificacion("Notificación cliente", "Cliente no seleccionado", "Debe seleccionar un cliente", AlertType.WARNING);
			}
		}
		
    }	

    @FXML
    void eventClienteEliminar(ActionEvent event) {

    	boolean clienteEliminado = false;
    	
    	if(cliente !=null ){
    		
    		if(notificacionConfirmacion("¿Esta seguro de eliminar el cliente? ") == true){
    			clienteEliminado= aplicacion.eliminarCliente(cliente.getId());
        		
        		if(clienteEliminado == true){
        			listClientes.remove(cliente);
        			cliente = null;
        			tableClientelistacliente.getSelectionModel().clearSelection();
        			notificacion("Notificación cliente", "Cliente actualizado", "El cliente se ha eliminado con éxtio", AlertType.INFORMATION);
        		}else{
        			notificacion("Notificación cliente", "Cliente no eliminado", "El cliente no se puede eliminar", AlertType.ERROR);
        		}
    		}
    		
    	}else{
    		notificacion("Notificación cliente", "Cliente no seleccionado", "Debe seleccionar un cliente", AlertType.WARNING);
		}
    }

	private boolean notificacionConfirmacion(String mensaje) {

	   	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    	alert.setTitle("Confirmación");
    	alert.setHeaderText(null);
    	alert.setContentText(mensaje);

    	Optional<ButtonType> action = alert.showAndWait();

    	if(action.get() == ButtonType.OK){
    		return true;
    	}else{
    		return false;
    	}
	
	}

	public void setAplicacion(Aplicacion aplicacion, TiendaElectronica tienda) {
		this.aplicacion = aplicacion;
		
		tableClientelistacliente.getItems().clear();
		tableClientelistacliente.setItems(tienda.getListClientes());
	}
	
	//Alertas
	/**
	 * AlertType.CONFIRMATION   - AlertType.ERROR -  AlertType.INFORMATION - AlertType.WARNING
	 * @param titulo
	 * @param contenido
	 * @param alertType
	 */
    public void notificacion(String titulo, String header, String contenido, AlertType alertType) {

    	Alert alert = new Alert(alertType);
    	alert.setTitle(titulo);
    	alert.setHeaderText(header);
    	alert.setContentText(contenido);
    	alert.showAndWait();
	}
	
	
	//-------------------------------------------- Action btn Producto ----------------------------------------------------
	
	@FXML
    void crearProducto(ActionEvent event) {

    }

    @FXML
    void actualizarProducto(ActionEvent event) {

    }

    @FXML
    void eliminarProducto(ActionEvent event) {

    }



}
