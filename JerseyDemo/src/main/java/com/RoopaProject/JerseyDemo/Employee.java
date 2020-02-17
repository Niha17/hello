package com.RoopaProject.JerseyDemo;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Employee {

	public Employee()
	{
	}
	private String empName;
	private float salary;
	private int id;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", salary=" + salary + ", id=" + id + "]";
	}
	
	
}
