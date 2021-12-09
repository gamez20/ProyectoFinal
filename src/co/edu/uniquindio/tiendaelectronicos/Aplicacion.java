package co.edu.uniquindio.tiendaelectronicos;

import java.io.IOException;

import co.edu.uniquindio.tiendaelectronicos.controller.TiendaElectronicaController;
import co.edu.uniquindio.tiendaelectronicos.model.Administrador;
import co.edu.uniquindio.tiendaelectronicos.model.Cliente;
import co.edu.uniquindio.tiendaelectronicos.model.TiendaElectronica;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Aplicacion extends Application {

	private Stage primaryStage;
	Administrador administradorNacional = new Administrador("123", "Juan", "slakjfalkjdf", "sldkfjslkfj", "sldfkslkfjd","dddff");
	TiendaElectronica miTienda = new TiendaElectronica(administradorNacional);
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Tienda Electrodomesticos");
		mostrarVentanaPrincipal();
	}
	
	public void mostrarVentanaPrincipal() {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("view/Plantilla.fxml"));
			AnchorPane rootLayout = (AnchorPane)loader.load();
			
			TiendaElectronicaController tiendaElectronica = loader.getController();
			tiendaElectronica.setAplicacion(this, miTienda);
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		launch(args);
	}

	public Cliente crearCliente(String documento, String nombre, String direccion, String correo, String fechaNac,
			String departamento, String ciudad) {
		
		Cliente cliente = null;

		cliente = miTienda.crearCliente(documento, nombre, direccion, correo,fechaNac,departamento,ciudad);

		return cliente;
	}
}
