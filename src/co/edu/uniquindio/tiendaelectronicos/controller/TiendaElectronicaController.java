package co.edu.uniquindio.tiendaelectronicos.controller;

import co.edu.uniquindio.tiendaelectronicos.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class TiendaElectronicaController {

    @FXML
    private TableView<?> tableClientelistacliente;

    @FXML
    private TableColumn<?, ?> columNombre;

    @FXML
    private TextField inputClienteFechaNac;

    @FXML
    private TableColumn<?, ?> columDireccion;

    @FXML
    private TextField inputClienteNombre;

    @FXML
    private Button btnClienteActualizar;

    @FXML
    private TextField inputClienteCiudad;

    @FXML
    private TableColumn<?, ?> columCorreo;

    @FXML
    private Button btnClienteEliminar;

    @FXML
    private TableColumn<?, ?> columFechaNac;

    @FXML
    private TextField inputClienteEmail;

    @FXML
    private TextField inputClienteDireccion;

    @FXML
    private TextField inputClienteDocumento;

    @FXML
    private TextField inputClienteDepartamento;

    @FXML
    private TableColumn<?, ?> columCiudad;

    @FXML
    private Button btnClienteCrear;

    @FXML
    void eventClienteCrear(ActionEvent event) {

    }

    @FXML
    void eventClienteActualizar(ActionEvent event) {

    }

    @FXML
    void eventClienteEliiminar(ActionEvent event) {

    }

	public void setAplicacion(Aplicacion aplicacion) {
		// TODO Auto-generated method stub
		
	}

}
