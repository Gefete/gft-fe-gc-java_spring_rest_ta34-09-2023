package com.gftFeGc.mavenTa34;

public class Empleado {
	private int id;
	private String nombre;
	private Trabajo trabajoEmp;
	private double salario;
	
	//Constructor basico
	public Empleado(int id) {
		this.id = id;
		this.nombre = "";
		this.trabajoEmp = Trabajo.INFORMATICA;
		this.salario = calculoSalarioAuto(Trabajo.INFORMATICA, 0);
	}
	
	//Constructor medio
	public Empleado(int id, Trabajo trabajoEmp) {
		this.id = id;
		this.nombre = "";
		this.trabajoEmp = trabajoEmp;
		this.salario = calculoSalarioAuto(trabajoEmp, 0);
	}
	
	//Constructor completo
	public Empleado(int id, String nombre, Trabajo trabajoEmp, double salario) {
		this.id = id;
		this.nombre = nombre;
		this.trabajoEmp = trabajoEmp;
		this.salario = calculoSalarioAuto(trabajoEmp, salario);
	}

	//=== GETTERS ===
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Trabajo getTrabajoEmp() {
		return trabajoEmp;
	}

	public double getSalario() {
		return salario;
	}

	//=== SETTERS ===
	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTrabajoEmp(Trabajo trabajoEmp) {
		this.trabajoEmp = trabajoEmp;
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
