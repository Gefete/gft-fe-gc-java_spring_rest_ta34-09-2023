package com.gftFeGc.mavenTa34v2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gftFeGc.mavenTa34v2.dto.Empleado;
import com.gftFeGc.mavenTa34v2.dto.Trabajo;
import com.gftFeGc.mavenTa34v2.service.EmpleadoServiceImpl;


@RestController
@RequestMapping("/api")
public class EmpleadoController {
	
	@Autowired
	EmpleadoServiceImpl empleadoServideImpl;
	
	//=== Mostrar todo ===
	@GetMapping("/empleados")
	public List<Empleado> getAll() {
		return empleadoServideImpl.listarEmpleados();
	}

	//=== Mostrar por trabajo ===
		@GetMapping("/empleados/trabajo/{trabajo}")
		public List<Empleado> getjob(@PathVariable(name = "trabajo") int trabajo) {
			return empleadoServideImpl.listarEmplTrabajo(Trabajo.fromId(trabajo));
		}
	
	//=== Crear ===
	@PostMapping("/empleados")
    public Empleado crear(@RequestBody Empleado empleado) {
		return empleadoServideImpl.guardarEmpleado(empleado);
    }
	
	//=== Modificación ===
	@PutMapping("/empleados/{id}")
    public Empleado modificar(@PathVariable Long id,@RequestBody Empleado empleado) {
		Empleado empleadoSelect= new Empleado();
		Empleado empleadoUpdate= new Empleado();
		
		empleadoSelect = empleadoServideImpl.empleadoXID(id);
		
		empleadoSelect.setNombre(empleado.getNombre());
		empleadoSelect.setTrabajoEmp(empleado.getTrabajoEmp());
		empleadoSelect.setSalario(empleado.getSalario());
		
		empleadoUpdate= empleadoServideImpl.actualizarEmpleado(empleadoSelect);
		
		System.out.println("El empleado actualizado es: "+ empleadoUpdate);
		
		return empleadoUpdate;
    }
	
	//=== Eliminación ===
	@DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
		empleadoServideImpl.eliminarEmpleado(id);
    }
}
