package com.RoopaProject.JerseyDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeReposotory {

	
	Connection con = null;
	public EmployeeReposotory() 
	{
		String url = "jdbc:mysql://localhost:3306/roopaschema";
		String username = "root";
		String pwd = "RoopaSql";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Employee> getEmployees()
	{
		List<Employee> emp = new ArrayList<>(); 
		String s = "select * from Employee";
		try {
		
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(s);
			while(rs.next())
			{
				Employee e = new Employee();
				e.setEmpName(rs.getString(2));
				e.setId(rs.getInt(1));
				e.setSalary(rs.getFloat(3));
				emp.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				return emp;
		
	}
	
    public Employee getEmployees(int id)
	{
		String s = "select * from Employee where eid="+id;
		System.out.println(s);
		Employee e = new Employee();
		try {
		
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(s);
			if(rs.next())
			{
			
				e.setEmpName(rs.getString(2));
				e.setId(rs.getInt(1));
				e.setSalary(rs.getFloat(3));
				
			}
		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
		}
				return e;

	}

	public void create(Employee e) {
		String sql = "insert into Employee values (?,?,?)";
		try 
		    {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1,e.getId());
			pst.setString(2,e.getEmpName());
			pst.setFloat(3,e.getSalary());
			pst.executeUpdate();

		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
		}
	}
	public void update(Employee e) {
		String sql = "update Employee set ename=?, sal =? where eid =?";
		try 
		    {
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1,e.getEmpName());
			pst.setFloat(2,e.getSalary());
			pst.setInt(3,e.getId());
			pst.executeUpdate();

		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
		}
	}

	
	public void delete(int id) {
		
		String sql = "delete from Employee where eid =?";
		try 
		    {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1,id);
			pst.executeUpdate();

		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
		}
	}
	
 	
}
