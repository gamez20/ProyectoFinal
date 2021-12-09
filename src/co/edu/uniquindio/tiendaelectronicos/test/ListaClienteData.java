package co.edu.uniquindio.tiendaelectronicos.test;

import co.edu.uniquindio.tiendaelectronicos.model.Cliente;
import javafx.collections.ObservableList;

public class ListaClienteData {
	 ObservableList<Cliente> listClientes;
	
	public ListaClienteData(){
		
	}

	public ObservableList<Cliente> cargardatos() {
		
		 
		Cliente cliente;
		cliente=new Cliente("1233","santiago","skdflsk","200/15/10","gamez.guerr@sdkf","Armenia","sdlkfj");
		listClientes.add(cliente);
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 return listClientes;
		
	}
}
