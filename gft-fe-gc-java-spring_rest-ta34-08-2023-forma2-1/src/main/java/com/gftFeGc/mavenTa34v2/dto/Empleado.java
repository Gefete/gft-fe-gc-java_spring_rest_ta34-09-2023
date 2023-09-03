package com.gftFeGc.mavenTa34v2.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="empleados")//en caso que la tabla sea diferente
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "trabajo")
	private Trabajo trabajo;
	
	@Column(name = "salario")
	private double salario;
	
	public Empleado() {}
	
	//Constructor basico
	public Empleado(Long id) {
		this.id = id;
		this.nombre = "";
		this.trabajo = Trabajo.INFORMATICA;
		this.salario = calculoSalarioAuto(Trabajo.INFORMATICA, 0);
	}
	
	//Constructor medio
	public Empleado(Long id, Trabajo trabajoEmp) {
		this.id = id;
		this.nombre = "";
		this.trabajo = trabajoEmp;
		this.salario = calculoSalarioAuto(trabajoEmp, 0);
	}
	
	//Constructor completo
	public Empleado(Long id, String nombre, Trabajo trabajoEmp, double salario) {
		this.id = id;
		this.nombre = nombre;
		this.trabajo = trabajoEmp;
		this.salario = calculoSalarioAuto(trabajoEmp, salario);
	}

	//=== GETTERS ===
	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Trabajo getTrabajoEmp() {
		return trabajo;
	}

	public double getSalario() {
		return salario;
	}

	//=== SETTERS ===
	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTrabajoEmp(Trabajo trabajoEmp) {
		this.trabajo = trabajoEmp;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	//METODO SALARIO AUTOMATICO
	private double calculoSalarioAuto(Trabajo trabajo, double salario) {
		if (salario==0) {
			switch (trabajo) {
				case INFORMATICA:
					return 1300;
				case PROGRAMAR:
					return 1500;
				case INFERMERIA:
					return salario;
				case GESTORDATOS:
					return 1800;
				default:
					return salario;
			}
		}else {
			return salario;
		}
	}
	
}
