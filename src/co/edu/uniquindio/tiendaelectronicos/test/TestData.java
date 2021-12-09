package co.edu.uniquindio.tiendaelectronicos.test;


import co.edu.uniquindio.tiendaelectronicos.model.Administrador;
import co.edu.uniquindio.tiendaelectronicos.model.CategoriaProducto;
import co.edu.uniquindio.tiendaelectronicos.model.Cliente;
import co.edu.uniquindio.tiendaelectronicos.model.DetalleVenta;
import co.edu.uniquindio.tiendaelectronicos.model.Producto;
import co.edu.uniquindio.tiendaelectronicos.model.Sede;
import co.edu.uniquindio.tiendaelectronicos.model.Tarjeta;
import co.edu.uniquindio.tiendaelectronicos.model.TiendaElectronica;
import co.edu.uniquindio.tiendaelectronicos.model.TipoTarjeta;
import co.edu.uniquindio.tiendaelectronicos.model.Venta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TestData {

	public TiendaElectronica inicializarDatos(TiendaElectronica tiendaElectronica){
		
		TiendaElectronica tienda = tiendaElectronica;
		
		ObservableList<Administrador> listAdmin = FXCollections.observableArrayList();
		ObservableList<Sede> listSede = FXCollections.observableArrayList();
		ObservableList<Producto> listProductos = FXCollections.observableArrayList();
		ObservableList<Cliente> listCliente = FXCollections.observableArrayList();
		ObservableList<Venta> listCompras = FXCollections.observableArrayList();
		
		//Administradores
		Administrador admin = new Administrador("001", "Julian", "Armenia", "19-04-2001", "sisas@gmail.com", "Administrador de empresas");
		listAdmin.add(admin);
		tienda.setListAdministrador(listAdmin);
		
		//Clientes
		Cliente cliente = new Cliente("001", "Juan", "Armenia", "19-04-2021", "siAbueno@gmail.com", "Armenia", "Quindio");
		cliente.setTarjeta(new Tarjeta("123", TipoTarjeta.CREDITO, "1234", "asdf"));
		listCliente.add(cliente);
		
		cliente = new Cliente("002", "Jose", "Armenia", "28-04-2021", "siAbueno123@gmail.com", "Armenia", "Quindio");
		cliente.setTarjeta(new Tarjeta("123", TipoTarjeta.CREDITO, "1234", "asdf"));
		listCliente.add(cliente);
		
		tienda.setListClientes(listCliente);
		
		//Sedes
		Sede sede = new Sede("Armenia", 001, admin);
		listSede.add(sede);
		
		sede = new Sede("Circasia", 002, admin);
		listSede.add(sede);
		
		sede = new Sede("Calarca", 001, admin);
		listSede.add(sede);
		
		tienda.setListSedes(listSede);
		
		
		//Productos
		Producto producto1 = new Producto(001, sede.getNombre(), "Ventilador", 12.00,CategoriaProducto.HOGAR,12);
		listProductos.add(producto1);
		
		Producto producto2 = new Producto(002, sede.getNombre(), "Radio", 5.00,CategoriaProducto.HOGAR,12);
		listProductos.add(producto2);
		
		Producto producto3 = new Producto(003, sede.getNombre(), "Telivisor", 80.00,CategoriaProducto.HOGAR,12);
		listProductos.add(producto3);
		tienda.setListProductos(listProductos);
		
		//Ventas
		Venta venta1 = new Venta(cliente, sede);
		DetalleVenta  detalleVenta = new  DetalleVenta(producto1);
		venta1.setDetalleVenta(detalleVenta);
		listCompras.add(venta1);
		
		Venta venta2 = new Venta(cliente, sede);
		DetalleVenta  detalleVenta2 = new  DetalleVenta(producto1);
		venta2.setDetalleVenta(detalleVenta2);
		
		DetalleVenta  detalleVenta3 = new  DetalleVenta(producto2);
		venta2.setDetalleVenta(detalleVenta3);
		listCompras.add(venta2);
		
		sede.setListProductos(listProductos);
		sede.setListCompras(listCompras);
		
		return tienda;
	}
}
