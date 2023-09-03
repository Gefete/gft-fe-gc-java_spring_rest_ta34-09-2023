package com.gftFeGc.mavenTa34;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@SpringBootApplication
@RestController
public class GftFeGcJavaSpringRestTa34082023Application {
	private ArrayList<Empleado> empleados=new ArrayList<Empleado>();
	
	public static void main(String[] args) {
		SpringApplication.run(GftFeGcJavaSpringRestTa34082023Application.class, args);
	}
	
	//=== Mostrar todo ===
	@GetMapping("/api/empleados")
	public String getAll() {
		//Se pasa a Json el array
		Gson gson = new Gson();
		String json = gson.toJson(empleados);

		return json;
	}
	
	//=== Crear ===
	@PostMapping("/api/crear")
    public String crear(
    		@RequestParam(value = "name", defaultValue = "ger") String nombre,
    		@RequestParam(value = "codTrabajo", defaultValue = "0") String codTrabajo,
    		@RequestParam(value = "salario", defaultValue = "0") String salario
    	) {
		
		//Se crea el objeto
		Empleado empleadoCreado= new Empleado((this.empleados.size()+1), nombre, Trabajo.fromId(Integer.valueOf(codTrabajo)), Double.valueOf(salario));
		//Se añade en el array
		this.empleados.add(empleadoCreado);
		
		//Se pasa a Json
		Gson gson = new Gson();
		String json = gson.toJson(empleados.get(empleados.lastIndexOf(empleadoCreado)));

		return json;
    }
	
	//=== Modificación ===
	@PutMapping("/api/modificar/{id}")
    public void modificar(
    		@PathVariable int id,
    		@RequestParam(value = "name", defaultValue = "ger") String nombre,
    		@RequestParam(value = "codTrabajo", defaultValue = "0") String codTrabajo,
    		@RequestParam(value = "salario", defaultValue = "0") String salario
    	) {
		//por medio de un for each iteramos hasta encontrar el objeto con la ID y se modifica segun los valores psados por URL
		for(Empleado empleado : empleados) { 
			   if(empleado.getId()==id) { 
			       empleado.setNombre(nombre);
			       empleado.setTrabajoEmp(Trabajo.fromId(Integer.valueOf(codTrabajo)));
			       empleado.setSalario(Double.valueOf(salario));
			   }
			}
    }
	
	//=== Eliminación ===
	@DeleteMapping("/api/eliminar/{id}")
    public boolean eliminar(@PathVariable int id) {
		//Elimina y devuelve si lo ha realizado con exito o no
		//La t hace referencia a un iterador y lo de la flecha la condicion para eliminar
		return empleados.removeIf(t -> t.getId()==id);
    }

}
