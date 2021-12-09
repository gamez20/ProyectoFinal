package co.edu.uniquindio.tiendaelectronicos.controller;

import java.util.Optional;

import co.edu.uniquindio.tiendaelectronicos.Aplicacion;
import co.edu.uniquindio.tiendaelectronicos.model.CategoriaProducto;
import co.edu.uniquindio.tiendaelectronicos.model.Cliente;
import co.edu.uniquindio.tiendaelectronicos.model.Producto;
import co.edu.uniquindio.tiendaelectronicos.model.Sede;
import co.edu.uniquindio.tiendaelectronicos.model.TiendaElectronica;
//import co.edu.uniquindio.tiendaelectronicos.test.ListaClienteData;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;


public class TiendaElectronicaController {
	
	private Aplicacion aplicacion;
	private Cliente cliente;
	private Producto producto;
	
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
    private TableView<Producto> tableProductolistaProducto;
        
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
    private ComboBox<CategoriaProducto> selectProductoCategoria;
    
    @FXML
    private ComboBox<String> selectProductoSede;
    
    @FXML
    private TableColumn<Producto, Integer> columProductoStock;

    @FXML
    private TableColumn<Producto, CategoriaProducto> columProductoCategoria;
    
    @FXML
    private TableColumn<Producto, String> columProductoSede;

    @FXML
    private TableColumn<Producto, String> columProductoNombre;
    
    @FXML
    private TableColumn<Producto, Double> columProductoPrecio;
    
    @FXML
    private TextField inputProductoCodigo;

    @FXML
    private Label labelProductoCodigo;
    
    //------------------------------------------ Transaccion components ------------------------------------------------------------
    @FXML
    private TextField inputTransaccionCvv;

    @FXML
    private TableView<?> tableTransaccionlistaProducto;

    @FXML
    private TextField inputTransaccionCodigoProducto;
   
    @FXML
    private TextField inputTransaccionCantidadProducto;
   
    @FXML
    private TextField inputTransaccionFechaTarjeta;
    
    @FXML
    private TableView<?> tableTransaccionlistaVentas;
    
    @FXML
    private Button btnTransaccionCompra;

    @FXML
    private Label labelTransaccionTotal;

    @FXML
    private ComboBox<Sede> selectTransaccionSede;
    
    @FXML
    private TextField inputTransaccionNumTarjeta;

    @FXML
    private ComboBox<?> selectTransaccionCliente;

    @FXML
    private ComboBox<?> selectTransaccionTarjeta;

    
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
    	
    	inicializarDatosProducto();
    	inicializarDatosTransaccion();
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
	    			clearCampos();
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

	private void clearCampos() {
    	
		//Campos Cliente
    	inputClienteDocumento.clear();
    	inputClienteNombre.clear();
    	inputClienteDireccion.clear();
    	inputClienteEmail.clear();
    	inputClienteFechaNac.clear();
    	inputClienteDepartamento.clear();
    	inputClienteCiudad.clear();
    		
    	//Campos Producto
    	inputProductoNombre.clear();
    	inputProductoPrecio.clear();
    	inputProductoStock.clear();
    	inputProductoCodigo.clear();
    	labelProductoCodigo.setVisible(false);
		inputProductoCodigo.setVisible(false);
		btnProductoCrear.setDisable(false);
    	//selectProductoCategoria.setValue(value);;
    	//selectProductoSede.getSelectionModel().selectFirst();
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
        			tableClientelistacliente.refresh();
        			cliente = null;
        			tableClientelistacliente.getSelectionModel().clearSelection();
        			notificacion("Notificación cliente", "Cliente Eliminado", "El cliente se ha eliminado con éxtio", AlertType.INFORMATION);
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
		
		//Llenar tabla clientes
		tableClientelistacliente.getItems().clear();
		tableClientelistacliente.setItems(tienda.getListClientes());
		
		//Llenar tabal productos
		tableProductolistaProducto.getItems().clear();
		tableProductolistaProducto.setItems(tienda.getListProductos());
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
	
    private void inicializarDatosProducto() {
    	selectProductoCategoria.getItems().addAll(CategoriaProducto.HOGAR,CategoriaProducto.EMPRESARIALES, CategoriaProducto.ENTRETENIMIENTO);
    	//selectProductoSede.getItems().addAll(tienda.getListSedes());
    	selectProductoSede.getItems().addAll("Armenia","Circasia","Calarca");
    	
    	// PLaceholder en el input inputProductoNombre.setPromptText("Ingrese el nombre");
    	
    	columProductoNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	columProductoPrecio.setCellValueFactory(new PropertyValueFactory<>("valor"));
    	columProductoCategoria.setCellValueFactory(new PropertyValueFactory<>("categoriaProducto"));
    	columProductoSede.setCellValueFactory(new PropertyValueFactory<>("sede"));
    	columProductoStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
    	
    	tableProductolistaProducto.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) -> {
    		
    		labelProductoCodigo.setVisible(true);
    		inputProductoCodigo.setVisible(true);
//    		btnProductoCrear.setDisable(true);
    		
    		producto = newSelection;
    		
    		showInfoProducto(producto);
    		
    	});
    
	}
    
    private void inicializarDatosTransaccion() {
    	/*if (aplicacion.obtenerSedes().size() > 0) {
    		selectTransaccionSede.setItems(aplicacion.obtenerSedes());
    		
		}*/
		
	}
    
    private void showInfoProducto(Producto producto) {
		
    	if (producto != null) {

        	inputProductoNombre.setText(producto.getNombre());
        	inputProductoPrecio.setText(String.valueOf(producto.getValor()));
        	inputProductoStock.setText(String.valueOf(producto.getStock()));
        	selectProductoSede.setValue(producto.getSede());
        	selectProductoCategoria.setValue(producto.getCategoriaProducto());
        	inputProductoCodigo.setText(String.valueOf(producto.getCodigo()));
    	}
	}
    
	@FXML
    void crearProducto(ActionEvent event) {
		
		// Captura de datos
		String nombre = inputProductoNombre.getText();
		String sede = selectProductoSede.getValue();
		CategoriaProducto categoria = selectProductoCategoria.getValue();
		
		if(datosValidosProducto(nombre, inputProductoPrecio.getText(), inputProductoStock.getText(), sede, categoria)){
			
			double precio = Double.parseDouble(inputProductoPrecio.getText());
			int stock = Integer.parseInt(inputProductoStock.getText());
			
			if(aplicacion.crearProducto(nombre,precio,stock,sede,categoria) !=null){
				
    			clearCampos();
    			notificacion("Notificación producto", "Producto registrado",
    					"Producto OK", AlertType.INFORMATION);
    		}else{
    			notificacion("Notificación producto", "Producto no registrado",
    					"El producto se encuentra registrado", AlertType.INFORMATION);
    		}

		}else {
			
			notificacion("Notificación producto", "Producto no registrado",
					"El producto no se ha logrado registrar", AlertType.ERROR);
		}
    }

    private boolean datosValidosProducto(String nombre, String precio, String stock, String sede, CategoriaProducto categoria) {
    	
    	String mensaje = "";
        
    	if(nombre == null || nombre.equals(""))
			mensaje += "El nombre es invalido \n";
		if(precio == null || precio.equals(""))
			mensaje += "La precio es invalida \n";
		if(stock == null || stock.equals(""))
			mensaje += "El stock es invalido \n";
		if(sede == null || sede.equals(""))
			mensaje += "El sede es invalido \n";
		if(categoria == null)
			mensaje += "El categoria es invalido \n";
		if(mensaje.equals("")){
			return true;
		}else{
			notificacion("Información Producto", "Datos invalidos", mensaje, AlertType.WARNING);
			return false;
		}
	}

	@FXML
    void actualizarProducto(ActionEvent event) {
		
		if (mostrarMensajeConfirmacion("Desea Actualizar el Producto")) {
			// Captura de datos
			String nombre = inputProductoNombre.getText();
			String sede = selectProductoSede.getValue();
			CategoriaProducto categoria = selectProductoCategoria.getValue();
			
			if(datosValidosProducto(nombre, inputProductoPrecio.getText(), inputProductoStock.getText(), sede, categoria) && !(inputProductoCodigo.getText().equalsIgnoreCase(""))){
				
				double precio = Double.parseDouble(inputProductoPrecio.getText());
				int stock = Integer.parseInt(inputProductoStock.getText());
				int codigo = Integer.parseInt(inputProductoCodigo.getText());
				
				
				if(aplicacion.actualizarProducto(producto.getCodigo(),codigo,nombre,precio,stock,sede,categoria) !=null){
	    			
	    			tableProductolistaProducto.refresh();
//	    			btnProductoCrear.setDisable(false);
	    			tableProductolistaProducto.getSelectionModel().select(null);
	    			clearCampos();
	    			
	    			notificacion("Notificación producto", "Producto actualizado",
	    					"Producto OK", AlertType.INFORMATION);
	    		}else{
	    			notificacion("Notificación producto", "Producto no actualizado",
	    					"El producto se encuentra registrado", AlertType.INFORMATION);
	    		}
	
			}else {
				
				notificacion("Notificación producto", "Producto no registrado",
						"El producto no se ha logrado registrar", AlertType.ERROR);
			}
		}
    }

    @FXML
    void eliminarProducto(ActionEvent event) {

    	if (mostrarMensajeConfirmacion("Desea Eliminar el Producto")) {
    		if (aplicacion.eliminarProducto(producto.getCodigo())) {
    			
    			tableProductolistaProducto.refresh();
    			tableProductolistaProducto.getSelectionModel().select(null);
    			clearCampos();
    			notificacion("Notificación producto", "Producto eliminado",
    					"Producto OK", AlertType.INFORMATION);
			}else {
				notificacion("Notificación producto", "Producto no eliminado",
    					"Producto OK", AlertType.INFORMATION);
			}
    	}
    }
    
  //-------------------------------------------- Action btn Transaccion ----------------------------------------------------
    
    @FXML
    void creaVenta(ActionEvent event) {

    }
    
    private boolean mostrarMensajeConfirmacion(String mensaje) {

		Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
		alerta.setHeaderText(null);
		alerta.setTitle("Confirmacion");
		alerta.setContentText(mensaje);

		Optional<ButtonType> acction = alerta.showAndWait();

		if (acction.get() == ButtonType.OK) {
			return true;
		}else {
			return false;
		}


	}

}
