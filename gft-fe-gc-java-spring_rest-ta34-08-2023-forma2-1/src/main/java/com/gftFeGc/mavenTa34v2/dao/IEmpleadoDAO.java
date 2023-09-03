package com.gftFeGc.mavenTa34v2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gftFeGc.mavenTa34v2.dto.Empleado;
import com.gftFeGc.mavenTa34v2.dto.Trabajo;

public interface IEmpleadoDAO extends JpaRepository<Empleado, Long>{
	
	public List<Empleado> findByTrabajo(Trabajo trabajo);

}
