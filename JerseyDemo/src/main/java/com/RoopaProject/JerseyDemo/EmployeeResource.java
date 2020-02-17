package com.RoopaProject.JerseyDemo;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("employeeresource")
public class EmployeeResource {

	
	EmployeeReposotory eres = new EmployeeReposotory();
	@GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Employee> getEmployee()
	{
		System.out.println("Employee Resouce called");
		return eres.getEmployees();		
	}
		
    @GET
    @Path("employees/{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Employee getEmployeebyId(@PathParam("id") int id)
	{
    	System.out.println("in method getEmployeebyId");
	   return eres.getEmployees(id);
	}
	
	@POST
	@Path("employees")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Employee createEmployee(Employee e)
	{
		System.out.println(e);
		eres.create(e);
		return e;
	}
	
	@PUT
	@Path("employees")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Employee updateEmployee(Employee e)
	{
		System.out.println(e);
		if (eres.getEmployees(e.getId()).getId()==0)
		{
			eres.create(e);
		}
		else
		eres.update(e);
		return e;
	}
	@DELETE
	@Path("employees/{id}")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Employee deleteEmployee(@PathParam("id") int id)
	{
	    Employee e = eres.getEmployees(id);	 
	    if (e.getId()!=0)
	    {	
	     System.out.println(e.getId());
	    eres.delete(id);
	    }
	    return e;
	}
	
}
