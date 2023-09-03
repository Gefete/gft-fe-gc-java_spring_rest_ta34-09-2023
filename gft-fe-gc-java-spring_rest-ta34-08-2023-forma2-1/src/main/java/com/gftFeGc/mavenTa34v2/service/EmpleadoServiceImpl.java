package com.gftFeGc.mavenTa34v2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gftFeGc.mavenTa34v2.dao.IEmpleadoDAO;
import com.gftFeGc.mavenTa34v2.dto.Empleado;
import com.gftFeGc.mavenTa34v2.dto.Trabajo;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

	//Utilizamos los metodos de la interface IClienteDAO, es como si instaciaramos.
	@Autowired
	IEmpleadoDAO iEmpleadoDAO;
	
	@Override
	public List<Empleado> listarEmpleados() {
		// TODO Auto-generated method stub
		return iEmpleadoDAO.findAll();
	}
	
	@Override
	public List<Empleado> listarEmplTrabajo(Trabajo trabajo) {
		// TODO Auto-generated method stub
		return iEmpleadoDAO.findByTrabajo(trabajo);
	}

	@Override
	public Empleado guardarEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return iEmpleadoDAO.save(empleado);
	}

	@Override
	public Empleado empleadoXID(Long id) {
		// TODO Auto-generated method stub
		return iEmpleadoDAO.findById(id).get();
	}

	@Override
	public Empleado actualizarEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return iEmpleadoDAO.save(empleado);
	}

	@Override
	public void eliminarEmpleado(Long id) {
		// TODO Auto-generated method stub
		iEmpleadoDAO.deleteById(id);
	}

}
