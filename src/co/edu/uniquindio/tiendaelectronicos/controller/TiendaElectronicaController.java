package co.edu.uniquindio.tiendaelectronicos.controller;

import co.edu.uniquindio.tiendaelectronicos.Aplicacion;
import co.edu.uniquindio.tiendaelectronicos.model.Cliente;
import co.edu.uniquindio.tiendaelectronicos.model.TiendaElectronica;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;


public class TiendaElectronicaController {
	
	private TiendaElectronica tienda;
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
    		
    		inputClienteDocumento.setDisable(true);
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
    	System.out.println("crear");
    	
    	try{
    	int documento = Integer.parseInt(inputClienteDocumento.getText());
    	String nombre = inputClienteNombre.getText();
    	String direccion  = inputClienteDireccion.getText();
    	String correo = inputClienteEmail.getText();
    	String fechaNac = inputClienteFechaNac.getText();
    	String departamento = inputClienteDepartamento.getText();
    	String ciudad = inputClienteCiudad.getText();
    	
	    	if (tienda.validFieldsCliente(documento,nombre,direccion,correo,fechaNac,departamento,ciudad)) {
	    		
	    		tienda.crearCliente(documento,nombre,direccion,correo,fechaNac,departamento,ciudad);
	    		clearCamposClientes();
	    		notificacion("Exitoso","Guardo correctamente",AlertType.INFORMATION);
	    		
			}else {
				notificacion("Campos Vacios","llenar todos los campos",AlertType.INFORMATION); 
			}
	    	
    	}catch (Exception e) {
    		notificacion("Campo Documento","Campo Documento obligatorio",AlertType.ERROR); 
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
    	System.out.println("actualizar");
    }	

    @FXML
    void eventClienteEliminar(ActionEvent event) {
    	System.out.println("eliminar");
    }

	public void setAplicacion(Aplicacion aplicacion, TiendaElectronica tienda) {
		this.tienda = tienda;
		
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
	public void notificacion(String titulo, String contenido, AlertType alertType) {
		Alert alerta = new Alert(alertType);
		alerta.setTitle(titulo);
		alerta.setContentText(contenido);
		alerta.showAndWait();
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
