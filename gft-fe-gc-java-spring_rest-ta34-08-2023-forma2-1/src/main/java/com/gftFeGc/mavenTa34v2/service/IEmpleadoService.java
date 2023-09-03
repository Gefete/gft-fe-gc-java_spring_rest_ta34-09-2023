package com.gftFeGc.mavenTa34v2.service;

import java.util.List;

import com.gftFeGc.mavenTa34v2.dto.Empleado;
import com.gftFeGc.mavenTa34v2.dto.Trabajo;

public interface IEmpleadoService {
	//Metodos del CRUD
	
		//Listar All 
		public List<Empleado> listarEmpleados(); 
		
		// FindByTrabajo
		public List<Empleado> listarEmplTrabajo(Trabajo trabajo);
		
		//Guarda un cliente CREATE
		public Empleado guardarEmpleado(Empleado cliente);	
		
		//Leer datos de un cliente READ
		public Empleado empleadoXID(Long id); 
		
		//Actualiza datos del cliente UPDATE
		public Empleado actualizarEmpleado(Empleado cliente); 
		
		// Elimina el cliente DELETE
		public void eliminarEmpleado(Long id);
}
